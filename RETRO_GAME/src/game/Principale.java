package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class Principale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblM;
	private static StatPanel sp;
	private static MapPanel mp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sp = new StatPanel(lblM);
		sp.setBounds(0, 0, 194, 698);
		contentPane.add(sp);
		
		mp = new MapPanel();
		mp.setBounds(194, 0, 830, 698);
		Thread td = new Thread(mp);
		td.start();
		contentPane.add(mp);
		
		lblM = new JLabel("SEI MORTO");
		lblM.setBounds(383, 328, 69, 50);
		lblM.setVisible(false);
		mp.add(lblM);
		
	}
}
