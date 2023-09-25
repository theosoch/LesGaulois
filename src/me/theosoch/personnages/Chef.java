package me.theosoch.personnages;

import me.theosoch.infrastructure.Village;

//

public class Chef extends Gaulois {
	
	private Village village;
	
	//	

	public Chef(String nom, int force, Village village) {
		super(nom, force);
		
		this.effetPotion = 1;
		
		this.village = village;
	}
	
	//
	
	public Village getVillage() { return this.village; }
	
}

