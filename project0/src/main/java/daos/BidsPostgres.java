package daos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import util.ConnectionUtil;

public class BidsPostgres implements BidsDao {
	
	public BidsPostgres(){
		super(); 
	}

	public int addBid(Double t, int a, int b) {
		int status = 0;  
		String sql = "INSERT INTO public.bids\n" + 
				"(bid_amount, fk_customer_id, fk_item_id)\n" + 
				"VALUES(?, ?, ?);\n";
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setDouble(1,t); 
			ps.setInt(2, a);
			ps.setInt(3, b);
		    status = ps.executeUpdate(); 
			if(status > 0) {
				System.out.println("bid was placed successfully"); 
			}else {
				System.out.println("bid was not placed, please make sure you input the correct parameters"); 
			}
			
		}catch(SQLException e) {
			System.out.println("error happened");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e); 
		}
		return status;
	}

	@Override
	public Object getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer updateBid(int i, boolean b) {
		//i is the bid id
		String sql = "UPDATE public.bids\n" + 
				"SET bid_accepted=?\n" + 
				"WHERE public.bids.bids_id =?;\n";
		int status = 0;  
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement ps = c.prepareStatement(sql);  
			ps.setInt(1, i);
			ps.setBoolean(2, b);
		    status = ps.executeUpdate(); 
			if(status > 0) {
				System.out.println("bid was updated successfully"); 
			}else {
				System.out.println("bid was not updated, please make sure you input the correct parameters"); 
			}
			
		}catch(SQLException e) {
			System.out.println("error happened");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e); 
		}
		return status;
		
	}

	@Override
	public Integer delete(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object add(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int updateAllOtherBids(int id) {
		//system method
		//find all rows on the item that was has offer accepted
		//set all rows that is returned to offerAccepted = false
		//when the offer of a avalaible item has been set to owned; 
		int status = 0;  
		String sql = "UPDATE public.bids\n" + 
				"SET bid_accepted=false\n" + 
				"WHERE (public.bids.bid_accepted is null)\n" + 
				"and (public.bids.fk_item_id =? );\n";
		try {
			Connection c = ConnectionUtil.getHardCodedConnection(); 
			PreparedStatement ps = c.prepareStatement(sql);  
			ps.setInt(1, id);
		    status = ps.executeUpdate(); 
			if(status > 0) {
				System.out.println("all other bids for the item has been rejected "); 
			}else {
				System.out.println("all other bids weren't able to be rejected"); 
			}
			
		}catch(SQLException e) {
			System.out.println("error happened");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e); 
		}
		return status;
	}

	@Override
	public Integer update(Object t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
