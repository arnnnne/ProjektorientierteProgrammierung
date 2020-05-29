package kaufvertrag;

public class Kaufvertrag {
	Vertragspartner verkaeufer;
	Vertragspartner kaeufer;
	Ware ware;
	String zahlungsModalitaeten;

	public Kaufvertrag(Vertragspartner verkaeufer, Vertragspartner kaeufer, Ware ware) {

	}

	public Vertragspartner getVerkaeufer() {
		return verkaeufer;
	}
	
	public Vertragspartner getKaeufer() {
		return kaeufer;
	}
	
	public void setVerkaeufer(Vertragspartner verkaeufer) {
		this.verkaeufer = verkaeufer;
	}
	
	public void setKaeufer(Vertragspartner kaeufer) {
		this.kaeufer = kaeufer;
	}
	
	public Ware getWare(){
		return ware;
	}
	
	public void setware(Ware ware) {
		this.ware = ware;
	}
	
	public void setZahlungsModalitaeten(String zahlungsModalitaeten) {
		this.zahlungsModalitaeten = zahlungsModalitaeten;
	}
	
	public String setZahlungsModalitaeten() {
		return zahlungsModalitaeten;
	}
	
	

}
