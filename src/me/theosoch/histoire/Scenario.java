package me.theosoch.histoire;

import me.theosoch.personnages.Druide;
import me.theosoch.personnages.Gaulois;
import me.theosoch.personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		
		Romain minus = new Romain("Minus", 6);
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");

		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}
	
}
