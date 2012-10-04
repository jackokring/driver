package local.raspberrypi.jackokring.driver;

import javax.media.opengl.*;

import com.jogamp.newt.event.*;
import com.jogamp.newt.opengl.*;
import com.jogamp.opengl.util.Animator;

public class Controller extends Zero implements Runnable {

	View view;
	static Controller self;
	static GLWindow window;
	static Animator animator;
	
	public Controller(View v) {
		view = v;
	}

	public void keys(int keyCode) {
		//general code thread
		switch(keyCode) {
		case KeyEvent.VK_ESCAPE :
			WindowListener[] wl = window.getWindowListeners(); 
			for(int i = 0; i < wl.length; i++)
				wl[i].windowDestroyNotify(null);//hook
			break;
		case KeyEvent.VK_UP :
			break;
		case KeyEvent.VK_DOWN :
			break;
		case KeyEvent.VK_LEFT :
			break;
		case KeyEvent.VK_RIGHT :
			break;
		case KeyEvent.VK_Z : //JB1
			break;
		case KeyEvent.VK_X : //JB2
			break;
		case KeyEvent.VK_A : //JB3
			break;
		case KeyEvent.VK_S : //JB4
			break;
		case KeyEvent.VK_SPACE : //JB5
			break;
		case KeyEvent.VK_ENTER : //JB6
			break;
			default : break;
		}
	}
	
	public static void init() {
		//grand design
		self = new Controller(new View(new Model()));
	}
	
	public static void main(String[] args) {
		GLProfile glp = GLProfile.get(GLProfile.GL2ES2);
        GLCapabilities caps = new GLCapabilities(glp);

        window = GLWindow.create(caps);
        window.setUndecorated(true);
        window.setFullscreen(true);
        window.setVisible(true);
        window.setPointerVisible(true);
        
        animator = new Animator(window);
        animator.add(window);
        animator.start();
        init();//set self and view
        window.addGLEventListener(self.view);
		new Thread(self).start();
        
        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
            	animator.stop();
            	window.setVisible(false);
                self = null;
            };
        });
        window.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				if(self != null) self.keys(arg0.getKeyCode());
			}
        });
	}
	
	public void run() {
		while(self == this) {
			view.model.update();
			Thread.yield();
		}
		window.removeGLEventListener(view);
		if(self == null) System.exit(0);
		window.addGLEventListener(self.view);
		new Thread(self).start();
	}
}