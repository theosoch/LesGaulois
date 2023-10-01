package me.theosoch.personnages;

public class Humain {

	private String nom;
	private String boissonFavorite;
	
	private int argent;
	
	//
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	//
	
	public String getNom() { return this.nom; }
	
	public int getArgent() { return this.argent; }
	
	//
	
	protected void parler(String texte) {
//		System.out.println("Humain " + this.getNom() + " parle : � " + texte + " �");
		System.out.println("(" + this.getNom() + ") - " + texte);
	}
	
	//	
	
	public void direBonjour() {
		this.parler("Bonjour ! Je m'appelle " + this.getNom() + " et j'aime boire du " + this.boissonFavorite + ".");
	}
	
	public void boire() {
		this.parler("Mmmm, un bon verre de " + this.boissonFavorite + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
//		this.parler("Wow, ce bien \"" + bien + "\" est incroyable ! En plus j'ai " + this.getArgent() + "€ sur moi !\n*Le vendeur* : " + prix + "€.\nCOMBIEN ?!! *achète quand même...* (voleur...)");
		if(this.getArgent() >= prix)
			this.parler("J'ai " + this.getArgent() + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
		else
			this.parler("Je n'ai que " + this.getArgent() + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		this.perdreArgent(prix);
	}
	
	public void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	public void perdreArgent(int perdre) {
		this.argent -= perdre;
	}
	
}
