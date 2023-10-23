package me.theosoch.histoire;

import me.theosoch.personnages.Commercant;
import me.theosoch.personnages.GrandMere;
import me.theosoch.personnages.Humain;
import me.theosoch.personnages.Ronin;
import me.theosoch.personnages.Samourai;
import me.theosoch.personnages.Traitre;
import me.theosoch.personnages.Yakuza;

public class HistoireTP5 {

	public static void main(String[] args) {
		Commercant marco = new Commercant("Marco", 20);
		Commercant chonin = new Commercant("Chonin", 40);
		Commercant kumi = new Commercant("Kumi", 10);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		
		marco.faireConnaissance(roro);
		marco.faireConnaissance(yaku);
		marco.faireConnaissance(chonin);
		marco.faireConnaissance(kumi);
		
		marco.listerConnaissances();
		roro.listerConnaissances();
		yaku.listerConnaissances();
		
		//		
		
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
		
		akimoto.repondre(marco);
		marco.direBonjour();
		akimoto.listerConnaissances();
		
		akimoto.boire("du thé");
		
		//		
		
		Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
		
		masako.faireLeGentil();
		
		masako.ranconner(kumi);
		masako.ranconner(chonin);
		masako.ranconner(marco);
		
		akimoto.faireConnaissance(masako);
		
		masako.ranconner(kumi);
		
		masako.faireConnaissance(yaku);
		masako.faireLeGentil();
		
		masako.faireConnaissance(roro);
		
		Samourai akira = new Traitre("Miyamoto", "Akira", "whisky", 50);
		Ronin hiro = new Traitre("Miyamoto", "Hiro", "saké", 20);
		Humain nori = new Traitre("Miyamoto", "Nori", "whisky", 70);
		
		//		
		
		GrandMere grandMere = new GrandMere("Grand-Mère", 10);
		
		grandMere.faireConnaissance(akimoto);
		grandMere.faireConnaissance(yaku);
		grandMere.faireConnaissance(masako);
		grandMere.faireConnaissance(kumi);
		grandMere.faireConnaissance(marco);
		grandMere.faireConnaissance(chonin);
		
		grandMere.ragoter();
	}
	
}
