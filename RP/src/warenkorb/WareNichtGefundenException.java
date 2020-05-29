package warenkorb;

public class WareNichtGefundenException extends Exception{
	
	private String warenNr;
	
	public WareNichtGefundenException(String warenNr) {
		this.warenNr = warenNr;
	}

	public String getWarenNr() {
		return warenNr;
	}

	public String getMessage() {
		String message = "Die Warennummer: " + getWarenNr() + ", kann nicht gefunden werden.";
		return message;
	}

}
