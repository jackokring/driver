package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.PMVMatrix;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.*;
import java.nio.*;

public class View extends Zero implements GLEventListener {
	
	static float[] vertex;
	static FloatBuffer fbVertices;
    public static int[][] order = {{ 0, 1, 2 }};
    IntBuffer buff;//pattern
    static IntBuffer[] ib;//all patterns
	
	Model model;
	static GL2ES2 gl;//main context
	static boolean canDraw = false;
	
	static {
		vertex = readAsFloat("local/raspberrypi/jackokring/driver/literals/vertexList");
		attribClose();
		fbVertices = Buffers.newDirectFloatBuffer(vertex);
		ib = new IntBuffer[order.length];
		for(int i = 0; i < order.length; i++)
			ib[i] = Buffers.newDirectIntBuffer(order[i]);
		attribOpen();
	}
	
	public void set(int s) {
		buff = ib[s];
	}
	
	public View(Model m) {
		model = m;
		set(0);
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
    
    static synchronized void attribOpen() {
    	try {
	    	//pos
	    	fbVertices.position(0);
	        gl.glVertexAttribPointer(0, 3, GL2ES2.GL_FLOAT, false, 8 * 4, fbVertices);
	        gl.glEnableVertexAttribArray(0);
	        //color
	        fbVertices.position(3);
	        gl.glVertexAttribPointer(1, 4, GL2ES2.GL_FLOAT, false, 8 * 4, fbVertices);
	        gl.glEnableVertexAttribArray(1);
	        canDraw = true;
    	} catch(Exception e) { 	}
    }
    
    static synchronized void attribClose() {
    	try {
	    	canDraw = false;
	    	gl.glDisableVertexAttribArray(0); // Allow release of vertex position memory
	        gl.glDisableVertexAttribArray(1); // Allow release of vertex colour memory

    	} catch(Exception e) {	}
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
   
        attribOpen();
        
        mvp.glLoadIdentity();
	    mvp.glFrustumf(-1, 1, -1, 1, 0.1f, 100);
	    mvp.glPushMatrix();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) { }

    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL2ES2.GL_STENCIL_BUFFER_BIT |
                GL2ES2.GL_COLOR_BUFFER_BIT   |
                GL2ES2.GL_DEPTH_BUFFER_BIT   );
        
        // Update variables used in animation TODO
	    double t1 = System.currentTimeMillis();
	    theta += (t1-t0)*0.005f;
	    t0 = t1;
	    s = Math.sin(theta);
	    
	    mvp.glPopMatrix();
	    mvp.glPushMatrix();
	    rotTrans();
	    transRot();
	    gl.glUniformMatrix4fv(MVPM_location, 1, false, mvp.glGetMatrixf());
	    
	    synchronized(View.class) {
	    	if(canDraw == false) return;
	    	IntBuffer z = buff;//fixed change overlap atomic
        	gl.glDrawElements(GL2ES2.GL_TRIANGLES, z.limit(), GL2ES2.GL_UNSIGNED_INT, z);
	    }
    }

    public void dispose(GLAutoDrawable drawable){
    	if(gl == null) return;
        System.out.println("cleanup, release shaders");
        attribClose();
        gl.glUseProgram(0);
        gl.glDetachShader(shaderProgram, vertShader);
        gl.glDeleteShader(vertShader);
        gl.glDetachShader(shaderProgram, fragShader);
        gl.glDeleteShader(fragShader);
        gl.glDeleteProgram(shaderProgram);
        gl = null;
    }
    
	static final String vertexShader = readAsString("local/raspberrypi/jackokring/driver/literals/vertex.c");
   
	static final String fragmentShader = readAsString("local/raspberrypi/jackokring/driver/literals/fragment.c");
	
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
	
	private static int lineCount;
	
	public static String readAsString(String name) {
        StringBuilder source = new StringBuilder();
        lineCount = 0;
        BufferedReader reader;
        try{
        	InputStream in = View.class.getClassLoader().getResourceAsStream(name);
            reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String line;
            while((line = reader.readLine()) != null) {
                source.append(line).append('\n');
                lineCount++;
            }
            reader.close();
            in.close();
        } catch(Exception exc) {
        	exc.printStackTrace(System.err);
        }
        
        return source.toString();
    }
	
	public static float[] readAsFloat(String name) {
		String[] in = readAsString(name).split(",");
		float[] fl = new float[lineCount * 8];
		if(fl.length < in.length) System.err.print("Vertex count warning./n");
		for(int i = 0; i < in.length; i++) 
			fl[i] = Float.parseFloat(in[i].trim());
		return fl;
	}
}