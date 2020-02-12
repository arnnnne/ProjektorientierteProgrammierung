package fussball1;

public class Spieler {
	
	private String name;
	private int alter;
	private int staerke;
	private int motivation;
	private int torschuss;
	private int tore;
	
	public Spieler(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAlter() {
		return alter;
	}
	
	public void setAlter(int alter) {
		this.alter = alter;
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
		text = "Name = " + name;
		text = text + "\nAlter = " + alter;
		text = text + "\nStärke = " + staerke;
		text = text + "\nMotivation = " + motivation;
		text = text + "\nTorschuss = " + torschuss;
		text = text + "\nTore = " + tore + "\n";
		return text;
	}
	
	

}
