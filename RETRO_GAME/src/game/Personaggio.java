package game;

public class Personaggio {

	/*
	 * INDEX EQUIPAGGIAMENTO 0 = Arma 1 = Armatura 2 = Elmo 3 = Guanti 4 = Stivali
	 *
	 */
	private Object[] equipaggiamento;

	/*
	 * INDEX ATTRIBUTI 0 = Name 1 = HP 2 = Attack 3 = Attack_speed 4 = Defence
	 * 
	 */
	private Object[] attributi;

	Personaggio(String name, Object[] attributi, Object[] equip) {

		this.attributi = attributi;
		this.equipaggiamento = equip;
		this.attributi[0] = name;
		this.attributi[1] = 100;
		System.out.println("Personaggio Generato");
	}

	private boolean updateAttributi(Object o) {
		if (o instanceof Arma) {
			this.attributi[2] = ((Arma) o).getAttack();
			this.attributi[3] = ((Arma) o).getAttackSpeed();
		} else if (o instanceof Armatura) {
			this.attributi[4] = ((Armatura) o).getDefence();
		} else {
			return false;
		}
		return true;
	}

	public boolean addEquip(Object o) {
		if (o instanceof Arma) {
			this.equipaggiamento[0] = o;
			updateAttributi(this.equipaggiamento[0]);
		} else if (o instanceof Armatura) {
			this.equipaggiamento[1] = o;
			updateAttributi(this.equipaggiamento[1]);
		} else {
			System.out.println("Errore: Oggetto non compatibile");
			return false;
		}
		return true;
	}

	public String getNome() {
		return (String) attributi[0];
	}

	public int getHP() {
		return (int) attributi[1];
	}

	public int getAttack() {
		return (int) attributi[2];
	}

	public int getAttackSpd() {
		return (int) attributi[3];
	}

	public int getDefence() {
		return (int) attributi[4];
	}

	public String getStat() {
		return "Nome = " + this.attributi[0] + "\nHP = " + this.attributi[1] + "\nAttack=" + this.attributi[2]
				+ "\nAttack_speed = " + this.attributi[3] + "\nDefence = " + this.attributi[4] + "\n";
	}

	public Arma getArma() {
		try {
			return (Arma) this.equipaggiamento[0];
		} catch (ClassCastException e){
			return null;
		}
	}

	public Armatura getArmatura() {
		try {
			return (Armatura) this.equipaggiamento[1];
		} catch (ClassCastException e){
			return null;
		}
	}

	public String getEquip() {
		String arma, armatura;
		if (this.equipaggiamento[0] == null) {
			arma = "null";
		} else {
			arma = this.equipaggiamento[0].toString();
		}

		if (this.equipaggiamento[1] == null) {
			armatura = "null";
		} else {
			armatura = this.equipaggiamento[1].toString();
		}
		return "Arma = " + arma + "\nArmatura = " + armatura + "\n";
	}

}
