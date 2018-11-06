package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StateFrame frame = new StateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void setLabelArma(JLabel l1, JLabel l2, JLabel l3, JLabel l4 , Arma o) {
		if (o != null) {
			l1.setText(o.getNome());
			l2.setText(o.getRarity());
			l3.setText(String.valueOf(o.getAttack()));
			l4.setText(String.valueOf(o.getAttackSpeed()));
		} else {
			l1.setText("null");
			l2.setText("null");
			l3.setText("null");
			l4.setText("null");
		}
	}
	
	private void setLabelArmatura(JLabel l1, JLabel l2, JLabel l3, Armatura o) {
		if (o != null) {
			l1.setText(o.getNome());
			l2.setText(o.getRarity());
			l3.setText(String.valueOf(o.getDefence()));
		} else {
			l1.setText("null");
			l2.setText("null");
			l3.setText("null");
		}
	}
	
	private void setLabelPg(JLabel l1, JLabel l2, JLabel l3, JLabel l4 , JLabel l5, Personaggio p) {
		if( p != null) {
			l1.setText(p.getNome());
			l2.setText(String.valueOf(p.getHP()));
			l3.setText(String.valueOf(p.getAttack()));
			l4.setText(String.valueOf(p.getAttackSpd()));
			l5.setText(String.valueOf(p.getDefence()));
		} else {
			l1.setText("null");
			l2.setText("null");
			l3.setText("null");
			l4.setText("null");
			l5.setText("null");
		}
	}
	
	/**
	 * Create the frame.
	 */
	public StateFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// NON VISUAL
		DropGenerator dp = new DropGenerator();
		Object[] att = {0,0,0,0,0};
		Object[] eqp = {0,0,0,0};
		
		String headers[] = {"TIPO","NOME","RARITA'","ATTACCO","ATT_SPD","DIFESA"};
		Personaggio p = new Personaggio("Marco",att,eqp);
		
		
		/*
		 *  ETICHETTE
		 */
		JLabel lblStatistiche = new JLabel("STATISTICHE");
		lblStatistiche.setBounds(67, 6, 86, 16);
		contentPane.add(lblStatistiche);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(6, 27, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblHp = new JLabel("HP:");
		lblHp.setBounds(6, 55, 27, 16);
		contentPane.add(lblHp);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(6, 83, 61, 16);
		contentPane.add(lblAttack);
		
		JLabel lblAttackspeed = new JLabel("Attack_speed:");
		lblAttackspeed.setBounds(6, 111, 97, 16);
		contentPane.add(lblAttackspeed);
		
		JLabel lblDefence = new JLabel("Defence:");
		lblDefence.setBounds(6, 139, 61, 16);
		contentPane.add(lblDefence);
		
		JLabel lblEquipaggiamento = new JLabel("EQUIPAGGIAMENTO");
		lblEquipaggiamento.setBounds(413, 6, 131, 16);
		contentPane.add(lblEquipaggiamento);
		
		JLabel lblArma = new JLabel("Arma:");
		lblArma.setBounds(286, 27, 61, 16);
		contentPane.add(lblArma);
		
		JLabel lblArmatura = new JLabel("Armatura:");
		lblArmatura.setBounds(286, 139, 80, 16);
		contentPane.add(lblArmatura);
		
		JLabel lblLnome = new JLabel();
		lblLnome.setBounds(138, 27, 136, 16);
		contentPane.add(lblLnome);
		
		JLabel lblLhp = new JLabel();
		lblLhp.setBounds(138, 55, 61, 16);
		contentPane.add(lblLhp);
		
		JLabel lblLattack = new JLabel();
		lblLattack.setBounds(138, 83, 61, 16);
		contentPane.add(lblLattack);
		
		JLabel lblLspeed = new JLabel();
		lblLspeed.setBounds(138, 111, 61, 16);
		contentPane.add(lblLspeed);
		
		JLabel lblLdefence = new JLabel();
		lblLdefence.setBounds(138, 139, 72, 16);
		contentPane.add(lblLdefence);
		
		setLabelPg(lblLnome,lblLhp,lblLattack,lblLspeed,lblLdefence,p);
		
		// LABELS OF ARMA
		JLabel lblLarma = new JLabel();
		lblLarma.setBounds(419, 27, 225, 16);
		contentPane.add(lblLarma);
		
		JLabel lblLatt = new JLabel();
		lblLatt.setBounds(419, 83, 125, 16);
		contentPane.add(lblLatt);
		
		JLabel lblLsp = new JLabel();
		lblLsp.setBounds(419, 111, 131, 16);
		contentPane.add(lblLsp);
		
		JLabel lblRararma = new JLabel();
		lblRararma.setBounds(419, 55, 125, 16);
		contentPane.add(lblRararma);
		
		// SET LABEL ARMA
		setLabelArma(lblLarma,lblRararma,lblLatt,lblLsp,p.getArma());
		
		// LABELS OF ARMATURA
		JLabel lblLarmat = new JLabel();
		lblLarmat.setBounds(419, 139, 225, 16);
		contentPane.add(lblLarmat);
		
		JLabel lblLrararm = new JLabel();
		lblLrararm.setBounds(419, 167, 125, 16);
		contentPane.add(lblLrararm);
		
		JLabel lblLdefe = new JLabel();
		lblLdefe.setBounds(419, 196, 125, 16);
		contentPane.add(lblLdefe);
		
		setLabelArmatura(lblLarmat,lblLrararm,lblLdefe,p.getArmatura());
		
		JLabel lblRarity = new JLabel("Rarity");
		lblRarity.setBounds(329, 55, 61, 16);
		contentPane.add(lblRarity);
		
		JLabel lblAtt = new JLabel("Att");
		lblAtt.setBounds(329, 83, 61, 16);
		contentPane.add(lblAtt);
		
		JLabel lblAttspd = new JLabel("Att_spd");
		lblAttspd.setBounds(329, 111, 61, 16);
		contentPane.add(lblAttspd);
		
		JLabel lblRarity_1 = new JLabel("Rarity");
		lblRarity_1.setBounds(329, 167, 61, 16);
		contentPane.add(lblRarity_1);
		
		JLabel lblDef = new JLabel("Def");
		lblDef.setBounds(329, 196, 61, 16);
		contentPane.add(lblDef);
		
		/*
		 * TABELLA 
		 */
		DefaultTableModel dtb = new DefaultTableModel(0,0);
		dtb.setColumnIdentifiers(headers);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(dtb);
		table.setBounds(527, 227, -520, 145);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 220, 510, 150);
		contentPane.add(sp);
		/*
		 * BOTTONI
		 */
		JButton btnEsci = new JButton("Esci");
		btnEsci.setBounds(527, 343, 117, 29);
		contentPane.add(btnEsci);
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnGenera = new JButton("Genera");
		btnGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = dp.getDrop();
				if(o instanceof Arma) {
					dtb.addRow(new Object[] {"Arma",((Arma) o).getNome(),((Arma) o).getRarity(),((Arma) o).getAttack(),((Arma) o).getAttackSpeed(),"X"});
				} else if(o instanceof Armatura) {
					dtb.addRow(new Object[] {"Armatura",((Armatura) o).getNome(),((Armatura) o).getRarity(),"X","X",((Armatura) o).getDefence()});
				}
				p.addEquip(o);
				setLabelPg(lblLnome,lblLhp,lblLattack,lblLspeed,lblLdefence,p);
				setLabelArma(lblLarma,lblRararma,lblLatt,lblLsp,p.getArma());
				setLabelArmatura(lblLarmat,lblLrararm,lblLdefe,p.getArmatura());
			}
		});
		btnGenera.setBounds(527, 313, 117, 29);
		contentPane.add(btnGenera);
		
		table.addMouseListener(new MouseAdapter(){
		     public void mouseClicked(MouseEvent e){
		         if (e.getClickCount() == 2){
		            System.out.println(" double click" );

		            }
		         }
		        } );
		      

	}
}
