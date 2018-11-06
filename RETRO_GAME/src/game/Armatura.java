package game;
import java.util.Random;

public class Armatura extends Oggetto{
	
	private int defence;
	private Object[] attributi = {null,null,null};
	private Random r = new Random();

	private int min = 0;
	private	int max = 50;
	
	Armatura (String name,int rarity, int defence){
		super(rarity);
		if(defence == -1) {
			this.defence = r.nextInt(((max - min) + 1)+min);
		} else {
			this.defence = defence;
		}
		attributi[0] = name;
		attributi[1] = super.getRarity();
		attributi[2] = this.defence;
	}
	
	public void rollDefence() {
		attributi[2] = r.nextInt(((max - min) + 1)+min);
	}
	
	public String getNome() {
		return (String)attributi[0];
	}
	
	public int getDefence() {
		return (int) attributi[2];
	}
	
	public String toString() {
		return super.toString()+"  Defence = '"+String.valueOf(attributi[2])+"']\n";
	}

}
