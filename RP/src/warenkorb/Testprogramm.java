package warenkorb;

import java.util.ArrayList;

public class Testprogramm {

	public static void main(String[] args) throws WareNichtGefundenException {
		Adresse adresseKunde1 = new Adresse("Teststrasse", "1B", "28211", "Bremen");
		Kunde kunde1 = new Kunde("Juergen", "Possehl", adresseKunde1);

		
		
		Buch buch1 = new Buch("0", "Harry Potter 1", 15.99, 2.70, "XBM11");
		Buch buch2 = new Buch("1", "Harry Potter 2", 15.99, 2.70, "XBM12");
		DVD dvd1 = new DVD("2", "Harry Potter 1", 25.99, 4.70, 130);
		DVD dvd2 = new DVD("3", "Harry Potter 2", 25.99, 4.70, 120);
		ArrayList<Ware> warenListe = new ArrayList<Ware>();
		Warenkorb warenkorbKunde1 = new Warenkorb(kunde1, warenListe);
		warenkorbKunde1.addWare(buch1);
		warenkorbKunde1.addWare(buch2);
		warenkorbKunde1.addWare(dvd1);
		warenkorbKunde1.addWare(dvd2);
		
		System.out.println(warenkorbKunde1.toString());
		
		warenkorbKunde1.removeWare(dvd2);
		
		System.out.println(warenkorbKunde1.toString());
		
		try {
			warenkorbKunde1.getWare("3");
		} catch (WareNichtGefundenException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
	}

}
