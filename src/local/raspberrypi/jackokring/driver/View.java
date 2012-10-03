package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;

import com.jogamp.common.nio.Buffers;

import java.nio.*;

public class View extends Zero implements GLEventListener {
	
	Model model;
	static GL2ES2 gl;//main context
	
	public View(Model m) {
		model = m;
	}
	
	//fix these TODO
    private double t0 = System.currentTimeMillis();
    private double theta;
    private double s;

    //main shader shares
    private static int shaderProgram;
    private static int vertShader;
    private static int fragShader;
    static int MVPM_location;
    
    public void MVPDo() {
	 	// Update variables used in animation
	    double t1 = System.currentTimeMillis();
	    theta += (t1-t0)*0.005f;
	    t0 = t1;
	    s = Math.sin(theta);
	
	    float[] model_view_projection;
	    float[] identity_matrix = {
	        1.0f, 0.0f, 0.0f, 0.0f,
	        0.0f, 1.0f, 0.0f, 0.0f,
	        0.0f, 0.0f, 1.0f, 0.0f,
	        0.0f, 0.0f, 0.0f, 1.0f,
	    };
	    model_view_projection =  translate(identity_matrix,0.0f,0.0f, -0.1f);
	    model_view_projection =  rotate(model_view_projection,(float)30f*(float)s,1.0f,0.0f,1.0f);
	
	    // Send the final projection matrix to the vertex shader by
	    // using the uniform location id obtained during the init part.
	    gl.glUniformMatrix4fv(MVPM_location, 1, false, model_view_projection, 0);
    }

    public void init(GLAutoDrawable drawable) {
    	if(gl != null) return;
        gl = drawable.getGL().getGL2ES2();

        System.out.println("Chosen GLCapabilities: " + drawable.getChosenGLCapabilities());
        System.out.println("INIT GL IS: " + gl.getClass().getName());
        System.out.println("GL_VENDOR: " + gl.glGetString(GL.GL_VENDOR));
        System.out.println("GL_RENDERER: " + gl.glGetString(GL.GL_RENDERER));
        System.out.println("GL_VERSION: " + gl.glGetString(GL.GL_VERSION));

        //Create shaders
        //OpenGL ES returns a index id to be stored for future reference.
        vertShader = gl.glCreateShader(GL2ES2.GL_VERTEX_SHADER);
        fragShader = gl.glCreateShader(GL2ES2.GL_FRAGMENT_SHADER);

        compile(vertexShader, vertShader);
        compile(fragmentShader, fragShader);

        //Each shaderProgram must have
        //one vertex shader and one fragment shader.
        shaderProgram = gl.glCreateProgram();
        gl.glAttachShader(shaderProgram, vertShader);
        gl.glAttachShader(shaderProgram, fragShader);

        //Associate attribute ids with the attribute names inside
        //the vertex shader.
        gl.glBindAttribLocation(shaderProgram, 0, "attribute_Position");
        gl.glBindAttribLocation(shaderProgram, 1, "attribute_Color");

        gl.glLinkProgram(shaderProgram);

        //Get a id number to the uniform_Projection matrix
        //so that we can update it.
        MVPM_location = gl.glGetUniformLocation(shaderProgram, "uniform_Projection");
        
        // Use the shaderProgram that got linked during the init part.
        gl.glUseProgram(shaderProgram);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) { }

