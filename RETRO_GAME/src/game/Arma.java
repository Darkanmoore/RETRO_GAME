package game;
import java.util.Random;

public class Arma extends Oggetto{
	
	private int attack, attack_speed;
	private Object[] attributi = {null,null,null,null};
	
	private Random r = new Random();
	
	private int min = 0;
	private int max = 25;

	
	Arma(String name, int rarity, int attack, int attack_speed){
		super(rarity);
		if(attack == -1 && attack_speed == -1) {
			this.attack = r.nextInt(((max - min) + 1)+min);
			this.attack_speed = r.nextInt(((max - min) + 1)+min);
		} else {
			this.attack = attack;
			this.attack_speed = attack_speed;
		}
		attributi[0] = name;
		attributi[1] = super.getRarity();
		attributi[2] = this.attack;
		attributi[3] = this.attack_speed;
	}
	
	public void rollAttack() {
		attributi[2] = r.nextInt(((max - min) + 1)+min);
	}
	
	public void rollAttackSpeed() {
		attributi[3] = r.nextInt(((max - min) + 1)+min);
	}
	
	public String getNome() {
		if(attributi[0] != null) {
			return (String)attributi[0];
		} else {
			return "null";
		}
	}
	
	public int getAttack() {
		return (int) attributi[2];
	}
	
	public int getAttackSpeed() {
		return (int) attributi[3];
	}
	
	public String toString() {
		return super.toString()+"  Attack = '"+String.valueOf(attributi[2])+"'  Attack_speed = '"+String.valueOf(attributi[3])+"']\n";
	}

}
