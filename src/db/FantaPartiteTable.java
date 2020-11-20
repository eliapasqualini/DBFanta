package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FantaPartita;

public class FantaPartiteTable {
	
	private DBConnection conn;
	private String tableName;
	
	public FantaPartiteTable(){
		conn = new DBConnection();
		tableName = "[FANTA-PARTITA]";
	}
	
	public List<FantaPartita> selectFantaPartite(int giornata, int lega){
		List<FantaPartita> fantaPartiteList = null;
		FantaPartita fantaPartita = null;
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String select = "SELECT [Fanta-Squadra casa], [Fanta-Squadra trasferta], Giornata, [Gol casa], [Punteggio casa],"
				+ " [Gol trasferta], [Punteggio trasferta], [Fanta-formazione casa], [Fanta-formazione trasferta] FROM "+tableName+
		                  ", [FANTA-SQUADRA] WHERE [FANTA-PARTITA].[Giornata] = "+giornata+
		                  " AND [FANTA-SQUADRA].Nome = [Fanta-Squadra casa] AND [FANTA-SQUADRA].[Fanta-Lega] = "+lega+";";
		try {
			statement = connection.prepareStatement(select);
			result= statement.executeQuery();
			if (result.next()) {
				fantaPartiteList = new ArrayList<>();
				fantaPartita = new FantaPartita();
				fantaPartita.setFantaSquadraCasa(result.getString("Fanta-Squadra casa"));
				fantaPartita.setFantaSquadraTrasferta(result.getString("Fanta-Squadra trasferta"));
				fantaPartita.setGiornata(result.getInt("Giornata"));
				fantaPartita.setGolCasa(result.getInt("Gol casa"));
				fantaPartita.setPunteggioCasa(result.getString("Punteggio casa"));
				fantaPartita.setGolTrasferta(result.getInt("Gol trasferta"));
				fantaPartita.setPunteggioTrasferta(result.getString("Punteggio trasferta"));
				fantaPartita.setFantaFormazioneCasa(result.getInt("Fanta-formazione casa"));
				fantaPartita.setFantaFormazioneTrasferta(result.getInt("Fanta-Formazione trasferta"));
				fantaPartiteList.add(fantaPartita);
			}
			while (result.next()) {
				fantaPartita = new FantaPartita();
				fantaPartita.setFantaSquadraCasa(result.getString("Fanta-Squadra casa"));
				fantaPartita.setFantaSquadraTrasferta(result.getString("Fanta-Squadra trasferta"));
				fantaPartita.setGiornata(result.getInt("Giornata"));
				fantaPartita.setGolCasa(result.getInt("Gol casa"));
				fantaPartita.setPunteggioCasa(result.getString("Punteggio casa"));
				fantaPartita.setGolTrasferta(result.getInt("Gol trasferta"));
				fantaPartita.setPunteggioTrasferta(result.getString("Punteggio trasferta"));
				fantaPartita.setFantaFormazioneCasa(result.getInt("Fanta-formazione casa"));
				fantaPartita.setFantaFormazioneTrasferta(result.getInt("Fanta-Formazione trasferta"));
				fantaPartiteList.add(fantaPartita);
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
		return fantaPartiteList;
	}
	
	
    public void insertFantaPartita(String casa, String trasferta, Integer giornata, Integer formC, Integer formT) {
	    
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        String insert = "INSERT INTO "+tableName+" ([Fanta-Squadra casa], [Fanta-Squadra trasferta], Giornata, [Fanta-Formazione casa], [Fanta-Formazione trasferta])"
        		+ " VALUES ('"+casa+"', '"+trasferta+"', "+giornata+", '"+formC+"', '"+formT+"');";
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
	
    public void updateCasa(String fantaS, int gol, String punteggio, int giornata) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE [FANTA-PARTITA] " + 
				"SET [Gol casa] = "+gol+", [Punteggio casa] = '"+punteggio+"'"
						+ " WHERE [Fanta-Squadra casa] = '"+fantaS+"'"
								+ " AND Giornata = "+giornata+";";
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
    
    public void updateTrasferta(String fantaS, int gol, String punteggio, int giornata) {
		
		Connection connection = this.conn.getAccessConnection();
		PreparedStatement statement = null;
		String update = "UPDATE [FANTA-PARTITA] " + 
				"SET [Gol trasferta] = "+gol+", [Punteggio trasferta] = '"+punteggio+"'"
						+ " WHERE [Fanta-Squadra trasferta] = '"+fantaS+"'"
								+ " AND Giornata = "+giornata+";";
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
