package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Customer;
import models.Manager;
import util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao {
	public Manager getManagerByUserName(String t) {
		String sql="Select * from manager where manager_username = ?";
		Manager manager = null;
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1,t); 
			ResultSet rs = p.executeQuery();  
			while(rs.next()) {
				int customer_id = rs.getInt("manager_id");
				String username = rs.getString("manager_username"); 
				String password = rs.getString("manager_password");
				String firstname = rs.getString("manager_firstname"); 
				manager = new Manager(customer_id, firstname, username, password); 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return manager; 
	}


	@Override
	public Boolean checkforUsername(String t) {
		String sql="Select * from manager where manager_username = ?";
		Boolean isInDatabase = null;  
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1,t); 
			ResultSet rs = p.executeQuery(); 
			if(rs.next()) {
				isInDatabase = true; 
			}else {
				isInDatabase = false; 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return isInDatabase;  
	}

}
