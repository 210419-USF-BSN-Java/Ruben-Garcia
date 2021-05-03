package services;
import daos.ManagerPostgres;
import models.Manager;

public class ManagerLogin implements UserLoginInterface {
	
	public ManagerLogin() {
		super(); 
	}

	public Boolean userAuth(String a, String b) {
		ManagerPostgres mp = new ManagerPostgres(); 
		Manager inputm = mp.getManagerByUserName(a); 
		Boolean check = mp.checkforUsername(a);
		
		if(check) {
			String u = inputm.getPassword();
			if((u.compareTo(b)) == 0) {
				return true;
			}else {
				return false; 
			}
		}else {
			return false; 
		}
	}
	
}
