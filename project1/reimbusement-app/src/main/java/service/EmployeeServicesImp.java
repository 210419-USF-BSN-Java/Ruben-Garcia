package service;

import model.User;

import java.util.List;

import model.Reimbursement;

public interface EmployeeServicesImp {
	
	public void checkCredentials();  
	public void submitReimbursementRequest();
	public void submitImageToReimbRequest();
	public List<Reimbursement> viewPendingRequests();
	public List<Reimbursement> viewResolvedRequests(); 
	public void viewEmployeeInfo(); 
	public void updateInfo(); 
	
	
}
