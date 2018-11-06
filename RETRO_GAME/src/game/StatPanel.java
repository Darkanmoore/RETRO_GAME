package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatPanel extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel[] hearts = {null,null,null,null,null,null,null,null,null,null,null};
	private int heart_index = 10;
	private JLabel lblHP, lblPgIcon, lblM;
	/**
	 * Create the panel.
	 */
	public StatPanel(JLabel labelMorte) {
		
		this.lblM = labelMorte;
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		
		setLayout(null);
		setBackground(Color.GRAY);
		setBorder(compound);

		lblPgIcon = new JLabel();
		lblPgIcon.setBounds(18, 10, 158, 158);
		lblPgIcon.setBorder(compound);
		lblPgIcon.setIcon(new ImageIcon(this.getClass().getResource("/images/pg_gif.gif")));
		add(lblPgIcon);
		
		lblHP = new JLabel("HP x");
		lblHP.setFont(new Font("Copperplate", Font.BOLD, 13));
		lblHP.setBounds(18,200,34,16);
		add(lblHP);
		
		generateHeart();
		
		JButton btnRigenera = new JButton("Rigenera");
		btnRigenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(heart_index < 10 && heart_index > 0) {
					heart_index++;
					hearts[heart_index].setVisible(true);
				}
				System.out.println(String.valueOf(heart_index));
			}
		});
		btnRigenera.setBounds(36, 591, 117, 29);
		add(btnRigenera);
		

		JButton btnColpisci = new JButton("Colpisci");
		btnColpisci.setBounds(36, 621, 117, 29);
		add(btnColpisci);
		btnColpisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(heart_index > 0) {
					hearts[heart_index].setVisible(false);
					heart_index--;
					if(heart_index == 0) {
						lblM.setVisible(true);
					}
				}
				System.out.println(String.valueOf(heart_index));
			}
		});
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setBounds(36,651,117,29);
		add(btnEsci);
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	private void generateHeart() {

		hearts[0] = null;
		int x = 55;
		int y = 194;
		for (int i = 1; i < 11; i++) {
			JLabel lblC = new JLabel("");
			lblC.setBounds(x, y, 21, 16);
			add(lblC);
			lblC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/heart_full.png")));
			hearts[i] = lblC;
			x += 25;
			if(i == 5) {
				y += 20;
				x = 55;
			}
		}
	}

}
