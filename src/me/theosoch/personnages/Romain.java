package me.theosoch.personnages;

import me.theosoch.personnages.bases.Combattant;

public class Romain extends Combattant {
	
	public static void main(String[] args) {
		Gaulois g = new Gaulois("Astérix", 8);
		Romain r = new Romain("César", 0);
		
		assert r.prendreParole() == "Le romain " + r.getNom() + " : ";
		
		String text = "test";
		r.parler(text);
		
		r.recevoirCoup(8/3);
	}
	
	//	
	
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
		
		if (force > 0) { parler("Aie"); }
		else { parler("J'abandonne..."); }
	}
	
}
