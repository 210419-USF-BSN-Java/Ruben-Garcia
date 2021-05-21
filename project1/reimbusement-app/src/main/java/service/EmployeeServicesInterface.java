package service;

import model.User;

import java.util.List;

import model.Reimbursement;

public interface EmployeeServicesInterface {
	 
	public Reimbursement submitReimbursementRequest(Reimbursement t);
	public void submitImageToReimbRequest();
	public List<Reimbursement> viewPendingRequests();
	public List<Reimbursement> viewResolvedRequests(); 
	public User viewEmployeeInfo(String username); 
	public void updateInfo(); 
	
	
}
