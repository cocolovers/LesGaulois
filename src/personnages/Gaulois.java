package personnages;

import objets.Equipement;
import objets.Musee;
import personnages.Village;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];

	private Village[] village = new Village[1];

	public void setVillage(Village village) {
		this.village[0] = village;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void sePresenter() {
		System.out.print("Le Gaulois " + nom + " :  \"Bonjour, je m'appelle " + nom);
		if (village[0] != null) {
			if (village[0].getChef() == this) {
				System.out.println(". Je suis le chef du village " + village[0].getNom() + ".\"");
			} else {
				System.out.println(". J'habite le village  " + village[0].getNom() + ".\"");
			}
		} else {
			System.out.println(". Je voyage de villages en villages. \"");
		}
	}

	@Override
	public String toString() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);

	}

//	public void frapper(Romain romain) {
//		String nomRomain = romain.getNom();
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + nomRomain);
//		int coup = force * effetPotion;
//		romain.recevoirCoup(coup / 3);
//		if (effetPotion > 1) {
//			effetPotion = effetPotion - 1;
//		} else
//			effetPotion = 1;
//
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0;trophee != null && i < trophee.length  ; i++, nbtrophees++) {
			this.trophees[nbtrophees] = trophee[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void faireUneDonation(Musee musee) {
		if (trophees != null) {
			this.parler(" Je donne au musee tous mes trophees: ");
			for (int i=0; i < trophees.length; i++) {
				musee.donnerTrophee(this, trophees[i]);
				System.out.println(" - " + trophees[i]);
			}
		}
	}
}
