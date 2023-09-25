package me.theosoch.personnages;

import me.theosoch.personnages.bases.Combattant;

//

public class Gaulois extends Combattant {

	protected int effetPotion = 0;
	
	//
	
	public Gaulois(String nom, int force) {
		super(nom, force);
	}
	
	//
	
	@Override
	protected String prendreParole() {
		return "Le gaulois " + this.getNom() + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(this.getNom() + " envoie un grand coup dans la machoire de " + romain.getNom());
		
		romain.recevoirCoup(this.force / 3);
	}
	
}
