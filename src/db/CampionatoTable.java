package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampionatoTable {
	
	private DBConnection conn;
	private String tableName;
	
	public CampionatoTable() {
		conn = new DBConnection();
		tableName = "[CAMPIONATI]";
	}
	
	public List<String> selectCampionati() {
		List<String> campionati = null;
		String campionato = null;
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String select = "SELECT Nome FROM " + tableName+";";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if(result.next()) {
		campionati = new ArrayList<>();
		campionato = "";
		campionato = result.getString("Nome");
		campionati.add(campionato);
		}
		while (result.next()) {
			campionato = "";
			campionato = result.getString("Nome");
			campionati.add(campionato);
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
	return campionati;
		
	}
	
	public int selectIDCampionato(String camp) {
		int idCampionato = 0;
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String select = "SELECT [ID-Campionato] FROM " + tableName+" WHERE Nome = '"+camp+"';";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if(result.next()) {
			idCampionato = result.getInt("ID-Campionato");
		}
		while (result.next()) {
			idCampionato = result.getInt("ID-Campionato");
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
	return idCampionato;
		
	}

}
