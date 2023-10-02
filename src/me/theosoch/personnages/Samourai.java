package me.theosoch.personnages;

public class Samourai extends Ronin {
	
	private String seigneur;
	
	//	
	
	public Samourai(String seigneur, String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
		init(seigneur);
	}
	
	public Samourai(String seigneur, String nom, String boissonFavorite, int argent, int force) {
		super(nom, boissonFavorite, argent, force);
		init(seigneur);
	}
	
	//
	
	private void init(String seigneur) {
		this.seigneur = seigneur;
	}

	//
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Je suis fier de servir le seigneur " + this.seigneur + ".");
	}

	public void boire(String boisson) {
		this.parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre " + boisson + ".");
	}
	
}
