/**
 * Copyright 2011 JogAmp Community. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 * 
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY JogAmp Community ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JogAmp Community OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of JogAmp Community.
 */
 
package jogamp.common.util.locks;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import com.jogamp.common.util.locks.SingletonInstance;

public class SingletonInstanceServerSocket extends SingletonInstance {

    private final Server singletonServer;
    private final String fullName;
    
    public SingletonInstanceServerSocket(long poll_ms, int portNumber) {
        super(poll_ms);
        
        // Gather the local InetAddress, loopback is prioritized 
        InetAddress ilh = null;
        try {
            ilh = InetAddress.getByName(null); // loopback
        } catch (UnknownHostException e1) { }
        if(null == ilh) {
            try {
                ilh = InetAddress.getByName("localhost");
                if(null!=ilh && !ilh.isLoopbackAddress()) { ilh = null; }
            } catch (UnknownHostException e1) { }
        }
        if(null == ilh) {
            try {
                ilh = InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 } );            
                if(null!=ilh && !ilh.isLoopbackAddress()) { ilh = null; }
            } catch (UnknownHostException e) { }
        }        
        if(null == ilh) {
            try {
                ilh = InetAddress.getLocalHost();
            } catch (UnknownHostException e) { }
        }
        if(null == ilh) {
            throw new RuntimeException("Could not determine local InetAddress");
        }
        
        fullName = ilh.toString()+":"+portNumber;
        singletonServer = new Server(ilh, portNumber);        
    }

    public final InetAddress getLocalInetAddress() {
        return singletonServer.getLocalInetAddress();
    }

    public final int getPortNumber() {
        return singletonServer.getPortNumber();
    }

    @Override
    public final String getName() { return fullName; }
    
    @Override
    protected boolean tryLockImpl() {
        if( singletonServer.isRunning() ) {
            return false; // same JVM .. server socket already installed !
        }
        
        // check if other JVM's locked the server socket ..
        Socket clientSocket = singletonServer.connect();
        if(null != clientSocket) {
            try {
                clientSocket.close();
            } catch (IOException e) { }
            return false;
        }
        
        if( !singletonServer.start() ) {
            return false;
        }
        
        return true;
    }

    @Override
    protected boolean unlockImpl() {
        return singletonServer.shutdown();
    }

    public class Server implements Runnable {
       private final InetAddress localInetAddress;
       private final int portNumber;   
       
       private volatile boolean shallQuit = false; 
       private volatile boolean alive = false;
       
       private Object syncOnStartStop = new Object();
       private ServerSocket serverSocket = null;
       
       public Server(InetAddress localInetAddress, int portNumber) {
           this.localInetAddress = localInetAddress;
           this.portNumber = portNumber;
       }
       
       public final InetAddress getLocalInetAddress() { return localInetAddress; }
       public final int getPortNumber() { return portNumber; }
       
       public boolean start() {
           if(alive) return true;
           
           Thread t = new Thread(this);
           t.setDaemon(true);  // be a daemon, don't keep the JVM running
           
           synchronized (syncOnStartStop) {
               t.start();
               try {
                   syncOnStartStop.wait();
               } catch (InterruptedException ie) {
                   ie.printStackTrace();
               }            
           }
           boolean ok = isBound();
           if(!ok) {
               shutdown();
           }
           return ok;
       }
       
       public final boolean shutdown() {
           if(!alive) return true;
           
           synchronized (syncOnStartStop) {
               shallQuit = true;
               connect();
               try {
                   syncOnStartStop.wait();
               } catch (InterruptedException ie) {
                   ie.printStackTrace();
               }            
           }
           if(alive) {
               System.err.println("SLOCK "+System.currentTimeMillis()+" EEE "+getName()+" - Unable to remove lock: ServerThread still alive ?");
           }
           return !alive;
       }
       
       public final boolean isRunning() { return alive; }
       
       public final boolean isBound() {
           return alive && null != serverSocket && serverSocket.isBound() ;
       }

       public final Socket connect() {
           try {
               return new Socket(localInetAddress, portNumber);
           } catch (Exception e) { }
           return null;
       }
       
       @Override
       public void run() {
           {
               final Thread currentThread = Thread.currentThread();
               currentThread.setName(currentThread.getName() + " - SingletonInstanceServerSocket: "+getName());
               if(DEBUG) {
                   System.err.println(currentThread.getName()+" - started");               
               }
           }
           alive = false;
           synchronized (syncOnStartStop) {
               try {
                   serverSocket = new ServerSocket(portNumber, 1, localInetAddress);
                   alive = true;
               } catch (IOException e) {
                    System.err.println("SLOCK "+System.currentTimeMillis()+" EEE "+getName()+" - Unable to install ServerSocket: "+e.getMessage());
                    shallQuit = true;
               } finally {
                    syncOnStartStop.notifyAll();                   
               }
           }
           
           while (!shallQuit) {
               try {
                   final Socket clientSocket = serverSocket.accept();
                   clientSocket.close();
               } catch (IOException ioe) {
                   System.err.println("SLOCK "+System.currentTimeMillis()+" EEE "+getName()+" - Exception during accept: " + ioe.getMessage());
               }
           }
           
           synchronized (syncOnStartStop) {
               try {
                   if(null != serverSocket) {
                       serverSocket.close();
                   }
               } catch (IOException e) {
                   System.err.println("SLOCK "+System.currentTimeMillis()+" EEE "+getName()+" - Exception during close: " + e.getMessage());
               } finally {
                   serverSocket = null;
                   alive = false;
                   shallQuit = false;
                   syncOnStartStop.notifyAll();
               }
           }
       }
    }
}
