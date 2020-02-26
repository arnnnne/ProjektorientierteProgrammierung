package fussball4;

public class Spiel {
	
	private Mannschaft heim;
	private Mannschaft gast;
	private Ergebnis ergebnis;
	private StringBuilder spielbericht;
	
	public Spiel(Mannschaft heim, Mannschaft gast) {
		this.heim = heim;
		this.gast = gast;
	}

	public Mannschaft getHeim() {
		return heim;
	}

	public Mannschaft getGast() {
		return gast;
	}

	public Ergebnis getErgebnis() {
		return ergebnis;
	}

	public StringBuilder getSpielbericht() {
		return spielbericht;
	}
	
	@Override
	public String toString() {
		String text = "";
		text = text + "\nMannschaft Heim = " + heim;
		text = text + "\nMannschaft Gast = " + gast;
		text = text + "\nErgebnis = " + getErgebnis();
		text = text + "\nSpielbericht = " + getSpielbericht();
		return text;
	}
	

}
