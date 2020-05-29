package nogard;

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
			String[] befehl = input.trim().split(" ");
			// Abbruch bei fehlender Eingabe.
			end = ausfuehrenBefehl(befehl);
		}

		ausgebenEndText();
	}
	private boolean ausfuehrenBefehl(String[] befehl) {
		boolean end;
		switch(befehl.length) {

		case 0: ausgebenFehlerBfehl();
		end = false;
		break;

		default: // Auswerten des Befehls.
			String befehlWort = befehl[0].trim();
			switch(befehlWort) {

			case "go": wechselBereich(befehl);
			end = false;
			break;

			case "help": ausgebenHilfeText();
			end = false;
			break;

			case "quit": end = true;	
			break;

			default: ausgebenFehlerBfehl();
			end = false;
			}

		}
		return end;
	}
	private void wechselBereich(String[] befehl) {
		switch(befehl.length) {

		case 1: System.out.println("Wohin möchtest Du gehen?");
		break;

		default: String richtung = befehl[1].trim();
		Bereich neuerBereich;

		switch(richtung) {
		case "north": neuerBereich = aktiverBereich.getNord();
		break;

		case "east": neuerBereich = aktiverBereich.getOst();
		break;

		case "west": neuerBereich = aktiverBereich.getWest();
		break;

		case "south": neuerBereich = aktiverBereich.getSued();
		break;

		default: neuerBereich = null;
		
		
		}

		// Auswertung der gefundenen Bereichs.
		if (neuerBereich == null) {
			System.out.println("Dort geht es nicht weiter.");
		}
		else {
			aktiverBereich = neuerBereich;
			System.out.println("Du befindest dich " + aktiverBereich.getBeschreibung() + ".");
			System.out.println("Du kannst gehen nach:");
			ausgebenBereichsInfo();
		}
		}
	}
	private void ausgebenHilfeText() {
		System.out.println("Du irrst in Nogard herum.");
		System.out.println("Dir stehen folgende Befehle zur Verfügung:");
		System.out.println("\tgo");
		System.out.println("\tquit");
		System.out.println("\thelp");
	}
	private void ausgebenEndText() {
		// Endbildschirm ausgeben.
		System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
	}
	private void ausgebenStartText() {
		// Begrüßungsbildschirm ausgeben.
		System.out.println("Willkommen in Nogard!");
		System.out.println("Entdecke die Welt von Nogard. Doch Vorsicht, überall lauern Gefahren!");
		System.out.println("Wenn du Hilfe benötigst, tippe 'help'.");
		System.out.println();
		System.out.println("Du befindest dich " + aktiverBereich.getBeschreibung() + ".");
		System.out.println("Du kannst gehen nach:");
		ausgebenBereichsInfo();
	}

	private void erzeugenDorf() {
		// Die Bereiche erzeugen.
		Bereich friedhof = new Bereich("auf einem Friedhof, umgeben von dunklen Tannen");
		Bereich wald = new Bereich("im dunklen Stadtwald von Nogard");
		Bereich taverne = new Bereich("in der Taverne, mit zwielichtigen Gestalten an der Theke");
		Bereich hexenhaus = new Bereich("im finsteren Hexenhaus");
		Bereich rathaus = new Bereich("im Rathaus von Nogard");
		Bereich marktplatz = new Bereich("auf dem Marktplatz");

		// Die Nachbarschaften festlegen.
		friedhof.setNachbarn(null, null, hexenhaus, null);
		wald.setNachbarn(hexenhaus, taverne, null, null);
		taverne.setNachbarn(rathaus, marktplatz, null, wald);
		hexenhaus.setNachbarn(friedhof, rathaus, wald, null);
		rathaus.setNachbarn(null, null, taverne, hexenhaus);
		marktplatz.setNachbarn(null, null, null, taverne);

		// Das Spielt startet im Wald.
		aktiverBereich = wald;
	}

	private void ausgebenFehlerBfehl() {
		System.out.println("Ich weiß nicht, was Du meinst ...");

	}

	private void ausgebenBereichsInfo() {
		if(aktiverBereich.getNord() != null) {
			System.out.println("\tNorden.");
		}
		if(aktiverBereich.getOst() != null) {
			System.out.println("\tOsten.");
		}
		if(aktiverBereich.getSued() != null) {
			System.out.println("\tSüden.");
		}
		if(aktiverBereich.getWest() != null) {
			System.out.println("\tWesten.");
		}
	}

}