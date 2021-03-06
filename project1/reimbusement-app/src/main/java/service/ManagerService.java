package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dao.ReimbDaoPostgres;
import dao.UserDaoPostgres;
import model.Reimbursement;
import model.User;

public class ManagerService implements ManagerServicesInterface {
	ReimbDaoPostgres rdp = new ReimbDaoPostgres();
	UserDaoPostgres up = new UserDaoPostgres(); 
	@Override
	public List<Reimbursement> viewAllPendingRequest() {
		// TODO Auto-generated method stub
		List<Reimbursement> allReimbs = rdp.getAll();
		int pendingRequest = 1; 
		// TODO Auto-generated method stub
		Stream<Reimbursement> list = allReimbs.stream(); 
		List<Reimbursement> pendingrequests =  list.filter(t -> t.getReimb_status_id() == 1).collect(Collectors.toList());  
		System.out.println(pendingrequests); 
		return pendingrequests;
	}

	@Override
	public List<Reimbursement> viewAllResolvedRequest() {
		// TODO Auto-generated method stub
		List<Reimbursement> allReimbs = rdp.getAll();
		int acceptedRequest = 2;
		int rejectedRequest = 3;
		// TODO Auto-generated method stub
		Stream<Reimbursement> list = allReimbs.stream(); 
		List<Reimbursement> resolvedrequests =  list.filter(t -> (t.getReimb_status_id() == rejectedRequest) || t.getReimb_status_id() == acceptedRequest).collect(Collectors.toList()); 
		System.out.println("resolved request " + resolvedrequests); 
		return resolvedrequests; 
	}


	public int resolveReimb(int inputStatus, String manager_username, int reimb_id) {
		User user = up.getByUsername(manager_username);
		int userId = user.getId();
		int didExecute = rdp.updateReimb(inputStatus, userId, reimb_id);
		
		return didExecute; 
	}

	@Override
	public List<User> viewAllEmployees() {
		List<User> allUser = up.getAll(); 
		return allUser; 
	}

	public List<Reimbursement> viewAEmployeeRequestHistory(String username) {
		User user = up.getByUsername(username);
		int userId = user.getId();
		// TODO Auto-generated method stub
		List<Reimbursement> allReimbs = rdp.getAll();
		Stream<Reimbursement> list = allReimbs.stream(); 
		List<Reimbursement> userReimbHistory =  list.filter(t -> t.getReimb_author()== userId ).collect(Collectors.toList());
		return userReimbHistory; 
	}

	@Override
	public int resolveReimb() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int resolveReimb(String username, int reimb_status_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
