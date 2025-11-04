package objets;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophee = new Trophee[200];
	private int nbTrophee;
	public void donnerTrophee(Gaulois gaulois, Equipement tropheedonne) {
		trophee[nbTrophee] = new Trophee(gaulois, tropheedonne);
		nbTrophee++;
	}
	public String extraireInstructionOcaml() {
		String resultat = "let musee = [ \n";
		for (int i = 0; i<nbTrophee; i++) {
			resultat += "\"" + (trophee[i]).donnerNom() + "\"" + " , " + (trophee[i]).getEquipement() + "\"" + ";\n";
		}
		resultat += "]";
		return resultat;
	}
}
