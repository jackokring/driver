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

package com.jogamp.common.util.locks;

import java.io.File;

import jogamp.common.util.locks.SingletonInstanceFileLock;
import jogamp.common.util.locks.SingletonInstanceServerSocket;

public abstract class SingletonInstance implements Lock {

    protected static final boolean DEBUG = true;

    public static SingletonInstance createFileLock(long poll_ms, String lockFileBasename) {
        return new SingletonInstanceFileLock(poll_ms, lockFileBasename);
    }

    public static SingletonInstance createFileLock(long poll_ms, File lockFile) {
        return new SingletonInstanceFileLock(poll_ms, lockFile);
    }
    
    /**
     * A user shall use <b>ephemeral ports</b>:
     * <ul>
     *  <li>IANA suggests 49152 to 65535 as "dynamic and/or private ports".</li>
     *  <li>Many GNU/Linux kernels use 32768 to 61000.</li>
     *  <li>FreeBSD >= 4.6 uses the IANA port range.</li>
     *  <li>FreeBSD < 4.6 and BSD use ports 1024 through 4999.</li>
     *  <li>Microsoft Windows operating systems through Server 2003 use the range 1025 to 5000</li>
     *  <li>Windows Vista, Windows 7, and Server 2008 use the IANA range.</li>
     * </ul> 
     * @param pollPeriod
     * @param portNumber to be used for this single instance server socket. 
     */
    public static SingletonInstance createServerSocket(long poll_ms, int portNumber) {
        return new SingletonInstanceServerSocket(poll_ms, portNumber);
    }
    
    protected SingletonInstance(long poll_ms) {
        this.poll_ms = Math.max(10, poll_ms);
    }
    
    public final long getPollPeriod() { return poll_ms; }
    public abstract String getName();
    @Override
    public final String toString() { return getName(); }
    
    @Override
    public synchronized void lock() throws RuntimeException {
        try {
            do {
                if(tryLock(TIMEOUT)) {
                    return;
                }
            } while ( true ) ;
        } catch ( RuntimeException ie ) {
            throw new  RuntimeException(ie);
        }
    }

    @Override
    public synchronized boolean tryLock(long maxwait) throws RuntimeException {
        if(locked) {
            return true;
        }
        int i=0;
        try {
            do {
                locked = tryLockImpl();
                if(locked) {
                    if(DEBUG) {
                        System.err.println("SLOCK "+System.currentTimeMillis()+" +++ "+getName()+" - Locked ");
                    }            
                    return true;
                }
                if(DEBUG && 0==i) {
                    System.err.println("SLOCK "+System.currentTimeMillis()+" ??? "+getName()+" - Wait for lock");
                }
                Thread.sleep(poll_ms);
                maxwait -= poll_ms;
                i++;
            } while ( 0 < maxwait ) ;
        } catch ( InterruptedException ie ) {
            throw new RuntimeException("SLOCK "+System.currentTimeMillis()+" EEE "+getName()+" - couldn't get lock", ie);            
        }
        return false;
    }    
    protected abstract boolean tryLockImpl();
    
    @Override
    public void unlock() throws RuntimeException {
        if(locked) {
            locked = !unlockImpl();
            if(DEBUG) {
                System.err.println("SLOCK "+System.currentTimeMillis()+" --- "+getName()+" - Unlock " 
                                   + ( locked ? "failed" : "ok" ) );
            }
        }
    }
    protected abstract boolean unlockImpl();

    @Override
    public synchronized boolean isLocked() {
        return locked;
    }

    private final long poll_ms;
    private boolean locked = false;
}
