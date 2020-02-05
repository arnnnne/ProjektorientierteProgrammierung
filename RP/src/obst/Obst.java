package obst;

public class Obst {

	private String name;
	private double gewicht;
	private double vitamingehalt;
	private boolean reife;

	/**
	 * Konstruktor.
	 * Wird nur aufgerufen, wenn ein Objekt erzeugt wird.
	 * @param Der Name des Obstes
	 */
	public Obst(String name) {
		this.name = name;
	}

	/**
	 * Gibt den Namen des Objektes zur�ck.
	 * @return Der Name des Obstes.
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Gibt das Gewicht des Obstes zur�ck
	 * @return Das Gewicht
	 */
	public double getGewicht() {
		return gewicht;
	}

	/**
	 * �ndert das Gewicht des Obstes.
	 * @param gewicht Das neue Gewicht des Obstes
	 */
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	
	public double getVitamingehalt() {
		return vitamingehalt;
	}

	/**
	 * �ndert den Vitamingehalt des Obstes.
	 * @param vitamingehalt Der neue Vitamingehalt des Obstes
	 */
	public void setVitamingehalt(double vitamingehalt) {
		this.vitamingehalt = vitamingehalt;
	}
	
	public boolean isReife() {
		return reife;
	}

	/**
	 * �ndert die Reife des Obstes.
	 * @param reife Die neue Reife des Obstes
	 */
	public void setReife(boolean reife) {
		this.reife = reife;
	}
}
