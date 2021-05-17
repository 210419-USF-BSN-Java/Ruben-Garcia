package service;

import java.util.List;

import dao.DAOFactory;
import dao.ReimbDao;
import dao.UserDao;
import model.Reimbursement;

public class EmployeeServices implements EmployeeServicesImp  {
	private UserDao ud; 
	private ReimbDao rd; 
	
	public void UserServiceImplementation() {
		ud = DAOFactory.getDAOFactory().getUserDao();
	}
	
	public void ReimbServiceImplementation() {
		rd = DAOFactory.getDAOFactory().getReimbDao();
	}

	@Override
	public void checkCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submitReimbursementRequest() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void viewEmployeeInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInfo() {
		// TODO Auto-generated method stub
		
	}

}
