package histoire;

import java.util.Random;

import Personnage.Gaulois;
import Personnage.Romain;
import Personnage.Druide;


class Scenario {

	public static void main(String[] args) {
		
		Druide panoramix = new Druide("Panoramix",5,10,1);
		Romain minus = new Romain("Minus",-6);
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Random random1 = new Random();
		panoramix.parler("Je vais aller préparer une petite potion...");
		int forcePotion = panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		asterix.boirePotion(forcePotion);
		asterix.parler("bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		
	}
	
}
