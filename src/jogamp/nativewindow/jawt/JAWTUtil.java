/*
 * Copyright (c) 2003 Sun Microsystems, Inc. All Rights Reserved.
 * Copyright (c) 2010 JogAmp Community. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed or intended for use
 * in the design, construction, operation or maintenance of any nuclear
 * facility.
 */

package jogamp.nativewindow.jawt;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Map;

import javax.media.nativewindow.NativeWindowException;
import javax.media.nativewindow.ToolkitLock;

import jogamp.nativewindow.Debug;

import com.jogamp.common.os.Platform;
import com.jogamp.common.util.VersionNumber;

public class JAWTUtil {
  public static final boolean DEBUG = Debug.debug("JAWT");

  /** OSX JAWT version option to use CALayer */
  public static final int JAWT_MACOSX_USE_CALAYER = 0x80000000;
  
  /** OSX JAWT CALayer availability on Mac OS X >= 10.6 Update 4 (recommended) */
  public static final VersionNumber JAWT_MacOSXCALayerMinVersion = new VersionNumber(10,6,4);
  
  /** OSX JAWT CALayer required with Java >= 1.7.0 (implies OS X >= 10.7  */
  public static final VersionNumber JAWT_MacOSXCALayerRequiredForJavaVersion = new VersionNumber(1,7,0);
  
  // See whether we're running in headless mode
  private static final boolean headlessMode;
  private static final JAWT jawtLockObject;

  // Java2D magic ..
  private static final Method isQueueFlusherThread;
  private static final boolean j2dExist;

  private static final Method  sunToolkitAWTLockMethod;
  private static final Method  sunToolkitAWTUnlockMethod;
  private static final boolean hasSunToolkitAWTLock;

  private static final ToolkitLock jawtToolkitLock;

  private static class PrivilegedDataBlob1 {
    PrivilegedDataBlob1() {
        ok = false;
    }  
    Method  sunToolkitAWTLockMethod;
    Method  sunToolkitAWTUnlockMethod;
    boolean ok;
  }
  
  /**
   * Returns true if this platform's JAWT implementation supports offscreen layer.
   */
  public static boolean isOffscreenLayerSupported() {
       return Platform.OS_TYPE == Platform.OSType.MACOS &&
              Platform.OS_VERSION_NUMBER.compareTo(JAWTUtil.JAWT_MacOSXCALayerMinVersion) >= 0;      
  }
 
  /**
   * Returns true if this platform's JAWT implementation requires using offscreen layer.
   */
  public static boolean isOffscreenLayerRequired() {
       return Platform.OS_TYPE == Platform.OSType.MACOS &&
              Platform.JAVA_VERSION_NUMBER.compareTo(JAWT_MacOSXCALayerRequiredForJavaVersion)>=0;
  }
 
