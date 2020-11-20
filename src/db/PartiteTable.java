package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Partita;

public class PartiteTable {
	
	private DBConnection conn;
	private String tableName;
	
	public PartiteTable(){
		conn = new DBConnection();
		tableName = "PARTITE";
	}
	
	public List<Partita> selectPartite(int giornata){
		List<Partita> partiteList = null;
		Partita partita = null;
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String select = "SELECT [Squadra casa], [Squadra trasferta], Campionato, Giornata FROM "+tableName+
		                  " WHERE Giornata = "+giornata+";";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
			if (result.next()) {
				partiteList = new ArrayList<>();
				partita = new Partita();
				partita.setSquadraCasa(result.getString("Squadra casa"));
				partita.setSquadraTrasferta(result.getString("Squadra trasferta"));
				partita.setCampionato(result.getInt("Campionato"));
				partita.setGiornata(result.getInt("Giornata"));
				partiteList.add(partita);
			}
			while (result.next()) {
				partita = new Partita();
				partita.setSquadraCasa(result.getString("Squadra casa"));
				partita.setSquadraTrasferta(result.getString("Squadra trasferta"));
				partita.setCampionato(result.getInt("Campionato"));
				partita.setGiornata(result.getInt("Giornata"));
				partiteList.add(partita);
			}
			
		}catch (SQLException e) {
			
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
		return partiteList;
	}
}
