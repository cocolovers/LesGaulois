package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public boolean resterPotion() {
		if (quantitePotion > 0) {
			return true;
		}
		return false;
	}

	
	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}


	public void remplirChaudron(int quantite, int forcePotionn) {
		quantitePotion = quantite;
		forcePotion = forcePotionn;
	}

	public int prendreLouche() {
		while (quantitePotion > 0) {
			quantitePotion -= 1;
		}
		return forcePotion;
	}

	public int getForcePotion() {
		return forcePotion;
	}

}
