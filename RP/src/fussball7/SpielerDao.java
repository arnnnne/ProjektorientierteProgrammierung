package fussball7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpielerDao{
		
		private final String CLASSNAME = "org.sqlite.JDBC";
		private final String CONNECTIONSTRING = "jdbc:sqlite:Fussball.db";
		
		public SpielerDao() throws ClassNotFoundException {
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
		public Spieler read(int id) throws DaoException, ClassNotFoundException{
			Spieler spieler = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			// Verbindung zu DB herstellen
			try {
				connection = DriverManager.getConnection(CONNECTIONSTRING);
				// liefert connection-Objekt, das die Verbindung repräsentiert
				
				// SQL-Abfrage erstellen
				String sql = "SELECT * FROM Spieler WHERE id = ?";
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				//SQL-Abfrage ausführen
				ResultSet resultSet = preparedStatement.executeQuery();
				
				// Zeiger auf den ersten Datensatz stellen
				resultSet.next();
			
				
				spieler = createObject(resultSet);
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException("Spieler kann nicht gefunden werden");
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
			
			return spieler;
			
			
		}
		
		private Spieler createObject(ResultSet resultSet) throws SQLException, ClassNotFoundException, DaoException {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("Name");
			int alter = resultSet.getInt("Alter");
			int staerke = resultSet.getInt("Staerke");
			int torschuss = resultSet.getInt("Torschuss");
			int motivation = resultSet.getInt("Motivation");
			int tore = resultSet.getInt("Tore");
			int mannschaftID = resultSet.getInt("Mannschaft_ID");
			Spieler spieler = new Spieler(id, name, alter, staerke, torschuss, motivation, tore, mannschaftID);
			spieler.setId(id);
			return spieler;
		}
		
		public ArrayList<Spieler> readTeam(int id) throws DaoException, SQLException, ClassNotFoundException {
			ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				// liefert connection-Objekt, das die Verbindung repräsentiert
				connection = DriverManager.getConnection(CONNECTIONSTRING);
				
				// SQL-Abfrage erstellen
				String sql = "SELECT * FROM Spieler WHERE Mannschaft_ID = ?";
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				
				//SQL-Abfrage ausführen
				ResultSet resultSet = preparedStatement.executeQuery();
				
				// Zeiger auf den ersten Datensatz stellen
				while(resultSet.next()) {
					Spieler spieler = createObject(resultSet);
					spielerListe.add(spieler);
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DaoException("Spielerliste kann nicht gefunden werden.");
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
			return spielerListe;
			
		}
	}


