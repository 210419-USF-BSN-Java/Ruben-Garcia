package driver;
import dao.UserDaoPostgres;
import model.Reimbursement;
import model.User;
import dao.ReimbDaoPostgres;

public class tester {

	public static void main(String[] args) {
		User tester = new User( 10,"tester12", "password", "jake", "parker", "spoof1@gmail.com", 1);
		Reimbursement reimb = new Reimbursement(  ); 
				
		ReimbDaoPostgres rp = new ReimbDaoPostgres(); 
		 Reimbursement newReimb = rp.add(reimb);
		 System.out.println(newReimb); 
		// TODO Auto-generated method stubcon.setAutoCommit(false);
		UserDaoPostgres u = new UserDaoPostgres(); 
		//u.getAll(); 
		//u.add(tester);
		//u.getById(2);
		Boolean s = u.validate("tester", "password");
		System.out.println(s);
		int r = u.getRoleIdOfUser("benEmployee"); 
		System.out.println(r);
		}
	

}
