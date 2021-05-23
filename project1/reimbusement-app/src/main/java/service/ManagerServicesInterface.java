package service;

import java.util.List;

import model.Reimbursement;
import model.User;

public interface ManagerServicesInterface {
	List<Reimbursement> viewAllPendingRequest();
	List<Reimbursement> viewAllResolvedRequest(); 
	int resolveReimb(); 
	List<User> viewAllEmployees(); 
	List<Reimbursement> viewAEmployeeRequestHistory(String username);
	int resolveReimb(String username, int reimb_status_id); 
}
