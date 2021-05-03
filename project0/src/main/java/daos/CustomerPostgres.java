package daos;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.List; 

import models.Customer;
import util.ConnectionUtil;


import models.Item;

public class CustomerPostgres implements CustomerDao {

	@Override
	public Boolean add(Object t) {
		// TODO Auto-generated method stub
		return true; 
	}

	@Override
	public Object getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		String sql = "select * from customer"; 
		List<Customer> customers = new ArrayList<>(); 
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			Statement s = c.createStatement(); 
			ResultSet rs = s.executeQuery(sql); 
			
			while(rs.next()) {
				int customer_id = rs.getInt("customer_id"); 
				String customer_username = rs.getString("customer_username"); 
				String customer_firstname = rs.getString("customer_firstname"); 
				String customer_lastname = rs.getString("customer_lastname"); 
				String customer_password = rs.getString("customer_password"); 
				customers.add(new Customer(customer_id, customer_firstname, customer_lastname, customer_password, customer_username));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customers; 
	}

	@Override
	public Integer update(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAllItemsOwned(String t) {
		String sql = "Select * from items\r\n"
				+ "inner join customer\r\n"
				+ "on items.customer_owner_id = customer.customer_id\r\n"
				+ "And customer.customer_username = ?";
		
		List<Item> items = new ArrayList<>(); 
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection();
			PreparedStatement p = c.prepareStatement(sql); 
			p.setString(1, t);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				Boolean owned = rs.getBoolean("item_statusOwned"); 
				Double price = rs.getDouble("item_price"); 
				items.add(new Item(id, name, owned, price)); 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Boolean checkforUsername(String t) {
		String sql="Select * from customer where customer_username = ?";
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

	@Override
	public Customer getCustomerByUserName(String t) {
		String sql="Select * from customer where customer_username = ?";
		Customer customer = null;
		
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1,t); 
			ResultSet rs = p.executeQuery();  
			while(rs.next()) {
				int customer_id = rs.getInt("customer_id");
				String username = rs.getString("customer_username"); 
				String password = rs.getString("customer_password");
				String firstname = rs.getString("customer_firstname"); 
				String lastname = rs.getString("customer_lastname"); 
				customer = new Customer(customer_id, firstname, lastname, password, username); 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customer; 
	}

}
