package driver;
import dao.UserDaoPostgres;
import model.User;

public class tester {

	public static void main(String[] args) {
		User tester = new User( 10,"tester", "password", "jake", "parker", "spoof@gmail.com", 1);
		
		// TODO Auto-generated method stubcon.setAutoCommit(false);
		UserDaoPostgres u = new UserDaoPostgres(); 
		u.getAll(); 
		u.add(tester);
		}

}
