package util;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.sql.*; 

//variables set up in sys env 
public class ConnectionUtil {
    private static Connection connection;
    
    //singleton pattern 
    public static Connection getConnectionFromEnv() throws SQLException {	
	String url = System.getenv("postgres_aws_ers_p1_db_url"); 
	String username = System.getenv("postgres_aws_ers_p1_db_user"); 
	String password = System.getenv("postgres_aws_ers_p1_db_password"); 
	
	if(connection == null || connection.isClosed()) {
	    connection = DriverManager.getConnection(url, username, password); 
	}
	
	return connection; 
    }
    
    public static Connection getHardCodedConnection() throws SQLException
	{
		String url = "com-revature-ers-p1.cl0hmzmpfzgp.us-east-2.rds.amazonaws.com";
		String username = "postgres";
		String password = "Noctis94.";

		if(connection == null || connection.isClosed()) {
		connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
    
    public static Connection getConnection() throws SQLException {
    	try {
    		Class.forName("org.postgresql.Driver"); 
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	String RDS_HOSTNAME = "com-revature-ers-p1.cl0hmzmpfzgp.us-east-2.rds.amazonaws.com";
		String username = "postgres";
		String password = "Noctis94.";
		String dbName = "postgres"; 
		String jdbcURL = "jdbc:postgresql://" +RDS_HOSTNAME + ":" +5432 +"/" + dbName + "?user=" + username + "&password=" + password;
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(jdbcURL);
		}
		
		return connection;
    }
     
    
}
