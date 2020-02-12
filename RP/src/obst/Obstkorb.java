package obst;

import java.util.ArrayList;

public class Obstkorb {

	private ArrayList<Obst> korb;

	public Obstkorb() {
		korb = new ArrayList<Obst>();
	}

	/**
	 * Fügt dem Korb ein neues Stück Obst hinzu
	 * @param stueckObst	Das hinzufügende Stück Obst
	 */
	public void hinzufuegen(Obst stueckObst) {
		korb.add(stueckObst);
	}

	/**
	 * Entfernt ein Stück Obst aus dem Obstkorb
	 * @param stueckObst	Das zu entnehmende Stück Obst
	 * @return				Das enternte Stück Obst
	 */
	public Obst entnehmen(Obst stueckObst) {
		boolean entfernt = korb.remove(stueckObst);
		if(entfernt == true) {
			return stueckObst;
		}
		else {
			return null;
		}
	}
	
	public int getAnzahl() {
		return korb.size();
	}
	
	/**
	 * Liefert den Inhalt des Obstkorbs 
	 * @return	Der Inhalt des Obstkorbs
	 */
	public String getInhalt() {
		String inhalt = "";
		for (Obst obst : korb) {	//Für jedes Element "obst" vom Typ "Obst" aus "korb" machen
			inhalt = inhalt + "\t" + obst.getName();
		}
		return inhalt;
	}

}
