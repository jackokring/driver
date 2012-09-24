package javax.media.opengl;

import java.io.*;
import javax.media.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import javax.media.opengl.GL3;
import javax.media.opengl.GL2GL3;

/** <P> Composable pipeline which wraps an underlying {@link GL} implementation,
    providing error checking after each OpenGL method call. If an error occurs,
    causes a {@link GLException} to be thrown at exactly the point of failure.
    Sample code which installs this pipeline: </P>

<PRE>
     GL gl = drawable.setGL(new DebugGL(drawable.getGL()));
</PRE>
*/
public class DebugGL3 implements javax.media.opengl.GL2GL3, javax.media.opengl.GL3{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("DebugGL3");
  public DebugGL3(GL3 downstreamGL3)
  {
    if (downstreamGL3 == null) {
      throw new IllegalArgumentException("null downstreamGL3");
    }
    this.downstreamGL3 = downstreamGL3;
    // Fetch GLContext object for better error checking (if possible)
    _context = downstreamGL3.getContext();
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
    return true;
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
    return false;
  }
  public boolean isGL2ES2() {
    return true;
  }
  public boolean isGL2GL3() {
    return true;
  }
  public boolean isGLES() {
    return isGLES2() || isGLES1();
  }
  public boolean isGLES2Compatible() {
    return downstreamGL3.isGLES2Compatible();
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
    return this;
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
    throw new GLException("Not a GL2ES1 implementation");
  }
  public javax.media.opengl.GL2ES2 getGL2ES2() {
    return this;
  }
  public javax.media.opengl.GL2GL3 getGL2GL3() {
    return this;
  }
  public GLProfile getGLProfile() {
    return downstreamGL3.getGLProfile();
  }
  public  void glVertexAttrib4Nsv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nsv(arg0,arg1);
    String txt = new String("glVertexAttrib4Nsv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix3x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform1iv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform1iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
        checkContext();
downstreamGL3.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glTexSubImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg10 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawTransformFeedback(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glDrawTransformFeedback(arg0,arg1);
    String txt = new String("glDrawTransformFeedback(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4sv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI4sv(arg0,arg1);
    String txt = new String("glVertexAttribI4sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP1ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP1ui(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP1ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glFramebufferTextureLayer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSecondaryColorP3uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glSecondaryColorP3uiv(arg0,arg1,arg2);
    String txt = new String("glSecondaryColorP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetTexParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetTexParameterIuiv(arg0,arg1,arg2);
    String txt = new String("glGetTexParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetActiveUniformBlockName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.ByteBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
        checkContext();
downstreamGL3.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glGetActiveSubroutineUniformName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL3.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
  public  void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix4x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenSamplers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenSamplers(arg0,arg1);
    String txt = new String("glGenSamplers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformBlockBinding(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glUniformBlockBinding(arg0,arg1,arg2);
    String txt = new String("glUniformBlockBinding(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix4x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsVBOArrayEnabled()
  {
        checkContext();
    boolean _res = downstreamGL3.glIsVBOArrayEnabled();
    String txt = new String("glIsVBOArrayEnabled(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttribI2uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI2uiv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramPipelineiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetProgramPipelineiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetProgramPipelineiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawTransformFeedbackInstanced(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDrawTransformFeedbackInstanced(arg0,arg1,arg2);
    String txt = new String("glDrawTransformFeedbackInstanced(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetFramebufferAttachmentParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilOpValueAMD(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glStencilOpValueAMD(arg0,arg1);
    String txt = new String("glStencilOpValueAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetUniformLocation(int arg0,java.lang.String arg1)
  {
        checkContext();
    int _res = downstreamGL3.glGetUniformLocation(arg0,arg1);
    String txt = new String("glGetUniformLocation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetActiveUniform(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
        checkContext();
downstreamGL3.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetActiveUniform(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.IntBuffer> "+arg5 +    ", " +
    "<java.nio.ByteBuffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindVertexArray(int arg0)
  {
        checkContext();
downstreamGL3.glBindVertexArray(arg0);
    String txt = new String("glBindVertexArray(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetFragDataLocation(int arg0,java.lang.String arg1)
  {
        checkContext();
    int _res = downstreamGL3.glGetFragDataLocation(arg0,arg1);
    String txt = new String("glGetFragDataLocation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glDebugMessageEnableAMD(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,boolean arg4)
  {
        checkContext();
downstreamGL3.glDebugMessageEnableAMD(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glDebugMessageEnableAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<boolean> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP1ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP1ui(arg0,arg1);
    String txt = new String("glTexCoordP1ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetNamedStringARB(int arg0,java.lang.String arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
        checkContext();
downstreamGL3.glGetNamedStringARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetNamedStringARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  java.lang.Object getExtension(java.lang.String arg0)
  {
        return downstreamGL3.getExtension(arg0);
  }
  public  void glGetActiveUniformsiv(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,java.nio.IntBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetActiveUniformsiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniformsiv(int arg0,int arg1,int[] arg2,int arg3,int arg4,int[] arg5,int arg6)
  {
        checkContext();
downstreamGL3.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetActiveUniformsiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetDebugMessageLogAMD(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
        checkContext();
    int _res = downstreamGL3.glGetDebugMessageLogAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetDebugMessageLogAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.IntBuffer> "+arg5 +    ", " +
    "<java.nio.ByteBuffer> "+arg6 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetIntegeri_v(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetIntegeri_v(arg0,arg1,arg2);
    String txt = new String("glGetIntegeri_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glViewportArrayv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glViewportArrayv(arg0,arg1,arg2);
    String txt = new String("glViewportArrayv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBeginTransformFeedback(int arg0)
  {
        checkContext();
downstreamGL3.glBeginTransformFeedback(arg0);
    String txt = new String("glBeginTransformFeedback(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformSubroutineuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetUniformSubroutineuiv(arg0,arg1,arg2);
    String txt = new String("glGetUniformSubroutineuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix4x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramParameteri(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glProgramParameteri(arg0,arg1,arg2);
    String txt = new String("glProgramParameteri(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetDoublev(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetDoublev(arg0,arg1,arg2);
    String txt = new String("glGetDoublev(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
        checkContext();
downstreamGL3.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
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
  public  void glVertexAttribL2dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribL2dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribL2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix2x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
        checkContext();
downstreamGL3.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glTexSubImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP3ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glVertexP3ui(arg0,arg1);
    String txt = new String("glVertexP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL3.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
  public  void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix3x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformui64vNV(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDisable(int arg0)
  {
        checkContext();
downstreamGL3.glDisable(arg0);
    String txt = new String("glDisable(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteQueries(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteQueries(arg0,arg1,arg2);
    String txt = new String("glDeleteQueries(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureImage2DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
        checkContext();
downstreamGL3.glTextureImage2DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glTextureImage2DMultisampleCoverageNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<boolean> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  void glFinish()
  {
        checkContext();
downstreamGL3.glFinish();
    String txt = new String("glFinish(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
        checkContext();
downstreamGL3.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glGetTransformFeedbackVarying(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg10).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
        checkContext();
downstreamGL3.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDrawRangeElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glDetachShader(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glDetachShader(arg0,arg1);
    String txt = new String("glDetachShader(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBooleani_v(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetBooleani_v(arg0,arg1,arg2);
    String txt = new String("glGetBooleani_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteNamedStringARB(int arg0,java.lang.String arg1)
  {
        checkContext();
downstreamGL3.glDeleteNamedStringARB(arg0,arg1);
    String txt = new String("glDeleteNamedStringARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexP3uiv(arg0,arg1);
    String txt = new String("glVertexP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetVertexAttribIiv(arg0,arg1,arg2);
    String txt = new String("glGetVertexAttribIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glLogicOp(int arg0)
  {
        checkContext();
downstreamGL3.glLogicOp(arg0);
    String txt = new String("glLogicOp(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
        checkContext();
downstreamGL3.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
  public  void glMultiDrawElementsIndirectAMD(int arg0,int arg1,java.nio.Buffer arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glMultiDrawElementsIndirectAMD(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glMultiDrawElementsIndirectAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform4fv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glAttachShader(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glAttachShader(arg0,arg1);
    String txt = new String("glAttachShader(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetVertexAttribIuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetVertexAttribIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetNamedStringARB(int arg0,java.lang.String arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetNamedStringARB(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetNamedStringARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.ByteBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2fv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetTexParameterIiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP4uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glMultiTexCoordP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteRenderbuffers(arg0,arg1);
    String txt = new String("glDeleteRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glEdgeFlagFormatNV(int arg0)
  {
        checkContext();
downstreamGL3.glEdgeFlagFormatNV(arg0);
    String txt = new String("glEdgeFlagFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
        checkContext();
downstreamGL3.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetTransformFeedbackVarying(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.IntBuffer> "+arg5 +    ", " +
    "<java.nio.ByteBuffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformui64NV(int arg0,long arg1)
  {
        checkContext();
downstreamGL3.glUniformui64NV(arg0,arg1);
    String txt = new String("glUniformui64NV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glMemoryBarrier(int arg0)
  {
        checkContext();
downstreamGL3.glMemoryBarrier(arg0);
    String txt = new String("glMemoryBarrier(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform2fv(arg0,arg1,arg2);
    String txt = new String("glUniform2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1s(int arg0,short arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib1s(arg0,arg1);
    String txt = new String("glVertexAttrib1s(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<short> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
        checkContext();
downstreamGL3.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetTexImage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform4uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetProgramiv(arg0,arg1,arg2);
    String txt = new String("glGetProgramiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetInternalformativ(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetActiveUniformBlockiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix2x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompileShader(int arg0)
  {
        checkContext();
downstreamGL3.glCompileShader(arg0);
    String txt = new String("glCompileShader(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
        checkContext();
downstreamGL3.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetActiveSubroutineUniformName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.ByteBuffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureImage3DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,boolean arg8)
  {
        checkContext();
downstreamGL3.glTextureImage3DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glTextureImage3DMultisampleCoverageNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<boolean> "+arg8 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform2iv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform2iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthMask(boolean arg0)
  {
        checkContext();
downstreamGL3.glDepthMask(arg0);
    String txt = new String("glDepthMask(" +
    "<boolean> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
        checkContext();
downstreamGL3.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetActiveUniformBlockName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3sv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib3sv(arg0,arg1);
    String txt = new String("glVertexAttrib3sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x2dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix3x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4dv(arg0,arg1);
    String txt = new String("glVertexAttrib4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glQueryCounter(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glQueryCounter(arg0,arg1);
    String txt = new String("glQueryCounter(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
        checkContext();
downstreamGL3.glUniform4f(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniform4f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetBooleanv(arg0,arg1,arg2);
    String txt = new String("glGetBooleanv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteSync(long arg0)
  {
        checkContext();
downstreamGL3.glDeleteSync(arg0);
    String txt = new String("glDeleteSync(" +
    "<long> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform4iv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniform4i(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniform4i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3s(int arg0,short arg1,short arg2,short arg3)
  {
        checkContext();
downstreamGL3.glVertexAttrib3s(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttrib3s(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<short> "+arg1 +    ", " +
    "<short> "+arg2 +    ", " +
    "<short> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniform(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
        checkContext();
downstreamGL3.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glGetActiveUniform(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg10).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glActiveShaderProgram(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glActiveShaderProgram(arg0,arg1);
    String txt = new String("glActiveShaderProgram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean hasGLSL()
  {
        return downstreamGL3.hasGLSL();
  }
  public  void glDepthFunc(int arg0)
  {
        checkContext();
downstreamGL3.glDepthFunc(arg0);
    String txt = new String("glDepthFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glTexParameterIuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferfi(int arg0,int arg1,float arg2,int arg3)
  {
        checkContext();
downstreamGL3.glClearBufferfi(arg0,arg1,arg2,arg3);
    String txt = new String("glClearBufferfi(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnSeparableFilter(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5,java.nio.Buffer arg6,java.nio.Buffer arg7)
  {
        checkContext();
downstreamGL3.glGetnSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glGetnSeparableFilter(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg6 +    ", " +
    "<java.nio.Buffer> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendFunci(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glBlendFunci(arg0,arg1,arg2);
    String txt = new String("glBlendFunci(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix2x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean isExtensionAvailable(java.lang.String arg0)
  {
        return downstreamGL3.isExtensionAvailable(arg0);
  }
  public  void glUniform2iv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform2iv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform2iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI3uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI3uiv(arg0,arg1);
    String txt = new String("glVertexAttribI3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glPolygonMode(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glPolygonMode(arg0,arg1);
    String txt = new String("glPolygonMode(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjectiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetQueryObjectiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetQueryObjectiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  long glImportSyncEXT(int arg0,long arg1,int arg2)
  {
        checkContext();
    long _res = downstreamGL3.glImportSyncEXT(arg0,arg1,arg2);
    String txt = new String("glImportSyncEXT(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttribI2iv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI2iv(arg0,arg1);
    String txt = new String("glVertexAttribI2iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetShaderiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetShaderiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalP3uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glNormalP3uiv(arg0,arg1,arg2);
    String txt = new String("glNormalP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4dv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform4dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniformName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetActiveUniformName(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetActiveUniformName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.ByteBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTexture1D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glFramebufferTexture1D(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glFramebufferTexture1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib2dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetUniformui64vNV(arg0,arg1,arg2);
    String txt = new String("glGetUniformui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRangeArrayv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glDepthRangeArrayv(arg0,arg1,arg2,arg3);
    String txt = new String("glDepthRangeArrayv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2dv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform2dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteBuffers(arg0,arg1);
    String txt = new String("glDeleteBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glCullFace(int arg0)
  {
        checkContext();
downstreamGL3.glCullFace(arg0);
    String txt = new String("glCullFace(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nsv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nsv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4Nsv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFogCoordFormatNV(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glFogCoordFormatNV(arg0,arg1);
    String txt = new String("glFogCoordFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribP3uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4sv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI4sv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI4sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix3x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteTextures(arg0,arg1,arg2);
    String txt = new String("glDeleteTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsTransformFeedback(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsTransformFeedback(arg0);
    String txt = new String("glIsTransformFeedback(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  boolean glIsQuery(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsQuery(arg0);
    String txt = new String("glIsQuery(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetIntegerv(arg0,arg1,arg2);
    String txt = new String("glGetIntegerv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetCompressedTexImage(int arg0,int arg1,long arg2)
  {
        checkContext();
downstreamGL3.glGetCompressedTexImage(arg0,arg1,arg2);
    String txt = new String("glGetCompressedTexImage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindFramebuffer(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBindFramebuffer(arg0,arg1);
    String txt = new String("glBindFramebuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP3ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP3ui(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP1ui(int arg0,int arg1,boolean arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP1ui(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP1ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetRenderbufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glIndexFormatNV(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glIndexFormatNV(arg0,arg1);
    String txt = new String("glIndexFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glEnableClientState(int arg0)
  {
        checkContext();
downstreamGL3.glEnableClientState(arg0);
    String txt = new String("glEnableClientState(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
        checkContext();
downstreamGL3.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glCompressedTexSubImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg10 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiDrawElements(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4)
  {
        checkContext();
downstreamGL3.glMultiDrawElements(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glMultiDrawElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<com.jogamp.common.nio.PointerBuffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribL3dv(arg0,arg1);
    String txt = new String("glVertexAttribL3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearStencil(int arg0)
  {
        checkContext();
downstreamGL3.glClearStencil(arg0);
    String txt = new String("glClearStencil(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glEnableVertexAttribArray(int arg0)
  {
        checkContext();
downstreamGL3.glEnableVertexAttribArray(arg0);
    String txt = new String("glEnableVertexAttribArray(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetShaderInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetShaderInfoLog(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP3uiv(arg0,arg1);
    String txt = new String("glTexCoordP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindTexture(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBindTexture(arg0,arg1);
    String txt = new String("glBindTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameteri(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glPointParameteri(arg0,arg1);
    String txt = new String("glPointParameteri(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP3ui(int arg0,int arg1,boolean arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP3ui(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSampleCoverage(float arg0,boolean arg1)
  {
        checkContext();
downstreamGL3.glSampleCoverage(arg0,arg1);
    String txt = new String("glSampleCoverage(" +
    "<float> "+arg0 +    ", " +
    "<boolean> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexFormatNV(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexFormatNV(arg0,arg1,arg2);
    String txt = new String("glVertexFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glFramebufferTexture2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glShaderSource(arg0,arg1,arg2,arg3);
    String txt = new String("glShaderSource(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glEnablei(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glEnablei(arg0,arg1);
    String txt = new String("glEnablei(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
        checkContext();
downstreamGL3.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glDrawRangeElementsBaseVertex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg5 +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetInteger64v(int arg0,java.nio.LongBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetInteger64v(arg0,arg1);
    String txt = new String("glGetInteger64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4bv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4bv(arg0,arg1);
    String txt = new String("glVertexAttrib4bv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramPipelineInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3);
    String txt = new String("glGetProgramPipelineInfoLog(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.ByteBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP3ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP3ui(arg0,arg1);
    String txt = new String("glTexCoordP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenVertexArrays(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenVertexArrays(arg0,arg1,arg2);
    String txt = new String("glGenVertexArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBindBufferBase(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glBindBufferBase(arg0,arg1,arg2);
    String txt = new String("glBindBufferBase(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenTextures(arg0,arg1);
    String txt = new String("glGenTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
        checkContext();
downstreamGL3.glBindBufferRange(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glBindBufferRange(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<long> "+arg3 +    ", " +
    "<long> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4ubv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI4ubv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI4ubv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetShaderInfoLog(arg0,arg1,arg2,arg3);
    String txt = new String("glGetShaderInfoLog(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.ByteBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
        checkContext();
downstreamGL3.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glCompressedTexSubImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawArraysInstancedBaseInstance(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glDrawArraysInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glDrawArraysInstancedBaseInstance(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsSampler(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsSampler(arg0);
    String txt = new String("glIsSampler(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glColorP4ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glColorP4ui(arg0,arg1);
    String txt = new String("glColorP4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glScissorArrayv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glScissorArrayv(arg0,arg1,arg2);
    String txt = new String("glScissorArrayv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glStencilFuncSeparate(arg0,arg1,arg2,arg3);
    String txt = new String("glStencilFuncSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glProgramUniform1ui(arg0,arg1,arg2);
    String txt = new String("glProgramUniform1ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP2uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexP2uiv(arg0,arg1);
    String txt = new String("glVertexP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glViewportIndexedfv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glViewportIndexedfv(arg0,arg1);
    String txt = new String("glViewportIndexedfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI4uiv(arg0,arg1);
    String txt = new String("glVertexAttribI4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
        checkContext();
downstreamGL3.glGetnTexImage(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetnTexImage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL3.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
  public  void glProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameteri64v(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetBufferParameteri64v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetBufferParameteri64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformui64NV(int arg0,int arg1,long arg2)
  {
        checkContext();
downstreamGL3.glProgramUniformui64NV(arg0,arg1,arg2);
    String txt = new String("glProgramUniformui64NV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform4fv(arg0,arg1,arg2);
    String txt = new String("glUniform4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetSamplerParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawArraysInstanced(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glDrawArraysInstanced(arg0,arg1,arg2,arg3);
    String txt = new String("glDrawArraysInstanced(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramPipelineInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetProgramPipelineInfoLog(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetMultisamplefv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetMultisamplefv(arg0,arg1,arg2);
    String txt = new String("glGetMultisamplefv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsBuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsBuffer(arg0);
    String txt = new String("glIsBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x3dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix2x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  int glGetSubroutineIndex(int arg0,int arg1,java.lang.String arg2)
  {
        checkContext();
    int _res = downstreamGL3.glGetSubroutineIndex(arg0,arg1,arg2);
    String txt = new String("glGetSubroutineIndex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.lang.String> "+arg2 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttrib2fv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib2fv(arg0,arg1);
    String txt = new String("glVertexAttrib2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4bv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI4bv(arg0,arg1);
    String txt = new String("glVertexAttribI4bv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  int glCheckFramebufferStatus(int arg0)
  {
        checkContext();
    int _res = downstreamGL3.glCheckFramebufferStatus(arg0);
    String txt = new String("glCheckFramebufferStatus(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glProgramUniform2uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform2uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteVertexArrays(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteVertexArrays(arg0,arg1,arg2);
    String txt = new String("glDeleteVertexArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4iv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI4iv(arg0,arg1);
    String txt = new String("glVertexAttribI4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenRenderbuffers(arg0,arg1);
    String txt = new String("glGenRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glColorP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glColorP3uiv(arg0,arg1);
    String txt = new String("glColorP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribPointer(javax.media.opengl.GLArrayData arg0)
  {
        checkContext();
downstreamGL3.glVertexAttribPointer(arg0);
    String txt = new String("glVertexAttribPointer(" +
    "<javax.media.opengl.GLArrayData> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetBufferParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetBufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameteri(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glSamplerParameteri(arg0,arg1,arg2);
    String txt = new String("glSamplerParameteri(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glTexParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glTexParameterIiv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetUniformuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveUniformName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
        checkContext();
downstreamGL3.glGetActiveUniformName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetActiveUniformName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix3fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureImage2DMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
        checkContext();
downstreamGL3.glTextureImage2DMultisampleNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glTextureImage2DMultisampleNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<boolean> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindProgramPipeline(int arg0)
  {
        checkContext();
downstreamGL3.glBindProgramPipeline(arg0);
    String txt = new String("glBindProgramPipeline(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3sv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib3sv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib3sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompileShaderIncludeARB(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glCompileShaderIncludeARB(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glCompileShaderIncludeARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMakeBufferResidentNV(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glMakeBufferResidentNV(arg0,arg1);
    String txt = new String("glMakeBufferResidentNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glTexParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryIndexediv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetQueryIndexediv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetQueryIndexediv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glEndQuery(int arg0)
  {
        checkContext();
downstreamGL3.glEndQuery(arg0);
    String txt = new String("glEndQuery(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5)
  {
        checkContext();
downstreamGL3.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glVertexAttribPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<long> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindFragDataLocation(int arg0,int arg1,java.lang.String arg2)
  {
        checkContext();
downstreamGL3.glBindFragDataLocation(arg0,arg1,arg2);
    String txt = new String("glBindFragDataLocation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.lang.String> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x4dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix3x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4iv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform4iv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjectuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetQueryObjectuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetQueryObjectuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform3dv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderSource(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetShaderSource(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetShaderSource(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetFloatv(arg0,arg1,arg2);
    String txt = new String("glGetFloatv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform3iv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform3iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x2dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix4x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4usv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI4usv(arg0,arg1);
    String txt = new String("glVertexAttribI4usv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClear(int arg0)
  {
        checkContext();
downstreamGL3.glClear(arg0);
    String txt = new String("glClear(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP2uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP2uiv(arg0,arg1);
    String txt = new String("glTexCoordP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glClearBufferuiv(arg0,arg1,arg2);
    String txt = new String("glClearBufferuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1fv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform1fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform1fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPixelMapuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetnPixelMapuiv(arg0,arg1,arg2);
    String txt = new String("glGetnPixelMapuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP1uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP1uiv(arg0,arg1);
    String txt = new String("glTexCoordP1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawTransformFeedbackStreamInstanced(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glDrawTransformFeedbackStreamInstanced(arg0,arg1,arg2,arg3);
    String txt = new String("glDrawTransformFeedbackStreamInstanced(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjectui64v(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetQueryObjectui64v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetQueryObjectui64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetFragDataIndex(int arg0,java.lang.String arg1)
  {
        checkContext();
    int _res = downstreamGL3.glGetFragDataIndex(arg0,arg1);
    String txt = new String("glGetFragDataIndex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttribL4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribL4d(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribL4d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1i(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glProgramUniform1i(arg0,arg1,arg2);
    String txt = new String("glProgramUniform1i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI3i(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribI3i(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribI3i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1fv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib1fv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib1fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetActiveSubroutineUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP1uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glMultiTexCoordP1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPixelStorei(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glPixelStorei(arg0,arg1);
    String txt = new String("glPixelStorei(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3fv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib3fv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribP1uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribP1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
        checkContext();
downstreamGL3.glCopyBufferSubData(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glCopyBufferSubData(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ", " +
    "<long> "+arg3 +    ", " +
    "<long> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetNamedStringivARB(int arg0,java.lang.String arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetNamedStringivARB(arg0,arg1,arg2,arg3);
    String txt = new String("glGetNamedStringivARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindImageTexture(int arg0,int arg1,int arg2,boolean arg3,int arg4,int arg5,int arg6)
  {
        checkContext();
downstreamGL3.glBindImageTexture(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glBindImageTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform3iv(arg0,arg1,arg2);
    String txt = new String("glUniform3iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilMask(int arg0)
  {
        checkContext();
downstreamGL3.glStencilMask(arg0);
    String txt = new String("glStencilMask(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBeginQueryIndexed(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glBeginQueryIndexed(arg0,arg1,arg2);
    String txt = new String("glBeginQueryIndexed(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3fv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform3fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetUniformdv(arg0,arg1,arg2);
    String txt = new String("glGetUniformdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Niv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Niv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4Niv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
        checkContext();
downstreamGL3.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    String txt = new String("glTexImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg9 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetUniformiv(arg0,arg1,arg2);
    String txt = new String("glGetUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMapiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnMapiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnMapiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix4x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x4dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix2x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetUniformIndices(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetUniformIndices(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameterui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetBufferParameterui64vNV(arg0,arg1,arg2);
    String txt = new String("glGetBufferParameterui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetSamplerParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetSamplerParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
        checkContext();
downstreamGL3.glCopyTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glCopyTexImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsNamedStringARB(int arg0,java.lang.String arg1)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsNamedStringARB(arg0,arg1);
    String txt = new String("glIsNamedStringARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  int glGetAttribLocation(int arg0,java.lang.String arg1)
  {
        checkContext();
    int _res = downstreamGL3.glGetAttribLocation(arg0,arg1);
    String txt = new String("glGetAttribLocation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetVertexAttribLdv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetVertexAttribLdv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetVertexAttribLdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glPointParameterfv(arg0,arg1,arg2);
    String txt = new String("glPointParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetIntegerui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetIntegerui64vNV(arg0,arg1);
    String txt = new String("glGetIntegerui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4usv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4usv(arg0,arg1);
    String txt = new String("glVertexAttrib4usv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElementsInstanced(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
        checkContext();
downstreamGL3.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glDrawElementsInstanced(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBindSampler(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBindSampler(arg0,arg1);
    String txt = new String("glBindSampler(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramParameteriARB(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glProgramParameteriARB(arg0,arg1,arg2);
    String txt = new String("glProgramParameteriARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetNamedBufferParameterui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetNamedBufferParameterui64vNV(arg0,arg1,arg2,arg3);
    String txt = new String("glGetNamedBufferParameterui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribL1dv(arg0,arg1);
    String txt = new String("glVertexAttribL1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClampColor(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glClampColor(arg0,arg1);
    String txt = new String("glClampColor(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix4x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetAttachedShaders(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetAttachedShaders(arg0,arg1,arg2,arg3);
    String txt = new String("glGetAttachedShaders(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetAttachedShaders(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetAttachedShaders(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetAttachedShaders(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform1uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsFramebuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsFramebuffer(arg0);
    String txt = new String("glIsFramebuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDrawElementsInstancedBaseVertex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
        checkContext();
downstreamGL3.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glTexImage1D(" +
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
  public  long glGetBufferSize(int arg0)
  {
        checkContext();
    long _res = downstreamGL3.glGetBufferSize(arg0);
    String txt = new String("glGetBufferSize(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glUniform3i(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform3i(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int getDefaultReadFramebuffer()
  {
        return downstreamGL3.getDefaultReadFramebuffer();
  }
  public  void glVertexAttrib4iv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4iv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
        checkContext();
downstreamGL3.glDrawElements(arg0,arg1,arg2,arg3);
    String txt = new String("glDrawElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<long> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP4uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPixelMapfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetnPixelMapfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnPixelMapfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glClearBufferfv(arg0,arg1,arg2,arg3);
    String txt = new String("glClearBufferfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL3.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glCompressedTexImage3D(" +
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
  public  void glMakeBufferNonResidentNV(int arg0)
  {
        checkContext();
downstreamGL3.glMakeBufferNonResidentNV(arg0);
    String txt = new String("glMakeBufferNonResidentNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendEquationSeparatei(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glBlendEquationSeparatei(arg0,arg1,arg2);
    String txt = new String("glBlendEquationSeparatei(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPolygonOffset(float arg0,float arg1)
  {
        checkContext();
downstreamGL3.glPolygonOffset(arg0,arg1);
    String txt = new String("glPolygonOffset(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nubv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nubv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4Nubv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP2uiv(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnColorTable(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
        checkContext();
downstreamGL3.glGetnColorTable(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnColorTable(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform1uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI1iv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI1iv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI1iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glNamedStringARB(int arg0,int arg1,java.lang.String arg2,int arg3,java.lang.String arg4)
  {
        checkContext();
downstreamGL3.glNamedStringARB(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glNamedStringARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.lang.String> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.lang.String> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetSamplerParameterIiv(arg0,arg1,arg2);
    String txt = new String("glGetSamplerParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI3iv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI3iv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI3iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramStageiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetProgramStageiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetProgramStageiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform3uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenQueries(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenQueries(arg0,arg1);
    String txt = new String("glGenQueries(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetVertexAttribiv(arg0,arg1,arg2);
    String txt = new String("glGetVertexAttribiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindRenderbuffer(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBindRenderbuffer(arg0,arg1);
    String txt = new String("glBindRenderbuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glEndConditionalRender()
  {
        checkContext();
downstreamGL3.glEndConditionalRender();
    String txt = new String("glEndConditionalRender(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1sv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib1sv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib1sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1i(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glUniform1i(arg0,arg1);
    String txt = new String("glUniform1i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glShaderBinary(int arg0,int[] arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5)
  {
        checkContext();
downstreamGL3.glShaderBinary(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glShaderBinary(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetInteger64i_v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetInteger64i_v(arg0,arg1,arg2);
    String txt = new String("glGetInteger64i_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glCopyTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glCopyTexSubImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glResumeTransformFeedback()
  {
        checkContext();
downstreamGL3.glResumeTransformFeedback();
    String txt = new String("glResumeTransformFeedback(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glColorP4uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glColorP4uiv(arg0,arg1,arg2);
    String txt = new String("glColorP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glSamplerParameterIuiv(arg0,arg1,arg2);
    String txt = new String("glSamplerParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilFunc(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glStencilFunc(arg0,arg1,arg2);
    String txt = new String("glStencilFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderSource(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetShaderSource(arg0,arg1,arg2,arg3);
    String txt = new String("glGetShaderSource(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.ByteBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenProgramPipelines(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenProgramPipelines(arg0,arg1,arg2);
    String txt = new String("glGenProgramPipelines(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP3uiv(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4fv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4fv(arg0,arg1);
    String txt = new String("glVertexAttrib4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjecti64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetQueryObjecti64v(arg0,arg1,arg2);
    String txt = new String("glGetQueryObjecti64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
        checkContext();
downstreamGL3.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glCompressedTexImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<long> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3i(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix4x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix2x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI1i(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI1i(arg0,arg1);
    String txt = new String("glVertexAttribI1i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
        checkContext();
    java.nio.ByteBuffer _res = downstreamGL3.glMapBuffer(arg0,arg1);
    String txt = new String("glMapBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glDebugMessageControlARB(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,boolean arg5)
  {
        checkContext();
downstreamGL3.glDebugMessageControlARB(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDebugMessageControlARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<boolean> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetVertexAttribdv(arg0,arg1,arg2);
    String txt = new String("glGetVertexAttribdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glPatchParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glPatchParameterfv(arg0,arg1);
    String txt = new String("glPatchParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
        checkContext();
downstreamGL3.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
  public  void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetActiveAtomicCounterBufferiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteFramebuffers(arg0,arg1);
    String txt = new String("glDeleteFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glProvokingVertex(int arg0)
  {
        checkContext();
downstreamGL3.glProvokingVertex(arg0);
    String txt = new String("glProvokingVertex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform2uiv(arg0,arg1,arg2);
    String txt = new String("glUniform2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnUniformfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPixelMapusv(int arg0,int arg1,short[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetnPixelMapusv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnPixelMapusv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUseProgramStages(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glUseProgramStages(arg0,arg1,arg2);
    String txt = new String("glUseProgramStages(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenBuffers(arg0,arg1,arg2);
    String txt = new String("glGenBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nuiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nuiv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4Nuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glClearBufferiv(arg0,arg1,arg2);
    String txt = new String("glClearBufferiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glSamplerParameterIiv(arg0,arg1,arg2,arg3);
    String txt = new String("glSamplerParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform1iv(arg0,arg1,arg2);
    String txt = new String("glUniform1iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform1dv(arg0,arg1,arg2);
    String txt = new String("glUniform1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTextureLayerARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glFramebufferTextureLayerARB(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glFramebufferTextureLayerARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nbv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nbv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4Nbv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPrimitiveRestartIndex(int arg0)
  {
        checkContext();
downstreamGL3.glPrimitiveRestartIndex(arg0);
    String txt = new String("glPrimitiveRestartIndex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenTransformFeedbacks(arg0,arg1,arg2);
    String txt = new String("glGenTransformFeedbacks(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniformui64vNV(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendFunc(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBlendFunc(arg0,arg1);
    String txt = new String("glBlendFunc(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glColorFormatNV(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glColorFormatNV(arg0,arg1,arg2);
    String txt = new String("glColorFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib3dv(arg0,arg1);
    String txt = new String("glVertexAttrib3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribDivisor(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribDivisor(arg0,arg1);
    String txt = new String("glVertexAttribDivisor(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix3x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4usv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI4usv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI4usv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib1dv(arg0,arg1);
    String txt = new String("glVertexAttrib1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMinmax(int arg0,boolean arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
        checkContext();
downstreamGL3.glGetnMinmax(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetnMinmax(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<boolean> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform3dv(arg0,arg1,arg2);
    String txt = new String("glUniform3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBindFragDataLocationIndexed(int arg0,int arg1,int arg2,java.lang.String arg3)
  {
        checkContext();
downstreamGL3.glBindFragDataLocationIndexed(arg0,arg1,arg2,arg3);
    String txt = new String("glBindFragDataLocationIndexed(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.lang.String> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  javax.media.opengl.GLContext getContext()
  {
        return downstreamGL3.getContext();
  }
  public  void glGetFloati_v(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetFloati_v(arg0,arg1,arg2);
    String txt = new String("glGetFloati_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetUniformfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteSamplers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteSamplers(arg0,arg1);
    String txt = new String("glDeleteSamplers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameteri(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexParameteri(arg0,arg1,arg2);
    String txt = new String("glTexParameteri(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBindTransformFeedback(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBindTransformFeedback(arg0,arg1);
    String txt = new String("glBindTransformFeedback(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4usv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4usv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4usv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribIFormatNV(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribIFormatNV(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribIFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP4uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexCoordP4uiv(arg0,arg1,arg2);
    String txt = new String("glTexCoordP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribP2uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexLevelParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendEquationi(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBlendEquationi(arg0,arg1);
    String txt = new String("glBlendEquationi(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetBoundBuffer(int arg0)
  {
        checkContext();
    int _res = downstreamGL3.glGetBoundBuffer(arg0);
    String txt = new String("glGetBoundBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  int getBoundFramebuffer(int arg0)
  {
        return downstreamGL3.getBoundFramebuffer(arg0);
  }
  public  void glUniformMatrix4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix4dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix2dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteTransformFeedbacks(arg0,arg1);
    String txt = new String("glDeleteTransformFeedbacks(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5,int arg6)
  {
        checkContext();
downstreamGL3.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glDrawElementsInstancedBaseVertexBaseInstance(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribFormatNV(int arg0,int arg1,int arg2,boolean arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribFormatNV(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL4dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribL4dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribL4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glTexStorage2D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveAttrib(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
        checkContext();
downstreamGL3.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetActiveAttrib(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.IntBuffer> "+arg5 +    ", " +
    "<java.nio.ByteBuffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformdv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnUniformdv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnUniformdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformSubroutinesuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniformSubroutinesuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformSubroutinesuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPolygonStipple(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetnPolygonStipple(arg0,arg1,arg2);
    String txt = new String("glGetnPolygonStipple(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawBuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDrawBuffers(arg0,arg1,arg2);
    String txt = new String("glDrawBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix3x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMapfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnMapfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnMapfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix4x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI1uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI1uiv(arg0,arg1);
    String txt = new String("glVertexAttribI1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix3x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexBuffer(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexBuffer(arg0,arg1,arg2);
    String txt = new String("glTexBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glSamplerParameterfv(arg0,arg1,arg2,arg3);
    String txt = new String("glSamplerParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMakeNamedBufferNonResidentNV(int arg0)
  {
        checkContext();
downstreamGL3.glMakeNamedBufferNonResidentNV(arg0);
    String txt = new String("glMakeNamedBufferNonResidentNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElementsIndirect(int arg0,int arg1,java.nio.Buffer arg2)
  {
        checkContext();
downstreamGL3.glDrawElementsIndirect(arg0,arg1,arg2);
    String txt = new String("glDrawElementsIndirect(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMapdv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnMapdv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnMapdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glScissorIndexedv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glScissorIndexedv(arg0,arg1);
    String txt = new String("glScissorIndexedv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnCompressedTexImage(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL3.glGetnCompressedTexImage(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnCompressedTexImage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glSamplerParameteriv(arg0,arg1,arg2);
    String txt = new String("glSamplerParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveAttrib(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
        checkContext();
downstreamGL3.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glGetActiveAttrib(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg10).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetIntegerui64i_vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetIntegerui64i_vNV(arg0,arg1,arg2,arg3);
    String txt = new String("glGetIntegerui64i_vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix2x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
        checkContext();
downstreamGL3.glBufferData(arg0,arg1,arg2,arg3);
    String txt = new String("glBufferData(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<java.nio.Buffer> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4ubv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4ubv(arg0,arg1);
    String txt = new String("glVertexAttrib4ubv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetTexLevelParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexP4uiv(arg0,arg1);
    String txt = new String("glVertexP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetDoublei_v(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetDoublei_v(arg0,arg1,arg2);
    String txt = new String("glGetDoublei_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendEquationSeparate(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBlendEquationSeparate(arg0,arg1);
    String txt = new String("glBlendEquationSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetSamplerParameteriv(arg0,arg1,arg2);
    String txt = new String("glGetSamplerParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform1dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteProgramPipelines(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteProgramPipelines(arg0,arg1,arg2);
    String txt = new String("glDeleteProgramPipelines(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiDrawArraysIndirectAMD(int arg0,java.nio.Buffer arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glMultiDrawArraysIndirectAMD(arg0,arg1,arg2,arg3);
    String txt = new String("glMultiDrawArraysIndirectAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDebugMessageInsertAMD(int arg0,int arg1,int arg2,int arg3,java.lang.String arg4)
  {
        checkContext();
downstreamGL3.glDebugMessageInsertAMD(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glDebugMessageInsertAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.lang.String> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform4uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4uiv(arg0,arg1);
    String txt = new String("glVertexAttrib4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsShader(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsShader(arg0);
    String txt = new String("glIsShader(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetnUniformuiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnUniformuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnUniformuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsNamedBufferResidentNV(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsNamedBufferResidentNV(arg0);
    String txt = new String("glIsNamedBufferResidentNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glBindBuffer(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBindBuffer(arg0,arg1);
    String txt = new String("glBindBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsProgramPipeline(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsProgramPipeline(arg0);
    String txt = new String("glIsProgramPipeline(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetnPixelMapusv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetnPixelMapusv(arg0,arg1,arg2);
    String txt = new String("glGetnPixelMapusv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteProgram(int arg0)
  {
        checkContext();
downstreamGL3.glDeleteProgram(arg0);
    String txt = new String("glDeleteProgram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glCreateShaderProgramv(int arg0,int arg1,com.jogamp.common.nio.PointerBuffer arg2)
  {
        checkContext();
    int _res = downstreamGL3.glCreateShaderProgramv(arg0,arg1,arg2);
    String txt = new String("glCreateShaderProgramv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<com.jogamp.common.nio.PointerBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenFramebuffers(arg0,arg1);
    String txt = new String("glGenFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1sv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib1sv(arg0,arg1);
    String txt = new String("glVertexAttrib1sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glPointSize(float arg0)
  {
        checkContext();
downstreamGL3.glPointSize(arg0);
    String txt = new String("glPointSize(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribfv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetVertexAttribfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetVertexAttribfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform1fv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform1fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix2x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  java.lang.String glGetString(int arg0)
  {
        checkContext();
    java.lang.String _res = downstreamGL3.glGetString(arg0);
    String txt = new String("glGetString(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetQueryiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetQueryiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetQueryiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSetMultisamplefvAMD(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glSetMultisamplefvAMD(arg0,arg1,arg2,arg3);
    String txt = new String("glSetMultisamplefvAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean isFunctionAvailable(java.lang.String arg0)
  {
        return downstreamGL3.isFunctionAvailable(arg0);
  }
  public  void glPointParameteriv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glPointParameteriv(arg0,arg1);
    String txt = new String("glPointParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glViewportIndexedf(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
        checkContext();
downstreamGL3.glViewportIndexedf(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glViewportIndexedf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glShaderBinary(int arg0,java.nio.IntBuffer arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
        checkContext();
downstreamGL3.glShaderBinary(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glShaderBinary(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsBufferResidentNV(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsBufferResidentNV(arg0);
    String txt = new String("glIsBufferResidentNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glProgramUniform3fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform3fv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI3ui(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribI3ui(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribI3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP3uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glMultiTexCoordP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glSamplerParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTexture3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glFramebufferTexture3D(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glFramebufferTexture3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenProgramPipelines(arg0,arg1);
    String txt = new String("glGenProgramPipelines(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glColorP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glColorP4uiv(arg0,arg1);
    String txt = new String("glColorP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glScissor(arg0,arg1,arg2,arg3);
    String txt = new String("glScissor(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDebugMessageControlARB(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,boolean arg6)
  {
        checkContext();
downstreamGL3.glDebugMessageControlARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glDebugMessageControlARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<boolean> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix4x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawBuffer(int arg0)
  {
        checkContext();
downstreamGL3.glDrawBuffer(arg0);
    String txt = new String("glDrawBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameterf(int arg0,float arg1)
  {
        checkContext();
downstreamGL3.glPointParameterf(arg0,arg1);
    String txt = new String("glPointParameterf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteFramebuffers(arg0,arg1,arg2);
    String txt = new String("glDeleteFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetUniformBlockIndex(int arg0,java.lang.String arg1)
  {
        checkContext();
    int _res = downstreamGL3.glGetUniformBlockIndex(arg0,arg1);
    String txt = new String("glGetUniformBlockIndex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glMultiTexCoordP4ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP4ui(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform2uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetActiveAtomicCounterBufferiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFloati_v(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetFloati_v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetFloati_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetUniformfv(arg0,arg1,arg2);
    String txt = new String("glGetUniformfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribLdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetVertexAttribLdv(arg0,arg1,arg2);
    String txt = new String("glGetVertexAttribLdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glLinkProgram(int arg0)
  {
        checkContext();
downstreamGL3.glLinkProgram(arg0);
    String txt = new String("glLinkProgram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
        checkContext();
downstreamGL3.glTexImage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glTexImage3DMultisample(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<boolean> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP2ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP2ui(arg0,arg1);
    String txt = new String("glTexCoordP2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform1uiv(arg0,arg1,arg2);
    String txt = new String("glUniform1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetTexLevelParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL1dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribL1dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribL1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix4x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4iv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4iv(arg0,arg1);
    String txt = new String("glVertexAttrib4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDisableVertexAttribArray(int arg0)
  {
        checkContext();
downstreamGL3.glDisableVertexAttribArray(arg0);
    String txt = new String("glDisableVertexAttribArray(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribP4uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBeginQuery(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBeginQuery(arg0,arg1);
    String txt = new String("glBeginQuery(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetBufferParameteri64v(arg0,arg1,arg2);
    String txt = new String("glGetBufferParameteri64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformdv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetUniformdv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  long glCreateSyncFromCLeventARB(java.nio.Buffer arg0,java.nio.Buffer arg1,int arg2)
  {
        checkContext();
    long _res = downstreamGL3.glCreateSyncFromCLeventARB(arg0,arg1,arg2);
    String txt = new String("glCreateSyncFromCLeventARB(" +
    "<java.nio.Buffer> "+arg0 +    ", " +
    "<java.nio.Buffer> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetSamplerParameterIiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetSamplerParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform1uiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI1iv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI1iv(arg0,arg1);
    String txt = new String("glVertexAttribI1iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nub(int arg0,byte arg1,byte arg2,byte arg3,byte arg4)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nub(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttrib4Nub(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<byte> "+arg1 +    ", " +
    "<byte> "+arg2 +    ", " +
    "<byte> "+arg3 +    ", " +
    "<byte> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP2uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glMultiTexCoordP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1d(int arg0,int arg1,double arg2)
  {
        checkContext();
downstreamGL3.glProgramUniform1d(arg0,arg1,arg2);
    String txt = new String("glProgramUniform1d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<double> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTexture(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glFramebufferTexture(arg0,arg1,arg2,arg3);
    String txt = new String("glFramebufferTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPauseTransformFeedback()
  {
        checkContext();
downstreamGL3.glPauseTransformFeedback();
    String txt = new String("glPauseTransformFeedback(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix2x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribI4ui(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribI4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage2DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
        checkContext();
downstreamGL3.glTexImage2DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glTexImage2DMultisampleCoverageNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<boolean> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI3iv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI3iv(arg0,arg1);
    String txt = new String("glVertexAttribI3iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramStageiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetProgramStageiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetProgramStageiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform3uiv(arg0,arg1,arg2);
    String txt = new String("glUniform3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenQueries(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenQueries(arg0,arg1,arg2);
    String txt = new String("glGenQueries(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetVertexAttribiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetVertexAttribiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
    String txt = new String("glGetShaderPrecisionFormat(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderPrecisionFormat(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetShaderPrecisionFormat(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1d(int arg0,double arg1)
  {
        checkContext();
downstreamGL3.glUniform1d(arg0,arg1);
    String txt = new String("glUniform1d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetInteger64v(int arg0,long[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetInteger64v(arg0,arg1,arg2);
    String txt = new String("glGetInteger64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix3x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Niv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Niv(arg0,arg1);
    String txt = new String("glVertexAttrib4Niv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetUniformIndices(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformIndices(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix3x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMapiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnMapiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnMapiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalFormatNV(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glNormalFormatNV(arg0,arg1);
    String txt = new String("glNormalFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMapfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnMapfv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnMapfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetUniformiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix4x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3d(int arg0,int arg1,double arg2,double arg3,double arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3d(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL3.glSamplerParameterf(arg0,arg1,arg2);
    String txt = new String("glSamplerParameterf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsProgram(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsProgram(arg0);
    String txt = new String("glIsProgram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glWaitSync(long arg0,int arg1,long arg2)
  {
        checkContext();
downstreamGL3.glWaitSync(arg0,arg1,arg2);
    String txt = new String("glWaitSync(" +
    "<long> "+arg0 +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glSamplerParameterfv(arg0,arg1,arg2);
    String txt = new String("glSamplerParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1f(int arg0,float arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib1f(arg0,arg1);
    String txt = new String("glVertexAttrib1f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  java.lang.Object getPlatformGLExtensions()
  {
        return downstreamGL3.getPlatformGLExtensions();
  }
  public  void glGetSynciv(long arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
        checkContext();
downstreamGL3.glGetSynciv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetSynciv(" +
    "<long> "+arg0 +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSynciv(long arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetSynciv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetSynciv(" +
    "<long> "+arg0 +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix2x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBindAttribLocation(int arg0,int arg1,java.lang.String arg2)
  {
        checkContext();
downstreamGL3.glBindAttribLocation(arg0,arg1,arg2);
    String txt = new String("glBindAttribLocation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.lang.String> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glViewport(arg0,arg1,arg2,arg3);
    String txt = new String("glViewport(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nubv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nubv(arg0,arg1);
    String txt = new String("glVertexAttrib4Nubv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL3.glGetBufferSubData(arg0,arg1,arg2,arg3);
    String txt = new String("glGetBufferSubData(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<long> "+arg2 +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTessellationModeAMD(int arg0)
  {
        checkContext();
downstreamGL3.glTessellationModeAMD(arg0);
    String txt = new String("glTessellationModeAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTextureFaceARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glFramebufferTextureFaceARB(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glFramebufferTextureFaceARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP2ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glVertexP2ui(arg0,arg1);
    String txt = new String("glVertexP2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP2uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexCoordP2uiv(arg0,arg1,arg2);
    String txt = new String("glTexCoordP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3d(int arg0,double arg1,double arg2,double arg3)
  {
        checkContext();
downstreamGL3.glUniform3d(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3iv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glValidateProgramPipeline(int arg0)
  {
        checkContext();
downstreamGL3.glValidateProgramPipeline(arg0);
    String txt = new String("glValidateProgramPipeline(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPixelMapuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetnPixelMapuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnPixelMapuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP1uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexCoordP1uiv(arg0,arg1,arg2);
    String txt = new String("glTexCoordP1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribdv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetVertexAttribdv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetVertexAttribdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glClearBufferuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glClearBufferuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetUniformui64vNV(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetActiveSubroutineUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP1uiv(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribIPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetVertexAttribfv(arg0,arg1,arg2);
    String txt = new String("glGetVertexAttribfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform1fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform1fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3f(int arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL3.glVertexAttrib3f(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttrib3f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2s(int arg0,short arg1,short arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib2s(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib2s(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<short> "+arg1 +    ", " +
    "<short> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilMaskSeparate(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glStencilMaskSeparate(arg0,arg1);
    String txt = new String("glStencilMaskSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetNamedStringivARB(int arg0,java.lang.String arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetNamedStringivARB(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetNamedStringivARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.lang.String> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2d(int arg0,double arg1,double arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib2d(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib2d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3iv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform3iv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2f(int arg0,float arg1,float arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib2f(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib2f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsTexture(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsTexture(arg0);
    String txt = new String("glIsTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glSetMultisamplefvAMD(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glSetMultisamplefvAMD(arg0,arg1,arg2);
    String txt = new String("glSetMultisamplefvAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP1uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib3dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteProgramPipelines(arg0,arg1);
    String txt = new String("glDeleteProgramPipelines(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nbv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nbv(arg0,arg1);
    String txt = new String("glVertexAttrib4Nbv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetSamplerParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetSamplerParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix3x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI1ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI1ui(arg0,arg1);
    String txt = new String("glVertexAttribI1ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexLevelParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP4uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexP4uiv(arg0,arg1,arg2);
    String txt = new String("glVertexP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRange(double arg0,double arg1)
  {
        checkContext();
downstreamGL3.glDepthRange(arg0,arg1);
    String txt = new String("glDepthRange(" +
    "<double> "+arg0 +    ", " +
    "<double> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearDepthf(float arg0)
  {
        checkContext();
downstreamGL3.glClearDepthf(arg0);
    String txt = new String("glClearDepthf(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetFloatv(arg0,arg1);
    String txt = new String("glGetFloatv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform(javax.media.opengl.GLUniformData arg0)
  {
        checkContext();
downstreamGL3.glUniform(arg0);
    String txt = new String("glUniform(" +
    "<javax.media.opengl.GLUniformData> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3dv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform3dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform1fv(arg0,arg1,arg2);
    String txt = new String("glUniform1fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformuiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnUniformuiv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnUniformuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib1dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform4uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramBinary(int arg0,int arg1,java.nio.Buffer arg2,int arg3)
  {
        checkContext();
downstreamGL3.glProgramBinary(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramBinary(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4uiv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
        checkContext();
downstreamGL3.glVertexAttrib4d(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttrib4d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1fv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib1fv(arg0,arg1);
    String txt = new String("glVertexAttrib1fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
        checkContext();
downstreamGL3.glVertexAttrib4f(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttrib4f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3fv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib3fv(arg0,arg1);
    String txt = new String("glVertexAttrib3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenFramebuffers(arg0,arg1,arg2);
    String txt = new String("glGenFramebuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalP3ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glNormalP3ui(arg0,arg1);
    String txt = new String("glNormalP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void setSwapInterval(int arg0)
  {
    downstreamGL3.setSwapInterval(arg0);
  }
  public  void glVertexAttrib4s(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
        checkContext();
downstreamGL3.glVertexAttrib4s(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttrib4s(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<short> "+arg1 +    ", " +
    "<short> "+arg2 +    ", " +
    "<short> "+arg3 +    ", " +
    "<short> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRangeIndexed(int arg0,double arg1,double arg2)
  {
        checkContext();
downstreamGL3.glDepthRangeIndexed(arg0,arg1,arg2);
    String txt = new String("glDepthRangeIndexed(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameteriv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glPointParameteriv(arg0,arg1,arg2);
    String txt = new String("glPointParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP2ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP2ui(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform3fv(arg0,arg1,arg2);
    String txt = new String("glUniform3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendEquation(int arg0)
  {
        checkContext();
downstreamGL3.glBlendEquation(arg0);
    String txt = new String("glBlendEquation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1dv(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform1dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetQueryiv(arg0,arg1,arg2);
    String txt = new String("glGetQueryiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformSubroutinesuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniformSubroutinesuiv(arg0,arg1,arg2);
    String txt = new String("glUniformSubroutinesuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferTextureARB(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glFramebufferTextureARB(arg0,arg1,arg2,arg3);
    String txt = new String("glFramebufferTextureARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawBuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDrawBuffers(arg0,arg1);
    String txt = new String("glDrawBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI2ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI2ui(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformdv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glGetnUniformdv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnUniformdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix4x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTessellationFactorAMD(float arg0)
  {
        checkContext();
downstreamGL3.glTessellationFactorAMD(arg0);
    String txt = new String("glTessellationFactorAMD(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
        checkContext();
downstreamGL3.glFlushMappedBufferRange(arg0,arg1,arg2);
    String txt = new String("glFlushMappedBufferRange(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<long> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI1uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI1uiv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI1uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribL4dv(arg0,arg1);
    String txt = new String("glVertexAttribL4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glBlitFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
        checkContext();
downstreamGL3.glBlitFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    String txt = new String("glBlitFramebuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glSamplerParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glSamplerParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix4fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
        checkContext();
downstreamGL3.glPointParameterfv(arg0,arg1);
    String txt = new String("glPointParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glScissorIndexedv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glScissorIndexedv(arg0,arg1,arg2);
    String txt = new String("glScissorIndexedv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRangef(float arg0,float arg1)
  {
        checkContext();
downstreamGL3.glDepthRangef(arg0,arg1);
    String txt = new String("glDepthRangef(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL3.glClearColor(arg0,arg1,arg2,arg3);
    String txt = new String("glClearColor(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetSamplerParameterfv(arg0,arg1,arg2);
    String txt = new String("glGetSamplerParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9)
  {
        checkContext();
downstreamGL3.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    String txt = new String("glTexImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<long> "+arg9 +    ")");
    checkGLGetError( txt );
  }
  public  void glActiveTexture(int arg0)
  {
        checkContext();
downstreamGL3.glActiveTexture(arg0);
    String txt = new String("glActiveTexture(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSecondaryColorP3ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glSecondaryColorP3ui(arg0,arg1);
    String txt = new String("glSecondaryColorP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP4ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP4ui(arg0,arg1);
    String txt = new String("glTexCoordP4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix2fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  long glFenceSync(int arg0,int arg1)
  {
        checkContext();
    long _res = downstreamGL3.glFenceSync(arg0,arg1);
    String txt = new String("glFenceSync(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glDeleteSamplers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteSamplers(arg0,arg1,arg2);
    String txt = new String("glDeleteSamplers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnMapdv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnMapdv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnMapdv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenerateMipmap(int arg0)
  {
        checkContext();
downstreamGL3.glGenerateMipmap(arg0);
    String txt = new String("glGenerateMipmap(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUseProgram(int arg0)
  {
        checkContext();
downstreamGL3.glUseProgram(arg0);
    String txt = new String("glUseProgram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL2d(int arg0,double arg1,double arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribL2d(arg0,arg1,arg2);
    String txt = new String("glVertexAttribL2d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPolygonStipple(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetnPolygonStipple(arg0,arg1);
    String txt = new String("glGetnPolygonStipple(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnPixelMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetnPixelMapfv(arg0,arg1,arg2);
    String txt = new String("glGetnPixelMapfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glClearBufferfv(arg0,arg1,arg2);
    String txt = new String("glClearBufferfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glEnable(int arg0)
  {
        checkContext();
downstreamGL3.glEnable(arg0);
    String txt = new String("glEnable(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteShader(int arg0)
  {
        checkContext();
downstreamGL3.glDeleteShader(arg0);
    String txt = new String("glDeleteShader(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glTexCoordP4uiv(arg0,arg1);
    String txt = new String("glTexCoordP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP2uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniformui64vNV(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniformui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureImage3DMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
        checkContext();
downstreamGL3.glTextureImage3DMultisampleNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glTextureImage3DMultisampleNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<boolean> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  void glEndTransformFeedback()
  {
        checkContext();
downstreamGL3.glEndTransformFeedback();
    String txt = new String("glEndTransformFeedback(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
        checkContext();
downstreamGL3.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glTexImage1D(" +
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
  public  boolean glIsRenderbuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsRenderbuffer(arg0);
    String txt = new String("glIsRenderbuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttrib4ubv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4ubv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4ubv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawTransformFeedbackStream(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDrawTransformFeedbackStream(arg0,arg1,arg2);
    String txt = new String("glDrawTransformFeedbackStream(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL3.glDrawElements(arg0,arg1,arg2,arg3);
    String txt = new String("glDrawElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glValidateProgram(int arg0)
  {
        checkContext();
downstreamGL3.glValidateProgram(arg0);
    String txt = new String("glValidateProgram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
        checkContext();
downstreamGL3.glTexImage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glTexImage2DMultisample(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<boolean> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL3.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glCompressedTexImage3D(" +
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
  public  void glDeleteTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteTransformFeedbacks(arg0,arg1,arg2);
    String txt = new String("glDeleteTransformFeedbacks(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
        checkContext();
downstreamGL3.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
  public  void glBufferAddressRangeNV(int arg0,int arg1,long arg2,long arg3)
  {
        checkContext();
downstreamGL3.glBufferAddressRangeNV(arg0,arg1,arg2,arg3);
    String txt = new String("glBufferAddressRangeNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ", " +
    "<long> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix2x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearBufferiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glClearBufferiv(arg0,arg1,arg2,arg3);
    String txt = new String("glClearBufferiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenBuffers(arg0,arg1);
    String txt = new String("glGenBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nuiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nuiv(arg0,arg1);
    String txt = new String("glVertexAttrib4Nuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4fv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4fv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
        checkContext();
downstreamGL3.glBufferSubData(arg0,arg1,arg2,arg3);
    String txt = new String("glBufferSubData(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<long> "+arg2 +    ", " +
    "<java.nio.Buffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glReadBuffer(int arg0)
  {
        checkContext();
downstreamGL3.glReadBuffer(arg0);
    String txt = new String("glReadBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glSamplerParameterIiv(arg0,arg1,arg2);
    String txt = new String("glSamplerParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1iv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform1iv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform1iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiDrawArrays(int arg0,int[] arg1,int arg2,int[] arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glMultiDrawArrays(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glMultiDrawArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiDrawArrays(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2,int arg3)
  {
        checkContext();
downstreamGL3.glMultiDrawArrays(arg0,arg1,arg2,arg3);
    String txt = new String("glMultiDrawArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP2ui(int arg0,int arg1,boolean arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP2ui(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform1dv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform1dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  int glGetGraphicsResetStatus()
  {
        checkContext();
    int _res = downstreamGL3.glGetGraphicsResetStatus();
    String txt = new String("glGetGraphicsResetStatus(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix4x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenTransformFeedbacks(arg0,arg1);
    String txt = new String("glGenTransformFeedbacks(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetDoublei_v(int arg0,int arg1,double[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetDoublei_v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetDoublei_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix2x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnUniformfv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnUniformfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glFlush()
  {
        checkContext();
downstreamGL3.glFlush();
    String txt = new String("glFlush(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
        checkContext();
downstreamGL3.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glCompressedTexImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glPatchParameterfv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glPatchParameterfv(arg0,arg1,arg2);
    String txt = new String("glPatchParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glTexStorage1D(arg0,arg1,arg2,arg3);
    String txt = new String("glTexStorage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsEnabledi(int arg0,int arg1)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsEnabledi(arg0,arg1);
    String txt = new String("glIsEnabledi(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x3dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix4x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDisableClientState(int arg0)
  {
        checkContext();
downstreamGL3.glDisableClientState(arg0);
    String txt = new String("glDisableClientState(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMinSampleShading(float arg0)
  {
        checkContext();
downstreamGL3.glMinSampleShading(arg0);
    String txt = new String("glMinSampleShading(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2iv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2ui(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glUniform2ui(arg0,arg1,arg2);
    String txt = new String("glUniform2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2dv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform4iv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4sv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4sv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniform4ui(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniform4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetCompressedTexImage(int arg0,int arg1,java.nio.Buffer arg2)
  {
        checkContext();
downstreamGL3.glGetCompressedTexImage(arg0,arg1,arg2);
    String txt = new String("glGetCompressedTexImage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix3x2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glGetProgramInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetProgramInfoLog(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glCreateShader(int arg0)
  {
        checkContext();
    int _res = downstreamGL3.glCreateShader(arg0);
    String txt = new String("glCreateShader(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glTexParameterIuiv(arg0,arg1,arg2);
    String txt = new String("glTexParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix3x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawArrays(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDrawArrays(arg0,arg1,arg2);
    String txt = new String("glDrawArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBeginConditionalRender(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glBeginConditionalRender(arg0,arg1);
    String txt = new String("glBeginConditionalRender(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawArraysIndirect(int arg0,java.nio.Buffer arg1)
  {
        checkContext();
downstreamGL3.glDrawArraysIndirect(arg0,arg1);
    String txt = new String("glDrawArraysIndirect(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI3uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI3uiv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjectiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetQueryObjectiv(arg0,arg1,arg2);
    String txt = new String("glGetQueryObjectiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI2iv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI2iv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI2iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform2iv(arg0,arg1,arg2);
    String txt = new String("glUniform2iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniform4ui(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniform4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glTexStorage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glHint(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glHint(arg0,arg1);
    String txt = new String("glHint(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glLineWidth(float arg0)
  {
        checkContext();
downstreamGL3.glLineWidth(arg0);
    String txt = new String("glLineWidth(" +
    "<float> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsVertexArray(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsVertexArray(arg0);
    String txt = new String("glIsVertexArray(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexP3uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexP3uiv(arg0,arg1,arg2);
    String txt = new String("glVertexP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetVertexAttribIiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetVertexAttribIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetIntegerui64i_vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetIntegerui64i_vNV(arg0,arg1,arg2);
    String txt = new String("glGetIntegerui64i_vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  int glGetDebugMessageLogARB(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.IntBuffer arg6,java.nio.ByteBuffer arg7)
  {
        checkContext();
    int _res = downstreamGL3.glGetDebugMessageLogARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glGetDebugMessageLogARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.IntBuffer> "+arg5 +    ", " +
    "<java.nio.IntBuffer> "+arg6 +    ", " +
    "<java.nio.ByteBuffer> "+arg7 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  int glGetDebugMessageLogAMD(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,byte[] arg10,int arg11)
  {
        checkContext();
    int _res = downstreamGL3.glGetDebugMessageLogAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    String txt = new String("glGetDebugMessageLogAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg11).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glMakeNamedBufferResidentNV(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glMakeNamedBufferResidentNV(arg0,arg1);
    String txt = new String("glMakeNamedBufferResidentNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiTexCoordP4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glMultiTexCoordP4uiv(arg0,arg1,arg2);
    String txt = new String("glMultiTexCoordP4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2sv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib2sv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib2sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glScissorIndexed(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glScissorIndexed(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glScissorIndexed(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetTexParameterIiv(arg0,arg1,arg2);
    String txt = new String("glGetTexParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetTexParameterfv(arg0,arg1,arg2);
    String txt = new String("glGetTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetVertexAttribIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetVertexAttribIuiv(arg0,arg1,arg2);
    String txt = new String("glGetVertexAttribIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform4uiv(arg0,arg1,arg2);
    String txt = new String("glUniform4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    String txt = new String("glRenderbufferStorage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glTextureStorage1DEXT(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3ui(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteRenderbuffers(arg0,arg1,arg2);
    String txt = new String("glDeleteRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
        checkContext();
downstreamGL3.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glCompressedTexSubImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ", " +
    "<long> "+arg10 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glUnmapBuffer(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glUnmapBuffer(arg0);
    String txt = new String("glUnmapBuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
        checkContext();
downstreamGL3.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetInternalformativ(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix4x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glEndQueryIndexed(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glEndQueryIndexed(arg0,arg1);
    String txt = new String("glEndQueryIndexed(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsSync(long arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsSync(arg0);
    String txt = new String("glIsSync(" +
    "<long> "+arg0 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetActiveUniformBlockiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetDoublev(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetDoublev(arg0,arg1);
    String txt = new String("glGetDoublev(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribL2dv(arg0,arg1);
    String txt = new String("glVertexAttribL2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetProgramiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetProgramiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribLPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL3.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
  public  void glGetIntegeri_v(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetIntegeri_v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetIntegeri_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int glGetDebugMessageLogARB(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,int[] arg10,int arg11,byte[] arg12,int arg13)
  {
        checkContext();
    int _res = downstreamGL3.glGetDebugMessageLogARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13);
    String txt = new String("glGetDebugMessageLogARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg11).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg13).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetnConvolutionFilter(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
        checkContext();
downstreamGL3.glGetnConvolutionFilter(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetnConvolutionFilter(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
        checkContext();
downstreamGL3.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
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
  public  void glFrontFace(int arg0)
  {
        checkContext();
downstreamGL3.glFrontFace(arg0);
    String txt = new String("glFrontFace(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordFormatNV(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexCoordFormatNV(arg0,arg1,arg2);
    String txt = new String("glTexCoordFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glViewportIndexedfv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glViewportIndexedfv(arg0,arg1,arg2);
    String txt = new String("glViewportIndexedfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
        checkContext();
downstreamGL3.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glDrawElementsBaseVertex(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glClearDepth(double arg0)
  {
        checkContext();
downstreamGL3.glClearDepth(arg0);
    String txt = new String("glClearDepth(" +
    "<double> "+arg0 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnHistogram(int arg0,boolean arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
        checkContext();
downstreamGL3.glGetnHistogram(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetnHistogram(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<boolean> "+arg1 +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBooleani_v(int arg0,int arg1,byte[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetBooleani_v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetBooleani_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformSubroutineuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetUniformSubroutineuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetUniformSubroutineuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
        checkContext();
downstreamGL3.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glCompressedTexSubImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<long> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4fv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform4fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteQueries(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteQueries(arg0,arg1);
    String txt = new String("glDeleteQueries(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsVBOElementArrayEnabled()
  {
        checkContext();
    boolean _res = downstreamGL3.glIsVBOElementArrayEnabled();
    String txt = new String("glIsVBOElementArrayEnabled(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttribP4ui(int arg0,int arg1,boolean arg2,int arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP4ui(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL3d(int arg0,double arg1,double arg2,double arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribL3d(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribL3d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nusv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nusv(arg0,arg1);
    String txt = new String("glVertexAttrib4Nusv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glColorP3ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glColorP3ui(arg0,arg1);
    String txt = new String("glColorP3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2fv(int arg0,float[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib2fv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetMultisamplefv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetMultisamplefv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetMultisamplefv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetBooleanv(arg0,arg1);
    String txt = new String("glGetBooleanv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glPatchParameteri(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glPatchParameteri(arg0,arg1);
    String txt = new String("glPatchParameteri(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetTexParameterIuiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetTexParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSecondaryColorP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glSecondaryColorP3uiv(arg0,arg1);
    String txt = new String("glSecondaryColorP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
        checkContext();
downstreamGL3.glTexParameterfv(arg0,arg1,arg2);
    String txt = new String("glTexParameterfv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.FloatBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform1iv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform1iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  int getSwapInterval()
  {
        return downstreamGL3.getSwapInterval();
  }
  public  void glTransformFeedbackVaryings(int arg0,int arg1,java.lang.String[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glTransformFeedbackVaryings(arg0,arg1,arg2,arg3);
    String txt = new String("glTransformFeedbackVaryings(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage3DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
        checkContext();
downstreamGL3.glTexImage3DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glTexImage3DMultisampleCoverageNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<boolean> "+arg7 +    ")");
    checkGLGetError( txt );
  }
  public  int glCreateProgram()
  {
        checkContext();
    int _res = downstreamGL3.glCreateProgram();
    String txt = new String("glCreateProgram(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glStencilOpSeparate(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glStencilOpSeparate(arg0,arg1,arg2,arg3);
    String txt = new String("glStencilOpSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.Buffer arg5)
  {
        checkContext();
downstreamGL3.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glVertexAttribPointer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterf(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL3.glTexParameterf(arg0,arg1,arg2);
    String txt = new String("glTexParameterf(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniformui64vNV(arg0,arg1,arg2);
    String txt = new String("glUniformui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenSamplers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenSamplers(arg0,arg1,arg2);
    String txt = new String("glGenSamplers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix2x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.DoubleBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetFramebufferAttachmentParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramPipelineiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetProgramPipelineiv(arg0,arg1,arg2);
    String txt = new String("glGetProgramPipelineiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDrawElementsInstancedBaseInstance(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg3 +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL1d(int arg0,double arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribL1d(arg0,arg1);
    String txt = new String("glVertexAttribL1d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI2uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI2uiv(arg0,arg1);
    String txt = new String("glVertexAttribI2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  java.lang.String glGetStringi(int arg0,int arg1)
  {
        checkContext();
    java.lang.String _res = downstreamGL3.glGetStringi(arg0,arg1);
    String txt = new String("glGetStringi(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  int glClientWaitSync(long arg0,int arg1,long arg2)
  {
        checkContext();
    int _res = downstreamGL3.glClientWaitSync(arg0,arg1,arg2);
    String txt = new String("glClientWaitSync(" +
    "<long> "+arg0 +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<long> "+arg2 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetProgramInfoLog(arg0,arg1,arg2,arg3);
    String txt = new String("glGetProgramInfoLog(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.ByteBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramBinary(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.Buffer arg4)
  {
        checkContext();
downstreamGL3.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetProgramBinary(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ", " +
    "<java.nio.Buffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetProgramBinary(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,java.nio.Buffer arg6)
  {
        checkContext();
downstreamGL3.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glGetProgramBinary(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<java.nio.Buffer> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix3x2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  boolean glIsEnabled(int arg0)
  {
        checkContext();
    boolean _res = downstreamGL3.glIsEnabled(arg0);
    String txt = new String("glIsEnabled(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttrib4dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDebugMessageEnableAMD(int arg0,int arg1,int arg2,int[] arg3,int arg4,boolean arg5)
  {
        checkContext();
downstreamGL3.glDebugMessageEnableAMD(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDebugMessageEnableAMD(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<boolean> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glDebugMessageInsertARB(int arg0,int arg1,int arg2,int arg3,int arg4,java.lang.String arg5)
  {
        checkContext();
downstreamGL3.glDebugMessageInsertARB(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDebugMessageInsertARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<java.lang.String> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform4dv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetBufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenRenderbuffers(arg0,arg1,arg2);
    String txt = new String("glGenRenderbuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glColorP3uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glColorP3uiv(arg0,arg1,arg2);
    String txt = new String("glColorP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4iv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI4iv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendFuncSeparatei(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glBlendFuncSeparatei(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glBlendFuncSeparatei(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix4x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetUniformuiv(arg0,arg1,arg2);
    String txt = new String("glGetUniformuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glVertexAttribI4i(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glVertexAttribI4i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glTexParameterIiv(arg0,arg1,arg2);
    String txt = new String("glTexParameterIiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
        checkContext();
downstreamGL3.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
  public  void glProgramUniform3uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform3uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
        checkContext();
downstreamGL3.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    String txt = new String("glTexSubImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg9).toUpperCase() +    ", " +
    "<long> "+arg10 +    ")");
    checkGLGetError( txt );
  }
  public  void glCompileShaderIncludeARB(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glCompileShaderIncludeARB(arg0,arg1,arg2,arg3);
    String txt = new String("glCompileShaderIncludeARB(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib2dv(arg0,arg1);
    String txt = new String("glVertexAttrib2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glStencilOp(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glStencilOp(arg0,arg1,arg2);
    String txt = new String("glStencilOp(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetnUniformiv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetnUniformiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjecti64v(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetQueryObjecti64v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetQueryObjecti64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform4dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform4dv(arg0,arg1,arg2);
    String txt = new String("glUniform4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  int glGetError()
  {
        checkContext();
    int _res = downstreamGL3.glGetError();
    String txt = new String("glGetError(" +
    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glUniform4iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform4iv(arg0,arg1,arg2);
    String txt = new String("glUniform4iv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glReleaseShaderCompiler()
  {
        checkContext();
downstreamGL3.glReleaseShaderCompiler();
    String txt = new String("glReleaseShaderCompiler(" +
    ")");
    checkGLGetError( txt );
  }
  public  void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glTextureStorage2DEXT(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4sv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib4sv(arg0,arg1);
    String txt = new String("glVertexAttrib4sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjectuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetQueryObjectuiv(arg0,arg1,arg2);
    String txt = new String("glGetQueryObjectuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glUniform2dv(arg0,arg1,arg2);
    String txt = new String("glUniform2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2ui(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2ui(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetInteger64i_v(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetInteger64i_v(arg0,arg1,arg2,arg3);
    String txt = new String("glGetInteger64i_v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glTexParameteriv(arg0,arg1,arg2);
    String txt = new String("glTexParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
        checkContext();
downstreamGL3.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
  public  void glGetQueryIndexediv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glGetQueryIndexediv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetQueryIndexediv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDepthRangeArrayv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
        checkContext();
downstreamGL3.glDepthRangeArrayv(arg0,arg1,arg2);
    String txt = new String("glDepthRangeArrayv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.DoubleBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
        checkContext();
downstreamGL3.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    String txt = new String("glGetActiveSubroutineName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
        checkContext();
downstreamGL3.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
  public  void glViewportArrayv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glViewportArrayv(arg0,arg1,arg2,arg3);
    String txt = new String("glViewportArrayv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform1f(int arg0,int arg1,float arg2)
  {
        checkContext();
downstreamGL3.glProgramUniform1f(arg0,arg1,arg2);
    String txt = new String("glProgramUniform1f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenTextures(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGenTextures(arg0,arg1,arg2);
    String txt = new String("glGenTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glPixelStoref(int arg0,float arg1)
  {
        checkContext();
downstreamGL3.glPixelStoref(arg0,arg1);
    String txt = new String("glPixelStoref(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP2uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexP2uiv(arg0,arg1,arg2);
    String txt = new String("glVertexP2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
        checkContext();
downstreamGL3.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glDrawRangeElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<long> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI4uiv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI4uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI2i(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI2i(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI2i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix2x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
        checkContext();
downstreamGL3.glColorMask(arg0,arg1,arg2,arg3);
    String txt = new String("glColorMask(" +
    "<boolean> "+arg0 +    ", " +
    "<boolean> "+arg1 +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<boolean> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3ui(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform3ui(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glScissorArrayv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glScissorArrayv(arg0,arg1,arg2,arg3);
    String txt = new String("glScissorArrayv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetSamplerParameterIuiv(arg0,arg1,arg2);
    String txt = new String("glGetSamplerParameterIuiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix3dv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.DoubleBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix3x4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
        checkContext();
    java.nio.ByteBuffer _res = downstreamGL3.glMapBufferRange(arg0,arg1,arg2,arg3);
    String txt = new String("glMapBufferRange(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<long> "+arg1 +    ", " +
    "<long> "+arg2 +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glVertexAttrib4bv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4bv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4bv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glSecondaryColorFormatNV(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glSecondaryColorFormatNV(arg0,arg1,arg2);
    String txt = new String("glSecondaryColorFormatNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteVertexArrays(arg0,arg1);
    String txt = new String("glDeleteVertexArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
        checkContext();
downstreamGL3.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    String txt = new String("glTexSubImage1D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<long> "+arg6 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribL3dv(int arg0,double[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribL3dv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribL3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glUniform1ui(arg0,arg1);
    String txt = new String("glUniform1ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib2sv(int arg0,java.nio.ShortBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib2sv(arg0,arg1);
    String txt = new String("glVertexAttrib2sv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ShortBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  boolean isNPOTTextureAvailable()
  {
        return downstreamGL3.isNPOTTextureAvailable();
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
        checkContext();
downstreamGL3.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
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
  public  void glGetNamedBufferParameterui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetNamedBufferParameterui64vNV(arg0,arg1,arg2);
    String txt = new String("glGetNamedBufferParameterui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib1d(int arg0,double arg1)
  {
        checkContext();
downstreamGL3.glVertexAttrib1d(arg0,arg1);
    String txt = new String("glVertexAttrib1d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glMultiDrawElements(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5)
  {
        checkContext();
downstreamGL3.glMultiDrawElements(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glMultiDrawElements(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<com.jogamp.common.nio.PointerBuffer> "+arg4 +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniformMatrix2dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetTexImage(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
        checkContext();
downstreamGL3.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glGetTexImage(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<long> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    String txt = new String("glGetRenderbufferParameteriv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
        checkContext();
downstreamGL3.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glRenderbufferStorageMultisample(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform3f(int arg0,int arg1,float arg2,float arg3,float arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform3f(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform3f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendColor(float arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL3.glBlendColor(arg0,arg1,arg2,arg3);
    String txt = new String("glBlendColor(" +
    "<float> "+arg0 +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2f(int arg0,int arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2f(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib4Nusv(int arg0,short[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttrib4Nusv(arg0,arg1,arg2);
    String txt = new String("glVertexAttrib4Nusv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[S>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix2x3dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2i(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2i(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
        checkContext();
downstreamGL3.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glGetActiveSubroutineName(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg4 +    ", " +
    "<java.nio.ByteBuffer> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glSampleMaski(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glSampleMaski(arg0,arg1);
    String txt = new String("glSampleMaski(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4ubv(int arg0,java.nio.ByteBuffer arg1)
  {
        checkContext();
downstreamGL3.glVertexAttribI4ubv(arg0,arg1);
    String txt = new String("glVertexAttribI4ubv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.ByteBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetIntegerui64vNV(int arg0,long[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glGetIntegerui64vNV(arg0,arg1,arg2);
    String txt = new String("glGetIntegerui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glTexCoordP3uiv(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glTexCoordP3uiv(arg0,arg1,arg2);
    String txt = new String("glTexCoordP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  int getDefaultDrawFramebuffer()
  {
        return downstreamGL3.getDefaultDrawFramebuffer();
  }
  public  void glProgramUniform2fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glProgramUniform2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniform2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform2d(int arg0,int arg1,double arg2,double arg3)
  {
        checkContext();
downstreamGL3.glProgramUniform2d(arg0,arg1,arg2,arg3);
    String txt = new String("glProgramUniform2d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    String txt = new String("glFramebufferRenderbuffer(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform1f(int arg0,float arg1)
  {
        checkContext();
downstreamGL3.glUniform1f(arg0,arg1);
    String txt = new String("glUniform1f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribI4bv(int arg0,byte[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glVertexAttribI4bv(arg0,arg1,arg2);
    String txt = new String("glVertexAttribI4bv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[B>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glShaderSource(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glShaderSource(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[Ljava.lang.String;>" +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetBufferParameterui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glGetBufferParameterui64vNV(arg0,arg1,arg2,arg3);
    String txt = new String("glGetBufferParameterui64vNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[J>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
        checkContext();
downstreamGL3.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
  public  void glUniform2fv(int arg0,int arg1,float[] arg2,int arg3)
  {
        checkContext();
downstreamGL3.glUniform2fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform2fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<[F>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
        checkContext();
downstreamGL3.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
    String txt = new String("glUniformMatrix2x3fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.FloatBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGenVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGenVertexArrays(arg0,arg1);
    String txt = new String("glGenVertexArrays(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
        checkContext();
downstreamGL3.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glProgramUniformMatrix4fv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<java.nio.FloatBuffer> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  int glGetSubroutineUniformLocation(int arg0,int arg1,java.lang.String arg2)
  {
        checkContext();
    int _res = downstreamGL3.glGetSubroutineUniformLocation(arg0,arg1,arg2);
    String txt = new String("glGetSubroutineUniformLocation(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.lang.String> "+arg2 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glUniform4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
        checkContext();
downstreamGL3.glUniform4d(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniform4d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttrib3d(int arg0,double arg1,double arg2,double arg3)
  {
        checkContext();
downstreamGL3.glVertexAttrib3d(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttrib3d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glCopyTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
        checkContext();
downstreamGL3.glCopyTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    String txt = new String("glCopyTexSubImage3D(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg6).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg7).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg8).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glGetShaderiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetShaderiv(arg0,arg1,arg2);
    String txt = new String("glGetShaderiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glNormalP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glNormalP3uiv(arg0,arg1);
    String txt = new String("glNormalP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
        checkContext();
downstreamGL3.glDeleteBuffers(arg0,arg1,arg2);
    String txt = new String("glDeleteBuffers(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<[I>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
        checkContext();
downstreamGL3.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    String txt = new String("glBlendFuncSeparate(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexP4ui(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glVertexP4ui(arg0,arg1);
    String txt = new String("glVertexP4ui(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
        checkContext();
downstreamGL3.glProgramUniform4i(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniform4i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg3).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg5).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4d(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5)
  {
        checkContext();
downstreamGL3.glProgramUniform4d(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniform4d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<double> "+arg2 +    ", " +
    "<double> "+arg3 +    ", " +
    "<double> "+arg4 +    ", " +
    "<double> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glProgramUniform4f(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
        checkContext();
downstreamGL3.glProgramUniform4f(arg0,arg1,arg2,arg3,arg4,arg5);
    String txt = new String("glProgramUniform4f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ", " +
    "<float> "+arg4 +    ", " +
    "<float> "+arg5 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
        checkContext();
downstreamGL3.glUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glUniformMatrix3x4dv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<[D>" +    ", " +
    "<int> 0x"+Integer.toHexString(arg4).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glDeleteTextures(arg0,arg1);
    String txt = new String("glDeleteTextures(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform3f(int arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
downstreamGL3.glUniform3f(arg0,arg1,arg2,arg3);
    String txt = new String("glUniform3f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
        checkContext();
downstreamGL3.glVertexAttribP3uiv(arg0,arg1,arg2,arg3);
    String txt = new String("glVertexAttribP3uiv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<java.nio.IntBuffer> "+arg3 +    ")");
    checkGLGetError( txt );
  }
  public  void glGetQueryObjectui64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
        checkContext();
downstreamGL3.glGetQueryObjectui64v(arg0,arg1,arg2);
    String txt = new String("glGetQueryObjectui64v(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<java.nio.LongBuffer> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  java.nio.ByteBuffer glAllocateMemoryNV(int arg0,float arg1,float arg2,float arg3)
  {
        checkContext();
    java.nio.ByteBuffer _res = downstreamGL3.glAllocateMemoryNV(arg0,arg1,arg2,arg3);
    String txt = new String("glAllocateMemoryNV(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ", " +
    "<float> "+arg3 +    ")");
    checkGLGetError( txt );
    return _res;
  }
  public  void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
        checkContext();
downstreamGL3.glGetIntegerv(arg0,arg1);
    String txt = new String("glGetIntegerv(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<java.nio.IntBuffer> "+arg1 +    ")");
    checkGLGetError( txt );
  }
  public  void glColorMaski(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
        checkContext();
downstreamGL3.glColorMaski(arg0,arg1,arg2,arg3,arg4);
    String txt = new String("glColorMaski(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<boolean> "+arg1 +    ", " +
    "<boolean> "+arg2 +    ", " +
    "<boolean> "+arg3 +    ", " +
    "<boolean> "+arg4 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2d(int arg0,double arg1,double arg2)
  {
        checkContext();
downstreamGL3.glUniform2d(arg0,arg1,arg2);
    String txt = new String("glUniform2d(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<double> "+arg1 +    ", " +
    "<double> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glDisablei(int arg0,int arg1)
  {
        checkContext();
downstreamGL3.glDisablei(arg0,arg1);
    String txt = new String("glDisablei(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2f(int arg0,float arg1,float arg2)
  {
        checkContext();
downstreamGL3.glUniform2f(arg0,arg1,arg2);
    String txt = new String("glUniform2f(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<float> "+arg1 +    ", " +
    "<float> "+arg2 +    ")");
    checkGLGetError( txt );
  }
  public  void glUniform2i(int arg0,int arg1,int arg2)
  {
        checkContext();
downstreamGL3.glUniform2i(arg0,arg1,arg2);
    String txt = new String("glUniform2i(" +
    "<int> 0x"+Integer.toHexString(arg0).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg1).toUpperCase() +    ", " +
    "<int> 0x"+Integer.toHexString(arg2).toUpperCase() +    ")");
    checkGLGetError( txt );
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DebugGL3 [ implementing javax.media.opengl.GL3,\n\t");
    sb.append(" downstream: "+downstreamGL3.toString()+"\n\t]");
    return sb.toString();
  }
  private void checkGLGetError(String caller)
  {
    // Debug code to make sure the pipeline is working; leave commented out unless testing this class
    //System.err.println("Checking for GL errors after call to " + caller);

    int err = downstreamGL3.glGetError();
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
        case GL_OUT_OF_MEMORY: buf.append("GL_OUT_OF_MEMORY "); break;
        case GL_NO_ERROR: throw new InternalError("Should not be treating GL_NO_ERROR as error");
        default: buf.append("Unknown glGetError() return value: ");
      }
      buf.append("( " + err + " 0x"+Integer.toHexString(err).toUpperCase() + "), ");
    } while ((--recursionDepth >= 0) && (err = downstreamGL3.glGetError()) != GL_NO_ERROR);
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

  private GL3 downstreamGL3;
} // end class DebugGL3