    public void display(GLAutoDrawable drawable) {
        
        gl.glClear(GL2ES2.GL_STENCIL_BUFFER_BIT |
                GL2ES2.GL_COLOR_BUFFER_BIT   |
                GL2ES2.GL_DEPTH_BUFFER_BIT   );
        MVPDo();
        float[] vertices = {  0.0f,  1.0f, 0.0f, //Top
                             -1.0f, -1.0f, 0.0f, //Bottom Left
                              1.0f, -1.0f, 0.0f  //Bottom Right
                                              };


        // Observe that the vertex data passed to glVertexAttribPointer must stay valid
        // through the OpenGL rendering lifecycle.
        // Therefore it is mandatory to allocate a NIO Direct buffer that stays pinned in memory
        // and thus can not get moved by the java garbage collector.
        // Also we need to keep a reference to the NIO Direct buffer around up until
        // we call glDisableVertexAttribArray first then will it be safe to garbage collect the memory. 
        // I will here use the com.jogamp.common.nio.Buffers to quickly wrap the array in a Direct NIO buffer.
        FloatBuffer fbVertices = Buffers.newDirectFloatBuffer(vertices);

        gl.glVertexAttribPointer(0, 3, GL2ES2.GL_FLOAT, false, 0, fbVertices);
        gl.glEnableVertexAttribArray(0);

        float[] colors = {    1.0f, 0.0f, 0.0f, 1.0f, //Top color (red)
                              0.0f, 0.0f, 0.0f, 1.0f, //Bottom Left color (black)
                              1.0f, 1.0f, 0.0f, 0.9f  //Bottom Right color (yellow) with 10% transparence
                                                   };
                                             
        FloatBuffer fbColors = Buffers.newDirectFloatBuffer(colors);

        gl.glVertexAttribPointer(1, 4, GL2ES2.GL_FLOAT, false, 0, fbColors);
        gl.glEnableVertexAttribArray(1);
        
        int[] in = { 0, 1, 2 };
        
        IntBuffer ib = Buffers.newDirectIntBuffer(in);
        
        gl.glDrawElements(GL2ES2.GL_TRIANGLES, 3, GL2ES2.GL_UNSIGNED_INT, ib);

        //gl.glDrawArrays(GL2ES2.GL_TRIANGLES, 0, 3); //Draw the vertices as triangle
        
        gl.glDisableVertexAttribArray(0); // Allow release of vertex position memory
        gl.glDisableVertexAttribArray(1); // Allow release of vertex color memory		
        // It is only safe to let the garbage collector collect the vertices and colors 
        // NIO buffers data after first calling glDisableVertexAttribArray.
        fbVertices = null;
        fbColors = null;
    }

    public void dispose(GLAutoDrawable drawable){
    	if(gl == null) return;
        System.out.println("cleanup, remember to release shaders");
        gl.glUseProgram(0);
        gl.glDetachShader(shaderProgram, vertShader);
        gl.glDeleteShader(vertShader);
        gl.glDetachShader(shaderProgram, fragShader);
        gl.glDeleteShader(fragShader);
        gl.glDeleteProgram(shaderProgram);
        gl = null;
    }
    
	static final String vertexShader =
	// For GLSL 1 and 1.1 code i highly recommend to not include a 
	// GLSL ES language #version line, GLSL ES section 3.4
	// Many GPU drivers refuse to compile the shader if #version is different from
	// the drivers internal GLSL version.
	"#ifdef GL_ES \n" +
	"precision mediump float; \n" + // Precision Qualifiers
	"precision mediump int; \n" +   // GLSL ES section 4.5.2
	"#endif \n" +
	
	"uniform mat4    uniform_Projection; \n" + // Incomming data used by
	"attribute vec4  attribute_Position; \n" + // the vertex shader
	"attribute vec4  attribute_Color; \n" +    // uniform and attributes
	
	"varying vec4    varying_Color; \n" + // Outgoing varying data
	                                      // sent to the fragment shader
	"void main(void) \n" +
	"{ \n" +
	"  varying_Color = attribute_Color; \n" +
	"  gl_Position = uniform_Projection * attribute_Position; \n" +
	"} ";
	
	/* Introducing the OpenGL ES 2 Fragment shader
	 *
	 * The main loop of the fragment shader gets executed for each visible
	 * pixel fragment on the render buffer.
	 *
	 *       vertex-> *
	 *      (0,1,-1) /f\
	 *              /ffF\ <- This fragment F gl_FragCoord get interpolated
	 *             /fffff\                   to (0.25,0.25,-1) based on the
	 *   vertex-> *fffffff* <-vertex         three vertex gl_Position.
	 *  (-1,-1,-1)           (1,-1,-1)
	 *
	 *
	 * All incomming "varying" and gl_FragCoord data to the fragment shader
	 * gets interpolated based on the vertex positions.
	 *
	 * The fragment shader produce and store the final color data output into
	 * gl_FragColor.
	 *
	 * Is up to you to set the final colors and calculate lightning here based on
	 * supplied position, color and normal data.
	 *
	 * The whole fragment shader program are a String containing GLSL ES language
	 * http://www.khronos.org/registry/gles/specs/2.0/GLSL_ES_Specification_1.0.17.pdf
	 * sent to the GPU driver for compilation.
	 */
	static final String fragmentShader =
	"#ifdef GL_ES \n" +
	"precision mediump float; \n" +
	"precision mediump int; \n" +
	"#endif \n" +
	
