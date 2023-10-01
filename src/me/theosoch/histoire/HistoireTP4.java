package me.theosoch.histoire;

import me.theosoch.personnages.Commercant;
import me.theosoch.personnages.Humain;
import me.theosoch.personnages.Ronin;
import me.theosoch.personnages.Yakuza;

//

public class HistoireTP4 {

	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		
		prof.boire();
		
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		
		Commercant marco = new Commercant("Marco", 20);
		
		marco.direBonjour();
		
		marco.setFaireExtorquer();
		marco.recevoir(15);
		
		marco.boire();
		
		Yakuza yakulenoir = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong", 0);
		
		yakulenoir.direBonjour();
		
		yakulenoir.extorquer(marco);
		
		Ronin roro = new Ronin("Roro", "shochu", 60, 1);
		
		roro.direBonjour();
		
		roro.donner(marco);
		
		roro.provoquer(yakulenoir);
	}
	
}
