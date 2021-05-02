package daos;

import java.util.List;

import models.Customer;
import models.Item;

public interface CustomerDao extends GenericDaos { 
	public List<Item> getAllItemsOwned(String t);
	public Boolean checkforUsername(String t); 
	public Customer getCustomerByUserName(String t); 
}
