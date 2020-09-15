package fussball7;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

public class TorwartDao {

	
		
		private final String CLASSNAME = "org.sqlite.JDBC";
		private final String CONNECTIONSTRING = "jdbc:sqlite:Fussball.db";
		
		public TorwartDao() throws ClassNotFoundException {
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
		public Torwart read(int id) throws DaoException{
			Torwart torwart = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			// Verbindung zu DB herstellen
			try {
				connection = DriverManager.getConnection(CONNECTIONSTRING);
				// liefert connection-Objekt, das die Verbindung repräsentiert
				
				// SQL-Abfrage erstellen
				String sql = "SELECT * FROM Torwart WHERE id = ?";
				
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
				int staerke = resultSet.getInt("Staerke");
				int motivation = resultSet.getInt("Motivation");
				int reaktion = resultSet.getInt("Reaktion");
				int torschuss = resultSet.getInt("Torschuss");
				torwart = new Torwart(id, name, alter, staerke, torschuss, motivation, reaktion);
				torwart.setId(id);
				
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
			
			return torwart;
			
			
		}
	}