
package com.jogamp.opengl.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GLException;
import javax.media.opengl.fixedfunc.GLPointerFuncUtil;

import jogamp.opengl.util.GLArrayHandler;
import jogamp.opengl.util.GLFixedArrayHandler;
import jogamp.opengl.util.glsl.GLSLArrayHandler;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.glsl.ShaderState;


public class GLArrayDataClient extends GLArrayDataWrapper implements GLArrayDataEditable {

  /**
   * Create a client side buffer object, using a predefined fixed function array index
   * and starting with a new created Buffer object with initialElementCount size
   *
   * On profiles GL2 and ES1 the fixed function pipeline behavior is as expected.
   * On profile ES2 the fixed function emulation will transform these calls to 
   * EnableVertexAttribArray and VertexAttribPointer calls,
   * and a predefined vertex attribute variable name will be chosen.
   * 
   * The default name mapping will be used, 
   * see {@link GLPointerFuncUtil#getPredefinedArrayIndexName(int)}.
   *              
   * @param index The GL array index
   * @param comps The array component number
   * @param dataType The array index GL data type
   * @param normalized Whether the data shall be normalized
   * @param initialElementCount
   *
   * @see javax.media.opengl.GLContext#getPredefinedArrayIndexName(int)
   */  
  public static GLArrayDataClient createFixed(int index, int comps, int dataType, boolean normalized, int initialElementCount)
    throws GLException
  {
      GLArrayDataClient adc = new GLArrayDataClient();
      GLArrayHandler glArrayHandler = new GLFixedArrayHandler(adc);
      adc.init(null, index, comps, dataType, normalized, 0, null, initialElementCount, false, glArrayHandler, 0, 0, 0, 0, false);
      return adc;
  }

  /**
   * Create a client side buffer object, using a predefined fixed function array index
   * and starting with a given Buffer object incl it's stride
   *
   * On profiles GL2 and ES1 the fixed function pipeline behavior is as expected.
   * On profile ES2 the fixed function emulation will transform these calls to 
   * EnableVertexAttribArray and VertexAttribPointer calls,
   * and a predefined vertex attribute variable name will be chosen.
   * 
   * The default name mapping will be used, 
   * see {@link GLPointerFuncUtil#getPredefinedArrayIndexName(int)}.
   *              
   * @param index The GL array index
   * @param comps The array component number
   * @param dataType The array index GL data type
   * @param normalized Whether the data shall be normalized
   * @param stride
   * @param buffer the user define data
   *
   * @see javax.media.opengl.GLContext#getPredefinedArrayIndexName(int)
   */  
  public static GLArrayDataClient createFixed(int index, int comps, int dataType, boolean normalized, int stride, 
                                              Buffer buffer)
    throws GLException
  {
      GLArrayDataClient adc = new GLArrayDataClient();
      GLArrayHandler glArrayHandler = new GLFixedArrayHandler(adc);
      adc.init(null, index, comps, dataType, normalized, stride, buffer, comps*comps, false, glArrayHandler, 0, 0, 0, 0, false);
      return adc;
  }

  /**
   * Create a client side buffer object, using a custom GLSL array attribute name
   * and starting with a new created Buffer object with initialElementCount size
   * @param name  The custom name for the GL attribute. 
   * @param comps The array component number
   * @param dataType The array index GL data type
   * @param normalized Whether the data shall be normalized
   * @param initialElementCount
   */
  public static GLArrayDataClient createGLSL(String name, int comps, 
                                             int dataType, boolean normalized, int initialElementCount)
    throws GLException
  {
      GLArrayDataClient adc = new GLArrayDataClient();
      GLArrayHandler glArrayHandler = new GLSLArrayHandler(adc);
      adc.init(name, -1, comps, dataType, normalized, 0, null, initialElementCount, true, glArrayHandler, 0, 0, 0, 0, true);
      return adc;
  }

  /**
   * Create a client side buffer object, using a custom GLSL array attribute name
   * and starting with a given Buffer object incl it's stride
   * @param name  The custom name for the GL attribute. 
   * @param comps The array component number
   * @param dataType The array index GL data type
   * @param normalized Whether the data shall be normalized
   * @param stride
   * @param buffer the user define data
   */
  public static GLArrayDataClient createGLSL(String name, int comps,
                                             int dataType, boolean normalized, int stride, Buffer buffer)
    throws GLException
  {
      GLArrayDataClient adc = new GLArrayDataClient();
      GLArrayHandler glArrayHandler = new GLSLArrayHandler(adc);
      adc.init(name, -1, comps, dataType, normalized, stride, buffer, comps*comps, true, glArrayHandler, 0, 0, 0, 0, true);
      return adc;
  }

