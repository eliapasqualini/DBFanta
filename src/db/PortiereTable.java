package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.InserimentoPortiere;

public class PortiereTable {
    private DBConnection conn;
    private String tableName;
    
    public PortiereTable() {
            conn = new DBConnection();
            tableName = "[PORTIERI]";
    }
    
    public List<Integer> selectIdCalciatore(String squadra, Integer idLega) {
        List<Integer> id = new ArrayList<>();
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        String select = "SELECT [Calciatore] FROM " + tableName+" WHERE [Fanta-Squadra] = '"+squadra+"' AND [Fanta-Lega] = "+idLega+";";
        try {
            statement = connection.prepareStatement(select);
            result= statement.executeQuery();
            if(result.next()) {
                id.add(result.getInt("Calciatore"));
            }
            while(result.next()) {
                id.add(result.getInt("Calciatore"));
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
    
	public void insertPortiereFantaFormazione(int portiere, int formazione) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String insert = "INSERT INTO [INSERIMENTO_PORTIERI] (Portiere, [Fanta-Formazione]) VALUES ("+portiere+", "+formazione+");";
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
	
	public void insertPortiereRosa(int lega, int calciatore, String fantaS) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String insert = "INSERT INTO [PORTIERI] ([Fanta-Lega], Calciatore, [Fanta-Squadra]) VALUES ("+lega+", "+calciatore+", '"+fantaS+"');";
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
	
	  public int selectIdPortiere(String squadra, int calciatore) {
	    	
			int idPortiere = 0;
			Connection connection = this.conn.getAccessConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			String select = "SELECT [ID-Fanta-Calciatore] FROM " + tableName+
					" WHERE [Fanta-Squadra] = '" +squadra+"' AND Calciatore = "+calciatore+";";
			try {
				statement = connection.prepareStatement(select);
				result= statement.executeQuery();
				if (result.next()) {
					idPortiere = result.getInt("ID-Fanta-Calciatore");
				}
				while(result.next()) {
					idPortiere = result.getInt("ID-Fanta-Calciatore");
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
			return idPortiere;
		    }
	 
	    public String selectFromInserimento(int idFantaCalciatore) {
	    	
	    	String cognome = null;
	    	Connection connection = this.conn.getAccessConnection();
	    	PreparedStatement statement = null;
	    	ResultSet result = null;
	    	String select = "SELECT C.Cognome FROM "+tableName+" A, CALCIATORI C, [INSERIMENTO_PORTIERI] I "
	    			+ "WHERE I.Portiere = A.[ID-Fanta-Calciatore] "
	    			+ "AND C.[ID-Calciatore] = A.Calciatore "
	    			+ "AND I.Portiere = "+idFantaCalciatore+";";
	    	try {
	    		statement = connection.prepareStatement(select);
	    		result= statement.executeQuery();
	    		if (result.next()) {
	    			cognome = result.getString("Cognome");
	    		} while (result.next()) {
	    			cognome = result.getString("Cognome");
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
	    	return cognome;
	        }
	    
	    public List<Integer> selectListFromInserimento(int fantaFormazione){
	    	List<Integer> listCalc = null;
	    	int id = 0;
	    	Connection connection = this.conn.getAccessConnection();
	    	PreparedStatement statement = null;
	    	ResultSet result = null;
	    	String select = "SELECT Portiere FROM [INSERIMENTO_PORTIERI] WHERE [Fanta-Formazione] = "+fantaFormazione+";";
	    	try {
	    		statement = connection.prepareStatement(select);
	    		result= statement.executeQuery();
	    		if (result.next()) {
	    			listCalc = new LinkedList<>();
	    			id = 0;
	    			id = result.getInt("Portiere");
	    			listCalc.add(id);
	    		} while (result.next()) {
	    			id = 0;
	    			id = result.getInt("Portiere");
	    			listCalc.add(id);
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
	    	return listCalc;
	    	
	    }
    public void updateInserimento(int fantacalc, String voto, int gol, int assist, int cg, int cr) {
    		
    		Connection connection = this.conn.getAccessConnection();
    		PreparedStatement statement = null;
    		String update = "UPDATE [INSERIMENTO_PORTIERI] " + 
    				"SET Voto = '"+voto+"', [Rigori parati] = "+gol+", [Gol subiti] = "+assist+", [Cartellini gialli] = "+cg+", [Cartellini rossi] = "+cr+""
    						+ " WHERE Portiere = "+fantacalc+";";
    	try {
    		statement = connection.prepareStatement(update);
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
    
    public Integer selectNumOfInserimento(int id){
        
        int num = 0;
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        String select = "SELECT COUNT(*) As Num FROM [INSERIMENTO_PORTIERI] WHERE [Fanta-Formazione] = "+ id +";";
        try {
                statement = connection.prepareStatement(select);
                result= statement.executeQuery();
                if (result.next()) {
                        
                        num = result.getInt("Num");
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
        return num;
        
    }
    
    public List<InserimentoPortiere> selectInserimenti(int idFormazione) {
        
    List<InserimentoPortiere> list = null;
	InserimentoPortiere id= null;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT * FROM [INSERIMENTO_PORTIERI] "
			+ "WHERE [Fanta-Formazione] = "+idFormazione+" ORDER BY Portiere ASC;";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
			list = new LinkedList<>();
			id = new InserimentoPortiere();
			id.setFantaFormazione(result.getInt("Fanta-Formazione"));
			id.setGolSubiti(result.getInt("Gol subiti"));
			id.setPortiere(result.getInt("Portiere"));
			id.setCartelliniGialli(result.getInt("Cartellini gialli"));
			id.setCartelliniRossi(result.getInt("Cartellini rossi"));
			id.setRigoriParati(result.getInt("Rigori Parati"));
			id.setVoto(result.getString("Voto"));
			list.add(id);
		} while (result.next()) {
			id = new InserimentoPortiere();
			id.setFantaFormazione(result.getInt("Fanta-Formazione"));
			id.setGolSubiti(result.getInt("Gol subiti"));
			id.setPortiere(result.getInt("Portiere"));
			id.setCartelliniGialli(result.getInt("Cartellini gialli"));
			id.setCartelliniRossi(result.getInt("Cartellini rossi"));
			id.setRigoriParati(result.getInt("Rigori Parati"));
			id.setVoto(result.getString("Voto"));
			list.add(id);
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
	return list;
    }
    
    public void updatePortiere(int fantacalc, int rg, int gs) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE " +tableName+
				"SET [Rigori parati] = [Rigori parati] + "+rg+", [Gol subiti] = [Gol subiti] + "+gs+""
						+ " WHERE [ID-Fanta-Calciatore] = "+fantacalc+";";
	try {
		statement = connection.prepareStatement(update);
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
