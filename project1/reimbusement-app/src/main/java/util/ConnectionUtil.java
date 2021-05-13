package util;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    
}
