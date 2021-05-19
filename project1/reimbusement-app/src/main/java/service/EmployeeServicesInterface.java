package service;

import model.User;

import java.util.List;

import model.Reimbursement;

public interface EmployeeServicesInterface {
	 
	public void submitReimbursementRequest();
	public void submitImageToReimbRequest();
	public List<Reimbursement> viewPendingRequests();
	public List<Reimbursement> viewResolvedRequests(); 
	public void viewEmployeeInfo(); 
	public void updateInfo(); 
	
	
}
