package tresor;

public abstract class Gegenstand {

	final int id;
	private int versicherungswert;
	
	public Gegenstand(int id, int versicherungswert) {
		this.id = id;
		this.versicherungswert = versicherungswert;
	}

	public int getID() {
		return id;
	}

	public int getVersicherungswert() {
		return versicherungswert;
	}

	public void setVersicherungswert(int versicherungswert) {
		this.versicherungswert = versicherungswert;
	}

}
