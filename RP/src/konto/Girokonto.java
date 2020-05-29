package konto;

public class Girokonto extends Konto{

	public Girokonto(double kontostand, double kreditlimit, double zinssatz) {
		super(kontostand, kreditlimit, zinssatz);
	}
	
	public boolean �berweisung(double betrag, Konto absender, Konto empfaenger) {
		boolean �berweisungAbgeschlossen;
		
		if(absender.auszahlen(betrag) == true) {
			absender.auszahlen(betrag);
			empfaenger.einzahlen(betrag);
			�berweisungAbgeschlossen = true;			
		}
		else {
			�berweisungAbgeschlossen = false;
		}
		return �berweisungAbgeschlossen;
	}
	
	public String toString() {
		String text = super.toString();
		return text;
	}

}
