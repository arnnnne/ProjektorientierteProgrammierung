package tresor;

public class Aktie extends Gegenstand{
	
	private String unternehmen;
	private int nennwert;
	
	public Aktie(int id, int versicherungswert, String unternehmen, int nennwert) {
		super(id, versicherungswert);
		this.nennwert = nennwert;
		this.unternehmen = unternehmen;
	}

	public String getUnternehmen() {
		return unternehmen;
	}

	public void setUnternehmen(String unternehmen) {
		this.unternehmen = unternehmen;
	}

	public int getNennwert() {
		return nennwert;
	}

	public void setNennwert(int nennwert) {
		this.nennwert = nennwert;
	}
	
	public String toString() {
		String text = "";
		text = text + "ID = " + getID();
		text = text + "Versicherungswert = " + getVersicherungswert();
		text = text + "Unternehmen = " + getUnternehmen();
		text = text + "Nennwert = " + getNennwert();
		return text;
	}

}
