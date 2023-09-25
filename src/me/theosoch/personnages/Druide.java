package me.theosoch.personnages;

import java.util.Random;

import me.theosoch.personnages.bases.Personnage;

//

public class Druide extends Personnage {
	
	private int effetPotionMin;
	private int effetPotionMax;
	
	private int forcePotion = 1;
	
	//
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super(nom);
		
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		
		parler("Bonjour, je suis le druide " + this.getNom() + " et ma potion peut aller d'une force " + this.effetPotionMin + " � " + this.effetPotionMax + ".");
	}
	
	//
	
	@Override
	protected String prendreParole() {
		return "Le druide " + this.getNom() + " : ";
	}
	
	//
	
	public void preparerPotion() {
		Random rand = new Random();
		
		this.forcePotion = effetPotionMin + rand.nextInt(effetPotionMax - effetPotionMin);
		if(this.forcePotion > 7 ) this.parler("J'ai préparé une super potion de force " + this.forcePotion);
		else this.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + this.forcePotion);
	}
	
	//	
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom().equals("Obélix")) this.parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		else gaulois.boirePotion(this.forcePotion);
	}
	
}
