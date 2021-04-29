package models;

public interface Employee extends GenericUser{
    	//
	public abstract void logIn();

	public abstract void logOut();

	public abstract void whoseLoggedIn();
	
	public abstract void addItem(); 
	
	public abstract void offerDecision(); 
	
	public abstract void removeItem(); 
	
	public abstract void viewAllPayment(); 

}
