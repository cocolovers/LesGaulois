package personnages;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] chef = new Gaulois[1];

	public void setChef(Gaulois gaulois) {
		this.chef[0] = gaulois;
	}


	public Gaulois getChef() {
		return chef[0];
	}


	private Gaulois[] villageois;

	public Village(String nom, int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > nbVillageois || numVillageois < 1) {
			System.out.println("Il n'y a pas d'autant d'habitants dans notre village!");
			return null;
		}
		return villageois[numVillageois - 1];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village " + nom + " du chef " + chef[0] + " vivent les legendaires gaulois: ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irreductibles", 30);
		village.setChef(abraracourcix);
		village.ajouterVillageois(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublePolemix = new Gaulois("DoublePolemix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
