package daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.List;

import models.Item;
import util.ConnectionUtil; 


public class ItemPostgres implements ItemsDao {
	
	public ItemPostgres() {
		super(); 
	}
	
	public int add(String n, Double p) { 
		int status = 0;  
		String sql = "insert into items (item_name, item_price) values (?, ?)";
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setString(1,n); 
			ps.setDouble(2, p); 
		    status = ps.executeUpdate(); 
			if(status > 0) {
				System.out.println("item was added successfully"); 
			}else {
				System.out.println("item was not added, please make sure you input the correct parameters"); 
			}
			
		}catch(SQLException e) {
			System.out.println("error happended");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e); 
		}
		return status;
		
	}



	@Override
	public List<Item> getAll() {
		String sql = "select * from items";
		List<Item> items = new ArrayList<>(); 
		
		try{
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			Statement s = c.createStatement(); 
			ResultSet rs = s.executeQuery(sql); 
			//System.out.println(rs);
			
			while(rs.next()) {
				int item_id = rs.getInt("item_id"); 
				String item_name = rs.getString("item_name"); 
				Boolean item_statusOwned = rs.getBoolean("item_statusOwned"); 
				Double item_price = rs.getDouble("item_price"); 
				items.add(new Item(item_id, item_name, item_statusOwned, item_price )); 
				
			}
			System.out.println("item getall method executed");
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return items;//working
	}

	@Override
	public Integer update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(int i) {
		int status = 0;  
		//int id = t.getId();
		//String nameO = t.getItem_name(); 		
		
		String sqlID = "delete from items where item_id=?";
		String sqlName = "delete from items where item_name=?";
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement ps = c.prepareStatement(sqlID); 
			ps.setInt(1, i); 
		    status = ps.executeUpdate(); 
			if(status > 0) {
				System.out.println("item was deleted successfully"); 
			}else {
				System.out.println("item was not deleted, please make sure the id exisits"); 
			}
			
		}catch(SQLException e) {
			System.out.println("error happended");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e); 
		}
		return status;
	}

	@Override
	public List<Item> getAllItemsAvailable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAllItemsOwned(String t) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Item add(Item t) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Item getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

}
