package me.theosoch.personnages;

public class Ronin extends Humain {

	private int honneur = 1;
	
	//
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}

	//	

	public int getHonneur() { return this.honneur; }
	
	//	
	
	public void donner(Commercant beneficiaire) {
		int don = this.getArgent() / 10;
		this.parler(beneficiaire.getNom() + ", prends ces " + don + " sous.");
		beneficiaire.recevoir(don);
	}
	
}
