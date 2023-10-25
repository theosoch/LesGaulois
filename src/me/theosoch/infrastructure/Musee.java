package me.theosoch.infrastructure;

import me.theosoch.objets.Trophee;
import me.theosoch.personnages.Equipement;
import me.theosoch.personnages.Gaulois;

public class Musee {

	private Trophee[] trophee = new Trophee[200];
	private int nbTrophee = 0;
	
	//
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		if(this.nbTrophee < this.trophee.length) {
			this.trophee[this.nbTrophee] = new Trophee(gaulois, equipement);
			this.nbTrophee++;
		}
		else {
			throw new RuntimeException("Max trophee count reached.");
		}
	}
	
	//
	
	public String extraireInstructionsCaml() {
		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append("let musee = [ ");
		
		for(int i = 0; i < this.nbTrophee; i++) {
			resultBuilder.append("(\"" + this.trophee[i].donnerNom() + "\", \"" + this.trophee[i].getEquipement() + "\")");
			if(i < this.nbTrophee-1) { resultBuilder.append("; "); }
		}
		
		resultBuilder.append(" ] ;;");
		
		return resultBuilder.toString();
	}
	
}
