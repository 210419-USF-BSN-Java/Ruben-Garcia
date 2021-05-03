package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Customer;
import models.Employee;
import models.Manager;
import util.ConnectionUtil; 

public class EmployeePostgres implements EmployeeDao{

	@Override
	public Employee getEmployeeByUserName(String t) {

		String sql="Select * from employee where employee_username = ?";
		Employee employee = null;
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1,t); 
			ResultSet rs = p.executeQuery();  
			while(rs.next()) {
				int id = rs.getInt("employee_id");
				String username = rs.getString("employee_username"); 
				String password = rs.getString("employee_password");
				String firstname = rs.getString("employee_firstname"); 
				employee = new Employee(id, firstname, username, password); 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee; 
	}

	@Override
	public Boolean checkforUsername(String t) {
		String sql="Select * from employee where employee_username = ?";
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
