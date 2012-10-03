package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;

import com.jogamp.newt.event.*;
import com.jogamp.newt.opengl.*;
import com.jogamp.opengl.util.Animator;

public class Controller extends Zero implements Runnable {

	View view;
	static Thread self;
	static GLWindow window;
	static Animator animator;
	
	public static Controller init() {
		return new Controller();
	}
	
	public void running() {
		//general code thread
	}
	
	public static void main(String[] args) {
		GLProfile glp = GLProfile.get(GLProfile.GL2ES2);
        GLCapabilities caps = new GLCapabilities(glp);

        window = GLWindow.create(caps);
        window.setSize(300, 300);
        window.setVisible(true);
        window.setTitle(Thread.currentThread().getName());
        window.setUndecorated(false);
        window.setPointerVisible(true);
        
        animator = new Animator(window);
        animator.add(window);
        animator.start();
        self = new Thread(init());
        self.start();
        
        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
            	animator.stop();
                self = null;
            };
        });
	}
	
	public void run() {
		view = new View(new Model());
		window.addGLEventListener(view);
		while(self != null) {
			running();
			Thread.yield();
		}
		window.removeGLEventListener(view);
		window.setVisible(false);
		System.exit(0);
	}
}