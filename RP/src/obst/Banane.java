package obst;

public class Banane extends Obst {
	
	private double kruemmung;
	
	/**
	 * Gibt die Krümmung der Banane zurück
	 * @return Die Krümmung der Banane
	 */
	public double getKruemmung() {
		return kruemmung;
	}
	
	/**
	 * Ändert die Krümmung der Banane
	 * @param kruemmung Die neue Krümmung der Banane
	 */
	public void setKruemmung(double kruemmung) {
		this.kruemmung = kruemmung;
	}

	public Banane() {
		super("Banane");
		// TODO Auto-generated constructor stub
	}

}
