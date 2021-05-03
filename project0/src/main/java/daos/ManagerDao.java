package daos;

import models.Customer;
import models.Manager;

public interface ManagerDao {
	public Manager getManagerByUserName(String t); 
	public Boolean checkforUsername(String t); 
}
