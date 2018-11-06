package game;

public class Oggetto {
	
	private String[] rarity = {"White","Brown","Blue","Gold","Legendary"};
	private int rarity_index;
		
	Oggetto(int rarity_index) {
		this.rarity_index = rarity_index;
	}
	
	public String getRarity() {
		return this.rarity[rarity_index];
	}
	
	public void setRarity( int rarity_index) {
		this.rarity_index = rarity_index;
	}

	@Override
	public String toString() {
		return "[Rarita' = '" + rarity[rarity_index]+"'";
	}

}
