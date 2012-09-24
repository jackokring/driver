/*
 * Copyright (c) 2008 Sun Microsystems, Inc. All Rights Reserved.
 * Copyright (c) 2011 JogAmp Community. All rights reserved.
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
 * Sun gratefully acknowledges that this software was originally authored
 * and developed by Kenneth Bradley Russell and Christopher John Kline.
 */

package jogamp.opengl.egl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Map;

import javax.media.nativewindow.AbstractGraphicsConfiguration;
import javax.media.nativewindow.AbstractGraphicsDevice;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;
import javax.media.opengl.GLProfile;

import jogamp.opengl.GLContextImpl;
import jogamp.opengl.GLDrawableImpl;

import com.jogamp.common.nio.Buffers;
import com.jogamp.common.os.Platform;
import com.jogamp.gluegen.runtime.ProcAddressTable;
import com.jogamp.gluegen.runtime.opengl.GLProcAddressResolver;

public abstract class EGLContext extends GLContextImpl {
    private boolean eglQueryStringInitialized;
    private boolean eglQueryStringAvailable;
    private EGLExt _eglExt;
    // Table that holds the addresses of the native C-language entry points for
    // EGL extension functions.
    private EGLExtProcAddressTable eglExtProcAddressTable;

    EGLContext(GLDrawableImpl drawable,
               GLContext shareWith) {
        super(drawable, shareWith);
    }

    @Override
    protected void resetStates() {
        eglQueryStringInitialized = false;
        eglQueryStringAvailable = false;
        eglExtProcAddressTable = null;
        // no inner state _eglExt = null;
        super.resetStates();
    }

    @Override
    public Object getPlatformGLExtensions() {
      return getEGLExt();
    }

    public EGLExt getEGLExt() {
      if (_eglExt == null) {
        _eglExt = new EGLExtImpl(this);
      }
      return _eglExt;
    }

    @Override
    public final ProcAddressTable getPlatformExtProcAddressTable() {
        return eglExtProcAddressTable;
    }

    public final EGLExtProcAddressTable getEGLExtProcAddressTable() {
        return eglExtProcAddressTable;
    }

    @Override
    protected Map<String, String> getFunctionNameMap() { return null; }

    @Override
    protected Map<String, String> getExtensionNameMap() { return null; }

    @Override
    public final boolean isGLReadDrawableAvailable() {
        return true;
    }

    @Override
    protected void makeCurrentImpl() throws GLException {
        if (EGL.eglGetCurrentContext() != contextHandle) {
            if (!EGL.eglMakeCurrent(drawable.getNativeSurface().getDisplayHandle(), drawable.getHandle(), drawableRead.getHandle(), contextHandle)) {
                throw new GLException("Error making context 0x" +
                                      Long.toHexString(contextHandle) + " current: error code 0x" + Integer.toHexString(EGL.eglGetError()));
            }
        }
    }

    @Override
    protected void releaseImpl() throws GLException {
      if (!EGL.eglMakeCurrent(drawable.getNativeSurface().getDisplayHandle(), EGL.EGL_NO_SURFACE, EGL.EGL_NO_SURFACE, EGL.EGL_NO_CONTEXT)) {
            throw new GLException("Error freeing OpenGL context 0x" +
                                  Long.toHexString(contextHandle) + ": error code 0x" + Integer.toHexString(EGL.eglGetError()));
      }
    }

    @Override
    protected void destroyImpl() throws GLException {
      if (!EGL.eglDestroyContext(drawable.getNativeSurface().getDisplayHandle(), contextHandle)) {
          final int eglError = EGL.eglGetError();
          if(EGL.EGL_SUCCESS != eglError) { /* oops, Mesa EGL impl. may return false, but has no EGL error */
              throw new GLException("Error destroying OpenGL context 0x" +
                                    Long.toHexString(contextHandle) + ": error code 0x" + Integer.toHexString(eglError));
          }
      }
    }

    @Override
    protected long createContextARBImpl(long share, boolean direct, int ctp, int major, int minor) {
        return 0; // FIXME
    }

    @Override
    protected void destroyContextARBImpl(long _context) {
        // FIXME
    }

