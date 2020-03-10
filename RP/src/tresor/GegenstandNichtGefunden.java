package tresor;

public class GegenstandNichtGefunden extends Exception{
	
	private int id;
	private String message = "Diese ID existiert nicht.";
	
	public GegenstandNichtGefunden(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
	
	

}
