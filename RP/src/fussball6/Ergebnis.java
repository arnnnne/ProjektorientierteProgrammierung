package fussball6;

public class Ergebnis {
	
	private int toreHeim;
	private int toreGast;
	
	
	
	public int getToreHeim() {
		return toreHeim;
	}
	
	public int getToreGast() {
		return toreGast;
	}
	
	public void addToreHeim() {
		this.toreHeim = toreHeim+1;
	}
	
	public void addToreGast() {
		this.toreGast = toreGast+1;
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