    @Override
    protected boolean createImpl(GLContextImpl shareWith) throws GLException {
        final EGLGraphicsConfiguration config = (EGLGraphicsConfiguration) drawable.getNativeSurface().getGraphicsConfiguration();
        final long eglDisplay = config.getScreen().getDevice().getHandle();
        final GLProfile glProfile = drawable.getGLProfile();
        final long eglConfig = config.getNativeConfig();
        long shareWithHandle = EGL.EGL_NO_CONTEXT;

        if ( 0 == eglDisplay ) {
            throw new GLException("Error: attempted to create an OpenGL context without a display connection");
        }
        if ( 0 == eglConfig ) {
            throw new GLException("Error: attempted to create an OpenGL context without a graphics configuration");
        }

        try {
            // might be unavailable on EGL < 1.2
            if(!EGL.eglBindAPI(EGL.EGL_OPENGL_ES_API)) {
                throw new GLException("Catched: eglBindAPI to ES failed , error 0x"+Integer.toHexString(EGL.eglGetError()));
            }
        } catch (GLException glex) {
            if (DEBUG) {
                glex.printStackTrace();
            }
        }

        if (shareWith != null) {
            shareWithHandle = shareWith.getHandle();
            if (shareWithHandle == 0) {
                throw new GLException("GLContextShareSet returned an invalid OpenGL context");
            }
        }

        final IntBuffer contextAttrsNIO;
        {
            final int[] contextAttrs = new int[] {
                    EGL.EGL_CONTEXT_CLIENT_VERSION, -1,
                    EGL.EGL_NONE
            };
            if (glProfile.usesNativeGLES2()) {
                contextAttrs[1] = 2;
            } else if (glProfile.usesNativeGLES1()) {
                contextAttrs[1] = 1;
            } else {
                throw new GLException("Error creating OpenGL context - invalid GLProfile: "+glProfile);
            }
            contextAttrsNIO = Buffers.newDirectIntBuffer(contextAttrs);
        }
        contextHandle = EGL.eglCreateContext(eglDisplay, eglConfig, shareWithHandle, contextAttrsNIO);
        if (contextHandle == 0) {
            throw new GLException("Error creating OpenGL context: eglDisplay "+toHexString(eglDisplay)+
                                  ", eglConfig "+config+", "+glProfile+", shareWith "+toHexString(shareWithHandle)+", error "+toHexString(EGL.eglGetError()));
        }
        if (DEBUG) {
            System.err.println(getThreadName() + ": Created OpenGL context 0x" +
                               Long.toHexString(contextHandle) +
                               ",\n\twrite surface 0x" + Long.toHexString(drawable.getHandle()) +
                               ",\n\tread  surface 0x" + Long.toHexString(drawableRead.getHandle())+
                               ",\n\t"+this+
                               ",\n\tsharing with 0x" + Long.toHexString(shareWithHandle));
        }
        if (!EGL.eglMakeCurrent(eglDisplay, drawable.getHandle(), drawableRead.getHandle(), contextHandle)) {
            throw new GLException("Error making context 0x" +
                                  Long.toHexString(contextHandle) + " current: error code " + EGL.eglGetError());
        }
        setGLFunctionAvailability(true, glProfile.usesNativeGLES2() ? 2 : 1, 0, CTX_PROFILE_ES);
        return true;
    }

    @Override
    protected final void updateGLXProcAddressTable() {
        final AbstractGraphicsConfiguration aconfig = drawable.getNativeSurface().getGraphicsConfiguration();
        final AbstractGraphicsDevice adevice = aconfig.getScreen().getDevice();
        final String key = "EGL-"+adevice.getUniqueID();
        if (DEBUG) {
          System.err.println(getThreadName() + ": Initializing EGLextension address table: "+key);
        }
        eglQueryStringInitialized = false;
        eglQueryStringAvailable = false;

        ProcAddressTable table = null;
        synchronized(mappedContextTypeObjectLock) {
            table = mappedGLXProcAddress.get( key );
        }
        if(null != table) {
            eglExtProcAddressTable = (EGLExtProcAddressTable) table;
            if(DEBUG) {
                System.err.println(getThreadName() + ": GLContext EGL ProcAddressTable reusing key("+key+") -> "+toHexString(table.hashCode()));
            }
        } else {
            eglExtProcAddressTable = new EGLExtProcAddressTable(new GLProcAddressResolver());
            resetProcAddressTable(getEGLExtProcAddressTable());
            synchronized(mappedContextTypeObjectLock) {
                mappedGLXProcAddress.put(key, getEGLExtProcAddressTable());
                if(DEBUG) {
                    System.err.println(getThreadName() + ": GLContext EGL ProcAddressTable mapping key("+key+") -> "+toHexString(getEGLExtProcAddressTable().hashCode()));
                }
            }
        }
    }

