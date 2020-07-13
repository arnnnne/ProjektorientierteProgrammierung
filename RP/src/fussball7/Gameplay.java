package fussball7;

import java.util.Random;

public class Gameplay {

	private static final int spielzeit = 90;
	private static final int maxNach = 5;
	private static final int dauerBisAktion = 10;	

	public static int ermittleMannschaftswert(Mannschaft mannschaft) {
		Random random = new Random();
		int zufall = random.nextInt(7)-3;

		int mannschaftswert = mannschaft.getMotivation() * mannschaft.getStaerke()
				* mannschaft.getTrainer1().getErfahrung() + zufall;

		if (mannschaftswert < 1) {
			mannschaftswert = 1;
		}
		return mannschaftswert;
	}

	private static boolean erzieltTor(Spieler schuetze, Torwart hueter) {
		Random random = new Random();
		int zufall = random.nextInt(5)-2;

		int zufall2 = random.nextInt(5)-2;

		if((schuetze.getTorschuss() + zufall) > (hueter.getReaktion() + zufall2)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean brecheSpielAb() {
		Random random = new Random();
		int zufall = random.nextInt(1000);
		if(zufall == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void spielen(Spiel spiel, Mannschaft heim, Mannschaft gast, Trainer trainerH, Trainer trainerG, Torwart torwartH, Torwart torwartG) throws SpielabbruchException {
		Random random = new Random();
		int zufall = random.nextInt(maxNach+1);
		int maxSpielzeit = spielzeit + zufall;
		spiel.getSpielbericht().append("Anpfiff!!\n");
		int spielmoment = 0;

		for (int i = 0; i < maxSpielzeit; i++) {
			random = new Random();
			int zufall2 = random.nextInt(dauerBisAktion)+1;
			spielmoment = spielmoment + zufall2;
			if(spielmoment < maxSpielzeit) {

				if(brecheSpielAb() == true) {
					throw new SpielabbruchException(spielmoment);
				}
				else {

					int zufall3 = random.nextInt((ermittleMannschaftswert(heim)
							+ermittleMannschaftswert(gast))+1);
					if(zufall3 > ermittleMannschaftswert(heim)) {
						int zufall4 = random.nextInt(heim.getSpieler().size());
						if(erzieltTor(spiel.getHeim().getSpieler().get(zufall4), torwartG) == true) {
							spiel.getHeim().getSpieler().get(zufall4)
							.setTore(spiel.getHeim().getSpieler().get(zufall4).getTore()+1);

							spiel.getErgebnis().addToreHeim();
							spiel.getSpielbericht().append(spielmoment + ": Tor durch " + spiel.getHeim().getSpieler().get(zufall4).getName() + "\n"); 
						}
						else {
							spiel.getSpielbericht().append(spielmoment + ": Tor gehalten durch " + spiel.getHeim().getTorwart1().getName() + "\n");
							zufall4 = 0;
						}

					}
					else {
						int zufall4 = random.nextInt(gast.getSpieler().size());
						if(erzieltTor(spiel.getGast().getSpieler().get(zufall4), torwartH) == true) {
							spiel.getGast().getSpieler().get(zufall4)
							.setTore(spiel.getHeim().getSpieler().get(zufall4).getTore()+1);
							spiel.getErgebnis().addToreGast();
							spiel.getSpielbericht().append(spielmoment + ": Tor durch " + spiel.getGast().getSpieler().get(zufall4).getName() + "\n");
						}
						else {
							spiel.getSpielbericht().append(spielmoment + ": Tor gehalten durch " + spiel.getGast().getTorwart1().getName() + "\n");
							zufall4 = 0;
						}
					}
				}

			}
		}
		spiel.getSpielbericht().append("Abfiff\n");
		spiel.getSpielbericht().append("Ergebnis: " + spiel.getErgebnis().getToreHeim() + " : " + spiel.getErgebnis().getToreGast());
		System.out.println(spiel.getSpielbericht());
	}



}
