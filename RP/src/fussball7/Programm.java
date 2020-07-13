package fussball7;

import java.util.ArrayList;

public class Programm {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Trainer traineR = new Trainer("TrainerH", 55, 30);
		Torwart torwarT = new Torwart("TorwartH", 66, 10, 10, 10);
		ArrayList<Spieler> spielerListe1 = new ArrayList<Spieler>();
		Spieler spieleR = new Spieler("SpielerVorne", 77, 5, 10, 8, 1);
		Spieler spielEr = new Spieler("SpielerHinten", 88, 10, 5, 8, 1);
		spielerListe1.add(spieleR);
		spielerListe1.add(spielEr);
		Mannschaft mannschaftH = new Mannschaft("BVB", traineR, torwarT, spielerListe1);
		
		Trainer tRainer = new Trainer("TrainerG", 99, 30);
		Torwart tOrwart = new Torwart("TorwartG", 92, 10, 10, 10);
		ArrayList<Spieler> spielerListe2 = new ArrayList<Spieler>();
		Spieler spieLer = new Spieler("SpielerGegen1", 66, 6, 10, 8, 1);
		Spieler spiEler = new Spieler("SpielerGegen2", 16, 10, 4, 8, 1);
		spielerListe2.add(spieLer);
		spielerListe2.add(spiEler);
		Mannschaft mannschaftG = new Mannschaft("VFL", tRainer, tOrwart, spielerListe2);
		
		Spiel spiel1 = new Spiel(mannschaftH, mannschaftG);
		System.out.println(spiel1.toString());
		
		Gameplay game = new Gameplay();
		try {
			game.spielen(spiel1, mannschaftH, mannschaftG, tRainer, tRainer, torwarT, tOrwart);
		} catch (SpielabbruchException e) {
			System.out.println(spiel1.getSpielbericht());
			System.out.println(e.getMessage());
		}
		
	}

}
