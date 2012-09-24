package jogamp.opengl.util.glsl.fixedfunc;

import java.io.*;
import javax.media.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import javax.media.opengl.fixedfunc.GLPointerFunc;
import jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook;
import javax.media.opengl.GL2ES2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.GL;

/**
 * Composable pipeline {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncImpl}, implementing the interface
 * {@link javax.media.opengl.GL2ES1}
 * <p>
 * Each method follows the call graph <ul>
 *   <li> call <em>prolog</em> {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook} if available
 *   <li> call <em>downstream</em> {@link javax.media.opengl.GL2ES2} if available
 *        <strong>and</strong> if no call to {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook} is made
 * </ul><p>
 * 
 * <ul>
 *   <li> <em>Interface</em> {@link javax.media.opengl.GL2ES1}
 *   <li> <em>Prolog</em> {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook}
 *   <li> <em>Downstream</em> {@link javax.media.opengl.GL2ES2}
 * </ul><p>
 *  Sample code which installs this pipeline: </P>
 * 
<PRE>
     GL gl = drawable.setGL( new FixedFuncImpl( drawable.getGL().getGL2ES2(), new FixedFuncHook( drawable.getGL().getGL2ES2() ) ) );
</PRE>
*/
public class FixedFuncImpl implements javax.media.opengl.GL, javax.media.opengl.fixedfunc.GLMatrixFunc, javax.media.opengl.fixedfunc.GLPointerFunc, javax.media.opengl.fixedfunc.GLLightingFunc, javax.media.opengl.GL2ES1{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("FixedFuncImpl");
  public FixedFuncImpl(GL2ES2 downstreamGL2ES2, FixedFuncHook prologFixedFuncHook)
  {
    if (downstreamGL2ES2 == null) {
      throw new IllegalArgumentException("null downstreamGL2ES2");
    }
    this.downstreamGL2ES2 = downstreamGL2ES2;
    this.prologFixedFuncHook = prologFixedFuncHook;
  }

