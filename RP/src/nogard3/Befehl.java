package nogard3;

public class Befehl {
	
	private String befehlsWort;
	private String befehlsZusatz = null;
	
	public Befehl(String befehlsWort, String befehlsZusatz) {
		this.befehlsWort = befehlsWort;
		this.befehlsZusatz = befehlsZusatz;
	}

	public String getBefehlsWort() {
		return befehlsWort;
	}

	public String getBefehlsZusatz() {
		return befehlsZusatz;
	}
	
	
}
