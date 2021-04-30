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
	
	@Override
	public Item add(Item t) {
		// TODO Auto-generated method stub
		Item item = null; 
		String sql = "insert into items (item_name, item_statusOwned, item_price) values (?, ?, ?) returning item_id)";
		return null;
		/*
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, t.getItem_name());
			ps.setBoolean(0, false);
		}
		*/
	}

	@Override
	public Item getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAll() {
		String sql = "select * from items"; 
		List<Item> items = new ArrayList<>(); 
		
		try{
			Connection c = ConnectionUtil.getConnectionFromEnv(); 
			Statement s = c.createStatement(); 
			ResultSet rs = s.executeQuery(sql); 
			
			while(rs.next()) {
				int item_id = rs.getInt("item_id"); 
				String item_name = rs.getString("item_name"); 
				Boolean item_statusOwned = rs.getBoolean("item_statusOwned"); 
				Double item_price = rs.getDouble("item_price"); 
				items.add(new Item(item_id, item_name, item_statusOwned, item_price )); 
				
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return items;
	}

	@Override
	public Integer update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Item t) {
		// TODO Auto-generated method stub
		return null;
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

}
