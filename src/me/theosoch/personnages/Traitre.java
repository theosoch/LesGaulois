package me.theosoch.personnages;

import java.util.Random;

public class Traitre extends Samourai {

	private int niveauTraitrise = 0;
	
	//
	
	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}
	
	public Traitre(String seigneur, String nom, String boissonFavorite, int argent, int force) {
		super(seigneur, nom, boissonFavorite, argent, force);
	}
	
	//	
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mais je suis un traître et mon niveau de traîtrise est : " + this.niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if(this.niveauTraitrise < 3) {
			int rancon = (commercant.getArgent() * 2 / 10);
			
			this.parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + rancon + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + this.getNom() + ".");
			
			this.perdreArgent(rancon);
			this.gagnerArgent(rancon);
			
			this.niveauTraitrise++;
		}
		else this.parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
	}
	
	public void faireLeGentil() {
		if(this.nombreConnaissances() > 0) {
			int don = this.getArgent() / 20;
			
			Humain ami = this.connaissances()[new Random().nextInt(this.nombreConnaissances())];
			
			this.parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + ami.getNom() + ".");
			this.parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			
			this.perdreArgent(don);
			ami.gagnerArgent(don);
			
			this.parler("Merci " + this.getNom() + ". Vous êtes quelqu'un de bien.");
			
			if(this.niveauTraitrise > 1) this.niveauTraitrise--;
		}
		else this.parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
	}
	
}
