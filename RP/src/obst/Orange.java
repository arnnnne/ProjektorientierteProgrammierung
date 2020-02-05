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
	 * Ändert die Kern-Eigenschaft
	 * @param kerne "true", wenn sie Kerne hat
	 * 				"false", wenn sie keine Kerne hat
	 */
	public void setKerne(boolean kerne) {
		this.kerne = kerne;
	}
	
	public Orange() {
		super("Orange");
	}

}
