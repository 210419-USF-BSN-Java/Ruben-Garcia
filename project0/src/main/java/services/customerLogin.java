package services;
import models.Customer;
import daos.CustomerPostgres;

public class customerLogin implements UserLoginInterface {
	
	public customerLogin(){
		super(); 
	}

	public Boolean userAuth(String a, String b) {
		
		CustomerPostgres cp = new CustomerPostgres(); 
		Customer inputUser = cp.getCustomerByUserName(a); 
		String u = inputUser.getPassword();
		
		if((u.compareTo(b)) == 0) {
			return true;
		}else {
			return false; 
		}
	}
}
