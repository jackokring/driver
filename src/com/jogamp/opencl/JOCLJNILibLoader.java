/*
 * Copyright (c) 2009 JogAmp Community. All rights reserved.
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

package com.jogamp.opencl;

import java.security.AccessController;
import java.security.PrivilegedAction;

import com.jogamp.common.jvm.JNILibLoaderBase;
import com.jogamp.common.os.NativeLibrary;
import com.jogamp.common.os.Platform;
import com.jogamp.common.util.cache.TempJarCache;


/**
 * Responsible for JOCL lib loading.
 * @author Michael Bien
 */
class JOCLJNILibLoader extends JNILibLoaderBase {

    /**
     * Loads the native binding and returns the OpenCL library for dynamic linking.
     * @return Returns libOpenCL represented as NativeLibrary.
     */
    static NativeLibrary loadOpenCL() {
        return AccessController.doPrivileged(new PrivilegedAction<NativeLibrary>() {
          public NativeLibrary run() {
            Platform.initSingleton();
            
            // Implementation should move to com.jogamp.common.os.DynamicLibraryBundleInfo, 
            // eg.: jogamp.opengl.GLDynamicLibraryBundleInfo etc.
            final String libName = "jocl";
            if(TempJarCache.isInitialized() && null == TempJarCache.findLibrary(libName)) {
                // only: jocl.jar -> jocl-natives-<os.and.arch>.jar
                addNativeJarLibs(new Class<?>[] { JOCLJNILibLoader.class }, null, null );
            }
            loadLibrary(libName, false, JOCLJNILibLoader.class.getClassLoader());
            NativeLibrary res = NativeLibrary.open("OpenCL", JOCLJNILibLoader.class.getClassLoader());
            if(null == res) {
                // try unix name w/ version (eg.: AMD has a /usr/lib32/fglrx/libOpenCL.so.1 only)
                res = NativeLibrary.open("libOpenCL.so.1", JOCLJNILibLoader.class.getClassLoader());
            }
            return res;
          }
        });
    }
}
