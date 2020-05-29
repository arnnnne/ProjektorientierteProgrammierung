package warenkorb;

public abstract class Ware {
	
	private String warenNr;
	private String bezeichnung;
	private double preis;
	private double mwst;
	
	public Ware(String warenNr, String bezeichnung, double preis, double mwst) {
		this.warenNr = warenNr;
		this.bezeichnung = bezeichnung;
		this.preis = preis;
		this.mwst = mwst;
	}

	public String getWarenNr() {
		return warenNr;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public double getMwst() {
		return mwst;
	}

	public void setMwst(double mwst) {
		this.mwst = mwst;
	}

	@Override
	public String toString() {
		String text = "";
		text = text + "Warennummer: " + getWarenNr() + "\n";
		text = text + "Bezeichnung: " + getBezeichnung() + "\n";
		text = text + "Preis: " + getPreis() + "\n";
		text = text + "Mehrwertsteuer: " + getMwst() + "\n";
		return text;
	}
}
