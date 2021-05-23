package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dao.DAOFactory;
import dao.ReimbDao;
import dao.ReimbDaoPostgres;
import dao.UserDao;
import model.Reimbursement;
import model.User;
import dao.UserDaoPostgres;

public class EmployeeServices implements EmployeeServicesInterface  {
	private UserDao ud; 
	private ReimbDao rd; 
	//TODO refactor to use daofactory
	UserDaoPostgres udp = new UserDaoPostgres(); 
	ReimbDaoPostgres rdp = new ReimbDaoPostgres(); 
	
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
	
	List<Reimbursement> allReimbs = rdp.getAll();

	public List<Reimbursement> viewUserPendingRequests(int id) {
		int id1 = id; 
		// TODO Auto-generated method stub
		Stream<Reimbursement> list = allReimbs.stream(); 
		//find way to convert int id to INT 
		List<Reimbursement> userpendingrequest =  list.filter(t -> t.getReimb_author() == (id1) && t.getReimb_status_id() == 1).collect(Collectors.toList());  
		System.out.println(userpendingrequest); 
		if(userpendingrequest.isEmpty()) {
			System.out.println("list is empty");
		}
		return userpendingrequest; 
	}

	public List<Reimbursement> viewUserResolvedRequests(int id) {
		// TODO Auto-generated method stub
		int id1 = id; 
		// TODO Auto-generated method stub
		Stream<Reimbursement> list = allReimbs.stream(); 
		//find way to convert int id to INT 
		List<Reimbursement> userresolvedrequest =  list.filter(t -> t.getReimb_author() == (id1) && ((t.getReimb_status_id() == 3) || t.getReimb_status_id() == 2)).collect(Collectors.toList()); 
		if(userresolvedrequest.isEmpty()) {
			System.out.println("the list from viewUser'sresolved reimbursements list is " +userresolvedrequest + " this list is empty");
		}
		return userresolvedrequest; 
	}

	@Override
	public List<Reimbursement> viewUserPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewUserResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}


}
