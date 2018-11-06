package game;

import java.util.Random;

public class DropGenerator {
	
	private Random r = new Random();
	private int min = 0;
	private int max = 10000;
	
	public Object getDrop() {
		
		int dpr = r.nextInt(((max - min) + 1)+min);
		Object a;
		int rarity = 0; // 6000
		
		if(dpr >= 6000 && dpr <= 7999) {	// 2000
			rarity = 1;
		} else if(dpr >=8000 && dpr <=9499) { // 1500
			rarity = 2;
		} else if(dpr >= 9500 && dpr <= 9989) { // 490
			rarity = 3;
		} else if(dpr >= 9990 && dpr <= 10000){ // 1
			rarity = 4;
		}
		
		if(dpr % 2 == 0) {
			a = new Arma("Arma_prova",rarity,-1,-1);
		} else {
			a = new Armatura("Armatura_prova",rarity,-1);
		}
		System.out.println("Rarità Generata: "+String.valueOf(rarity)+"\n");
		return a;
	}
}
