package fussball3;

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
		

	}

}
