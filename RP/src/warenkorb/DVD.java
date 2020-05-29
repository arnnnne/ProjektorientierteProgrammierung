package warenkorb;

public class DVD extends Ware{
	
	private int spieldauer;
	
	public DVD(String warenNr, String bezeichnung, double preis, double mwst, int spieldauer) {
		super(warenNr, bezeichnung, preis, mwst);
		this.spieldauer = spieldauer;
	}

	public int getSpieldauer() {
		return spieldauer;
	}

	public void setSpieldauer(int spieldauer) {
		this.spieldauer = spieldauer;
	}
	
	public String toString() {
		String text = super.toString();
		text = text + "Spieldauer: " + getSpieldauer() + "\n";
		return text;
	}

}
