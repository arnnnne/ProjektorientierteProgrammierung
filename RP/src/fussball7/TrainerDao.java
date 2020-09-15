package fussball7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerDao {
	
	private final String CLASSNAME = "org.sqlite.JDBC";
	private final String CONNECTIONSTRING = "jdbc:sqlite:Fussball.db";
	
	public TrainerDao() throws ClassNotFoundException {
		Class.forName(CLASSNAME);		
	}

	// folgende Tätigkeiten sind bei Datenbankverbindungen bei Java erforderlich:
	// - JDBC-Treiber laden
	// - Verbindung zur Datenbank herstellen
	// - SQL-Anweisung an die DB senden und diese ausführen
	// - Ergebnisse in Form einer Ergebniss-Tabelle (ResultSet) verarbeitet
	
	/**
	 * Holt einen Trainer aus der Datenbank
	 * @ param id Die ID des gesuchten Trainers
	 * @ return Der gesuchte Trainer oder NULL
	 * @ throws DaoException
	 */
	public Trainer read(int id) throws DaoException{
		Trainer trainer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		// Verbindung zu DB herstellen
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING);
			// liefert connection-Objekt, das die Verbindung repräsentiert
			
			// SQL-Abfrage erstellen
			String sql = "SELECT * FROM Trainer WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			//SQL-Abfrage ausführen
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Zeiger auf den ersten Datensatz stellen
			resultSet.next();
			
			// gesuchten Trainer erstellen
			id = resultSet.getInt("id");
			String name = resultSet.getString("Name");
			int alter = resultSet.getInt("Alter");
			int erfahrung = resultSet.getInt("Erfahrung");
			trainer = new Trainer(id, name, alter, erfahrung);
			trainer.setId(id);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new DaoException("Trainer kann nicht gefunden werden");
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
		
		return trainer;
		
		
	}
	
	public void update(Trainer trainer) throws DaoException, SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		connection = DriverManager.getConnection(CONNECTIONSTRING);
		String sql = "UPDATE Trainer SET Name = ?, \"Alter\" = ?, Erfahrung = ? WHERE ID = ?";
		
	}
}

