package obst;

public class Orange extends Obst {

	private boolean kerne;
	
	/**
	 * Gibt an, ob die Orange Kerne hat
	 * @return Zustand der Kerne 
	 */
	public boolean isKerne() {
		return kerne;
	}
	
	/**
	 * Wird nur aufgerufen wenn ein neues Objekt erstellt wird
	 * @param kerne "true", wenn die Orange Kerne hat
	 * 				"false", wenn die Orange keine Kerne hat
	 */
	public Orange(boolean kerne) {
		super("Orange");
		this.kerne = kerne;
	}
	
	@Override
	public String toString() {
		String text;
		text = super.toString();
		text = text + "\nKerne = " + kerne + "\n";
		return text;
	}

}
