package me.theosoch.personnages;

import me.theosoch.personnages.bases.Combattant;

public class Romain extends Combattant {
	
	public Romain(String nom, int force) {
		super(nom, force);
	}
	
	//
	
	@Override
	protected String prendreParole() {
		return "Le romain " + this.getNom() + " : ";
	}
	
	//	
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		
		if (force > 0) { parler("Aïe"); }
		else { parler("J'abandonne..."); }
	}
	
}
