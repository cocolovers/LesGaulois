package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import objets.Equipement;

//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller preparer une petite potion...");
		druide.fabriquerPotion(5, 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois asterix = new Gaulois("Asterix", 8);
		druide.booster(obelix);
		obelix.parler("Par Belenos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}