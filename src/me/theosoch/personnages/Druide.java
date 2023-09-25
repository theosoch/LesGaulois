package me.theosoch.personnages;

import me.theosoch.personnages.bases.Personnage;

//

public class Druide extends Personnage {
	
	private int effetPotionMin;
	private int effetPotionMax;
	
	//
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super(nom);
		
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		
		parler("Bonjour, je suis le druide " + this.getNom() + " et ma potion peut aller d'une force " + this.effetPotionMin + " à " + this.effetPotionMax + ".");
	}
	
	//
	
	@Override
	protected String prendreParole() {
		return "Le druide " + this.getNom() + " : ";
	}
}
