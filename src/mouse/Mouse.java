package mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

public class Mouse extends Robot {
	private Random rand = new Random();
	private NmzThread nmz;
	public Mouse() throws AWTException {
	}

	public void doubleClick() {
		new Thread() {
			boolean exit;
			public void run() {
				mouseClick();
				try {
					Thread.sleep(rand.nextInt(120) + 80);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!exit)
				mouseClick();
			}
			
		}.start();
	}

	public void mouseClick() {
		new Thread() {
			public void run() {
				mousePress(InputEvent.BUTTON1_DOWN_MASK);
				try {
					Thread.sleep(new Random().nextInt(20) + 50);
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
				}
				mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
		}.start();
	}

	public void nmzStart() throws InterruptedException {
		if(nmz == null) {
			nmz = new NmzThread();
			nmz.start();
		}
		
	}
	
	public void nmzStop() {
		nmz.stopThread();
		nmz = null;
		
	}
	
	private class NmzThread extends Thread {
		private volatile boolean exit = false;
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(!exit) {
				doubleClick();
				
				try {
					Thread.sleep(rand.nextInt(50000) + 5000);
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}
		}
		
		public void stopThread() {
			exit = true;
			interrupt();
		}
		
		
	}

}
