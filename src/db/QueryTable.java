package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.FantaSquadra;
import model.Giornata;

public class QueryTable {
    
    private DBConnection conn;
    
    public QueryTable() {
        conn = new DBConnection();
    }
    
    public List<Giornata> selectTable() {
        List<Giornata> giornate = null;
        Giornata giornata = null;
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        String select = "SELECT * FROM GIORNATE";
        try {
                statement = connection.prepareStatement(select);
                result= statement.executeQuery();
                if (result.next()) {
                        giornate = new LinkedList<Giornata>();
                        giornata = new Giornata();
                        giornata.setNumero(result.getInt("Numero"));
                        giornate.add(giornata);
                }
                while(result.next()) {
                        giornata = new Giornata();
                        giornata.setNumero(result.getInt("Numero"));
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
        
        
        public List<FantaSquadra> selectFantaSquadre (Integer idLega){
            List<FantaSquadra> squadre = null;
            FantaSquadra squadra = null;
            Integer lega = idLega;
            Connection connection = this.conn.getAccessConnection();
            PreparedStatement statement = null;
            ResultSet result = null;
            String select = "SELECT Nome FROM FANTASQUADRE WHERE FantaLega = ?";
            try {
                statement = connection.prepareStatement(select);
                statement.setInt(1, lega);
                result = statement.executeQuery();
                if (result.next()) {
                    squadre = new ArrayList<>();
                    squadra = new FantaSquadra();
                    squadra.setNome(result.getString("Nome"));
                    squadre.add(squadra);
            }
            while(result.next()) {
                    squadra = new FantaSquadra();
                    squadra.setNome(result.getString("Nome"));
                    squadre.add(squadra);
            }
            }
            catch (SQLException e) {
                    new Exception(e.getMessage());
                System.out.println("Errore"+ e.getMessage());
            }
            finally {
                try {
                    if (statement != null) 
                        statement.close();
                    if (connection!= null)
                        connection.close();
                } catch (SQLException e) {
                    new Exception(e.getMessage());
                         System.out.println("Errore"+ e.getMessage());
                }
            }
            return squadre;
            
            
        }
        


}
