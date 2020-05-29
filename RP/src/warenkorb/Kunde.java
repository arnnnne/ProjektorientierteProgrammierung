package warenkorb;

public class Kunde {
	
	private String vorname;
	private String nachname;
	private Adresse adresse;
	
	public Kunde(String vorname, String nachname, Adresse adresse) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public String toString() {
		String text = "";
		text = text + "Vorname: " + getVorname() + "\n";
		text = text + "Nachname: " + getNachname() + "\n";
		text = text + "Adresse >> " + getAdresse() + "\n";
		return text;
	}

}
