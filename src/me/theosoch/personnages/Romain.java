package me.theosoch.personnages;

import me.theosoch.personnages.bases.Combattant;

public class Romain extends Combattant {

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

		assert minus.prendreParole().equals("Le romain " + minus.getNom() + " : ");

		String text = "test";
		minus.parler(text);

		minus.recevoirCoup(8 / 3);

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}

	//

	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];

	//

	public Romain(String nom, int force) {
		super(nom, force);
	}

	//

	@Override
	protected String prendreParole() {
		return "Le romain " + this.getNom() + " : ";
	}

	//

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;

		// précondition
		assert this.force > 0;

		int oldForce = this.force;

		forceCoup = calculResistanceEquipement(forceCoup);
		this.force -= forceCoup;

		if(this.force == 0) { parler("Aïe"); }
		
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");

		// post condition la force a diminuée
		assert this.force < oldForce;

		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;

		int resistanceEquipement = 0;

		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";

			for (int i = 0; i < nbEquipement; i++) {
				if(equipements[i] != null) {
					if(equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else if(equipements[i].equals(Equipement.CASQUE)) {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
			}

			texte += resistanceEquipement + "!";
		}

		parler(texte);

		forceCoup -= resistanceEquipement;
		return forceCoup < 0 ? 0 : forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];

		System.out.println("L'équipement de " + this.getNom() + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for(int i = 0; i < nbEquipement; i++) {
			if(equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}

		return equipementEjecte;
	}

	//

	private void forcerAsEquiper(Equipement equipement) {
		System.out.println("Le soldat " + this.getNom() + " s'équipe avec un " + equipement);
		this.equipements[this.nbEquipement] = equipement;
		this.nbEquipement++;
	}

	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
			case 2:
				System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
				break;
	
			case 1:
				if (equipement == this.equipements[0])
					System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equipement);
				else
					this.forcerAsEquiper(equipement);
				break;
	
			default:
				this.forcerAsEquiper(equipement);
				break;
		}
	}

}
