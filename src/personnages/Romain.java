package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

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

	public int getForce() {
		return force;
	}

	public Equipement[] getEquipements() {
		return equipements;
	}

	public int getNbEquipement() {
		return nbEquipement;
	}

	public String getTexte() {
		return texte;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " :";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert isInvariantVerified(forceCoup);
//		int forceinit = force;
//		force -= forceCoup;
//		assert force <= forceinit;
//		if (force < 1) {
//			force = 0;
//			parler("J'abandonne!");
//		} else {
//			parler("Aie");
//		}
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");

		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2: {

			System.out.println("Le soldat " + nom + " est deja bien protege!");
			break;
		}
		case 1: {
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possede deja un " + this.equipements[0] + "!");
			} else {
				addEquip(equipement, 1);
			}
			break;
		}

		default:
			addEquip(equipement, 0);
			break;
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
