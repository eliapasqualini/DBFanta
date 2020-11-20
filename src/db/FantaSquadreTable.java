package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.FantaSquadra;

public class FantaSquadreTable {
	
    private DBConnection conn;
    private String tableName;
	
    public FantaSquadreTable() {
        conn = new DBConnection();
        tableName = "[FANTA-SQUADRA]";
    }

    public List<FantaSquadra> selectNameFantaSquadre(String lega) {

        List<FantaSquadra> nomi = null;
	FantaSquadra nome = null;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT S.Nome FROM " + tableName+ " S, [FANTA-LEGHE] L"
				+ " WHERE S.[Fanta-Lega] = L.[ID-Lega] AND L.Nome = '"+lega+"';";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
		    nomi = new LinkedList<FantaSquadra>();
		    nome = new FantaSquadra();
		    nome.setNome(result.getString("Nome"));
		    nomi.add(nome);
		}
		while(result.next()) {
		    nome = new FantaSquadra();
		    nome.setNome(result.getString("Nome"));
		    nomi.add(nome);
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
	return nomi;
    }     
	
    public int numeroPartiteGiocate(int lega) {
		
	int partite = 0;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT DISTINCT S.[Partite giocate] FROM " + tableName+ " S"
			+ " WHERE [Fanta-Lega] = "+lega+";";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
		    partite = result.getInt("Partite giocate");
		}
		while(result.next()) {
		    partite=result.getInt("Partite giocate");
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
	return partite;
    }
	
    public void insertFantaSquadra(String nome,Integer idAllenatore, Integer idLega) {
	    
	        Connection connection = this.conn.getAccessConnection();
	        PreparedStatement statement = null;
	        String insert = "INSERT INTO " + tableName+" (Nome,[Fanta-Allenatore], [Fanta-Lega]) VALUES ('"+nome+"',"+idAllenatore+", "+ idLega+");";
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
    
    public void updateVittora(String fantaS, int lega, String string) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE [FANTA-SQUADRA] " + 
				"SET [Partite giocate] = [Partite giocate] + 1, Vittorie = Vittorie + 1, "
				+ "Sconfitte = Sconfitte + 0, Pareggi = Pareggi + 0,  Punteggio = Punteggio + '"+string+"'" + 
				" WHERE Nome = '"+fantaS+"'" + 
				"AND [Fanta-Lega] = "+lega+";";
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
    
    public void updateSconfitta(String fantaS, int lega, String string) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE [FANTA-SQUADRA] " + 
				"SET [Partite giocate] = [Partite giocate] + 1, Vittorie = Vittorie + 0, Sconfitte = Sconfitte + 1, Pareggi = Pareggi + 0,  Punteggio = Punteggio + '"+string+"' WHERE Nome = '"+fantaS+"' AND [Fanta-Lega] = "+lega+";";
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
    

	public void updatePareggio(String fantaS, int lega, String punteggio) {
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE [FANTA-SQUADRA] " + 
				"SET [Partite giocate] = [Partite giocate] + 1, Vittorie = Vittorie + 0, "
				+ "Sconfitte = Sconfitte + 0, Pareggi = Pareggi + 1,  Punteggio = Punteggio + '"+punteggio+"'" + 
				" WHERE Nome = '"+fantaS+"'" + 
				"AND [Fanta-Lega] = "+lega+";";
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
