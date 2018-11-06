package game;

import javax.swing.JLabel;
import java.util.Random;

public class MobMover implements Runnable{
	
	private boolean flag = true;
	private JLabel lab;
	private int x = 200;
	private int y = 200;
	private Random r = new Random();
	private int min = -30;
	private int max = 30;
	
	public MobMover(JLabel lab) {
		this.lab = lab;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {	
			int add = r.nextInt(((max - min) + 1)+min);
			if (add % 2 == 0) {
				x += add;
			} else {
				y += add;
			}
			this.lab.setLocation(x, y);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
