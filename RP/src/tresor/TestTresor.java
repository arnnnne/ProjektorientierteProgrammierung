package tresor;

import java.util.ArrayList;

public class TestTresor {

	public static void main(String[] args) {
		ArrayList<Gegenstand> gegenstandsliste = new ArrayList<Gegenstand>();
		Aktie airbusAktie = new Aktie(000, 10, "Airbus", 12);
		Aktie nettoAktie = new Aktie(001, 15, "Netto", 20);
		Schmuck kette = new Schmuck(002, 100, "Kette");
		Schmuck ohrringe = new Schmuck(003, 200, "Ohrringe");
		gegenstandsliste.add(airbusAktie);
		gegenstandsliste.add(nettoAktie);
		gegenstandsliste.add(kette);
		gegenstandsliste.add(ohrringe);
		Tresor tresor = new Tresor(gegenstandsliste);
		System.out.println(tresor.toString());
		gegenstandsliste.remove(ohrringe);
		System.out.println(tresor.toString());
		try {
			System.out.println(tresor.getGegestand(3));
		} catch (GegenstandNichtGefunden e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(tresor.getGegestand(0));
		} catch (GegenstandNichtGefunden e) {
			System.out.println(e.getMessage());
		}

	}

}