  /**
   * @param useOffscreenLayerIfAvailable
   * @return
   */
  public static JAWT getJAWT(boolean useOffscreenLayerIfAvailable) {
    final int jawt_version_flags = JAWTFactory.JAWT_VERSION_1_4;    
    JAWT jawt = JAWT.create();
    
    // default queries
    boolean tryOffscreenLayer;
    boolean tryOnscreen;
    int jawt_version_flags_offscreen = jawt_version_flags;
    
    if(isOffscreenLayerRequired()) {
        if(Platform.OS_TYPE == Platform.OSType.MACOS) {
            if(Platform.OS_VERSION_NUMBER.compareTo(JAWTUtil.JAWT_MacOSXCALayerMinVersion) >= 0) {
                jawt_version_flags_offscreen |= JAWTUtil.JAWT_MACOSX_USE_CALAYER;
                tryOffscreenLayer = true;
                tryOnscreen = false;
            } else {
                throw new RuntimeException("OSX: Invalid version of Java ("+Platform.JAVA_VERSION_NUMBER+") / OS X ("+Platform.OS_VERSION_NUMBER+")");
            }
        } else {
            throw new InternalError("offscreen required, but n/a for: "+Platform.OS_TYPE);
        }
    } else if(useOffscreenLayerIfAvailable && isOffscreenLayerSupported()) {
        if(Platform.OS_TYPE == Platform.OSType.MACOS) {
            jawt_version_flags_offscreen |= JAWTUtil.JAWT_MACOSX_USE_CALAYER;
            tryOffscreenLayer = true;
            tryOnscreen = true;
        } else {
            throw new InternalError("offscreen requested and supported, but n/a for: "+Platform.OS_TYPE);
        }
    } else {
        tryOffscreenLayer = false;
        tryOnscreen = true;
    }    
    if(DEBUG) {
        System.err.println("JAWTUtil.getJAWT(tryOffscreenLayer "+tryOffscreenLayer+", tryOnscreen "+tryOnscreen+")");
    }
    
    StringBuilder errsb = new StringBuilder();
    if(tryOffscreenLayer) {
        errsb.append("Offscreen 0x").append(Integer.toHexString(jawt_version_flags_offscreen));
        if( JAWT.getJAWT(jawt, jawt_version_flags_offscreen) ) {
            return jawt;
        }
    }
    if(tryOnscreen) {
        if(tryOffscreenLayer) {
            errsb.append(", ");
        }
        errsb.append("Onscreen 0x").append(Integer.toHexString(jawt_version_flags));
        if( JAWT.getJAWT(jawt, jawt_version_flags) ) {
            return jawt;
        }        
    }
    throw new RuntimeException("Unable to initialize JAWT, trials: "+errsb.toString());
  }
  
  public static boolean isJAWTUsingOffscreenLayer(JAWT jawt) {
      return 0 != ( jawt.getCachedVersion() & JAWTUtil.JAWT_MACOSX_USE_CALAYER );
  }
  
  static {
    if(DEBUG) {
        System.err.println("JAWTUtil initialization (JAWT/JNI/...");
        // Thread.dumpStack();
    }
    JAWTJNILibLoader.initSingleton();
    if(!JAWTJNILibLoader.loadNativeWindow("awt")) {
        throw new NativeWindowException("NativeWindow AWT native library load error.");
    }

    headlessMode = GraphicsEnvironment.isHeadless();
    boolean ok = false;
    Class<?> jC = null;
    Method m = null;
    if (!headlessMode) {
        jawtLockObject = getJAWT(false); // don't care for offscreen layer here
        try {
            jC = Class.forName("jogamp.opengl.awt.Java2D");
            m = jC.getMethod("isQueueFlusherThread", (Class[])null);
            ok = true;
        } catch (Exception e) {
        }
    } else {
        jawtLockObject = null; // headless !
    }
    isQueueFlusherThread = m;
    j2dExist = ok;

    PrivilegedDataBlob1 pdb1 = (PrivilegedDataBlob1) AccessController.doPrivileged(new PrivilegedAction<Object>() {        
        public Object run() {
            PrivilegedDataBlob1 d = new PrivilegedDataBlob1();
            try {                
                final Class<?> sunToolkitClass = Class.forName("sun.awt.SunToolkit");
                d.sunToolkitAWTLockMethod = sunToolkitClass.getDeclaredMethod("awtLock", new Class[]{});
                d.sunToolkitAWTLockMethod.setAccessible(true);
                d.sunToolkitAWTUnlockMethod = sunToolkitClass.getDeclaredMethod("awtUnlock", new Class[]{});
                d.sunToolkitAWTUnlockMethod.setAccessible(true);
                d.ok=true;
            } catch (Exception e) {
                // Either not a Sun JDK or the interfaces have changed since 1.4.2 / 1.5
            }
            return d;
        }
    });
    sunToolkitAWTLockMethod = pdb1.sunToolkitAWTLockMethod;
    sunToolkitAWTUnlockMethod = pdb1.sunToolkitAWTUnlockMethod;
    
    boolean _hasSunToolkitAWTLock = false;
    if ( pdb1.ok ) {
        try {
            sunToolkitAWTLockMethod.invoke(null, (Object[])null);
            sunToolkitAWTUnlockMethod.invoke(null, (Object[])null);
            _hasSunToolkitAWTLock = true;
        } catch (Exception e) {
        }
    }
    hasSunToolkitAWTLock = _hasSunToolkitAWTLock;
    // hasSunToolkitAWTLock = false;

    jawtToolkitLock = new ToolkitLock() {
          public final void lock() {
              JAWTUtil.lockToolkit();
          }    
          public final void unlock() {
              JAWTUtil.unlockToolkit();
          }
      };  

    // trigger native AWT toolkit / properties initialization
    Map<?,?> desktophints = null;
    try {
        if(EventQueue.isDispatchThread()) {
            desktophints = (Map<?,?>)(Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints"));
        } else {
            final ArrayList<Map<?,?>> desktophintsBucket = new ArrayList<Map<?,?>>(1);
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    Map<?,?> _desktophints = (Map<?,?>)(Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints"));
                    if(null!=_desktophints) {
                        desktophintsBucket.add(_desktophints);
                    }
                }
            });
            desktophints = ( desktophintsBucket.size() > 0 ) ? desktophintsBucket.get(0) : null ;
        }
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    } catch (InvocationTargetException ex) {
        ex.printStackTrace();
    }

