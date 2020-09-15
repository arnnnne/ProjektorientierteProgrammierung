package fussball7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MannschaftDao {
	
	private final String CLASSNAME = "org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:Fussball.db";
	
	public MannschaftDao() throws ClassNotFoundException {
		Class.forName(CLASSNAME);		
	}

	// folgende Tätigkeiten sind bei Datenbankverbindungen bei Java erforderlich:
	// - JDBC-Treiber laden
	// - Verbindung zur Datenbank herstellen
	// - SQL-Anweisung an die DB senden und diese ausführen
	// - Ergebnisse in Form einer Ergebniss-Tabelle (ResultSet) verarbeitet
	
	/**
	 * Holt einen Trainer aus der Datenbank
	 * @throws ClassNotFoundException 
	 * @ param id Die ID des gesuchten Trainers
	 * @ return Der gesuchte Trainer oder NULL
	 * @ throws DaoException
	 */
	public Mannschaft read(int mannschaftID) throws DaoException, ClassNotFoundException{
		
		Mannschaft mannschaft  = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		// Verbindung zu DB herstellen
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			// liefert connection-Objekt, das die Verbindung repräsentiert
			
			// SQL-Abfrage erstellen
			String sql = "SELECT * FROM Mannschaft WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mannschaftID);
			
			//SQL-Abfrage ausführen
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Zeiger auf den ersten Datensatz stellen
			resultSet.next();
			
			// gesuchte Mannschaft erstellen
			mannschaft = createObject(resultSet);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Mannschaft kann nicht gefunden werden");
		}
		
		finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		return mannschaft;
		
		
	}
	

	private Mannschaft createObject(ResultSet resultSet) throws SQLException, ClassNotFoundException, DaoException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		
		int idTrainer = resultSet.getInt("Trainer_ID");
		Trainer trainer = new TrainerDao().read(idTrainer);
		
		int idTorwart = resultSet.getInt("Torwart_ID");
		Torwart torwart = new TorwartDao().read(idTorwart);
		
		ArrayList<Spieler> spielerListe = new SpielerDao().readTeam(id);
		
		Mannschaft mannschaft = new Mannschaft(id, name, trainer, torwart, spielerListe);
		mannschaft.setId(id);
		
		return mannschaft;
		
	}
}

