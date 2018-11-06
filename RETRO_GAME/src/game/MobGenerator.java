package game;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MobGenerator implements Runnable {
	private JPanel p;
	
	
	public MobGenerator(JPanel p) {
		this.p = p;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			JLabel l = new JLabel();
			l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heart_full.png")));
			l.setBounds(200, 200, 30, 30);
			p.add(l);
			MobMover mm = new MobMover(l);
			Thread td = new Thread(mm);
			td.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
