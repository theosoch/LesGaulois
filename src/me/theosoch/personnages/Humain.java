package me.theosoch.personnages;

public class Humain {
	
	private static int CONNAISSANCES_MAX = 30;
	
	//	

	private String nom;
	private String boissonFavorite;
	
	private int argent;
	
	private int nbConnaissances = 0;
	private Humain[] connaissances = new Humain[Humain.CONNAISSANCES_MAX];
	
	//
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	//
	
	public String getNom() { return this.nom; }
	
	public int getArgent() { return this.argent; }
	
	public int nombreConnaissances() { return this.nbConnaissances; }
	
	public final Humain[] connaissances() { return this.connaissances; }
	
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
	
	//
	
	public void faireConnaissance(Humain homme2) {
		this.direBonjour();
		homme2.repondre(this);
		this.memoriser(homme2);
	}
	
	public void repondre(Humain h) {
		this.direBonjour();
		this.memoriser(h);
	}
	
	private void memoriser(Humain h) {
//		if(this.nbConnaissances < this.connaissances.length) {
		if(this.nombreConnaissances() == this.connaissances.length) {
			for(int i = 0; i < this.nombreConnaissances()-1; ++i)
				this.connaissances[i] = this.connaissances[i+1];
		}
		
		if(this.nombreConnaissances() < this.connaissances.length) {
			this.connaissances[this.nombreConnaissances()] = h;
			this.nbConnaissances++;
		}
		else this.connaissances[this.nbConnaissances-1] = h;
		
//		}
//		else {
//			throw new RuntimeException("Max connaissances count reached.");
//		}
	}
	
	//
	
	public void listerConnaissances() {
		String texte = "Je connais beaucoup de monde dont :";
		
		for(int i = 0; i < this.nbConnaissances; ++i) {
			texte += "\n - " + this.connaissances[i].getNom();
		}
		
		this.parler(texte);
	}
	
}
