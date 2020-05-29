package konto;

public class Kontoinhaber extends Person {
	
	
	Mitarbeiter betreuer;

	public Kontoinhaber(String vorname, String nachname, String adresse, Mitarbeiter betreuer) {
		super(vorname, nachname, adresse);
		this.betreuer = betreuer;
	}

	public Mitarbeiter getBetreuer() {
		return betreuer;
	}

	public void setBetreuer(Mitarbeiter betreuer) {
		this.betreuer = betreuer;
	}
	
	public String toString() {
		String text = super.toString();
		text = text + "Betreuer = " + getBetreuer();
		return text;
	}

}
