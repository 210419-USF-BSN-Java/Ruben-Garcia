package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.ConnectionUtil;

public class UserDaoPostgres implements UserDao {
	//user add works correctly, must add handling on ui for constraint unique values errors
	public User add(User t) {
		User user = null; 
		String sql = "insert into public.ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" + 
				"values(?, ?, ?, ?, ?, ?) returning ers_user_id;\n";
		try {
			
			Connection c = ConnectionUtil.getConnection(); 
			c.setAutoCommit(false);
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getUserRoleId());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = t; 
				user.setId(rs.getInt(1)); //gets primary id from database from query executed, depends on database what it inputs
				c.commit();//this declared here since auto commit is off
			}else {
				c.rollback();
				//incase query executes but runs into issue
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user; 
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		String sql = "select * from public.ers_users;"; 
		try {
			Connection c = ConnectionUtil.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int ers_user_id = rs.getInt("ers_user_id"); 
				String ers_username = rs.getString("ers_username"); 
				String ers_password = rs.getString("ers_password");
				String user_first_name = rs.getString("user_first_name"); 
				String user_last_name = rs.getString("user_last_name"); 
				String user_email = rs.getString("user_email"); 
				int user_role_id = rs.getInt("user_role_Id"); 
				users.add(new User(ers_user_id, ers_username, ers_password, user_first_name, user_last_name,user_email, user_role_id )); 
			}
			System.out.println("connection good");
			System.out.println(users);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public Integer update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(User t) {
		// TODO Auto-generated method stub
		return null;
	}

}
