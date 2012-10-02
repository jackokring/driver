package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;

import com.jogamp.newt.event.*;
import com.jogamp.newt.opengl.*;
import com.jogamp.opengl.util.Animator;

public class Controller extends Zero implements Runnable {

	View view;
	static Thread self;
	static IOMux io;
	static GLWindow window;
	static Animator animator;
	
	public static void main(String[] args) throws InterruptedException {
		io = new IOMux();
		GLProfile glp = GLProfile.get(GLProfile.GL2ES2);
        GLCapabilities caps = new GLCapabilities(glp);
    	// We may at this point tweak the caps and request a translucent drawable
        caps.setBackgroundOpaque(false);

        window = GLWindow.create(caps);
        window.setSize(300, 300);
        window.setVisible(true);
        window.setTitle(Thread.currentThread().getName());
        window.setUndecorated(false);
        window.setPointerVisible(true);

        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
                System.exit(0);
            };
        });
        
        animator = new Animator(window);
        animator.add(window);
        animator.start();
        self = new Thread(init());
        self.start();
	}
	
	public static Controller init() {
		return new Controller();
	}
	
	public void run() {
		view = new View(new Model());
		window.addGLEventListener(view);
	}
}
