package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] chef = new Gaulois[1];

	private Gaulois[] villageois;
	public Village (int NB_VILLAGEOIS_MAX) {
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}
	public String getNom() {
		return nom;
	}

	public Gaulois[] getChef() {
		return chef;
	}
	public void ajouterVillageois(Gaulois gaulois) {
		);
	}

}
