package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.FantaAllenatore;

public class FantaAllenatoriTable {
	
	private DBConnection conn;
	private String tableName;
	
	public FantaAllenatoriTable() {
		conn = new DBConnection();
		tableName = "[FANTA-ALLENATORI]";
	}
		public List<FantaAllenatore> selectFantaAllenatori() {
		
			List<FantaAllenatore> allenatori = null;
			FantaAllenatore allenatore = null;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT Nome, Cognome FROM " + tableName;
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
				if (result.next()) {
					allenatori = new LinkedList<FantaAllenatore>();
					allenatore = new FantaAllenatore();
					allenatore.setNome(result.getString("Nome"));
					allenatore.setCognome(result.getString("Cognome"));
					allenatori.add(allenatore);
				}
				while(result.next()) {
					allenatore = new FantaAllenatore();
					allenatore.setNome(result.getString("Nome"));
					allenatore.setCognome(result.getString("Cognome"));
					allenatori.add(allenatore);
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
		return allenatori;
		}
		
		public void insertFantaAllenatore(String nome, String cognome) {
                    
                    Connection connection = this.conn.getAccessConnection();
                    PreparedStatement statement = null;
                    String insert = "INSERT INTO " + tableName+" (Nome, Cognome) VALUES ('"+nome+"', '"+ cognome+"');";
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
		
		public int selectIdAllenatore(String nome, String cognome) {
            int id = 0;
            Connection connection = this.conn.getAccessConnection();
            PreparedStatement statement = null;
            ResultSet result = null;
            String select = "SELECT [ID-Allenatore] FROM " + tableName+" WHERE Nome = '"+nome+"' AND Cognome = '"+ cognome+"';";
            try {
                statement = connection.prepareStatement(select);
                result = statement.executeQuery();
                if (result.next()) {
                id = result.getInt("ID-Allenatore");
                } while (result.next()) {
                	id = result.getInt("ID-Allenatore");
                }
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
        return id;
    }

		
		

}