    @Override
    protected final StringBuilder getPlatformExtensionsStringImpl() {
        StringBuilder sb = new StringBuilder();
        if (!eglQueryStringInitialized) {
          eglQueryStringAvailable =
            getDrawableImpl().getGLDynamicLookupHelper().dynamicLookupFunction("eglQueryString") != 0;
          eglQueryStringInitialized = true;
        }
        if (eglQueryStringAvailable) {
            final String ret = EGL.eglQueryString(drawable.getNativeSurface().getDisplayHandle(), EGL.EGL_EXTENSIONS);
            if (DEBUG) {
              System.err.println("EGL extensions: " + ret);
            }
            sb.append(ret);
        }
        return sb;
    }

    @Override
    protected boolean setSwapIntervalImpl(int interval) {
        // FIXME !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // eglSwapInterval(..) issued:
        //   Android 4.0.3 / Pandaboard ES / PowerVR SGX 540: crashes
        // FIXME !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if( Platform.OSType.ANDROID == Platform.getOSType() && getGLRendererString(true).contains("powervr") ) {
            if(DEBUG) {
                System.err.println("Ignored: eglSwapInterval("+interval+") - cause: OS "+Platform.getOSType() + " / Renderer " + getGLRendererString(false));
            }
            return false;
        }
        return EGL.eglSwapInterval(drawable.getNativeSurface().getDisplayHandle(), interval);
    }

    @Override
    public abstract void bindPbufferToTexture();

    @Override
    public abstract void releasePbufferFromTexture();

    //
    // Accessible ..
    //
    
    /**
     * If context is an ES profile, map it to the given device 
     * via {@link GLContext#mapAvailableGLVersion(AbstractGraphicsDevice, int, int, int, int, int)}.
     * <p>
     * We intentionally override a non native EGL device ES profile mapping,
     * i.e. this will override/modify an already 'set' X11/WGL/.. mapping.
     * </p> 
     * 
     * @param device
     */
    protected void mapCurrentAvailableGLVersion(AbstractGraphicsDevice device) {
        mapCurrentAvailableGLVersionImpl(device, ctxMajorVersion, ctxMinorVersion, ctxOptions);
    }
        
    protected static void mapStaticGLESVersion(AbstractGraphicsDevice device, int major) {
        int ctp = ( 2 == major ) ? ( GLContext.CTX_PROFILE_ES | GLContext.CTX_IMPL_ES2_COMPAT | GLContext.CTX_IMPL_FBO ) : ( GLContext.CTX_PROFILE_ES );  
        mapCurrentAvailableGLVersionImpl(device, major, 0, ctp);
    }
    private static void mapCurrentAvailableGLVersionImpl(AbstractGraphicsDevice device, int major, int minor, int ctp) {
        if( 0 != ( ctp & GLContext.CTX_PROFILE_ES) ) {
            // ES1 or ES2
            final int reqMajor = major;
            final int reqProfile = GLContext.CTX_PROFILE_ES;
            GLContext.mapAvailableGLVersion(device, reqMajor, reqProfile,
                                            major, minor, ctp);
        }
    }
    
    protected static boolean getAvailableGLVersionsSet(AbstractGraphicsDevice device) {
        return GLContext.getAvailableGLVersionsSet(device);
    }
    protected static void setAvailableGLVersionsSet(AbstractGraphicsDevice device) {
        GLContext.setAvailableGLVersionsSet(device);
    }
    
    protected static String toHexString(int hex) {
        return GLContext.toHexString(hex);
    }
    protected static String toHexString(long hex) {
        return GLContext.toHexString(hex);
    }

    //----------------------------------------------------------------------
    // Currently unimplemented stuff
    //

    @Override
    protected void copyImpl(GLContext source, int mask) throws GLException {
        throw new GLException("Not yet implemented");
    }


    @Override
    public ByteBuffer glAllocateMemoryNV(int arg0, float arg1, float arg2, float arg3) {
        throw new GLException("Should not call this");
    }

    @Override
    public boolean offscreenImageNeedsVerticalFlip() {
        throw new GLException("Should not call this");
    }

    @Override
    public int getOffscreenContextPixelDataType() {
        throw new GLException("Should not call this");
    }
}
