package obst;

public class Banane extends Obst {
	
	private double kruemmung;
	
	/**
	 * Gibt die Kr�mmung der Banane zur�ck
	 * @return Die Kr�mmung der Banane
	 */
	public double getKruemmung() {
		return kruemmung;
	}
	
	/**
	 * �ndert die Kr�mmung der Banane
	 * @param kruemmung Die neue Kr�mmung der Banane
	 */
	public void setKruemmung(double kruemmung) {
		this.kruemmung = kruemmung;
	}

	public Banane() {
		super("Banane");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String text;
		text = super.toString();
		text = text + "\nKruemmung = " + kruemmung + "\n";
		return text;
	}

}
