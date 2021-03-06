package fussball7;

import java.util.ArrayList;

public class Programm {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		try {
			Torwart torwart = new TorwartDao().read(1);
			System.out.println(torwart);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Spieler spieler1 = new SpielerDao().read(3);
			System.out.println(spieler1);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Trainer trainer2 = new TrainerDao().read(3);
			System.out.println(trainer2);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Mannschaft mannschaft = new MannschaftDao().read(1);
			System.out.println("\n\n" + mannschaft);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
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