  // 
  // Data read access
  //

  public final boolean isVBOWritten() { return bufferWritten; }

  public final boolean sealed() { return sealed; }
  
  public final boolean enabled() { return bufferEnabled; }

  //
  // Data and GL state modification ..
  //

  public final void setVBOWritten(boolean written) { bufferWritten=written; }

  public void destroy(GL gl) {
    reset(gl);
    super.destroy(gl);
  }

  public void reset(GL gl) {
    enableBuffer(gl, false);
    reset();
  }

  public void seal(GL gl, boolean seal) {
    seal(seal);
    enableBuffer(gl, seal);
  }

  public void enableBuffer(GL gl, boolean enable) {
    if( enableBufferAlways || bufferEnabled != enable ) { 
        if(enable) {
            checkSeal(true);
            // init/generate VBO name if not done yet
            init_vbo(gl);
        }
        final Object ext;
        if(usesGLSL) {
            ext = ShaderState.getShaderState(gl);
            if(null == ext) {
                throw new GLException("A ShaderState must be bound to the GL context, use 'ShaderState.setShaderState(gl)'");
            }
        } else {
            ext = null;
        }
        if(enable) {
            glArrayHandler.syncData(gl, true, ext);
            glArrayHandler.enableState(gl, true, ext);
        } else {
            glArrayHandler.enableState(gl, false, ext);
            glArrayHandler.syncData(gl, false, ext);
        }
        bufferEnabled = enable;
    }
  }

  public void setEnableAlways(boolean always) {
    enableBufferAlways = always;
  }

  //
  // Data modification ..
  //

  public void reset() {
    if(buffer!=null) {
        buffer.clear();
    }
    this.sealed=false;
    this.bufferEnabled=false;
    this.bufferWritten=false;
  }

  public void seal(boolean seal)
  {
    if(sealed==seal) return;
    sealed = seal;
    bufferWritten=false;
    if(seal) {
        if (null!=buffer) {
            buffer.flip();
        }
    } else if (null!=buffer) {
        buffer.position(buffer.limit());
        buffer.limit(buffer.capacity());
    }
  }


  public void rewind() {
    if(buffer!=null) {
        buffer.rewind();
    }
  }

  public void padding(int doneInByteSize) {
    if ( buffer==null || sealed ) return;
    while(doneInByteSize<strideB) {
        Buffers.putb(buffer, (byte)0);
        doneInByteSize++;
    }
  }

  /**
   * Generic buffer relative put method.
   *
   * This class buffer Class must match the arguments buffer class.
   * The arguments remaining elements must be a multiple of this arrays element stride.
   */
  public void put(Buffer v) {
    if ( sealed ) return;
    /** FIXME: isn't true for interleaved arrays !
    if(0!=(v.remaining() % strideL)) {
        throw new GLException("Buffer length ("+v.remaining()+") is not a multiple of component-stride:\n\t"+this);
    } */
    growBufferIfNecessary(v.remaining());
    Buffers.put(buffer, v);
  }

  public void putb(byte v) {
    if ( sealed ) return;
    growBufferIfNecessary(1);
    Buffers.putb(buffer, v);
  }

  public void puts(short v) {
    if ( sealed ) return;
    growBufferIfNecessary(1);
    Buffers.puts(buffer, v);
  }

  public void puti(int v) {
    if ( sealed ) return;
    growBufferIfNecessary(1);
    Buffers.puti(buffer, v);
  }

  public void putx(int v) {
    puti(v);
  }

  public void putf(float v) {
    if ( sealed ) return;
    growBufferIfNecessary(1);
    Buffers.putf(buffer, v);
  }

