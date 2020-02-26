package fussball4;

public class Spieler extends Person {
	
	private int staerke;
	private int motivation;
	private int torschuss;
	private int tore;
	
	public Spieler(String name, int alter, int staerke, int motivation, int torschuss, int tore) {
		super(name, alter);
		this.staerke = staerke;
		this.motivation = motivation;
		this.tore = tore;
		this.torschuss = torschuss;
		
	}
	
	public int getStaerke() {
		return staerke;
	}
	
	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}

	public int getMotivation() {
		return motivation;
	}

	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}

	public int getTorschuss() {
		return torschuss;
	}

	public void setTorschuss(int torschuss) {
		this.torschuss = torschuss;
	}

	public int getTore() {
		return tore;
	}

	public void setTore(int tore) {
		this.tore = tore;
	}
	
	@Override
	public String toString() {
		String text;
		text = "\nName = " + getName();
		text = text + "\nAlter = " + getAlter();
		text = text + "\nSt�rke = " + staerke;
		text = text + "\nMotivation = " + motivation;
		text = text + "\nTorschuss = " + torschuss;
		text = text + "\nTore = " + tore;
		return text;
	}
	
	

}
