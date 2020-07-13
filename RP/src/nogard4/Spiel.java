package nogard4;

import java.util.Scanner;

/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Nogard".
 *  
 *  "Die Welt von Nogard" ist ein sehr einfaches, textbasiertes Adventure-Game, in dem sich ein Spieler durch Nogard bewegen kann. 
 *  
 *  Das Spiel sollte auf jeden Fall ausgebaut werden, damit es interessanter wird!
 * 
 *  Zum Spielen muss an einer Instanz dieser Klasse die Methode "spielen()" aufgerufen werden.
 * 
 *  Diese Klasse erzeugt und initialisiert alle Objekte der Anwendung: 
 *  - Sie legt alle Bereiche an. Anschließend startet das Spiel. 
 *  - Sie wertet die Befehle aus und sorgt für ihre Ausführung.
 */
public class Spiel {

	private Bereich aktiverBereich;


	public Spiel() {
		erzeugenDorf();
	}
	/**
	 * Die Hauptmethode zum Spielen. 
	 * Läuft bis zum Ende des Spiels in einer Schleife.
	 */
	public void spielen() {   


		ausgebenStartText();

		// Befehle einlesen und auswerten.
		Scanner scannerZeile = new Scanner(System.in);
		boolean end = false;
		while (! end) {
			// Eingabeaufforderung anzeigen.
			System.out.print("> ");
			// Befehlszeile lesen.
			String input = scannerZeile.nextLine();
			// Befehl interpretieren.
			try {
				// Befehls-Objekt erzeugen.
				Befehl befehl = BefehlFactory.createBefehl(input);
				// Befehl ausführen.
				end = ausfuehrenBefehl(befehl);
			} catch (BefehlUnbekanntException e) {
				System.out.println(e.getMessage());
			}
		}

		ausgebenEndText();
	}

	private void erzeugenDorf() {
		// Die Bereiche erzeugen.
		Bereich friedhof = new Bereich("auf einem Friedhof, umgeben von dunklen Tannen");
		Bereich hexenhaus = new Bereich("im finsteren Hexenhaus");
		Bereich rathaus = new Bereich("im Rathaus von Nogard");
		Bereich taverne = new Bereich("in der Taverne, mit zwielichtigen Gestalten an der Theke");
		Bereich wald = new Bereich("im dunklen Stadtwald von Nogard");
		Bereich hoehle = new Bereich("in einer dunklen und feuchten Höhle");
		Bereich kraeuterkeller = new Bereich("im Kräuterkeller der Dorfhexe");
		Bereich weinkeller = new Bereich("im Weinkeller der Taverne");

		// Die Nachbarschaften festlegen.
		friedhof.setNachbarn(Richtungen.SOUTH, hexenhaus);
		hexenhaus.setNachbarn(Richtungen.NORTH, friedhof);
		hexenhaus.setNachbarn(Richtungen.EAST, rathaus);
		hexenhaus.setNachbarn(Richtungen.SOUTH, wald);
		hexenhaus.setNachbarn(Richtungen.DOWN, kraeuterkeller);
		rathaus.setNachbarn(Richtungen.SOUTH, taverne);
		rathaus.setNachbarn(Richtungen.WEST, hexenhaus);
		taverne.setNachbarn(Richtungen.NORTH, rathaus);
		taverne.setNachbarn(Richtungen.WEST, wald);
		taverne.setNachbarn(Richtungen.DOWN, weinkeller);
		wald.setNachbarn(Richtungen.NORTH, hexenhaus);
		wald.setNachbarn(Richtungen.EAST, taverne);
		hoehle.setNachbarn(Richtungen.NORTH, kraeuterkeller);
		hoehle.setNachbarn(Richtungen.EAST, weinkeller);
		kraeuterkeller.setNachbarn(Richtungen.SOUTH, hoehle);
		kraeuterkeller.setNachbarn(Richtungen.UP, hexenhaus);
		weinkeller.setNachbarn(Richtungen.WEST, hoehle);
		weinkeller.setNachbarn(Richtungen.UP, taverne);

		// Das Spielt startet im Wald.
		aktiverBereich = wald;
	}

	private boolean ausfuehrenBefehl(Befehl befehl) {
		switch (befehl.getBefehlsWort()) {
		case "go":
			wechselBereich(befehl);
			return false;
		case "help":
			ausgebenHilfeText();
			return false;
		case "quit":
			return true;
		default:
			ausgebenFehlerBefehl();
			return false;
		}
	}
	private void wechselBereich(Befehl befehl) {
		// Neuen Bereich ermitteln.
		Richtungen richtung = Richtungen.valueOf(befehl.getBefehlsZusatz().toUpperCase());
		Bereich neuerBereich = aktiverBereich.getNachbar(richtung);
		// Auswertung der gefundenen Bereichs.
		if (neuerBereich == null) {
			System.out.println("Dort geht es nicht weiter.");
		}
		else {
			aktiverBereich = neuerBereich;
			System.out.println(aktiverBereich.getInfo());
		}

		// Auswertung der gefundenen Bereichs.
		if (neuerBereich == null) {
			System.out.println("Dort geht es nicht weiter.");
		}
		else {
			aktiverBereich = neuerBereich;
			System.out.println(aktiverBereich.getInfo());
		}
	}

	/**
	 * Gibt einen Begrüßungstext auf der Konsole aus.
	 */
	private void ausgebenStartText() {
		System.out.println("Willkommen in Nogard!");
		System.out.println("Entdecke die Welt von Nogard. Doch Vorsicht, überall lauern Gefahren!");
		System.out.println("Wenn du Hilfe benötigst, tippe 'help'.");
		System.out.println();
		System.out.println(aktiverBereich.getInfo());
	}

	/**
	 * Gibt einen Text mit Hilfsinformationen auf der Konsole aus.
	 */
	private void ausgebenHilfeText() {
		System.out.println("Du irrst in Nogard herum.");
		System.out.println("Dir stehen folgende Befehle zur Verfügung:");
		System.out.println("\tgo");
		System.out.println("\tquit");
		System.out.println("\thelp");
	}

	/**
	 * Gibt einen Endtext auf der Konsole aus.
	 */
	private void ausgebenEndText() {
		System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
	}



	/**
	 * Gibt einen Fehlertext auf der Konsole aus, wenn der Befehl nicht verstanden wird.
	 */
	private void ausgebenFehlerBefehl() {
		System.out.println("Ich weiß nicht, was Du meinst ...");
	}

}