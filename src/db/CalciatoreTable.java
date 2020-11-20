package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Calciatore;

public class CalciatoreTable {
    
    private DBConnection conn;
    private String tableName;
    
    public CalciatoreTable() {
            conn = new DBConnection();
            tableName = "[CALCIATORI]";
    }
    
    public Calciatore selectCalciatori(Integer id){
        Calciatore c= null;
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        String select = "SELECT * FROM " + tableName + " WHERE [ID-Calciatore] = "+ id +";";
        try {
            statement = connection.prepareStatement(select);
            result= statement.executeQuery();
            if(result.next()) {
            	c = new Calciatore();
            	c.setCalciatore(result.getInt("ID-Calciatore"));
                c.setNome(result.getString("Nome"));
                c.setCognome(result.getString("Cognome"));
                c.setSquadra(result.getString("Squadra"));
                c.setRuolo(result.getString("Ruolo"));
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
        return c;
                
    }
    
    
    public List<Calciatore> selectAll(String ruolo){
        List<Calciatore> calciatori = null;
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        String select = "SELECT * FROM " + tableName + " WHERE Ruolo = '"+ ruolo +"';";
        try {
            statement = connection.prepareStatement(select);
            result= statement.executeQuery();
            if(result.next()) {
                calciatori = new ArrayList<>();
                Calciatore c= new Calciatore();
                c.setCalciatore(result.getInt("ID-Calciatore"));
                c.setNome(result.getString("Nome"));
                c.setCognome(result.getString("Cognome"));
                c.setSquadra(result.getString("Squadra"));
                c.setRuolo(result.getString("Ruolo"));
                calciatori.add(c);
                
            }
            while(result.next()) {
                Calciatore c= new Calciatore();
                c.setCalciatore(result.getInt("ID-Calciatore"));
                c.setNome(result.getString("Nome"));
                c.setCognome(result.getString("Cognome"));
                c.setSquadra(result.getString("Squadra"));
                c.setRuolo(result.getString("Ruolo"));
                calciatori.add(c);
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
        return calciatori;
        
        }
}


