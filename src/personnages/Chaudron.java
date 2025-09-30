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
	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		forcePotion = forcePotion;
	}
	
	public void prendreLouche() {
		while (quantitePotion > 0) {
			quantitePotion -= 1;
		}
		forcePotion = 0;
	}
	
	}
	
}
