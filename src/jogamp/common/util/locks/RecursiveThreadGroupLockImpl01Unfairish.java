/**
 * Copyright 2010 JogAmp Community. All rights reserved.
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

import java.util.Arrays;

import com.jogamp.common.util.locks.RecursiveThreadGroupLock;

public class RecursiveThreadGroupLockImpl01Unfairish 
    extends RecursiveLockImpl01Unfairish 
    implements RecursiveThreadGroupLock 
{
    /* package */ @SuppressWarnings("serial")
    static class ThreadGroupSync extends SingleThreadSync {        
        /* package */ ThreadGroupSync() {
            super();
            threadNum = 0;
            threads = null;
            holdCountAdditionOwner = 0;
        }
        @Override
        public final void incrHoldCount(Thread t) { 
            super.incrHoldCount(t); 
            if(!isOriginalOwner(t)) { 
                holdCountAdditionOwner++; 
            } 
        }
        @Override
        public final void decrHoldCount(Thread t) { 
            super.decrHoldCount(t); 
            if(!isOriginalOwner(t)) { 
                holdCountAdditionOwner--; 
            } 
        }
        public final int getAdditionalOwnerHoldCount() {
            return holdCountAdditionOwner;
        }
        
        public final boolean isOriginalOwner(Thread t) {
            return super.isOwner(t);
        }
        @Override
        public final boolean isOwner(Thread t) {
            if(getExclusiveOwnerThread()==t) {
                return true;
            }
            for(int i=threadNum-1; 0<=i; i--) {
                if(threads[i]==t) {
                    return true;
                }
            }
            return false;
        }
        
        public final int getAddOwnerCount() {
            return threadNum;
        }
        public final void addOwner(Thread t) throws IllegalArgumentException {            
            if(null == threads) {
                if(threadNum>0) {
                    throw new InternalError("XXX");
                }
                threads = new Thread[4];
            }
            for(int i=threadNum-1; 0<=i; i--) {
                if(threads[i]==t) {
                    throw new IllegalArgumentException("Thread already added: "+t);
                }
            }
            if (threadNum == threads.length) {
                threads = Arrays.copyOf(threads, threadNum * 2);
            }
            threads[threadNum] = t;
            threadNum++;
        }
        
        public final void removeAllOwners() {
            for(int i=threadNum-1; 0<=i; i--) {
                threads[i]=null;
            }
            threadNum=0;            
        }
        
        public final void removeOwner(Thread t) throws IllegalArgumentException {       
            for (int i = 0 ; i < threadNum ; i++) {
                if (threads[i] == t) {
                    threadNum--;
                    System.arraycopy(threads, i + 1, threads, i, threadNum - i);
                    threads[threadNum] = null; // cleanup 'dead' [or duplicate] reference for GC
                    return;
                }
            }
            throw new IllegalArgumentException("Not an owner: "+t);
        }
        
        String addOwnerToString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<threadNum; i++) {
                if(i>0) {
                    sb.append(", ");
                }
                sb.append(threads[i].getName());
            }
            return sb.toString();            
        }
        
        // lock count by addition owner threads
        private int holdCountAdditionOwner;        
        private Thread[] threads;
        private int threadNum;
    }
    
    public RecursiveThreadGroupLockImpl01Unfairish() {
        super(new ThreadGroupSync());
    }
    
    @Override
    public final boolean isOriginalOwner() {
        return isOriginalOwner(Thread.currentThread());
    }

    @Override
    public final boolean isOriginalOwner(Thread thread) {
        synchronized(sync) {
            return ((ThreadGroupSync)sync).isOriginalOwner(thread) ;
        }
    }

    @Override
    public final void addOwner(Thread t) throws RuntimeException, IllegalArgumentException {
        validateLocked();
        final Thread cur = Thread.currentThread();
        final ThreadGroupSync tgSync = (ThreadGroupSync)sync;
        if(!tgSync.isOriginalOwner(cur)) {
            throw new IllegalArgumentException("Current thread is not the original owner: orig-owner: "+tgSync.getOwner()+", current "+cur);
        }
        if(tgSync.isOriginalOwner(t)) {
            throw new IllegalArgumentException("Passed thread is original owner: "+t);
        }
        tgSync.addOwner(t);
    }
    
    @Override
    public final void unlock(Runnable taskAfterUnlockBeforeNotify) {
        synchronized(sync) {
            final Thread cur = Thread.currentThread();
            final ThreadGroupSync tgSync = (ThreadGroupSync)sync;
            
            if( tgSync.getAddOwnerCount()>0 ) {
                if(DEBUG) {
                    System.err.println("++ unlock(0): currentThread "+cur.getName()+", lock: "+this.toString());
                }
                if( tgSync.isOriginalOwner(cur) ) {
                    // original locking owner thread
                    if( tgSync.getHoldCount() - tgSync.getAdditionalOwnerHoldCount() == 1 ) {
                        // release orig. lock
                        while ( tgSync.getAdditionalOwnerHoldCount() > 0 ) {
                            try {
                                sync.wait();
                            } catch (InterruptedException e) {
                                // regular wake up!
                            }
                        }
                        tgSync.removeAllOwners();
                    }
                } else if( tgSync.getAdditionalOwnerHoldCount() == 1 ) {
                    // last additional owner thread wakes up original owner
                    final Thread originalOwner = tgSync.getOwner();
                    if(originalOwner.getState() == Thread.State.WAITING) {
                        originalOwner.interrupt();
                    }                
                }
            }
            if(DEBUG) {
                System.err.println("++ unlock(X): currentThread "+cur.getName()+", lock: "+this.toString());
            }
            super.unlock(taskAfterUnlockBeforeNotify);       
        }
    }
    
    @Override
    public final void removeOwner(Thread t) throws RuntimeException, IllegalArgumentException {
        validateLocked();
        ((ThreadGroupSync)sync).removeOwner(t);
    }
    
    @Override
    public String toString() {
        final ThreadGroupSync tgSync = (ThreadGroupSync)sync;
        final int hc = sync.getHoldCount();
        final int addHC = tgSync.getAdditionalOwnerHoldCount();
        return syncName()+"[count "+hc+" [ add. "+addHC+", orig "+(hc-addHC)+
                           "], qsz "+sync.getQSz()+", owner "+threadName(sync.getOwner())+", add.owner "+tgSync.addOwnerToString()+"]";
    }
}
