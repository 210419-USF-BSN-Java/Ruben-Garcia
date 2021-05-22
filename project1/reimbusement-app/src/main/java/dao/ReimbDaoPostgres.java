package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Reimbursement;
import util.ConnectionUtil;

public class ReimbDaoPostgres implements ReimbDao {
	//TODO  test 
	@Override
	//specify to only add values based on form details 
	//TODO 
	public Reimbursement add(Reimbursement t) {
		String sql = "insert into public.ers_reimbursement (reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id,reimb_type_id )\n" + 
				"values(?,?,?, ?,?,?,?) returning reimb_id;\n";
		Reimbursement reim = null;
		try {
			Connection c = ConnectionUtil.getConnection(); 
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setDouble(1, t.getReimb_amount());
			ps.setString(2, t.getReimb_description());
			ps.setBytes(3, t.getReimb_receipt());
			ps.setInt(4, t.getReimb_author());
			ps.setInt(5, t.getReimb_resolver());
			ps.setInt(6, t.getReimb_status_id());
			ps.setInt(7, t.getReimb_type_id());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reim = t; 
				reim.setReimb_id(rs.getInt(1));
				c.commit();
			}else {
				c.rollback(); 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reim;
	}
	//TODO  test
	@Override
	public Reimbursement getById(Integer id) {
		Reimbursement reim = null;
		String sql = "select * from public.ers_reimbursement  where reimb_id = 2;\n";
		try {
			Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reim = new Reimbursement(); 
				reim.setReimb_id(id);
				reim.setReimb_amount(rs.getDouble("reimb_amount"));
				reim.setReimb_submitted(rs.getTimestamp("reimb_resolved"));
				reim.setReimb_resolved(rs.getTimestamp("reimb_resolved"));
				reim.setReimb_description(rs.getString("reimb_description"));
				reim.setReimb_receipt(rs.getBytes("reimb_receipt"));
				reim.setReimb_author(rs.getInt("reimb_author"));
				reim.setReimb_resolver(rs.getInt("reimb_resolver"));
				reim.setReimb_status_id(rs.getInt("reimb_status_id"));
				reim.setReimb_type_id(rs.getInt("reimb_type_id"));
					
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reim;
	}

	@Override
	public List<Reimbursement> getAll() {
		String sql = "select * from public.ers_reimbursement\n";
		List<Reimbursement> reimbs = new ArrayList<>(); 
		try {
			Connection c = ConnectionUtil.getConnection();
			Statement s = c.createStatement(); 
			ResultSet rs = s.executeQuery(sql); 
			
			while(rs.next()) {
				int r_id = rs.getInt("reimb_id"); 
				double r_amount = rs.getDouble("reimb_amount");
				Date r_submitted = rs.getDate("reimb_submitted"); 
				Date r_resolved = rs.getDate("reimb_resolved");
				String r_description = rs.getString("reimb_description"); 
				byte[] r_receipt = rs.getBytes("reimb_receipt"); 
				int r_author = rs.getInt("reimb_author");
				int r_resolver = rs.getInt("reimb_resolver"); 
				int r_status_id = rs.getInt("reimb_status_id");
				int r_type_id = rs.getInt("reimb_type_id"); 
				reimbs.add(new Reimbursement(r_id, r_amount, r_submitted, r_resolved, r_description, r_receipt, r_author, r_resolver, r_status_id, r_type_id ));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		System.out.println(reimbs);
		return reimbs; 
		}


	@Override
	public Integer update(Reimbursement t) {
		// TODO test, designed to not be able to change time submitted stamp 
		int r = -1;
		String sql = "update public.ers_reimbursement set reimb_amount = ?," + 
				"reimb_resolved =?, reimb_description = ?, reimb_receipt = ?, reimb_author = ?, reimb_resolver=?, reimb_status_id = ?, reimb_type_id = ?\n" + 
				"where reimb_id = ?;\n";
		try{
			Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDouble(1, t.getReimb_amount());
			ps.setDate(2, (Date) t.getReimb_resolved());
			ps.setString(3, t.getReimb_description());
			ps.setBytes(4, t.getReimb_receipt());
			ps.setInt(5, t.getReimb_author());
			ps.setInt(6, t.getReimb_resolver());
			ps.setInt(7, t.getReimb_status_id());
			ps.setInt(8, t.getReimb_type_id());
			
			r = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	// TODO test
	@Override
	public Integer delete(Reimbursement t) {
		String sql = "delete from public.ers_reimbursement where reimb_id = ?;\n";
		int r = -1;
		try {
			Connection c = ConnectionUtil.getConnection(); 
			PreparedStatement ps = c.prepareStatement(sql); 
			ps.setInt(1, t.getReimb_id());
			r = ps.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

}
