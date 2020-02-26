package fussball4;

public class Ergebnis {
	
	private int toreHeim;
	private int toreGast;
	
	public Ergebnis(int toreHeim, int toreGast) {
		this.toreHeim = toreHeim;
		this.toreGast = toreGast;
	}
	
	public int getToreHeim() {
		return toreHeim;
	}
	
	public int getToreGast() {
		return toreGast;
	}
	
	public void addToreHeim() {
		this.toreHeim = toreHeim++;
	}
	
	public void addToreGast() {
		this.toreGast = toreGast++;
	}
	
	@Override
	public String toString() {
		String text;
		text = super.toString();
		text = text + "\nTore Heim = " + getToreHeim();
		text = text + "\nTore Gast = " + getToreGast();
		return text;
	}
	
	
}
