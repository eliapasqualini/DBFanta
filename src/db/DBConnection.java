package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	// variables
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;

	public Connection getAccessConnection() {
			// Step 1: Loading or registering Oracle JDBC driver class
			try {

				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			}
			catch(ClassNotFoundException cnfex) {

				System.out.println("Problem in loading or "
						+ "registering MS Access JDBC driver");
				cnfex.printStackTrace();
			}

			// Step 2: Opening database connection
			try {

				String msAccDB = "res/Fantacalcio.accdb";
				String dbURL = "jdbc:ucanaccess://" +msAccDB; 

				// Step 2.A: Create and get connection using DriverManager class
				connection = DriverManager.getConnection(dbURL); 
			}
			catch(SQLException sqlex){
				sqlex.printStackTrace();
				System.out.println("Errore SQL" + sqlex.getMessage());
			}
		    return connection;
	}

	/*
				// Step 2.B: Creating JDBC Statement 
				statement = connection.createStatement();

				// Step 2.C: Executing SQL &amp; retrieve data into ResultSet
				resultSet = statement.executeQuery("SELECT * FROM GIORNATE");

				System.out.println("Numero");
				System.out.println("==");

				// processing returned data and printing into console
				while(resultSet.next()) {
					System.out.println(resultSet.getString(1));
				}
			}

			finally {

				// Step 3: Closing database connection
				try {
					if(null != connection) {

						// cleanup resources, once after processing
						resultSet.close();
						statement.close();

						// and then finally close connection
						connection.close();
					}
				}
				catch (SQLException sqlex) {
					sqlex.printStackTrace();
				}
			}
		}*/

}
