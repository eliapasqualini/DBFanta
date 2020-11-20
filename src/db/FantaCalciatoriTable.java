package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Calciatore;

public class FantaCalciatoriTable {
	private DBConnection conn;
	private String tableName;
	
	public FantaCalciatoriTable() {
		conn = new DBConnection();
		tableName = "[CALCIATORI]";
	}
		public List<Calciatore> selectAttaccanti(int lega, String fantaSquadra) {
		
			List<Calciatore> attaccanti = null;
			Calciatore calciatore = null;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT C.Nome, C.Cognome, C.Ruolo " + 
					"FROM "+tableName+" C, ATTACCANTI A " + 
					"WHERE C.[ID-Calciatore] = A.Calciatore " + 
					"AND A.[Fanta-Lega] = " + lega+
					" AND A.[Fanta-Squadra] = '" +fantaSquadra+"';";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
				if (result.next()) {
					attaccanti = new LinkedList<>();
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					attaccanti.add(calciatore);
				}
				while(result.next()) {
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					attaccanti.add(calciatore);
				}
		}
		catch (SQLException e) {
		
		}
		finally {
	
			// Step 3: Closing database connection
			try {
				if(null != connection) {
	
					// cleanup resources, once after processing
					result.close();
					statement.close();
	
					// and then finally close connection
					connection.close();
				}
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		
		}
		return attaccanti;
	
	
	}
		
		public List<Calciatore> selectCentrocampisti(int lega, String fantaSquadra) {
			
			List<Calciatore> centrocampisti = null;
			Calciatore calciatore = null;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT C.Nome, C.Cognome, C.Ruolo " + 
					"FROM "+tableName+" C, CENTROCAMPISTI A " + 
					"WHERE C.[ID-Calciatore] = A.Calciatore " + 
					"AND A.[Fanta-Lega] = " + lega+
					" AND A.[Fanta-Squadra] = '" +fantaSquadra+"';";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
				if (result.next()) {
					centrocampisti = new LinkedList<>();
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					centrocampisti.add(calciatore);
				}
				while(result.next()) {
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					centrocampisti.add(calciatore);
				}
		}
		catch (SQLException e) {
		
		}
		finally {
	
			// Step 3: Closing database connection
			try {
				if(null != connection) {
	
					// cleanup resources, once after processing
					result.close();
					statement.close();
	
					// and then finally close connection
					connection.close();
				}
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		
		}
		return centrocampisti;
	
	
	}
		
		public List<Calciatore> selectDifensori(int lega, String fantaSquadra) {
			
			List<Calciatore> difensori = null;
			Calciatore calciatore = null;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT C.Nome, C.Cognome, C.Ruolo " + 
					"FROM "+tableName+" C, DIFENSORI A " + 
					"WHERE C.[ID-Calciatore] = A.Calciatore " + 
					"AND A.[Fanta-Lega] = " + lega+
					" AND A.[Fanta-Squadra] = '" +fantaSquadra+"';";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
				if (result.next()) {
					difensori = new LinkedList<>();
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					difensori.add(calciatore);
				}
				while(result.next()) {
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					difensori.add(calciatore);
				}
		}
		catch (SQLException e) {
		
		}
		finally {
	
			// Step 3: Closing database connection
			try {
				if(null != connection) {
	
					// cleanup resources, once after processing
					result.close();
					statement.close();
	
					// and then finally close connection
					connection.close();
				}
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		
		}
		return difensori;	
	}
		
		public List<Calciatore> selectPortieri(int lega, String fantaSquadra) {
			
			List<Calciatore> portieri = null;
			Calciatore calciatore = null;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT C.Nome, C.Cognome, C.Ruolo " + 
					"FROM "+tableName+" C, PORTIERI A " + 
					"WHERE C.[ID-Calciatore] = A.Calciatore " + 
					"AND A.[Fanta-Lega] = " + lega+
					" AND A.[Fanta-Squadra] = '" +fantaSquadra+"';";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
				if (result.next()) {
					portieri = new LinkedList<>();
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					portieri.add(calciatore);
				}
				while(result.next()) {
					calciatore = new Calciatore();
					calciatore.setNome(result.getString("Nome"));
					calciatore.setCognome(result.getString("Cognome"));
					calciatore.setRuolo(result.getString("Ruolo"));
					portieri.add(calciatore);
				}
		}
		catch (SQLException e) {
		
		}
		finally {
	
			// Step 3: Closing database connection
			try {
				if(null != connection) {
	
					// cleanup resources, once after processing
					result.close();
					statement.close();
	
					// and then finally close connection
					connection.close();
				}
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		
		}
		return portieri;	
	}
		
		public List<List<Calciatore>> selectFantaCalciatori(int lega, String fantaSquadra) {
			List<List<Calciatore>> fantaCalciatori = new LinkedList<>();
			fantaCalciatori.add(selectAttaccanti(lega,fantaSquadra));
			fantaCalciatori.add(selectCentrocampisti(lega,fantaSquadra));
			fantaCalciatori.add(selectDifensori(lega,fantaSquadra));
			fantaCalciatori.add(selectPortieri(lega,fantaSquadra));
			return fantaCalciatori;
		}
		
		
}
