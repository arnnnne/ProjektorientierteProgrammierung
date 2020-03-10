package tresor;

import java.util.ArrayList;

public class Tresor {
	private ArrayList<Gegenstand> gegenstandListe;
	
	public Tresor(ArrayList<Gegenstand> gegenstandListe) {
		this.gegenstandListe = gegenstandListe;
	}
	
	public ArrayList<Gegenstand> getGegenstandsListe(){
		return gegenstandListe;
		
	}
	
	public void addGegenstand(Gegenstand gegenstand){
		this.gegenstandListe.add(gegenstand);
	}
	
	public void removeGegenstand(Gegenstand gegenstand){
		this.gegenstandListe.remove(gegenstand);
	}
	
	public Gegenstand getGegestand(int id) throws GegenstandNichtGefunden {
		boolean gegenstandexistiert = false;
		Gegenstand gegenstand1 = null;
		for (Gegenstand gegenstand2 : gegenstandListe) {
			
			if(gegenstand2.getID() == id) {
				gegenstand1 = gegenstand2;
			}
			else {
				continue;
			}
		}
		if(gegenstand1 == null) {
			throw new GegenstandNichtGefunden(id);
		}
		else {
			return gegenstand1;
		}
		}
	
	public int gesamtVerssicherungswert() {
		int gesamt = 0;
		for (Gegenstand gegenstand : gegenstandListe) {
			gesamt = gesamt + gegenstand.getVersicherungswert();
		}
		return gesamt;
	}
	
	public String toString() {
		String text = "";
		text = text + "Gegenstände = " + getGegenstandsListe();
		text = text + "Gesamtversicherheitswert = " +  gesamtVerssicherungswert();
		return text;
	}
}