	"varying   vec4    varying_Color; \n" + //incomming varying data to the
	                                        //frament shader
	                                        //sent from the vertex shader
	"void main (void) \n" +
	"{ \n" +
	"  gl_FragColor = varying_Color; \n" +
	"} ";
	
	private void compile(String shader, int id) {
		//Compile the vertexShader String into a program.
	    String[] vlines = new String[] { shader };
	    int[] vlengths = new int[] { vlines[0].length() };
	    gl.glShaderSource(id, vlines.length, vlines, vlengths, 0);
	    gl.glCompileShader(id);
	
	    //Check compile status.
	    int[] compiled = new int[1];
	    gl.glGetShaderiv(id, GL2ES2.GL_COMPILE_STATUS, compiled,0);
	    if(compiled[0]!=0){System.out.println("Horray! Shader "+id+" compiled");}
	    else {
	        int[] logLength = new int[1];
	        gl.glGetShaderiv(id, GL2ES2.GL_INFO_LOG_LENGTH, logLength, 0);
	
	        byte[] log = new byte[logLength[0]];
	        gl.glGetShaderInfoLog(id, logLength[0], (int[])null, 0, log, 0);
	
	        System.err.println("Error compiling shader "+id+": " + new String(log));
	        System.exit(1);
	    }
	}

/* Introducing projection matrix helper functions
 *
 * OpenGL ES 2 vertex projection transformations gets applied inside the
 * vertex shader, all you have to do are to calculate and supply a projection matrix.
 *
 * Its recommended to use the com/jogamp/opengl/util/PMVMatrix.java
 * import com.jogamp.opengl.util.PMVMatrix;
 * To simplify all your projection model view matrix creation needs.
 *
 * These helpers here are based on PMVMatrix code and common linear
 * algebra for matrix multiplication, translate and rotations.
 */
    private void glMultMatrixf(FloatBuffer a, FloatBuffer b, FloatBuffer d) {
        final int aP = a.position();
        final int bP = b.position();
        final int dP = d.position();
        for (int i = 0; i < 4; i++) {
            final float ai0=a.get(aP+i+0*4),  ai1=a.get(aP+i+1*4),  ai2=a.get(aP+i+2*4),  ai3=a.get(aP+i+3*4);
            d.put(dP+i+0*4 , ai0 * b.get(bP+0+0*4) + ai1 * b.get(bP+1+0*4) + ai2 * b.get(bP+2+0*4) + ai3 * b.get(bP+3+0*4) );
            d.put(dP+i+1*4 , ai0 * b.get(bP+0+1*4) + ai1 * b.get(bP+1+1*4) + ai2 * b.get(bP+2+1*4) + ai3 * b.get(bP+3+1*4) );
            d.put(dP+i+2*4 , ai0 * b.get(bP+0+2*4) + ai1 * b.get(bP+1+2*4) + ai2 * b.get(bP+2+2*4) + ai3 * b.get(bP+3+2*4) );
            d.put(dP+i+3*4 , ai0 * b.get(bP+0+3*4) + ai1 * b.get(bP+1+3*4) + ai2 * b.get(bP+2+3*4) + ai3 * b.get(bP+3+3*4) );
        }
    }

    private float[] multiply(float[] a,float[] b){
        float[] tmp = new float[16];
        glMultMatrixf(FloatBuffer.wrap(a),FloatBuffer.wrap(b),FloatBuffer.wrap(tmp));
        return tmp;
    }

    private float[] translate(float[] m,float x,float y,float z){
        float[] t = { 1.0f, 0.0f, 0.0f, 0.0f,
                      0.0f, 1.0f, 0.0f, 0.0f,
                      0.0f, 0.0f, 1.0f, 0.0f,
                      x, y, z, 1.0f };
        return multiply(m, t);
    }

    private float[] rotate(float[] m,float a,float x,float y,float z){
        float s, c;
        s = (float)Math.sin(Math.toRadians(a));
        c = (float)Math.cos(Math.toRadians(a));
        float[] r = {
            x * x * (1.0f - c) + c,     y * x * (1.0f - c) + z * s, x * z * (1.0f - c) - y * s, 0.0f,
            x * y * (1.0f - c) - z * s, y * y * (1.0f - c) + c,     y * z * (1.0f - c) + x * s, 0.0f,
            x * z * (1.0f - c) + y * s, y * z * (1.0f - c) - x * s, z * z * (1.0f - c) + c,     0.0f,
            0.0f, 0.0f, 0.0f, 1.0f };
            return multiply(m, r);
    }
}