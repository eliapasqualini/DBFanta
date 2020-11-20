package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.FantaSquadra;

public class ClassificaTable {
	
	private DBConnection conn;
	private String tableName;
	
	public ClassificaTable() {
		conn = new DBConnection();
		tableName = "[FANTA-SQUADRA]";
	}
	
	public List<FantaSquadra> selectTable(int lega) {
		List<FantaSquadra> classificaList = null;
		FantaSquadra fantaSquadra = null;
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String select = "SELECT S.Nome, S.[Partite giocate], S.Vittorie, S.Pareggi, S.Sconfitte, S.Punti, S.Punteggio "
				+ "      FROM "+tableName+" S WHERE S.[Fanta-Lega] = "+lega+" ORDER BY Punti DESC, Punteggio DESC";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
			if (result.next()) {
				classificaList = new LinkedList<FantaSquadra>();
				fantaSquadra = new FantaSquadra();
				fantaSquadra.setNome(result.getString("Nome"));
				fantaSquadra.setPartiteGiocate(result.getInt("Partite Giocate"));
				fantaSquadra.setVittorie(result.getInt("Vittorie"));
				fantaSquadra.setPareggi(result.getInt("Pareggi"));
				fantaSquadra.setSconfitte(result.getInt("Sconfitte"));
				fantaSquadra.setPunti(result.getInt("Punti"));
				fantaSquadra.setPunteggio(result.getString("Punteggio"));
				classificaList.add(fantaSquadra);
			}
			while(result.next()) {
				fantaSquadra = new FantaSquadra();
				fantaSquadra.setNome(result.getString("Nome"));
				fantaSquadra.setPartiteGiocate(result.getInt("Partite Giocate"));
				fantaSquadra.setVittorie(result.getInt("Vittorie"));
				fantaSquadra.setPareggi(result.getInt("Pareggi"));
				fantaSquadra.setSconfitte(result.getInt("Sconfitte"));
				fantaSquadra.setPunti(result.getInt("Punti"));
				fantaSquadra.setPunteggio(result.getString("Punteggio"));
				classificaList.add(fantaSquadra);
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
		return classificaList;

		
	}


}
