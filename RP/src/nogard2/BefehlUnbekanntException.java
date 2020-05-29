package nogard2;

public class BefehlUnbekanntException extends Exception{
	
	private String meldung;
	
	public BefehlUnbekanntException(String meldung) {
		this.meldung = meldung;
	}
	
	@Override
	public String getMessage() {
		return meldung;
	}

}
