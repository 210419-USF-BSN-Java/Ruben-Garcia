package services;

import daos.CustomerPostgres;
import daos.EmployeePostgres;
import models.Customer;
import models.Employee;

public class EmployeeLogin implements UserLoginInterface{

	@Override
	public Boolean userAuth(String a, String b) {
		EmployeePostgres ep = new EmployeePostgres(); 
		Employee inputUser = ep.getEmployeeByUserName(a); 
		Boolean check = ep.checkforUsername(a);
		
		if(check) {
			String u = inputUser.getPassword();
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
