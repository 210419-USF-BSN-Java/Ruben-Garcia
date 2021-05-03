package daos;

import models.Customer;
import models.Employee;

public interface EmployeeDao {
	public Employee getEmployeeByUserName(String t); 
	public Boolean checkforUsername(String t); 
	
}
