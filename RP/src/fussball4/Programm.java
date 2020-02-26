package fussball4;

import java.util.ArrayList;

public class Programm {

	public static void main(String[] args) {
		Trainer trainer1 = new Trainer("Guenther Jauch", 55, 5);
		System.out.println(trainer1.getName());
		System.out.println(trainer1.getAlter());
		System.out.println(trainer1.getErfahrung());
		trainer1.setName("Günther Jauch");
		trainer1.setErfahrung(1);
		trainer1.setAlter(44);
		System.out.println("\n" + trainer1.getName());
		System.out.println(trainer1.getAlter());
		System.out.println(trainer1.getErfahrung());
		
		System.out.println(trainer1.toString());
		
		
		Spieler spieler1 = new Spieler("Manuel Neuer", 33, 4,99 ,5, 55);
		System.out.println("\n" + spieler1.getName());
		System.out.println(spieler1.getAlter());
		spieler1.setMotivation(100);
		spieler1.setStaerke(77);
		spieler1.setTore(15);
		spieler1.setTorschuss(100);
		System.out.println(spieler1.getMotivation());
		System.out.println(spieler1.getStaerke());
		System.out.println(spieler1.getTore());
		System.out.println(spieler1.getTorschuss());
		
		System.out.println(spieler1.toString());
		
		Torwart torwart1 = new Torwart("Peter", 22, 100, 1, 19);
		System.out.println(torwart1.toString());
		
		Trainer traineR = new Trainer("TrainerH", 55, 20);
		Torwart torwarT = new Torwart("TorwartH", 66, 10, 10, 1);
		ArrayList<Spieler> spielerListe1 = new ArrayList<Spieler>();
		Spieler spieleR = new Spieler("SpielerVorne", 77, 10, 10, 8, 1);
		Spieler spielEr = new Spieler("SpielerHinten", 88, 1, 1, 0, 0);
		spielerListe1.add(spieleR);
		spielerListe1.add(spielEr);
		Mannschaft mannschaftH = new Mannschaft("BVB", traineR, torwarT, spielerListe1);
		System.out.println("============================\n\n\n");
		System.out.println("HEIM\n");
		System.out.println(mannschaftH.toString());
		
		Trainer tRainer = new Trainer("TrainerG", 99, 30);
		Torwart tOrwart = new Torwart("TorwartG", 92, 10, 10, 3);
		ArrayList<Spieler> spielerListe2 = new ArrayList<Spieler>();
		Spieler spieLer = new Spieler("SpielerGegen1", 66, 10, 10, 3, 1);
		Spieler spiEler = new Spieler("SpielerGegen2", 16, 4, 7, 1, 4);
		spielerListe2.add(spieLer);
		spielerListe2.add(spiEler);
		Mannschaft mannschaftG = new Mannschaft("VFL", tRainer, tOrwart, spielerListe2);
		System.out.println("\n\nGAST\n");
		System.out.println(mannschaftG.toString());
		
		Spiel spiel1 = new Spiel(mannschaftH, mannschaftG);
		System.out.println(spiel1.toString());
		

	}

}
