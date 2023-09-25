package me.theosoch.personnages;

import me.theosoch.personnages.bases.Combattant;

public class Romain extends Combattant {
	
	public static void main(String[] args) {
		Gaulois g = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		
		assert minus.prendreParole().equals("Le romain " + minus.getNom() + " : ");
		
		String text = "test";
		minus.parler(text);
		
		minus.recevoirCoup(8/3);
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
		assert this.force >= 0;
		int tmp = this.force;
		
		this.force -= forceCoup;
		
		if (this.force > 0) { parler("Aie"); }
		else { parler("J'abandonne..."); }
		
		assert this.force < tmp;
	}
	
}
