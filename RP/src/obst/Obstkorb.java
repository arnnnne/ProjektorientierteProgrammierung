package obst;

import java.util.ArrayList;

public class Obstkorb {

	private ArrayList<Obst> korb;

	public Obstkorb() {
		korb = new ArrayList<Obst>();
	}

	/**
	 * F�gt dem Korb ein neues St�ck Obst hinzu
	 * @param stueckObst	Das hinzuf�gende St�ck Obst
	 */
	public void hinzufuegen(Obst stueckObst) {
		korb.add(stueckObst);
	}

	/**
	 * Entfernt ein St�ck Obst aus dem Obstkorb
	 * @param stueckObst	Das zu entnehmende St�ck Obst
	 * @return				Das enternte St�ck Obst
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
		for (Obst obst : korb) {	//F�r jedes Element "obst" vom Typ "Obst" aus "korb" machen
			inhalt = inhalt + "\t" + obst.getName();
		}
		return inhalt;
	}

}
