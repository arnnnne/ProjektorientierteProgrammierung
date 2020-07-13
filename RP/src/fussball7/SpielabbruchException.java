package fussball7;

public class SpielabbruchException extends Exception{
	
	private int spielminute;
	private String message = "Das Spiel wurde abgebrochen";
	
	public SpielabbruchException(int spielminute) {
		this.spielminute = spielminute;
	}

	public int getSpielminute() {
		return spielminute;
	}
	
	public String getMessage() {
		return message;
	}

}
