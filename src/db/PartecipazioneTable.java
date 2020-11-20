package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartecipazioneTable {
    private DBConnection conn;
    private String tableName;
    
    public PartecipazioneTable() {
            conn = new DBConnection();
            tableName = "PARTECIPAZIONI";
    }
    
    public void insertLega(Integer idAllenatore, Integer idLega) {
        
        Connection connection = this.conn.getAccessConnection();
        PreparedStatement statement = null;
        String insert = "INSERT INTO " + tableName+" ([Fanta-Allenatore], [Fanta-Lega]) VALUES ("+idAllenatore+", "+ idLega+");";
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
