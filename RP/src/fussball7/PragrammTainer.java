package fussball7;

public class PragrammTainer {

	public static void main(String[] args) throws ClassNotFoundException, DaoException {

		
		try {
			Torwart torwart = new TorwartDao().read(1);
			System.out.println(torwart);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Spieler spieler1 = new SpielerDao().read(3);
			System.out.println(spieler1);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Trainer trainer2 = new TrainerDao().read(3);
			System.out.println(trainer2);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Mannschaft mannschaft = new MannschaftDao().read(1);
			System.out.println("\n\n" + mannschaft);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

}
