package konto;

public class Girokonto extends Konto{

	public Girokonto(double kontostand, double kreditlimit, double zinssatz) {
		super(kontostand, kreditlimit, zinssatz);
	}
	
	public boolean überweisung(double betrag, Konto absender, Konto empfaenger) {
		boolean überweisungAbgeschlossen;
		
		if(absender.auszahlen(betrag) == true) {
			absender.auszahlen(betrag);
			empfaenger.einzahlen(betrag);
			überweisungAbgeschlossen = true;			
		}
		else {
			überweisungAbgeschlossen = false;
		}
		return überweisungAbgeschlossen;
	}
	
	public String toString() {
		String text = super.toString();
		return text;
	}

}