    if (DEBUG) {
        System.err.println("JAWTUtil: Has sun.awt.SunToolkit.awtLock/awtUnlock " + hasSunToolkitAWTLock);
        System.err.println("JAWTUtil: Has Java2D " + j2dExist);
        System.err.println("JAWTUtil: Is headless " + headlessMode);
        int hints = ( null != desktophints ) ? desktophints.size() : 0 ;
        System.err.println("JAWTUtil: AWT Desktop hints " + hints);
        System.err.println("JAWTUtil: OffscreenLayer Supported: "+isOffscreenLayerSupported()+" - Required "+isOffscreenLayerRequired());
    }
  }

  public static void initSingleton() {
      // just exist to ensure static init has been run
  }


  public static boolean hasJava2D() {
    return j2dExist;
  }

  public static boolean isJava2DQueueFlusherThread() {
    boolean b = false;
    if(j2dExist) {
        try {
            b = ((Boolean)isQueueFlusherThread.invoke(null, (Object[])null)).booleanValue();
        } catch (Exception e) {}
    }
    return b;
  }

  public static boolean isHeadlessMode() {
    return headlessMode;
  }

  /**
   * Locks the AWT's global ReentrantLock.<br>
   *
   * JAWT's native Lock() function calls SunToolkit.awtLock(),
   * which just uses AWT's global ReentrantLock.<br>
   */
  private static void awtLock() {
    if(hasSunToolkitAWTLock) {
        try {
            sunToolkitAWTLockMethod.invoke(null, (Object[])null);
        } catch (Exception e) {
          throw new NativeWindowException("SunToolkit.awtLock failed", e);
        }
    } else {
        jawtLockObject.Lock();
    }
  }

  /**
   * Unlocks the AWT's global ReentrantLock.<br>
   *
   * JAWT's native Unlock() function calls SunToolkit.awtUnlock(),
   * which just uses AWT's global ReentrantLock.<br>
   */
  private static void awtUnlock() {
    if(hasSunToolkitAWTLock) {
        try {
            sunToolkitAWTUnlockMethod.invoke(null, (Object[])null);
        } catch (Exception e) {
          throw new NativeWindowException("SunToolkit.awtUnlock failed", e);
        }
    } else {
        jawtLockObject.Unlock();
    }
  }

  public static void lockToolkit() throws NativeWindowException {
    if(ToolkitLock.TRACE_LOCK) { System.err.println("JAWTUtil-ToolkitLock.lock()"); }
    if(!headlessMode && !isJava2DQueueFlusherThread()) {
        awtLock();
    }
  }

  public static void unlockToolkit() {
    if(ToolkitLock.TRACE_LOCK) { System.err.println("JAWTUtil-ToolkitLock.unlock()"); }
    if(!headlessMode && !isJava2DQueueFlusherThread()) {
        awtUnlock();
    }
  }

  public static ToolkitLock getJAWTToolkitLock() {
    return jawtToolkitLock;
  }
  
}

