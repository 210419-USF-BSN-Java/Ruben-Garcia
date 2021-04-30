package util;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
    private static Connection connection; 
    //singleton pattern 
    public static Connection getConnectionFromEnv() throws SQLException {
	String url = System.getenv("DB_URL"); 
	String username = System.getenv("DB_USER"); 
	String password = System.getenv("DB_PASS"); 
	
	if(connection == null || connection.isClosed()) {
	    connection = DriverManager.getConnection(url, username, password); 
	}
	
	return connection; 
    }
    
    public static Connection getHardCodedConnection() throws SQLException
	{

		String url = "jdbc:postgresql://localhost:5432/project0";
		String username = "postgres";
		String password = "Noctis94.";

		if(connection == null || connection.isClosed()) {
		connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
    
    
    
    
    
}
