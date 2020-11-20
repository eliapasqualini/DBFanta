package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.InserimentoDifensore;

public class DifensoreTable {
    private DBConnection conn;
    private String tableName;
    
    public DifensoreTable() {
            conn = new DBConnection();
            tableName = "[DIFENSORI]";
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
    
	public void insertDifensoreFantaFormazione(int difensore, int formazione) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String insert = "INSERT INTO [INSERIMENTO_DIFENSORI] (Difensore, [Fanta-Formazione]) VALUES ("+difensore+", "+formazione+");";
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
	
	public void insertDifensoreRosa(int lega, int calciatore, String fantaS) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String insert = "INSERT INTO [DIFENSORI] ([Fanta-Lega], Calciatore, [Fanta-Squadra]) VALUES ("+lega+", "+calciatore+", '"+fantaS+"');";
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
	

    public int selectIdDifensore(String squadra, int calciatore) {
    	
	int idDifensore = 0;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT [ID-Fanta-Calciatore] FROM " + tableName+
			" WHERE [Fanta-Squadra] = '" +squadra+"' AND Calciatore = "+calciatore+";";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
			idDifensore = result.getInt("ID-Fanta-Calciatore");
		}
		while(result.next()) {
			idDifensore = result.getInt("ID-Fanta-Calciatore");
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
	return idDifensore;
    }
    
    public String selectFromInserimento(int idFantaCalciatore) {
    	
	String cognome = null;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT C.Cognome FROM "+tableName+" A, CALCIATORI C, [INSERIMENTO_DIFENSORI] I "
			+ "WHERE I.Difensore = A.[ID-Fanta-Calciatore] "
			+ "AND C.[ID-Calciatore] = A.Calciatore "
			+ "AND I.Difensore = "+idFantaCalciatore+";";
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
    	String select = "SELECT Difensore FROM [INSERIMENTO_DIFENSORI] WHERE [Fanta-Formazione] = "+fantaFormazione+" ORDER BY Difensore ASC;";
    	try {
    		statement = connection.prepareStatement(select);
    		result= statement.executeQuery();
    		if (result.next()) {
    			listCalc = new LinkedList<>();
    			id = 0;
    			id = result.getInt("Difensore");
    			listCalc.add(id);
    		} while (result.next()) {
    			id = 0;
    			id = result.getInt("Difensore");
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
		String update = "UPDATE [INSERIMENTO_DIFENSORI] " + 
				"SET Voto = '"+voto+"', Gol = "+gol+", Assist = "+assist+", [Cartellini gialli] = "+cg+", [Cartellini rossi] = "+cr+""
						+ " WHERE Difensore = "+fantacalc+";";
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
    
    public List<InserimentoDifensore> selectInserimenti(int idFormazione) {
        
    List<InserimentoDifensore> list = null;
	InserimentoDifensore id= null;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT * FROM [INSERIMENTO_DIFENSORI] "
			+ "WHERE [Fanta-Formazione] = "+idFormazione+" ORDER BY Difensore ASC;";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
			list = new LinkedList<>();
			id = new InserimentoDifensore();
			id.setFantaFormazione(result.getInt("Fanta-Formazione"));
			id.setAssist(result.getInt("Assist"));
			id.setDifensore(result.getInt("Difensore"));
			id.setCartelliniGialli(result.getInt("Cartellini gialli"));
			id.setCartelliniRossi(result.getInt("Cartellini rossi"));
			id.setGol(result.getInt("Gol"));
			id.setVoto(result.getString("Voto"));
			list.add(id);
		} while (result.next()) {
			id = new InserimentoDifensore();
			id.setFantaFormazione(result.getInt("Fanta-Formazione"));
			id.setAssist(result.getInt("Assist"));
			id.setDifensore(result.getInt("Difensore"));
			id.setCartelliniGialli(result.getInt("Cartellini gialli"));
			id.setCartelliniRossi(result.getInt("Cartellini rossi"));
			id.setGol(result.getInt("Gol"));
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
    
    public void updateDifensore(int fantacalc, int gol, int assist) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE " +tableName+
				"SET Gol = Gol + "+gol+", Assist = Assist + "+assist+""
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
