package konto;

public abstract class Person {
	
	private String vorname;
	private String nachname;
	private String adresse;
	
	public Person(String vorname, String nachname, String adresse) {
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String toString() {
		String text = "";
		text = text + "Vorname = " + getVorname();
		text = text + "Nachname = " + getNachname();
		text = text + "Adresse = " + getAdresse();
		return text;
	}
	
	

}
