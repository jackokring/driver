package javax.media.opengl;

import java.io.*;
import javax.media.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLPointerFunc;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GL;

/** <P> Composable pipeline which wraps an underlying {@link GL} implementation,
    providing error checking after each OpenGL method call. If an error occurs,
    causes a {@link GLException} to be thrown at exactly the point of failure.
    Sample code which installs this pipeline: </P>

<PRE>
     GL gl = drawable.setGL(new DebugGL(drawable.getGL()));
</PRE>
*/
public class DebugGL2ES1 implements javax.media.opengl.GL, javax.media.opengl.fixedfunc.GLMatrixFunc, javax.media.opengl.fixedfunc.GLPointerFunc, javax.media.opengl.fixedfunc.GLLightingFunc, javax.media.opengl.GL2ES1{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("DebugGL2ES1");
  public DebugGL2ES1(GL2ES1 downstreamGL2ES1)
  {
    if (downstreamGL2ES1 == null) {
      throw new IllegalArgumentException("null downstreamGL2ES1");
    }
    this.downstreamGL2ES1 = downstreamGL2ES1;
    // Fetch GLContext object for better error checking (if possible)
    _context = downstreamGL2ES1.getContext();
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
    return downstreamGL2ES1.isGLES2Compatible();
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
    return downstreamGL2ES1.getGLProfile();
  }
  public  void glBlendEquation(int arg0)
  {
        checkContext();
downstreamGL2ES1.glBlendEquation(arg0);
    String txt = new String("glBlendEquation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexPointer(int arg0,int arg1,int arg2,long arg3)
  {
        checkContext();
downstreamGL2ES1.glVertexPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<long> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glTexEnvfv(arg0,arg1,arg2);
    String txt = new String("glTexEnvfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glColorPointer(javax.media.opengl.GLArrayData arg0)
  {
        checkContext();
downstreamGL2ES1.glColorPointer(arg0);
    String txt = new String("glColorPointer(" +
    "<javax.media.opengl.GLArrayData> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glTexEnviv(arg0,arg1,arg2);
    String txt = new String("glTexEnviv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsEnabled(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsEnabled(arg0);
    String txt = new String("glIsEnabled(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glMaterialfv(arg0,arg1,arg2,arg3);
    String txt = new String("glMaterialfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsTexture(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsTexture(arg0);
    String txt = new String("glIsTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  boolean glIsVBOArrayEnabled()
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsVBOArrayEnabled();
    String txt = new String("glIsVBOArrayEnabled(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  int getSwapInterval()
  {
        return downstreamGL2ES1.getSwapInterval();
  }
  public  void glStencilOp(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glStencilOp(arg0,arg1,arg2);
    String txt = new String("glStencilOp(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL2ES1.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glTexImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  void glFlush()
  {
        checkContext();
downstreamGL2ES1.glFlush();
    String txt = new String("glFlush(" +
    ")");
    checkGLGetError( txt );
  }
  public  void setSwapInterval(int arg0)
  {
    downstreamGL2ES1.setSwapInterval(arg0);
  }
  public  void glBlendEquationSeparate(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glBlendEquationSeparate(arg0,arg1);
    String txt = new String("glBlendEquationSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSampleCoverage(float arg0,boolean arg1)
  {
        checkContext();
downstreamGL2ES1.glSampleCoverage(arg0,arg1);
    String txt = new String("glSampleCoverage(" +
    "<float> "+arg0 +    ", " +
    "<boolean> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glTexCoordPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glTexCoordPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexEnvi(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glTexEnvi(arg0,arg1,arg2);
    String txt = new String("glTexEnvi(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCullFace(int arg0)
  {
        checkContext();
downstreamGL2ES1.glCullFace(arg0);
    String txt = new String("glCullFace(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glBufferSubData(arg0,arg1,arg2,arg3);
    String txt = new String("glBufferSubData(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<long> "+arg2 +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetTexGenfv(arg0,arg1,arg2);
    String txt = new String("glGetTexGenfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetTexEnvfv(arg0,arg1,arg2);
    String txt = new String("glGetTexEnvfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
        checkContext();
downstreamGL2ES1.glNormalPointer(arg0,arg1,arg2);
    String txt = new String("glNormalPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetTexGeniv(arg0,arg1,arg2);
    String txt = new String("glGetTexGeniv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  java.lang.Object getPlatformGLExtensions()
  {
        return downstreamGL2ES1.getPlatformGLExtensions();
  }
  public  void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
        checkContext();
downstreamGL2ES1.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glReadnPixels(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    String txt = new String("glBlendFuncSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  long glGetBufferSize(int arg0)
  {
        checkContext();
    long _res = downstreamGL2ES1.glGetBufferSize(arg0);
    String txt = new String("glGetBufferSize(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glBindBuffer(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glBindBuffer(arg0,arg1);
    String txt = new String("glBindBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glDrawElements(arg0,arg1,arg2,arg3);
    String txt = new String("glDrawElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    String txt = new String("glFramebufferRenderbuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetBufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetTexGenfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexGenfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetTexEnvfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexEnvfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glNormal3f(float arg0,float arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glNormal3f(arg0,arg1,arg2);
    String txt = new String("glNormal3f(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glActiveTexture(int arg0)
  {
        checkContext();
downstreamGL2ES1.glActiveTexture(arg0);
    String txt = new String("glActiveTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL2ES1.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glTexStorage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int getDefaultReadFramebuffer()
  {
        return downstreamGL2ES1.getDefaultReadFramebuffer();
  }
  public  void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glDeleteBuffers(arg0,arg1,arg2);
    String txt = new String("glDeleteBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
        checkContext();
downstreamGL2ES1.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glReadPixels(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL2ES1.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glFramebufferTexture2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetTexParameterfv(arg0,arg1,arg2);
    String txt = new String("glGetTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearDepthf(float arg0)
  {
        checkContext();
downstreamGL2ES1.glClearDepthf(arg0);
    String txt = new String("glClearDepthf(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glMaterialfv(arg0,arg1,arg2);
    String txt = new String("glMaterialfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexGeni(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glTexGeni(arg0,arg1,arg2);
    String txt = new String("glTexGeni(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexGeniv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexGeniv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearStencil(int arg0)
  {
        checkContext();
downstreamGL2ES1.glClearStencil(arg0);
    String txt = new String("glClearStencil(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexEnvfv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexEnvfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsFramebuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsFramebuffer(arg0);
    String txt = new String("glIsFramebuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glEnableClientState(int arg0)
  {
        checkContext();
downstreamGL2ES1.glEnableClientState(arg0);
    String txt = new String("glEnableClientState(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameteri(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glTexParameteri(arg0,arg1,arg2);
    String txt = new String("glTexParameteri(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glLoadIdentity()
  {
        checkContext();
downstreamGL2ES1.glLoadIdentity();
    String txt = new String("glLoadIdentity(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL2ES1.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
        checkContext();
downstreamGL2ES1.glOrtho(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glOrtho(" +
    "<double> "+arg0 +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ", " +
    "<double> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRangef(float arg0,float arg1)
  {
        checkContext();
downstreamGL2ES1.glDepthRangef(arg0,arg1);
    String txt = new String("glDepthRangef(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsVBOElementArrayEnabled()
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsVBOElementArrayEnabled();
    String txt = new String("glIsVBOElementArrayEnabled(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL2ES1.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glCompressedTexSubImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
        checkContext();
    java.nio.ByteBuffer _res = downstreamGL2ES1.glMapBuffer(arg0,arg1);
    String txt = new String("glMapBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glPointSize(float arg0)
  {
        checkContext();
downstreamGL2ES1.glPointSize(arg0);
    String txt = new String("glPointSize(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL2ES1.glClearColor(arg0,arg1,arg2,arg3);
    String txt = new String("glClearColor(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGenRenderbuffers(arg0,arg1,arg2);
    String txt = new String("glGenRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalPointer(javax.media.opengl.GLArrayData arg0)
  {
        checkContext();
downstreamGL2ES1.glNormalPointer(arg0);
    String txt = new String("glNormalPointer(" +
    "<javax.media.opengl.GLArrayData> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetTexParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGenBuffers(arg0,arg1,arg2);
    String txt = new String("glGenBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glUnmapBuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glUnmapBuffer(arg0);
    String txt = new String("glUnmapBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glEnable(int arg0)
  {
        checkContext();
downstreamGL2ES1.glEnable(arg0);
    String txt = new String("glEnable(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGetIntegerv(arg0,arg1,arg2);
    String txt = new String("glGetIntegerv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL2ES1.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetFramebufferAttachmentParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glColor4f(float arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL2ES1.glColor4f(arg0,arg1,arg2,arg3);
    String txt = new String("glColor4f(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
        checkContext();
downstreamGL2ES1.glColorPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glColorPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<long> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glWeightPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glWeightPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glWeightPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glDeleteTextures(arg0,arg1,arg2);
    String txt = new String("glDeleteTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexPointer(javax.media.opengl.GLArrayData arg0)
  {
        checkContext();
downstreamGL2ES1.glVertexPointer(arg0);
    String txt = new String("glVertexPointer(" +
    "<javax.media.opengl.GLArrayData> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glMatrixMode(int arg0)
  {
        checkContext();
downstreamGL2ES1.glMatrixMode(arg0);
    String txt = new String("glMatrixMode(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGenFramebuffers(arg0,arg1,arg2);
    String txt = new String("glGenFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glLightf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glLightf(arg0,arg1,arg2);
    String txt = new String("glLightf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenerateMipmap(int arg0)
  {
        checkContext();
downstreamGL2ES1.glGenerateMipmap(arg0);
    String txt = new String("glGenerateMipmap(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
        checkContext();
downstreamGL2ES1.glColorMask(arg0,arg1,arg2,arg3);
    String txt = new String("glColorMask(" +
    "<boolean> "+arg0 +    ", " +
    "<boolean> "+arg1 +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<boolean> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glDeleteFramebuffers(arg0,arg1);
    String txt = new String("glDeleteFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindTexture(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glBindTexture(arg0,arg1);
    String txt = new String("glBindTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendFunc(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glBlendFunc(arg0,arg1);
    String txt = new String("glBlendFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFogf(int arg0,float arg1)
  {
        checkContext();
downstreamGL2ES1.glFogf(arg0,arg1);
    String txt = new String("glFogf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetTexEnviv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexEnviv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL2ES1.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glTexSubImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<long> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glTexParameterfv(arg0,arg1,arg2);
    String txt = new String("glTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  boolean hasGLSL()
  {
        return downstreamGL2ES1.hasGLSL();
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetRenderbufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  java.lang.Object getExtension(java.lang.String arg0)
  {
        return downstreamGL2ES1.getExtension(arg0);
  }
  public  void glClientActiveTexture(int arg0)
  {
        checkContext();
downstreamGL2ES1.glClientActiveTexture(arg0);
    String txt = new String("glClientActiveTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenTextures(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGenTextures(arg0,arg1,arg2);
    String txt = new String("glGenTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean isExtensionAvailable(java.lang.String arg0)
  {
        return downstreamGL2ES1.isExtensionAvailable(arg0);
  }
  public  void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL2ES1.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glTextureStorage2DEXT(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCurrentPaletteMatrix(int arg0)
  {
        checkContext();
downstreamGL2ES1.glCurrentPaletteMatrix(arg0);
    String txt = new String("glCurrentPaletteMatrix(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBindFramebuffer(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glBindFramebuffer(arg0,arg1);
    String txt = new String("glBindFramebuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glLightModelf(int arg0,float arg1)
  {
        checkContext();
downstreamGL2ES1.glLightModelf(arg0,arg1);
    String txt = new String("glLightModelf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glDeleteRenderbuffers(arg0,arg1);
    String txt = new String("glDeleteRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRange(double arg0,double arg1)
  {
        checkContext();
downstreamGL2ES1.glDepthRange(arg0,arg1);
    String txt = new String("glDepthRange(" +
    "<double> "+arg0 +    ", " +
    "<double> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glBufferData(arg0,arg1,arg2,arg3);
    String txt = new String("glBufferData(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<java.nio.Buffer> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
        checkContext();
downstreamGL2ES1.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glCompressedTexImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<long> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  void glScalef(float arg0,float arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glScalef(arg0,arg1,arg2);
    String txt = new String("glScalef(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
        checkContext();
downstreamGL2ES1.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glCopyTexImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilMask(int arg0)
  {
        checkContext();
downstreamGL2ES1.glStencilMask(arg0);
    String txt = new String("glStencilMask(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL2ES1.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glCompressedTexSubImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<long> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthMask(boolean arg0)
  {
        checkContext();
downstreamGL2ES1.glDepthMask(arg0);
    String txt = new String("glDepthMask(" +
    "<boolean> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexEnviv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexEnviv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
        checkContext();
downstreamGL2ES1.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glCopyTexSubImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawArrays(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glDrawArrays(arg0,arg1,arg2);
    String txt = new String("glDrawArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordPointer(javax.media.opengl.GLArrayData arg0)
  {
        checkContext();
downstreamGL2ES1.glTexCoordPointer(arg0);
    String txt = new String("glTexCoordPointer(" +
    "<javax.media.opengl.GLArrayData> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexEnvf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glTexEnvf(arg0,arg1,arg2);
    String txt = new String("glTexEnvf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL2ES1.glGetnUniformfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnUniformfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glLineWidth(float arg0)
  {
        checkContext();
downstreamGL2ES1.glLineWidth(arg0);
    String txt = new String("glLineWidth(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glMaterialf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glMaterialf(arg0,arg1,arg2);
    String txt = new String("glMaterialf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glDisableClientState(int arg0)
  {
        checkContext();
downstreamGL2ES1.glDisableClientState(arg0);
    String txt = new String("glDisableClientState(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  javax.media.opengl.GLContext getContext()
  {
        return downstreamGL2ES1.getContext();
  }
  public  void glClear(int arg0)
  {
        checkContext();
downstreamGL2ES1.glClear(arg0);
    String txt = new String("glClear(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetTexGeniv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexGeniv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetGraphicsResetStatus()
  {
        checkContext();
    int _res = downstreamGL2ES1.glGetGraphicsResetStatus();
    String txt = new String("glGetGraphicsResetStatus(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  java.lang.String glGetString(int arg0)
  {
        checkContext();
    java.lang.String _res = downstreamGL2ES1.glGetString(arg0);
    String txt = new String("glGetString(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glColorPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glColorPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  int getDefaultDrawFramebuffer()
  {
        return downstreamGL2ES1.getDefaultDrawFramebuffer();
  }
  public  void glRotatef(float arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL2ES1.glRotatef(arg0,arg1,arg2,arg3);
    String txt = new String("glRotatef(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL2ES1.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnUniformfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPushMatrix()
  {
        checkContext();
downstreamGL2ES1.glPushMatrix();
    String txt = new String("glPushMatrix(" +
    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsBuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsBuffer(arg0);
    String txt = new String("glIsBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glPolygonOffset(float arg0,float arg1)
  {
        checkContext();
downstreamGL2ES1.glPolygonOffset(arg0,arg1);
    String txt = new String("glPolygonOffset(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL2ES1.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glTexSubImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glViewport(arg0,arg1,arg2,arg3);
    String txt = new String("glViewport(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsRenderbuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL2ES1.glIsRenderbuffer(arg0);
    String txt = new String("glIsRenderbuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  boolean isNPOTTextureAvailable()
  {
        return downstreamGL2ES1.isNPOTTextureAvailable();
  }
  public  void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL2ES1.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glTextureStorage1DEXT(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDisable(int arg0)
  {
        checkContext();
downstreamGL2ES1.glDisable(arg0);
    String txt = new String("glDisable(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glDeleteBuffers(arg0,arg1);
    String txt = new String("glDeleteBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glMatrixIndexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glMatrixIndexPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glMatrixIndexPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexGenf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glTexGenf(arg0,arg1,arg2);
    String txt = new String("glTexGenf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindRenderbuffer(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glBindRenderbuffer(arg0,arg1);
    String txt = new String("glBindRenderbuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetBufferParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetBufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  int glGetBoundBuffer(int arg0)
  {
        checkContext();
    int _res = downstreamGL2ES1.glGetBoundBuffer(arg0);
    String txt = new String("glGetBoundBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL2ES1.glGetnUniformiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  int getBoundFramebuffer(int arg0)
  {
        return downstreamGL2ES1.getBoundFramebuffer(arg0);
  }
  public  void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3)
  {
        checkContext();
downstreamGL2ES1.glColor4ub(arg0,arg1,arg2,arg3);
    String txt = new String("glColor4ub(" +
    "<byte> "+arg0 +    ", " +
    "<byte> "+arg1 +    ", " +
    "<byte> "+arg2 +    ", " +
    "<byte> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glPopMatrix()
  {
        checkContext();
downstreamGL2ES1.glPopMatrix();
    String txt = new String("glPopMatrix(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
        checkContext();
downstreamGL2ES1.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glCompressedTexImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glTexGeniv(arg0,arg1,arg2);
    String txt = new String("glTexGeniv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameterf(int arg0,float arg1)
  {
        checkContext();
downstreamGL2ES1.glPointParameterf(arg0,arg1);
    String txt = new String("glPointParameterf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    String txt = new String("glRenderbufferStorage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGenBuffers(arg0,arg1);
    String txt = new String("glGenBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL2ES1.glVertexPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGenRenderbuffers(arg0,arg1);
    String txt = new String("glGenRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glFinish()
  {
        checkContext();
downstreamGL2ES1.glFinish();
    String txt = new String("glFinish(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glShadeModel(int arg0)
  {
        checkContext();
downstreamGL2ES1.glShadeModel(arg0);
    String txt = new String("glShadeModel(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glLightfv(arg0,arg1,arg2,arg3);
    String txt = new String("glLightfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGetBooleanv(arg0,arg1);
    String txt = new String("glGetBooleanv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetLightfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetLightfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFogfv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glFogfv(arg0,arg1);
    String txt = new String("glFogfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL2ES1.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glTexImage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<long> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalPointer(int arg0,int arg1,long arg2)
  {
        checkContext();
downstreamGL2ES1.glNormalPointer(arg0,arg1,arg2);
    String txt = new String("glNormalPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glHint(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glHint(arg0,arg1);
    String txt = new String("glHint(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL2ES1.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glTexStorage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glDeleteFramebuffers(arg0,arg1,arg2);
    String txt = new String("glDeleteFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glGetMaterialfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetMaterialfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glTexParameteriv(arg0,arg1,arg2);
    String txt = new String("glTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3)
  {
        checkContext();
downstreamGL2ES1.glTexCoordPointer(arg0,arg1,arg2,arg3);
    String txt = new String("glTexCoordPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<long> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glDeleteTextures(arg0,arg1);
    String txt = new String("glDeleteTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearDepth(double arg0)
  {
        checkContext();
downstreamGL2ES1.glClearDepth(arg0);
    String txt = new String("glClearDepth(" +
    "<double> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glLightModelfv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glLightModelfv(arg0,arg1);
    String txt = new String("glLightModelfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGenFramebuffers(arg0,arg1);
    String txt = new String("glGenFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glFrontFace(int arg0)
  {
        checkContext();
downstreamGL2ES1.glFrontFace(arg0);
    String txt = new String("glFrontFace(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultMatrixf(java.nio.FloatBuffer arg0)
  {
        checkContext();
downstreamGL2ES1.glMultMatrixf(arg0);
    String txt = new String("glMultMatrixf(" +
    "<java.nio.FloatBuffer> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
        checkContext();
downstreamGL2ES1.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glTextureStorage3DEXT(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glOrthof(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
        checkContext();
downstreamGL2ES1.glOrthof(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glOrthof(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ", " +
    "<float> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glLogicOp(int arg0)
  {
        checkContext();
downstreamGL2ES1.glLogicOp(arg0);
    String txt = new String("glLogicOp(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL2ES1.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetFramebufferAttachmentParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glAlphaFunc(int arg0,float arg1)
  {
        checkContext();
downstreamGL2ES1.glAlphaFunc(arg0,arg1);
    String txt = new String("glAlphaFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glTexParameterf(arg0,arg1,arg2);
    String txt = new String("glTexParameterf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glTranslatef(float arg0,float arg1,float arg2)
  {
        checkContext();
downstreamGL2ES1.glTranslatef(arg0,arg1,arg2);
    String txt = new String("glTranslatef(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGetFloatv(arg0,arg1,arg2);
    String txt = new String("glGetFloatv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glPointParameterfv(arg0,arg1);
    String txt = new String("glPointParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
        checkContext();
downstreamGL2ES1.glFrustum(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glFrustum(" +
    "<double> "+arg0 +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ", " +
    "<double> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glLoadMatrixf(float[] arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glLoadMatrixf(arg0,arg1);
    String txt = new String("glLoadMatrixf(" +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glCheckFramebufferStatus(int arg0)
  {
        checkContext();
    int _res = downstreamGL2ES1.glCheckFramebufferStatus(arg0);
    String txt = new String("glCheckFramebufferStatus(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glGetBooleanv(arg0,arg1,arg2);
    String txt = new String("glGetBooleanv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glTexGenfv(arg0,arg1,arg2);
    String txt = new String("glTexGenfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGetIntegerv(arg0,arg1);
    String txt = new String("glGetIntegerv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glLightModelfv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glLightModelfv(arg0,arg1,arg2);
    String txt = new String("glLightModelfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
        checkContext();
downstreamGL2ES1.glMultiTexCoord4f(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glMultiTexCoord4f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glMultMatrixf(float[] arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glMultMatrixf(arg0,arg1);
    String txt = new String("glMultMatrixf(" +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetMaterialfv(arg0,arg1,arg2);
    String txt = new String("glGetMaterialfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glScissor(arg0,arg1,arg2,arg3);
    String txt = new String("glScissor(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPixelStorei(int arg0,int arg1)
  {
        checkContext();
downstreamGL2ES1.glPixelStorei(arg0,arg1);
    String txt = new String("glPixelStorei(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGenTextures(arg0,arg1);
    String txt = new String("glGenTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
        checkContext();
downstreamGL2ES1.glDrawElements(arg0,arg1,arg2,arg3);
    String txt = new String("glDrawElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<long> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthFunc(int arg0)
  {
        checkContext();
downstreamGL2ES1.glDepthFunc(arg0);
    String txt = new String("glDepthFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetRenderbufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glLoadMatrixf(java.nio.FloatBuffer arg0)
  {
        checkContext();
downstreamGL2ES1.glLoadMatrixf(arg0);
    String txt = new String("glLoadMatrixf(" +
    "<java.nio.FloatBuffer> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexGenfv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexGenfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFrustumf(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
        checkContext();
downstreamGL2ES1.glFrustumf(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glFrustumf(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ", " +
    "<float> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL2ES1.glGetFloatv(arg0,arg1);
    String txt = new String("glGetFloatv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glPointParameterfv(arg0,arg1,arg2);
    String txt = new String("glPointParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetTexEnviv(arg0,arg1,arg2);
    String txt = new String("glGetTexEnviv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  boolean isFunctionAvailable(java.lang.String arg0)
  {
        return downstreamGL2ES1.isFunctionAvailable(arg0);
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
        checkContext();
downstreamGL2ES1.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glReadPixels(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<long> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL2ES1.glTexStorage1D(arg0,arg1,arg2,arg3);
    String txt = new String("glTexStorage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetError()
  {
        checkContext();
    int _res = downstreamGL2ES1.glGetError();
    String txt = new String("glGetError(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glStencilFunc(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glStencilFunc(arg0,arg1,arg2);
    String txt = new String("glStencilFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glDeleteRenderbuffers(arg0,arg1,arg2);
    String txt = new String("glDeleteRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFogfv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL2ES1.glFogfv(arg0,arg1,arg2);
    String txt = new String("glFogfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glLightfv(arg0,arg1,arg2);
    String txt = new String("glLightfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL2ES1.glGetLightfv(arg0,arg1,arg2);
    String txt = new String("glGetLightfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DebugGL2ES1 [ implementing javax.media.opengl.GL2ES1,\n\t");
    sb.append(" downstream: "+downstreamGL2ES1.toString()+"\n\t]");
    return sb.toString();
  }
  private void checkGLGetError(String caller)
  {
    // Debug code to make sure the pipeline is working; leave commented out unless testing this class
    //System.err.println("Checking for GL errors after call to " + caller);

    int err = downstreamGL2ES1.glGetError();
    if (err == GL_NO_ERROR) { return; }

    StringBuilder buf = new StringBuilder(Thread.currentThread()+
      " glGetError() returned the following error codes after a call to " + caller + ": ");

    // Loop repeatedly to allow for distributed GL implementations,
    // as detailed in the glGetError() specification
    int recursionDepth = 10;
    do {
      switch (err) {
        case GL_INVALID_ENUM: buf.append("GL_INVALID_ENUM "); break;
        case GL_INVALID_VALUE: buf.append("GL_INVALID_VALUE "); break;
        case GL_INVALID_OPERATION: buf.append("GL_INVALID_OPERATION "); break;
        case GL_STACK_OVERFLOW: buf.append("GL_STACK_OVERFLOW "); break;
        case GL_STACK_UNDERFLOW: buf.append("GL_STACK_UNDERFLOW "); break;
        case GL_OUT_OF_MEMORY: buf.append("GL_OUT_OF_MEMORY "); break;
        case GL_NO_ERROR: throw new InternalError("Should not be treating GL_NO_ERROR as error");
        default: buf.append("Unknown glGetError() return value: ");
      }
      buf.append("( " + err + " 0x"+Integer.toHexString(err).toUpperCase() + "), ");
    } while ((--recursionDepth >= 0) && (err = downstreamGL2ES1.glGetError()) != GL_NO_ERROR);
    throw new GLException(buf.toString());
  }
  private void checkContext() {
    GLContext currentContext = GLContext.getCurrent();
    if (currentContext == null) {
      throw new GLException("No OpenGL context is current on this thread");
    }
    if ((_context != null) && (_context != currentContext)) {
      throw new GLException("This GL object is being incorrectly used with a different GLContext than that which created it");
    }
  }
  private GLContext _context;

  private GL2ES1 downstreamGL2ES1;
} // end class DebugGL2ES1
