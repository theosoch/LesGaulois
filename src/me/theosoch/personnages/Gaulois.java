package me.theosoch.personnages;

import me.theosoch.personnages.bases.Combattant;

//

public class Gaulois extends Combattant {
	
	public static void main(String[] args) {
		Gaulois g = new Gaulois("Astérix", 8);
		Romain r = new Romain("César", 6);
		
		assert g.prendreParole() == "Le gaulois " + g.getNom() + " : ";
		
		String text = "test";
		g.parler(text);
		
		g.frapper(r);
		
		Romain r2 = new Romain("César", 6);
		g.boirePotion(3);
		g.frapper(r2);
	}
	
	//	

	protected int effetPotion = 1;
	
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
		
		romain.recevoirCoup((this.force / 3) * this.effetPotion);
	}
	
	//
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + this.getNom() + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	//	
	
	public void boirePotion(int force) {
		this.effetPotion = force;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}
	
}
