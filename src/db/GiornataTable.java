package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GiornataTable {
	
	private DBConnection conn;
	private String tableName;
	
	public GiornataTable() {
		conn = new DBConnection();
		tableName = "GIORNATE";
	}
	
	public List<Integer> selectGiornate() {
		List<Integer> giornate = null;
		int giornata = 0;
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String select = "SELECT * FROM " + tableName;
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
			if (result.next()) {
				giornate = new LinkedList<Integer>();
				giornata = result.getInt("Numero");
				giornate.add(giornata);
			}
			while(result.next()) {
				giornata = result.getInt("Numero");
				giornate.add(giornata);
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
		return giornate;

		
	}

}