  public boolean isGL() {
    return true;
  }
  public boolean isGL4bc() {
    return false;
  }
  public boolean isGL4() {
    return false;
  }
  public boolean isGL3bc() {
    return false;
  }
  public boolean isGL3() {
    return false;
  }
  public boolean isGL2() {
    return false;
  }
  public boolean isGLES1() {
    return false;
  }
  public boolean isGLES2() {
    return false;
  }
  public boolean isGL2ES1() {
    return true;
  }
  public boolean isGL2ES2() {
    return false;
  }
  public boolean isGL2GL3() {
    return false;
  }
  public boolean isGLES() {
    return isGLES2() || isGLES1();
  }
  public boolean isGLES2Compatible() {
    return downstreamGL2ES2.isGLES2Compatible();
  }
  public javax.media.opengl.GL getGL() {
    return this;
  }
  public javax.media.opengl.GL4bc getGL4bc() {
    throw new GLException("Not a GL4bc implementation");
  }
  public javax.media.opengl.GL4 getGL4() {
    throw new GLException("Not a GL4 implementation");
  }
  public javax.media.opengl.GL3bc getGL3bc() {
    throw new GLException("Not a GL3bc implementation");
  }
  public javax.media.opengl.GL3 getGL3() {
    throw new GLException("Not a GL3 implementation");
  }
  public javax.media.opengl.GL2 getGL2() {
    throw new GLException("Not a GL2 implementation");
  }
  public javax.media.opengl.GLES1 getGLES1() {
    throw new GLException("Not a GLES1 implementation");
  }
  public javax.media.opengl.GLES2 getGLES2() {
    throw new GLException("Not a GLES2 implementation");
  }
  public javax.media.opengl.GL2ES1 getGL2ES1() {
    return this;
  }
  public javax.media.opengl.GL2ES2 getGL2ES2() {
    throw new GLException("Not a GL2ES2 implementation");
  }
  public javax.media.opengl.GL2GL3 getGL2GL3() {
    throw new GLException("Not a GL2GL3 implementation");
  }
  public GLProfile getGLProfile() {
    return downstreamGL2ES2.getGLProfile();
  }
  public  int getDefaultReadFramebuffer()
  {
        return downstreamGL2ES2.getDefaultReadFramebuffer();
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glGetBufferParameteriv(arg0,arg1,arg2);
  }
  public  void glBindTexture(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindTexture(arg0,arg1);
  }
  public  void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    downstreamGL2ES2.glColorMask(arg0,arg1,arg2,arg3);
  }
  public  boolean glIsVBOElementArrayEnabled()
  {
        return downstreamGL2ES2.glIsVBOElementArrayEnabled();
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    prologFixedFuncHook.glDrawElements(arg0,arg1,arg2,arg3);
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    downstreamGL2ES2.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  public  void glColor4f(float arg0,float arg1,float arg2,float arg3)
  {
    prologFixedFuncHook.glColor4f(arg0,arg1,arg2,arg3);
  }
  public  void glColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    prologFixedFuncHook.glColorPointer(arg0,arg1,arg2,arg3);
  }
  public  void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    prologFixedFuncHook.glMaterialfv(arg0,arg1,arg2);
  }
  public  void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    downstreamGL2ES2.glGetTexParameterfv(arg0,arg1,arg2);
  }
  public  void glScalef(float arg0,float arg1,float arg2)
  {
    prologFixedFuncHook.glScalef(arg0,arg1,arg2);
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    downstreamGL2ES2.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  public  void glTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")"); } 
  }
  public  void glClientActiveTexture(int arg0)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glClientActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")"); } 
  }
  public  void glCurrentPaletteMatrix(int arg0)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glCurrentPaletteMatrix("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")"); } 
  }
  public  void glNormalPointer(int arg0,int arg1,long arg2)
  {
    prologFixedFuncHook.glNormalPointer(arg0,arg1,arg2);
  }
  public  void glDepthRangef(float arg0,float arg1)
  {
    downstreamGL2ES2.glDepthRangef(arg0,arg1);
  }
  public  void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glOrtho("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")"); } 
  }
  public  void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    downstreamGL2ES2.glClearColor(arg0,arg1,arg2,arg3);
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    downstreamGL2ES2.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
  }
  public  void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteBuffers(arg0,arg1);
  }
  public  void glTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  boolean hasGLSL()
  {
        return downstreamGL2ES2.hasGLSL();
  }
  public  void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    downstreamGL2ES2.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  public  void glGenerateMipmap(int arg0)
  {
    downstreamGL2ES2.glGenerateMipmap(arg0);
  }
  public  void glMatrixMode(int arg0)
  {
    prologFixedFuncHook.glMatrixMode(arg0);
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    downstreamGL2ES2.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
  }
  public  boolean glUnmapBuffer(int arg0)
  {
        return downstreamGL2ES2.glUnmapBuffer(arg0);
  }
  public  void glPointSize(float arg0)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glPointSize("+"<float> "+arg0+")"); } 
  }
  public  void glGetTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  public  void glFogf(int arg0,float arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFogf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")"); } 
  }
  public  void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  public  void glEnable(int arg0)
  {
    prologFixedFuncHook.glEnable(arg0);
  }
  public  void glDepthRange(double arg0,double arg1)
  {
    downstreamGL2ES2.glDepthRange(arg0,arg1);
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    downstreamGL2ES2.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  public  int getSwapInterval()
  {
        return downstreamGL2ES2.getSwapInterval();
  }
  public  void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    downstreamGL2ES2.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  public  void glGetTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glBindFramebuffer(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindFramebuffer(arg0,arg1);
  }
  public  void glLightf(int arg0,int arg1,float arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")"); } 
  }
  public  void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3)
  {
    prologFixedFuncHook.glTexCoordPointer(arg0,arg1,arg2,arg3);
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    downstreamGL2ES2.glGetnUniformiv(arg0,arg1,arg2,arg3);
  }
  public  void glMatrixIndexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glMatrixIndexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")"); } 
  }
  public  void glLightModelf(int arg0,float arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightModelf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")"); } 
  }
  public  void glBlendFunc(int arg0,int arg1)
  {
    downstreamGL2ES2.glBlendFunc(arg0,arg1);
  }
  public  void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  public  void glSampleCoverage(float arg0,boolean arg1)
  {
    downstreamGL2ES2.glSampleCoverage(arg0,arg1);
  }
  public  void glColorPointer(javax.media.opengl.GLArrayData arg0)
  {
    prologFixedFuncHook.glColorPointer(arg0);
  }
  public  void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")"); } 
  }
  public  void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
  }
  public  void glEnableClientState(int arg0)
  {
    prologFixedFuncHook.glEnableClientState(arg0);
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    downstreamGL2ES2.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glGetRenderbufferParameteriv(arg0,arg1,arg2);
  }
  public  boolean glIsVBOArrayEnabled()
  {
        return downstreamGL2ES2.glIsVBOArrayEnabled();
  }
  public  void glBindBuffer(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindBuffer(arg0,arg1);
  }
  public  void glLoadMatrixf(float[] arg0,int arg1)
  {
    prologFixedFuncHook.glLoadMatrixf(arg0,arg1);
  }
  public  void glFogfv(int arg0,float[] arg1,int arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  public  void glTexParameteri(int arg0,int arg1,int arg2)
  {
    downstreamGL2ES2.glTexParameteri(arg0,arg1,arg2);
  }
  public  void glClearStencil(int arg0)
  {
    downstreamGL2ES2.glClearStencil(arg0);
  }
  public  void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenBuffers(arg0,arg1);
  }
  public  void glBlendEquationSeparate(int arg0,int arg1)
  {
    downstreamGL2ES2.glBlendEquationSeparate(arg0,arg1);
  }
  public  void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenRenderbuffers(arg0,arg1);
  }
  public  void glGetMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glNormal3f(float arg0,float arg1,float arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glNormal3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")"); } 
  }
  public  void glTexGeni(int arg0,int arg1,int arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexGeni("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  public  void glFlush()
  {
    downstreamGL2ES2.glFlush();
  }
  public  void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    downstreamGL2ES2.glBufferData(arg0,arg1,arg2,arg3);
  }
  public  void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    prologFixedFuncHook.glGetIntegerv(arg0,arg1);
  }
  public  void glLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    prologFixedFuncHook.glLightfv(arg0,arg1,arg2,arg3);
  }
  public  void glVertexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    prologFixedFuncHook.glVertexPointer(arg0,arg1,arg2,arg3);
  }
  public  void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
  }
  public  void glGetLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    downstreamGL2ES2.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
  }
  public  void glActiveTexture(int arg0)
  {
    prologFixedFuncHook.glActiveTexture(arg0);
  }
  public  void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
  }
  public  void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenFramebuffers(arg0,arg1);
  }
  public  void glClearDepthf(float arg0)
  {
    downstreamGL2ES2.glClearDepthf(arg0);
  }
  public  boolean glIsFramebuffer(int arg0)
  {
        return downstreamGL2ES2.glIsFramebuffer(arg0);
  }
  public  void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteFramebuffers(arg0,arg1,arg2);
  }
  public  void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    downstreamGL2ES2.glTexParameterfv(arg0,arg1,arg2);
  }
  public  void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteTextures(arg0,arg1);
  }
  public  void glLightModelfv(int arg0,float[] arg1,int arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  public  void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    downstreamGL2ES2.glGetBooleanv(arg0,arg1);
  }
  public  boolean glIsEnabled(int arg0)
  {
        return downstreamGL2ES2.glIsEnabled(arg0);
  }
  public  void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
    prologFixedFuncHook.glGetFloatv(arg0,arg1,arg2);
  }
  public  boolean glIsTexture(int arg0)
  {
        return downstreamGL2ES2.glIsTexture(arg0);
  }
  public  void glVertexPointer(javax.media.opengl.GLArrayData arg0)
  {
    prologFixedFuncHook.glVertexPointer(arg0);
  }
  public  void glLoadIdentity()
  {
    prologFixedFuncHook.glLoadIdentity();
  }
  public  void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetTexParameteriv(arg0,arg1,arg2,arg3);
  }
  public  boolean isExtensionAvailable(java.lang.String arg0)
  {
        return downstreamGL2ES2.isExtensionAvailable(arg0);
  }
  public  void glClearDepth(double arg0)
  {
    downstreamGL2ES2.glClearDepth(arg0);
  }
  public  void glTexEnvi(int arg0,int arg1,int arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  public  void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenTextures(arg0,arg1);
  }
  public  void glCullFace(int arg0)
  {
    prologFixedFuncHook.glCullFace(arg0);
  }
  public  void glNormalPointer(javax.media.opengl.GLArrayData arg0)
  {
    prologFixedFuncHook.glNormalPointer(arg0);
  }
  public  void glTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glStencilOp(int arg0,int arg1,int arg2)
  {
    downstreamGL2ES2.glStencilOp(arg0,arg1,arg2);
  }
  public  void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteRenderbuffers(arg0,arg1,arg2);
  }
  public  void setSwapInterval(int arg0)
  {
    downstreamGL2ES2.setSwapInterval(arg0);
  }
  public  void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glTexParameteriv(arg0,arg1,arg2);
  }
  public  void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
  }
  public  void glMultMatrixf(float[] arg0,int arg1)
  {
    prologFixedFuncHook.glMultMatrixf(arg0,arg1);
  }
  public  void glBlendEquation(int arg0)
  {
    downstreamGL2ES2.glBlendEquation(arg0);
  }
  public  void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    downstreamGL2ES2.glBufferSubData(arg0,arg1,arg2,arg3);
  }
  public  void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetTexParameterfv(arg0,arg1,arg2,arg3);
  }
  public  void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    prologFixedFuncHook.glTexCoordPointer(arg0,arg1,arg2,arg3);
  }
  public  void glOrthof(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    prologFixedFuncHook.glOrthof(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  public  int getDefaultDrawFramebuffer()
  {
        return downstreamGL2ES2.getDefaultDrawFramebuffer();
  }
  public  void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFrustum("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")"); } 
  }
  public  void glHint(int arg0,int arg1)
  {
    downstreamGL2ES2.glHint(arg0,arg1);
  }
  public  void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    downstreamGL2ES2.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  public  void glPointParameterf(int arg0,float arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glPointParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")"); } 
  }
  public  void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    downstreamGL2ES2.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  public  void glStencilFunc(int arg0,int arg1,int arg2)
  {
    downstreamGL2ES2.glStencilFunc(arg0,arg1,arg2);
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    downstreamGL2ES2.glGetnUniformfv(arg0,arg1,arg2,arg3);
  }
  public  javax.media.opengl.GLContext getContext()
  {
        return downstreamGL2ES2.getContext();
  }
  public  void glFinish()
  {
    downstreamGL2ES2.glFinish();
  }
  public  void glDepthFunc(int arg0)
  {
    downstreamGL2ES2.glDepthFunc(arg0);
  }
  public  java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
        return downstreamGL2ES2.glMapBuffer(arg0,arg1);
  }
  public  void glAlphaFunc(int arg0,float arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glAlphaFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")"); } 
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    downstreamGL2ES2.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  public  void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glRenderbufferStorage(arg0,arg1,arg2,arg3);
  }
  public  void glTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glMultiTexCoord4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")"); } 
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    downstreamGL2ES2.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
  }
  public  void glMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    prologFixedFuncHook.glMaterialfv(arg0,arg1,arg2,arg3);
  }
  public  void glDepthMask(boolean arg0)
  {
    downstreamGL2ES2.glDepthMask(arg0);
  }
  public  long glGetBufferSize(int arg0)
  {
        return downstreamGL2ES2.glGetBufferSize(arg0);
  }
  public  void glNormalPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
    prologFixedFuncHook.glNormalPointer(arg0,arg1,arg2);
  }
  public  void glLogicOp(int arg0)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLogicOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")"); } 
  }
  public  void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    downstreamGL2ES2.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    downstreamGL2ES2.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  public  void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteBuffers(arg0,arg1,arg2);
  }
  public  void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")"); } 
  }
  public  void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glTexStorage1D(arg0,arg1,arg2,arg3);
  }
  public  void glFrontFace(int arg0)
  {
    downstreamGL2ES2.glFrontFace(arg0);
  }
  public  void glTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  int glGetBoundBuffer(int arg0)
  {
        return downstreamGL2ES2.glGetBoundBuffer(arg0);
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    downstreamGL2ES2.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
  }
  public  void glTexCoordPointer(javax.media.opengl.GLArrayData arg0)
  {
    prologFixedFuncHook.glTexCoordPointer(arg0);
  }
  public  void glTexParameterf(int arg0,int arg1,float arg2)
  {
    downstreamGL2ES2.glTexParameterf(arg0,arg1,arg2);
  }
  public  void glTranslatef(float arg0,float arg1,float arg2)
  {
    prologFixedFuncHook.glTranslatef(arg0,arg1,arg2);
  }
  public  void glFrustumf(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    prologFixedFuncHook.glFrustumf(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    prologFixedFuncHook.glDrawElements(arg0,arg1,arg2,arg3);
  }
  public  int getBoundFramebuffer(int arg0)
  {
        return downstreamGL2ES2.getBoundFramebuffer(arg0);
  }
  public  void glShadeModel(int arg0)
  {
    prologFixedFuncHook.glShadeModel(arg0);
  }
  public  void glColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
    prologFixedFuncHook.glColorPointer(arg0,arg1,arg2,arg3);
  }
  public  void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glScissor(arg0,arg1,arg2,arg3);
  }
  public  void glGetTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glGetTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glGetTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")"); } 
  }
  public  int glGetGraphicsResetStatus()
  {
        return downstreamGL2ES2.glGetGraphicsResetStatus();
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    downstreamGL2ES2.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  public  void glPixelStorei(int arg0,int arg1)
  {
    downstreamGL2ES2.glPixelStorei(arg0,arg1);
  }
  public  void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenBuffers(arg0,arg1,arg2);
  }
  public  void glTexGenf(int arg0,int arg1,float arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexGenf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")"); } 
  }
  public  void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    prologFixedFuncHook.glLightfv(arg0,arg1,arg2);
  }
  public  void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenRenderbuffers(arg0,arg1,arg2);
  }
  public  void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  public  void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")"); } 
  }
  public  boolean glIsBuffer(int arg0)
  {
        return downstreamGL2ES2.glIsBuffer(arg0);
  }
  public  void glGetTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  public  void glWeightPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glWeightPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")"); } 
  }
  public  boolean glIsRenderbuffer(int arg0)
  {
        return downstreamGL2ES2.glIsRenderbuffer(arg0);
  }
  public  void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    downstreamGL2ES2.glTexParameterfv(arg0,arg1,arg2,arg3);
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
  }
  public  void glLightModelfv(int arg0,java.nio.FloatBuffer arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")"); } 
  }
  public  int glGetError()
  {
        return downstreamGL2ES2.glGetError();
  }
  public  void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    downstreamGL2ES2.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  public  void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenFramebuffers(arg0,arg1,arg2);
  }
  public  void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
  }
  public  void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteFramebuffers(arg0,arg1);
  }
  public  void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteTextures(arg0,arg1,arg2);
  }
  public  void glLoadMatrixf(java.nio.FloatBuffer arg0)
  {
    prologFixedFuncHook.glLoadMatrixf(arg0);
  }
  public  void glDisable(int arg0)
  {
    prologFixedFuncHook.glDisable(arg0);
  }
  public  void glFogfv(int arg0,java.nio.FloatBuffer arg1)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")"); } 
  }
  public  void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  public  void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    prologFixedFuncHook.glGetIntegerv(arg0,arg1,arg2);
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    downstreamGL2ES2.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
  }
  public  int glCheckFramebufferStatus(int arg0)
  {
        return downstreamGL2ES2.glCheckFramebufferStatus(arg0);
  }
  public  java.lang.Object getExtension(java.lang.String arg0)
  {
        return downstreamGL2ES2.getExtension(arg0);
  }
  public  void glTexEnvf(int arg0,int arg1,float arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")"); } 
  }
  public  void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glGetTexParameteriv(arg0,arg1,arg2);
  }
  public  void glPopMatrix()
  {
    prologFixedFuncHook.glPopMatrix();
  }
  public  void glVertexPointer(int arg0,int arg1,int arg2,long arg3)
  {
    prologFixedFuncHook.glVertexPointer(arg0,arg1,arg2,arg3);
  }
  public  void glTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  public  void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3)
  {
        if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glColor4ub("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+")"); } 
  }
  public  java.lang.Object getPlatformGLExtensions()
  {
        return downstreamGL2ES2.getPlatformGLExtensions();
  }
  public  void glDisableClientState(int arg0)
  {
    prologFixedFuncHook.glDisableClientState(arg0);
  }
  public  void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenTextures(arg0,arg1,arg2);
  }
  public  void glClear(int arg0)
  {
    downstreamGL2ES2.glClear(arg0);
  }
  public  void glMultMatrixf(java.nio.FloatBuffer arg0)
  {
    prologFixedFuncHook.glMultMatrixf(arg0);
  }
  public  boolean isNPOTTextureAvailable()
  {
        return downstreamGL2ES2.isNPOTTextureAvailable();
  }
  public  boolean isFunctionAvailable(java.lang.String arg0)
  {
        return downstreamGL2ES2.isFunctionAvailable(arg0);
  }
  public  void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    downstreamGL2ES2.glGetBooleanv(arg0,arg1,arg2);
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    downstreamGL2ES2.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  public  void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glTexParameteriv(arg0,arg1,arg2,arg3);
  }
  public  void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    prologFixedFuncHook.glGetFloatv(arg0,arg1);
  }
  public  void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glViewport(arg0,arg1,arg2,arg3);
  }
  public  void glMaterialf(int arg0,int arg1,float arg2)
  {
    prologFixedFuncHook.glMaterialf(arg0,arg1,arg2);
  }
  public  void glBindRenderbuffer(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindRenderbuffer(arg0,arg1);
  }
  public  void glDrawArrays(int arg0,int arg1,int arg2)
  {
    prologFixedFuncHook.glDrawArrays(arg0,arg1,arg2);
  }
  public  java.lang.String glGetString(int arg0)
  {
        return downstreamGL2ES2.glGetString(arg0);
  }
  public  void glPolygonOffset(float arg0,float arg1)
  {
    downstreamGL2ES2.glPolygonOffset(arg0,arg1);
  }
  public  void glLineWidth(float arg0)
  {
    downstreamGL2ES2.glLineWidth(arg0);
  }
  public  void glPushMatrix()
  {
    prologFixedFuncHook.glPushMatrix();
  }
  public  void glRotatef(float arg0,float arg1,float arg2,float arg3)
  {
    prologFixedFuncHook.glRotatef(arg0,arg1,arg2,arg3);
  }
  public  void glStencilMask(int arg0)
  {
    downstreamGL2ES2.glStencilMask(arg0);
  }
  public  void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteRenderbuffers(arg0,arg1);
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("FixedFuncImpl [ implementing javax.media.opengl.GL2ES1,\n\t");
    sb.append(" prolog: "+prologFixedFuncHook.toString()+",\n\t");
    sb.append(" downstream: "+downstreamGL2ES2.toString()+"\n\t]");
    return sb.toString();
  }
  private FixedFuncHook prologFixedFuncHook;
  private GL2ES2 downstreamGL2ES2;
} // end class FixedFuncImpl
