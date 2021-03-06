package nogard3;

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
 *  - Sie legt alle Bereiche an. Anschlie�end startet das Spiel. 
 *  - Sie wertet die Befehle aus und sorgt f�r ihre Ausf�hrung.
 */
public class Spiel {

	private Bereich aktiverBereich;


	public Spiel() {
		erzeugenDorf();
	}
	/**
	 * Die Hauptmethode zum Spielen. 
	 * L�uft bis zum Ende des Spiels in einer Schleife.
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
				// Befehl ausf�hren.
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

		// Die Nachbarschaften festlegen.
		friedhof.setNachbarn(null, null, hexenhaus, null);
		hexenhaus.setNachbarn(friedhof, rathaus, wald, null);
		rathaus.setNachbarn(null, null, taverne, hexenhaus);
		taverne.setNachbarn(rathaus, null, null, wald);
		wald.setNachbarn(hexenhaus, taverne, null, null);

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
		Bereich neuerBereich;
		switch (befehl.getBefehlsZusatz()) {
		case "north":
			neuerBereich = aktiverBereich.getNachbar(Richtungen.NORTH);
			break;
		case "east":
			neuerBereich = aktiverBereich.getNachbar(Richtungen.EAST);
			break;
		case "south":
			neuerBereich = aktiverBereich.getNachbar(Richtungen.SOUTH);
			break;
		case "west":
			neuerBereich = aktiverBereich.getNachbar(Richtungen.WEST);
			break;
		default:
			neuerBereich = null;
			break;
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
	 * Gibt einen Begr��ungstext auf der Konsole aus.
	 */
	private void ausgebenStartText() {
		System.out.println("Willkommen in Nogard!");
		System.out.println("Entdecke die Welt von Nogard. Doch Vorsicht, �berall lauern Gefahren!");
		System.out.println("Wenn du Hilfe ben�tigst, tippe 'help'.");
		System.out.println();
		System.out.println(aktiverBereich.getInfo());
	}

	/**
	 * Gibt einen Text mit Hilfsinformationen auf der Konsole aus.
	 */
	private void ausgebenHilfeText() {
		System.out.println("Du irrst in Nogard herum.");
		System.out.println("Dir stehen folgende Befehle zur Verf�gung:");
		System.out.println("\tgo");
		System.out.println("\tquit");
		System.out.println("\thelp");
	}

	/**
	 * Gibt einen Endtext auf der Konsole aus.
	 */
	private void ausgebenEndText() {
		System.out.println("Danke f�r dieses Spiel. Auf Wiedersehen.");
	}

	

	/**
	 * Gibt einen Fehlertext auf der Konsole aus, wenn der Befehl nicht verstanden wird.
	 */
	private void ausgebenFehlerBefehl() {
		System.out.println("Ich wei� nicht, was Du meinst ...");
	}

}