package personnages;

public class Romain {
	private String nom;
	private int force;

	private boolean isInvariantVerified(int force) {
		if (force < 0) {
			return false;
		} else {
			return true;
		}
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " :";
	}

	public void recevoirCoup(int forceCoup) {
		assert isInvariantVerified(forceCoup);
		int forceinit = force;
		force -= forceCoup;
		assert force <= forceinit;
		if (force < 1) {
			force = 0;
			parler("J'abandonne!");
		} else {
			parler("Aie");
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}

}
