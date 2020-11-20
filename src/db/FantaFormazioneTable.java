package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FantaFormazioneTable {
	
	private DBConnection conn;
	private String tableName;
	
	public FantaFormazioneTable() {
		conn = new DBConnection();
		tableName = "[FANTA-FORMAZIONE]";
	}
	
	public void insertFormazione(String squadra, int giornata) {
	
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String insert = "INSERT INTO " + tableName+" ([Fanta-Squadra], Giornata) VALUES ('"+squadra+"', "+giornata+");";
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
    public int selectIdFantaFormazione(String squadra, int giornata) {
    	
	int idFormazione = 0;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT [ID-Formazione] FROM " + tableName+
			" WHERE [Fanta-Squadra] = '" +squadra+"' AND Giornata = "+giornata+";";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
			idFormazione = result.getInt("ID-Formazione");
		}
		while(result.next()) {
			idFormazione = result.getInt("ID-Formazione");
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
	return idFormazione;
    }
    
    public void deleteAll(int fantaformazione) {
    	
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String deleteA = "DELETE * FROM [INSERIMENTO_ATTACCANTI] WHERE [Fanta-Formazione] = "+fantaformazione+";";
		String deleteC = "DELETE * FROM [INSERIMENTO_CENTROCAMPISTI] WHERE [Fanta-Formazione] = "+fantaformazione+";";
		String deleteD = "DELETE * FROM [INSERIMENTO_DIFENSORI] WHERE [Fanta-Formazione] = "+fantaformazione+";";
		String deleteP = "DELETE * FROM [INSERIMENTO_PORTIERI] WHERE [Fanta-Formazione] = "+fantaformazione+";";
	try {
		statement = connection.prepareStatement(deleteA);
		statement.executeUpdate();
		statement = connection.prepareStatement(deleteC);
		statement.executeUpdate();
		statement = connection.prepareStatement(deleteD);
		statement.executeUpdate();
		statement = connection.prepareStatement(deleteP);
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
    
    public String selectSquadra(int idFormazione) {
       	
    	String nome = null;
    	Connection connection = this.conn.getAccessConnection();
    	PreparedStatement statement = null;
    	ResultSet result = null;
    	String select = "SELECT [Fanta-Squadra] FROM " + tableName+
    			" WHERE [ID-Formazione] = "+idFormazione+";";
    	try {
    		statement = connection.prepareStatement(select);
    		result= statement.executeQuery();
    		if (result.next()) {
    			nome = result.getString("Fanta-Squadra");
    		}
    		while(result.next()) {
    			nome = result.getString("Fanta-Squadra");
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
    	return nome;
    }
    
    public int selectGiornata(int idFormazione) {
    	
	int giornata = 0;
	Connection connection = this.conn.getAccessConnection();
	PreparedStatement statement = null;
	ResultSet result = null;
	String select = "SELECT [Giornata] FROM " + tableName+
			" WHERE [ID-Formazione] = " +idFormazione+";";
	try {
		statement = connection.prepareStatement(select);
		result= statement.executeQuery();
		if (result.next()) {
			giornata = result.getInt("Giornata");
		}
		while(result.next()) {
			giornata = result.getInt("Giornata");
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
	return giornata;
    }

}
