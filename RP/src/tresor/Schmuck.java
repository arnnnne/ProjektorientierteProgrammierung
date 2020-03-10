package tresor;

public class Schmuck extends Gegenstand{
	
	private String bezeichnung;
	
	public Schmuck(int id, int versicherungswert, String bezeichnung) {
		super(id, versicherungswert);
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public String toString() {
		String text = "";
		text = "Bezeichnung = " + getBezeichnung();
		text = text + "ID = " + getID();
		text = text + "Versicherungswert = " + getVersicherungswert();
		return text;
	}

}
