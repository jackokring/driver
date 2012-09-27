package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;
import com.jogamp.newt.event.*;
import com.jogamp.newt.opengl.*;

public class Controller extends Zero implements Runnable {

	View view;
	static Thread self = new Thread();
	static IOMux io;
	static GLWindow window;
	
	public static void main(String[] args) throws InterruptedException {
		io = new IOMux();
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);

        window = GLWindow.create(caps);
        window.setSize(300, 300);
        window.setVisible(true);
        window.setTitle(Thread.currentThread().getName());
        Thread.sleep(5000);

        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
                System.exit(0);
            };
        });
		
	}
	
	public void run() {
		view = new View(new Model());
	}
	
}
