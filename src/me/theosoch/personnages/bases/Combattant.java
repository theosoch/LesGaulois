package me.theosoch.personnages.bases;

public abstract class Combattant extends Personnage {
	
	protected int force;
	
	//
	
	public Combattant(String nom, int force) {
		super(nom);
		
		assert force >= 0;
		this.force = force;
	}

}
