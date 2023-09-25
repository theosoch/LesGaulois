package me.theosoch.personnages.bases;

public abstract class Personnage {

	private String nom;
	
	//	
	
	public Personnage(String nom) {
		this.nom = nom;
	}
	
	//
	
	public String getNom() { return this.nom; }
	
	//	
	
	protected abstract String prendreParole();
	
	public void parler(String text) {
		System.out.println(prendreParole() + "« " + text + " »");
	}
	
}
