package services;
import models.Customer;
import daos.CustomerPostgres;


public class CustomerLogin implements UserLoginInterface {
	
	public CustomerLogin(){
		super(); 
	}

	public Boolean userAuth(String a, String b) {
		
		CustomerPostgres cp = new CustomerPostgres(); 
		Customer inputUser = cp.getCustomerByUserName(a);
		Boolean check =  cp.checkforUsername(a);
		String u = inputUser.getPassword();
		
		if(check) {
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
