package warenkorb;

import java.util.ArrayList;

public class Warenkorb {

	private Kunde kunde;
	private ArrayList<Ware> warenListe;
	
	public Warenkorb(Kunde kunde, ArrayList<Ware> warenListe) {
		this.kunde = kunde;
		this.warenListe = warenListe;
	}

	public Kunde getKunde() {
		return kunde;
	}
	
	public void addWare(Ware ware) {
		warenListe.add(ware);
	}
	
	public void removeWare(Ware ware) {
		warenListe.remove(ware);
	}
	
	public Ware getWare(String warenNr) throws WareNichtGefundenException{
		if(warenNr.equals(warenListe)) {
			return warenListe.get(Integer.parseInt(warenNr));
		}
		else {
			throw new WareNichtGefundenException(warenNr);
		}
	}
	
	public int getAnzahlWaren() {
		return warenListe.size();
	}
	
	public double getPreisGesamt() {
		double preis = 0;
		for (Ware ware : warenListe) {
			preis = preis + ware.getPreis();
		}
		return preis;
	}
	
	public String toString() {
		String text = "";
		
		text = text + "Waren >> \n";
		text = text + warenListe.toString();
		text = text + "\nPreis insgesamt: " + getPreisGesamt() + "\n";
		text = text + "Anzahl an Waren: " + getAnzahlWaren() + "\n";
		return text;
	}
}
