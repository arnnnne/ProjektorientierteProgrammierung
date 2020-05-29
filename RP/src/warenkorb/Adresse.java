package warenkorb;

public class Adresse {
	
	private String strasse;
	private String hausNr;
	private String plz;
	private String ort;
	
	public Adresse(String strasse, String hausNr, String plz, String ort) {
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.plz = plz;
		this.ort = ort;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNr() {
		return hausNr;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public String toString() {
		String text = "";
		text = text + "Strasse: " + getStrasse() + "\n";
		text = text + "Hausnummer: " + getHausNr() + "\n";
		text = text + "Postleitzeahl: " + getPlz() + "\n";
		text = text + "Ort: " + getOrt() + "\n";
		return text;
	}
	

}
