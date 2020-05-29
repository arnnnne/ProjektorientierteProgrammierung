package konto;

public abstract class Konto {
	
	private double kotnostand;
	private double kreditlimit;
	private double zinssatz;
	
	public Konto(double kontostand, double kreditlimit, double zinssatz) {
		this.kotnostand = kontostand;
		this.kreditlimit = kreditlimit;
		this.zinssatz = zinssatz;
	}
	
	public double getKotnostand() {
		return kotnostand;
	}
	
	public void setKotnostand(double kotnostand) {
		this.kotnostand = kotnostand;
	}

	public double getKreditlimit() {
		return kreditlimit;
	}

	public void setKreditlimit(double kreditlimit) {
		this.kreditlimit = kreditlimit;
	}

	public double getZinssatz() {
		return zinssatz;
	}

	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}
	
	public void einzahlen(double betrag) {
		if(getKotnostand() < 0) {
			setKotnostand(getKotnostand() + (betrag - (betrag*getZinssatz())));
		}
		else {
		setKotnostand(getKotnostand() + betrag);
		}
	}
	
	public boolean auszahlen(double betrag) {
		boolean kreditlimitEingehalten;
		if((getKotnostand() - betrag) < getKreditlimit()) {
			kreditlimitEingehalten = false;
		}
		
		else {
			kreditlimitEingehalten = true;
			setKotnostand(getKotnostand() - betrag);
		}
		return kreditlimitEingehalten;
	}
	
	public String toString() {
		String text = "";
		text = text + "Kontostand = " + getKotnostand();
		text = text + "Kreditlimit = " + getKreditlimit();
		text = text + "Zinssatz = " + getZinssatz();
		return text;
	}

}
