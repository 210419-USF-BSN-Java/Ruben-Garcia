package service;

import java.util.List;

import dao.DAOFactory;
import dao.ReimbDao;
import dao.UserDao;
import model.Reimbursement;
import model.User;
import dao.UserDaoPostgres;

public class EmployeeServices implements EmployeeServicesInterface  {
	private UserDao ud; 
	private ReimbDao rd; 
	UserDaoPostgres udp = new UserDaoPostgres(); 
	
	public void UserServiceImplementation() {
		ud = DAOFactory.getDAOFactory().getUserDao();
	}
	
	public void ReimbServiceImplementation() {
		rd = DAOFactory.getDAOFactory().getReimbDao();
	}

	public Reimbursement submitReimbursementRequest(Reimbursement t) {
		// TODO Auto-generated method stub
		rd = DAOFactory.getDAOFactory().getReimbDao(); 
		
		return rd.add(t); 
		
	}

	@Override
	public void submitImageToReimbRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimbursement> viewPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public void viewEmployeeInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User viewEmployeeInfo(String username) {
		// TODO Auto-generated method stub
		User user = udp.getByUsername(username);
		return user; 
	}


}
