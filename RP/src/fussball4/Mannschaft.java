package fussball4;

import java.util.ArrayList;

public class Mannschaft {

	private String name;
	private Trainer trainer1;
	private Torwart torwart1;
	private ArrayList<Spieler> spielerListe;

	public Mannschaft(String name, Trainer trainer1, Torwart torwart1, ArrayList<Spieler> spielerListe) {
		this.setName(name);
		this.setTrainer1(trainer1);
		this.setTorwart1(torwart1);
		this.spielerListe = spielerListe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Trainer getTrainer1() {
		return trainer1;
	}

	public void setTrainer1(Trainer trainer1) {
		this.trainer1 = trainer1;
	}

	public Torwart getTorwart1() {
		return torwart1;
	}

	public void setTorwart1(Torwart torwart1) {
		this.torwart1 = torwart1;
	}

	public ArrayList<Spieler> getSpieler() {
		return spielerListe;
	}

	public void setSpieler(ArrayList<Spieler> spieler) {
		this.spielerListe = spieler;
	}

	public int getMotivation() {

		int motiGes = torwart1.getMotivation();

		for(Spieler spieler: spielerListe) {
			motiGes = motiGes + spieler.getMotivation();
		}
		
		/**for (int i = 0; i < spielerListe.size(); i++) {
		motiGes = motiGes + spielerListe.get(i).getMotivation();
	}**/
		
		int dMoti = motiGes / (spielerListe.size()+1);
		return dMoti;
	}

	public int getStaerke() {

		int staerkeGes = 0;

		for(Spieler spieler: spielerListe) {
			staerkeGes = staerkeGes + spieler.getMotivation();
		}
		
		/**for (int i = 0; i < spielerListe.size(); i++) {
			staerkeGes = staerkeGes + spielerListe.get(i).getStaerke();
		}**/
		int dStae = staerkeGes / spielerListe.size();
		return dStae;
	}
	
	@Override
	public String toString() {
		String text = "";
		text = text + name;
		text = text + "\nTrainer" + trainer1;
		text = text + "\n\nTorwart" + torwart1;
		for(Spieler spieler : spielerListe) {
			text = text + "\n\nSpieler" + spieler;
		}
		text = text + "\n\nStaerke gesamt = " + getStaerke();
		text = text + "\nMotivation gesamt = " + getMotivation() + "\n\n";
		return text;
	}
}
