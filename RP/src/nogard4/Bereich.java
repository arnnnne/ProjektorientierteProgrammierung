package nogard4;

import java.util.HashMap;
import java.util.Map;

/**
 * Diese Klasse modelliert Bereiche.Ein Bereich kann ein Gebiet, ein Haus, ein Raum etc. sein.
 * 
 * Jeder Bereich ist mit anderen Bereichen über Ausgänge verbunden. Mögliche Ausgänge liegen im Norden, Osten, Süden und Westen.
 * 
 * Für jeden Ausgang hält ein Bereich eine Referenz auf den benachbarten Bereich parat.
 */
public class Bereich {

	private String beschreibung;
    private Map<Richtungen, Bereich> nachbarn;

    /**
     * Konstruktor.
     * @param beschreibung	Die Beschreibung des Areals.
     */
    public Bereich(String beschreibung) {
        this.beschreibung = beschreibung;
        nachbarn = new HashMap<>();
        for (Richtungen richtung : Richtungen.values()) {
        	nachbarn.put(richtung, null);			
		}
    }

    /**
     * Liefert die Beschreibung des Bereichs.
     * @return	Die Beschreibung des Bereichs.
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Definiert die benachbarten Bereiche des Bereichs. 
     * Jede Richtung führt entweder in einen anderen Bereich oder ist 'null' (kein Ausgang).
     * @param nord	Der im Norden benachbarte Bereich.
     * @param ost	Der im Osten benachbarte Bereich.
     * @param sued	Der im Süden benachbarte Bereich.
     * @param west	Der im Westen benachbarte Bereich.
     */
    public void setNachbarn(Richtungen richtung, Bereich nachbar) {
    	nachbarn.put(richtung, nachbar);
    }
    
    public Bereich getNachbar(Richtungen richtung) {
    	return nachbarn.get(richtung);
    }
	
	/**
	 * Gibt die Informationen zum aktiven Bereich auf der Konsole aus.
	 */
	public String getInfo() {
		System.out.println("Du befindest dich " + getBeschreibung() + ".");
		System.out.println("Du kannst gehen nach:");
		StringBuilder info = new StringBuilder();
		for(Map.Entry<Richtungen, Bereich> paar : nachbarn.entrySet()) {
			info.append("\n\t" + paar.getKey().name().toLowerCase());
		}
		
		return info.toString();
	}

}

