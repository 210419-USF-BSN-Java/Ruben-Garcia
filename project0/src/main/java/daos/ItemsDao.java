package daos;
import java.util.List;
import models.Item;

public interface ItemsDao extends GenericDaos<Item>{
	//getAllItemsAvailable will query based upon if a variable is owned or not, boolean
	public List<Item> getAllItemsAvailable(); 
	public List<Item> getAllItemsOwned(String t); //t is a specific customer username
	//public Double <T> moneyOwed(Int id, String t); //for story, view remaining payments for an item
	
}

