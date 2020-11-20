package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LegheTable {
	
		private DBConnection conn;
		private String tableName;
		
		public LegheTable() {
			conn = new DBConnection();
			tableName = "[FANTA-LEGHE]";
		}
		public List<String> selectLegheName() {
		
			List<String> nomiLeghe = null;
			String nome = null;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT Nome FROM " + tableName;
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
				if (result.next()) {
					nomiLeghe = new LinkedList<String>();
					nome = result.getString("Nome");
					nomiLeghe.add(nome);
				}
				while(result.next()) {
					nome=result.getString("Nome");
					nomiLeghe.add(nome);
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
		return nomiLeghe;

	
	}
		
		public int selectIDLega(String lega) {
			int id = 0;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT [ID-Lega] FROM " + tableName+" WHERE Nome = '"+lega+"';";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
			if(result.next()) {
			id = result.getInt("ID-Lega");
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
		return id;
			
		}
		
		public void insertLega(String nome, Integer idCampionato) {
		        
		        Connection connection = this.conn.getAccessConnection();
	                PreparedStatement statement = null;
	                String insert = "INSERT INTO " + tableName+" (Nome, Campionato) VALUES ('"+nome+"', "+idCampionato+");";
	                try {
	                    statement = connection.prepareStatement(insert);
	                    statement.executeUpdate();
	            }
	            catch (SQLException e) {
	            
	            }
	            finally {

	                    // Step 3: Closing database connection
	                    try {
	                            if(null != connection) {

	                                    // cleanup resources, once after processing
	                                    statement.close();

	                                    // and then finally close connection
	                                    connection.close();
	                            }
	                    }
	                    catch (SQLException sqlex) {
	                            sqlex.printStackTrace();
	                    }
	            
	            }
		}

}
