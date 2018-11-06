package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class MapPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x = 0, y = 0;
	private int base_x = 35, base_y = 35;
	private BufferedImage img;
	private BufferedImage pers_img;
	private String pers_img_name = "/images/right_2.png";
	private String imgFileName = "/images/mapback.jpg";
	private boolean A = false, W = false, D = false, S = false;
	private int DELAY = 1;

	/**
	 * Create the panel.
	 */
	
	// COSTRUTTORE
	public MapPanel() {
		setLayout(null);
		loadImages();
		
		AbstractAction leftAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                A = true;
            }
        };
		AbstractAction rightAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                D = true;
            }
        };
        
		AbstractAction upAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                W = true;
            }
        };
		AbstractAction downAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                S = true;
            }
        };
        
		AbstractAction leftrelAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                A = false;
            }
        };
        
		AbstractAction rigrelAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                D = false;
            }
        };
        
		AbstractAction uprelAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                W = false;
            }
        };
        
		AbstractAction downrelAction = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                S = false;
            }
        };
        
        // SETTAGGIO PULSANTI IN PRESSED
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke("A"), leftAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke("D"), rightAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke("S"), downAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke("W"), upAction);

        // SETTAGGIO PULSANTI IN RELEASED
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left.released", KeyStroke.getKeyStroke("released A"), leftrelAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right.released", KeyStroke.getKeyStroke("released D"), rigrelAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down.released", KeyStroke.getKeyStroke("released S"), downrelAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up.released", KeyStroke.getKeyStroke("released W"), uprelAction);
		
	}
	
	
	// FUNZIONAMENTO PER IL SETTAGGIO DEI PULSANTI
    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, javax.swing.Action action) {
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }
	
    // FUNZIONE PER IL CARICARAMENTO DELLE IMMAGINI BASE
    private void loadImages() {
    	java.net.URL url = getClass().getResource(imgFileName);
		java.net.URL url2 = getClass().getResource(pers_img_name);
		if (url == null) {
			System.err.println("Couldn't find file: " + imgFileName);
		} else {
			try {
				img = ImageIO.read(url);
				pers_img = ImageIO.read(url2);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }

    // FUNZIONE PER IL DISEGNO DEI VARI COMPONENTI
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pers_img, base_x, base_y, this);
		
		while (x < 830) {
			g.drawImage(img, x, y, this);
			g.drawImage(img, x, 666, this);
			x += 32;
		}
		y = 32;
		while (y < (830 - 32)) {
			g.drawImage(img, 0, y, this);
			g.drawImage(img, 800, y, this);
			y += 32;
		}

		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(A && W) { // DIAGONALE LEFT-UP
				if(base_x > 35) {
					base_x -= 1;
				} 
				if(base_y > 35) {
					base_y -= 1;
				}
			} else if(A && S) { // DIAGONALE LEFT-DOWN
				if(base_x > 35) {
					base_x -= 1;
				}
				if(base_y < 632) {
					base_y += 1;
				}
			} else if(D && W) { // DIAGONALE RIGHT-UP
				if(base_x < 772) {
					base_x += 1;
				}
				if(base_y > 35) {
					base_y -= 1;
				}
			} else if(D && S) { // DIAGONALE RIGHT-DOWN
				if(base_x < 772) {
					base_x += 1;
				}
				if(base_y < 632) {
					base_y += 1;
				}
			} else if(A) {	// LEFT
				if(base_x > 35) {
					base_x -= 1;
				}
			} else if(D) { // RIGHT
				if(base_x < 772) {
					base_x += 1;
				}
			} else if(W) { // UP
				if(base_y > 35) {
					base_y -= 1;
				}
			} else if(S) { // DOWN
				if(base_y <632) {
					base_y += 1;
				}
			}
			
			// RIDISEGNA LO SPRITE DEL PERSONAGGIO
			repaint();
			System.out.println("A="+String.valueOf(A)+".D="+String.valueOf(D)+".W="+String.valueOf(W)+".S="+String.valueOf(S));
			
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
