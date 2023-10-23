package me.theosoch.personnages;

import me.theosoch.infrastructure.Musee;
import me.theosoch.personnages.bases.Combattant;

//

public class Gaulois extends Combattant {
	
	public static void main(String[] args) {
		Gaulois g = new Gaulois("Astérix", 8);
		Romain r = new Romain("César", 6);
		
		assert g.prendreParole().equals("Le gaulois " + g.getNom() + " : ");
		
		String text = "test";
		g.parler(text);
		
		g.frapper(r);
		
		Romain r2 = new Romain("César", 6);
		g.boirePotion(3);
		g.frapper(r2);
	}
	
	//	

	protected int effetPotion = 1;
	
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	//
	
	public Gaulois(String nom, int force) {
		super(nom, force);
	}
	
	//
	
//	@Override
//	protected String prendreParole() {
//		return "Le gaulois " + this.getNom() + " : ";
//	}
	
//	private String prendreParole() {
	protected String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(this.getNom() + " envoie un grand coup dans la machoire de " + romain.getNom());
//		
//		romain.recevoirCoup((this.force / 3) * this.effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans lamâchoire de " + romain.getNom());
		
		Equipement[] returnedTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		
		for (int i = 0; i < returnedTrophees.length && returnedTrophees[i] != null; i++, nbTrophees++)
			this.trophees[nbTrophees] = returnedTrophees[i];
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
	
	//	
	
	public void faireUneDonation(Musee musee) {
		if(this.nbTrophees > 0) {
			String texte = "Je donne au musée tous mes trophées :";
			
			for(int i = 0; i < this.nbTrophees; ++i) {
				texte += "\n - " + this.trophees[i];
				musee.donnerTrophee(this, this.trophees[i]);
			}
			
			this.parler(texte);
		}
		else {
			this.parler("Je n'ai aucun trophée à donner.");
		}
	}
	
	//
	
	
	
}
