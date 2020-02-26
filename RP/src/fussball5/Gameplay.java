package fussball5;

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
	
	public static void spielen(Spiel spiel, Mannschaft heim, Mannschaft gast, Trainer trainerH, Trainer trainerG, Torwart torwartH, Torwart torwartG) {
		Random random = new Random();
		int zufall = random.nextInt(maxNach+1);
		int maxSpielzeit = spielzeit + zufall;
		int toreHeim = 0;
		int toreGast = 0;
		Ergebnis ergebnis = new Ergebnis(toreHeim, toreGast);
		StringBuilder spielbericht = new StringBuilder();
		spielbericht.append("Anpfiff!!\n");
		int spielmoment = 0;
		
		for (int i = 0; i < maxSpielzeit; i++) {
			int zufall2 = random.nextInt(dauerBisAktion)+1;
			spielmoment = spielmoment + zufall2;
			if(spielmoment < maxSpielzeit) {
			
			
			int zufall3 = random.nextInt((ermittleMannschaftswert(heim)
					+ermittleMannschaftswert(gast))+1);
			if(zufall3 > ermittleMannschaftswert(heim)) {
				int zufall4 = random.nextInt(heim.getSpieler().size());
				if(erzieltTor(spiel.getHeim().getSpieler().get(zufall4), torwartG) == true) {
					spiel.getHeim().getSpieler().get(zufall4)
					.setTore(spiel.getHeim().getSpieler().get(zufall4).getTore()+1);
					
					ergebnis.addToreHeim();
					spielbericht.append(spielmoment + ": Tor durch " + spiel.getHeim().getSpieler().get(zufall4).getName() + "\n"); 
				}
				else {
					spielbericht.append(spielmoment + ": Tor gehalten durch " + spiel.getHeim().getTorwart1().getName() + "\n");
					zufall4 = 0;
				}
				
			}
			else {
				int zufall4 = random.nextInt(gast.getSpieler().size());
				if(erzieltTor(spiel.getGast().getSpieler().get(zufall4), torwartH) == true) {
					spiel.getGast().getSpieler().get(zufall4)
					.setTore(spiel.getHeim().getSpieler().get(zufall4).getTore()+1);
					ergebnis.addToreGast();
					spielbericht.append(spielmoment + ": Tor durch " + spiel.getGast().getSpieler().get(zufall4).getName() + "\n");
				}
				else {
					spielbericht.append(spielmoment + ": Tor gehalten durch " + spiel.getGast().getTorwart1().getName() + "\n");
					zufall4 = 0;
				}
			}
			}
			
			}
		spielbericht.append("Abfiff\n");
		spielbericht.append("Ergebnis: " + ergebnis.getToreHeim() + " : " + ergebnis.getToreGast());
		System.out.println(spielbericht);
	
	
	}
	

}
