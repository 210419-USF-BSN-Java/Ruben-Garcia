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
	//works
	@Override
	public User getById(Integer id) {
		String sql = "select * from public.ers_users where ers_user_id = ?;\n";
		User user = null; 
		try {
			Connection c = ConnectionUtil.getConnection(); 
			PreparedStatement ps = c.prepareStatement(sql);
			System.out.println("try donr");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				user = new User();
				user.setId(id);
				user.setUsername(rs.getString("ers_username"));
				user.setPassword(rs.getString("ers_password"));
				user.setFirstName(rs.getString("user_first_name"));
				user.setLastName(rs.getString("user_last_name"));
				user.setEmail(rs.getString("user_email"));
				user.setUserRoleId(rs.getInt("user_role_id"));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
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
	//TODO 
	@Override
	public Integer update(User t) {
		String sql = "update public.ers_users set ers_username = ? , public.ers_password = ? , public.user_first_name = ? , public.user_last_name = ?, public.user_email = ?, role_id = ? where ers_user_id = ? ;\n";
		int r = -1;
		try {
			Connection c = ConnectionUtil.getConnection(); 
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getUserRoleId());
			r = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	//TODO , test
	@Override
	public Integer delete(User t) {
		int r = -1; 
		String sql = "delete from public.ers_users where ers_user_id = ?;\n";
		try {
			Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, t.getId());
			r = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	@Override
	public boolean validate(String username, String password) {
		String sql = "select * from public.ers_users where ers_username = ? and ers_password = ?;\n";
		boolean status = false;
		try {
			Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public int getRoleIdOfUser(String username) {
		String sql = "select public.ers_users.user_role_id from public.ers_users where ers_username=?\n";
		int role_id = 0; 
		try {
			Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				role_id = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return role_id;
	}

}
