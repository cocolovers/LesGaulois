package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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

	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2: {
			
			System.out.println("Le soldat " + nom + " est deja bien protege!");
		}
		case 1: {
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possede deja un " + this.equipements[0] + "!");
				}
			else {
				addEquip(equipement,1);
			}
		}
		
		default:
			addEquip(equipement, 0);
		}
	}

	private void addEquip(Equipement equipement, int nb) {
		this.equipements[nb] = equipement;
		nbEquipement++;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}

}
