package se.rende.gyro.gamecontrol;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Driver for getting change events from a Saitek PP22.
 * On ubuntu 11.04, install driver with:</p>
 * <p>sudo apt-get install joystick</p>
 * <p>then calibrate with:</p>
 * <p>sudo jscal -c /dev(input/js0</p>
 * 
 * Usage example:
 * <pre>
 * GameControlDriver gcd = new GameControlDriver("/dev(input/js0");
 * gcd.addGameEventListener(new GameControlDriver.GameEventListener() {
 * 			@Override
 * 			public void gameEventReceived(long time, int type, int channel, int value) {
 * 				System.out.println("time=" + time + " type=" + type + " channel=" + channel + " value=" + value);
 * 			}
 * });
 * </pre>
 * 
 * @author dag
 *
 */
public class GameControlDriver {
	protected static final int TYPE_BUTTON = 1;
	protected static final int TYPE_JOYSTICK = 2;
	private List<GameEventListener> listeners = new ArrayList<GameControlDriver.GameEventListener>();
	private Thread thread;

	/**
	 * 
	 * @param devicePath path to gamecontrol port device file. Example: "/dev/input/js0"
	 * @throws FileNotFoundException
	 */
	public GameControlDriver(String devicePath) throws FileNotFoundException {
		final FileInputStream is = new FileInputStream(devicePath);
		thread = new Thread("GameControlReader") {
			@Override
			public void run() {
				byte[] buf = new byte[8];
					try {
						while (true) {
							int n = is.read(buf, 0, 8);
							if (n == 8) {
								long time = buf[3] << 24
										| (buf[2] & 0xff) << 16
										| (buf[1] & 0xff) << 8 | (buf[0] & 0xff);
								int value = buf[5] << 8 | (buf[4] & 0xff);
								int type = buf[6] & 0xff;
								int channel = buf[7] & 0xff;
								for (GameEventListener listener : listeners) {
									listener.gameEventReceived(time, type, channel,
											value);
								}
							} else {
								System.err
										.println("only " + n + " of 8 bytes read");
							}
						}
					} catch (IOException e) {
						e.printStackTrace(System.err);
					}
			}
		};
		thread.start();
	}

	public void addGameEventListener(GameEventListener listener) {
		listeners.add(listener);
	}

	public void removeGameEventListener(GameEventListener listener) {
		listeners.remove(listener);
	}

	public interface GameEventListener {
		void gameEventReceived(long time, int type, int part, int value);
	}
}
