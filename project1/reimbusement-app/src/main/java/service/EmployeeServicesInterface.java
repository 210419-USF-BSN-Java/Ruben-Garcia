package service;

import model.User;

import java.util.List;

import model.Reimbursement;

public interface EmployeeServicesInterface {
	 
	public Reimbursement submitReimbursementRequest(Reimbursement t);
	public void submitImageToReimbRequest();
	public List<Reimbursement> viewUserPendingRequests();
	public List<Reimbursement> viewUserResolvedRequests(); 
	public User viewEmployeeInfo(String username); 
	public void updateInfo(); 
	
	
}
