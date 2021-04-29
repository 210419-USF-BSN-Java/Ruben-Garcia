package models;

public interface GenericUser { 
	public Integer getId();
	public void setId(Integer id); 
	
	public String getFirstName(); 
	public void setFirstName(String firstName); 
	
	public String getLastName(); 
	public void setLastName(String lastName); 
	
	public String getPassword(); 
	public void setPassword(String password); 
}
