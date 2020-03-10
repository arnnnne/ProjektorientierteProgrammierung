package fussball5;

import java.util.ArrayList;

public class Programm {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Trainer traineR = new Trainer("TrainerBVB", 55, 30);
		Torwart torwarT = new Torwart("TorwartBVB", 66, 10, 10, 10);
		ArrayList<Spieler> spielerListe1 = new ArrayList<Spieler>();
		Spieler spieleR = new Spieler("SpielerBVB1", 77, 5, 10, 8, 1);
		Spieler spielEr = new Spieler("SpielerBVB2", 88, 10, 5, 8, 1);
		spielerListe1.add(spieleR);
		spielerListe1.add(spielEr);
		Mannschaft mannschaftH = new Mannschaft("BVB", traineR, torwarT, spielerListe1);

		Trainer tRainer = new Trainer("TrainerVFL", 99, 30);
		Torwart tOrwart = new Torwart("TorwartVFL", 92, 10, 10, 10);
		ArrayList<Spieler> spielerListe2 = new ArrayList<Spieler>();
		Spieler spieLer = new Spieler("SpielerVFL1", 66, 6, 10, 8, 1);
		Spieler spiEler = new Spieler("SpielerVFL2", 16, 10, 4, 8, 1);
		spielerListe2.add(spieLer);
		spielerListe2.add(spiEler);
		Mannschaft mannschaftG = new Mannschaft("VFL", tRainer, tOrwart, spielerListe2);

		Spiel spiel1 = new Spiel(mannschaftH, mannschaftG);
		System.out.println(spiel1.toString());

		Gameplay game = new Gameplay();
		game.spielen(spiel1, mannschaftH, mannschaftG, tRainer, tRainer, torwarT, tOrwart);

	}

}
