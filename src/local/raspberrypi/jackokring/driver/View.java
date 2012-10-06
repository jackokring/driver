package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.PMVMatrix;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.IOException;
import java.nio.*;

public class View extends Zero implements GLEventListener {
	
	public float[] vertex = {	0.0f,  1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f,//Top
            					-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,//Bottom Left
            					1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.9f, 0.0f  //Bottom Right
    							};
	
	FloatBuffer fbVertices = Buffers.newDirectFloatBuffer(vertex);
	
    public int[] order = { 0, 1, 2 };
    
    IntBuffer ib = Buffers.newDirectIntBuffer(order);
	
	Model model;
	static GL2ES2 gl;//main context
	
	public View(Model m) {
		model = m;
	}
	
	static Texture tex;
	
	/* static {
	    try {
	        System.out.println("Loading texture...");
	        tex = TextureIO.newTexture(arg0, arg1, arg2);
	        System.out.println("Texture estimated memory size = " + tex.getEstimatedMemorySize());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	} */
	
	//fix these TODO
    private double t0 = System.currentTimeMillis();
    private double theta;
    private double s;

    //main shader shares
    public static PMVMatrix mvp = new PMVMatrix();
    private static int shaderProgram;
    private static int vertShader;
    private static int fragShader;
    static int MVPM_location;
    
    public void transRot() {
    	mvp.glTranslatef(0.0f, 10f, -10f);
	    mvp.glRotatef((float)3f*(float)s,1.0f,0.0f,2.0f);
    }
    
    void rotTrans() {
    	//restore centric viewing context
    }
    
    void MVPDo() {
	 	// Update variables used in animation
	    double t1 = System.currentTimeMillis();
	    theta += (t1-t0)*0.005f;
	    t0 = t1;
	    s = Math.sin(theta);
	    
	    mvp.glPopMatrix();
	    mvp.glPushMatrix();
	    rotTrans();
	    transRot();
	    gl.glUniformMatrix4fv(MVPM_location, 1, false, mvp.glGetMatrixf());
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

        /*
        tex.enable(gl);
        tex.bind(gl);//TODO
        */

        gl.glLinkProgram(shaderProgram);

        //Get a id number to the uniform_Projection matrix
        //so that we can update it.
        MVPM_location = gl.glGetUniformLocation(shaderProgram, "uniform_Projection");
        
        // Use the shaderProgram that got linked during the init part.
        gl.glUseProgram(shaderProgram);
        
        fbVertices.position(0);
        gl.glVertexAttribPointer(0, 3, GL2ES2.GL_FLOAT, false, 8 * 4, fbVertices);
        gl.glEnableVertexAttribArray(0);

        fbVertices.position(3);
        gl.glVertexAttribPointer(1, 4, GL2ES2.GL_FLOAT, false, 8 * 4, fbVertices);
        gl.glEnableVertexAttribArray(1);
        
        mvp.glLoadIdentity();
	    mvp.glFrustumf(-1, 1, -1, 1, 0.1f, 100);
	    mvp.glPushMatrix();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) { }

    public void display(GLAutoDrawable drawable) {
        
        gl.glClear(GL2ES2.GL_STENCIL_BUFFER_BIT |
                GL2ES2.GL_COLOR_BUFFER_BIT   |
                GL2ES2.GL_DEPTH_BUFFER_BIT   );
        MVPDo();
        
        gl.glDrawElements(GL2ES2.GL_TRIANGLES, 3, GL2ES2.GL_UNSIGNED_INT, ib);		
    }

    public void dispose(GLAutoDrawable drawable){
    	if(gl == null) return;
        System.out.println("cleanup, release shaders");
        gl.glDisableVertexAttribArray(0); // Allow release of vertex position memory
        gl.glDisableVertexAttribArray(1); // Allow release of vertex colour memory
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
}