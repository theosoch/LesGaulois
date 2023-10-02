package me.theosoch.personnages;

public class Yakuza extends Humain {

	private String clan;
	private int reputation;
	
	//
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		this(nom, boissonFavorite, argent, clan, 0);
	}
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan, int reputation) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
		this.reputation = reputation;
	}
	
	//
	
	public String getClan() { return this.clan; }
	
	public int getReputation() { return this.reputation; }
	
	//
	
	public void extorquer(Commercant victime) {
		this.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		this.parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argentExtorque = victime.setFaireExtorquer();
		this.gagnerArgent(argentExtorque);
		this.parler("J’ai piqué les " + argentExtorque + " sous de " + victime.getNom() + ", ce qui me fait " + this.getArgent() + " sous dans ma poche. Hi ! Hi !");
	}
	
	//
	
	public int perdre() {
		int argent = this.getArgent();
		this.perdreArgent(argent);
		this.reputation--;
		
		this.parler("J’ai perdu mon duel et mes " + argent + " sous, snif... J'ai déshonoré le clan de " + this.getClan() + ".");
		
		return this.getReputation();
	}
	
	public void gagner(int gain) {
		this.gagnerArgent(gain);
		this.parler("Ce ronin pensait vraiment battre " + this.getNom() + " du clan de " + this.getClan() + " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
	
	//	
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mon clan est celui de " + this.getClan() + ".");
	}
	
}