  public String toString() {
    return "GLArrayDataClient["+name+
                       ", index "+index+
                       ", location "+location+
                       ", isVertexAttribute "+isVertexAttribute+
                       ", dataType 0x"+Integer.toHexString(componentType)+ 
                       ", bufferClazz "+componentClazz+ 
                       ", elements "+getElementCount()+
                       ", components "+components+ 
                       ", stride "+strideB+"b "+strideL+"c"+
                       ", initialElementCount "+initialElementCount+ 
                       ", sealed "+sealed+ 
                       ", bufferEnabled "+bufferEnabled+ 
                       ", bufferWritten "+bufferWritten+ 
                       ", buffer "+buffer+
                       ", alive "+alive+
                       "]";
  }

  // non public matters

  protected final boolean growBufferIfNecessary(int spare) {
    if(buffer==null || buffer.remaining()<spare) { 
        growBuffer(Math.max(initialElementCount, spare));
        return true;
    }
    return false;
  }

  protected final void growBuffer(int additionalElements) {     
    if(!alive || sealed) {
       throw new GLException("Invalid state: "+this); 
    }

    // add the stride delta
    additionalElements += (additionalElements/components)*(strideL-components);

    final int osize = (buffer!=null) ? buffer.capacity() : 0;
    final int nsize = osize + ( additionalElements * components );
    
    if(componentClazz==ByteBuffer.class) {
        ByteBuffer newBBuffer = Buffers.newDirectByteBuffer( nsize );
        if(buffer!=null) {
            buffer.flip();
            newBBuffer.put((ByteBuffer)buffer);
        }
        buffer = newBBuffer;
    } else if(componentClazz==ShortBuffer.class) {
        ShortBuffer newSBuffer = Buffers.newDirectShortBuffer( nsize );
        if(buffer!=null) {
            buffer.flip();
            newSBuffer.put((ShortBuffer)buffer);
        }
        buffer = newSBuffer;
    } else if(componentClazz==IntBuffer.class) {
        IntBuffer newIBuffer = Buffers.newDirectIntBuffer( nsize );
        if(buffer!=null) {
            buffer.flip();
            newIBuffer.put((IntBuffer)buffer);
        }
        buffer = newIBuffer;
    } else if(componentClazz==FloatBuffer.class) {
        FloatBuffer newFBuffer = Buffers.newDirectFloatBuffer( nsize );
        if(buffer!=null) {
            buffer.flip();
            newFBuffer.put((FloatBuffer)buffer);
        }
        buffer = newFBuffer;
    } else {
        throw new GLException("Given Buffer Class not supported: "+componentClazz+":\n\t"+this);
    }
    if(DEBUG) {
        System.err.println("*** Grow: comps: "+components+", "+(osize/components)+"/"+osize+" -> "+(nsize/components)+"/"+nsize+", "+this);
    }
  }

  protected final void checkSeal(boolean test) throws GLException {
    if(!alive) {
        throw new GLException("Invalid state: "+this); 
    }    
    if(sealed!=test) {
        if(test) {
            throw new GLException("Not Sealed yet, seal first:\n\t"+this); 
        } else {
            throw new GLException("Already Sealed, can't modify VBO:\n\t"+this); 
        }
    }
  }

  protected void init(String name, int index, int comps, int dataType, boolean normalized, int stride, Buffer data, 
                      int initialElementCount, boolean isVertexAttribute, GLArrayHandler handler,
                      int vboName, long vboOffset, int vboUsage, int vboTarget, boolean usesGLSL)
    throws GLException
  {
    super.init(name, index, comps, dataType, normalized, stride, data, isVertexAttribute,
               vboName, vboOffset, vboUsage, vboTarget);

    this.initialElementCount = initialElementCount;
    this.glArrayHandler = handler;
    this.usesGLSL = usesGLSL;
    this.sealed=false;
    this.bufferEnabled=false;
    this.enableBufferAlways=false;
    this.bufferWritten=false;
    if(null==buffer && initialElementCount>0) {
        growBuffer(initialElementCount);
    }
  }

  private boolean isValidated = false;
  
  protected void init_vbo(GL gl) {
      if(!isValidated ) {
          isValidated = true;
          validate(gl.getGLProfile(), true);
      }      
  }

  protected GLArrayDataClient() { }

  protected boolean sealed;
  protected boolean bufferEnabled;
  protected boolean bufferWritten;
  protected boolean enableBufferAlways;

  protected int initialElementCount;

  protected GLArrayHandler glArrayHandler;
  protected boolean usesGLSL;
}

