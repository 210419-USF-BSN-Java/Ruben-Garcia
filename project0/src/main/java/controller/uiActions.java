package controller;

public interface uiActions {
	public abstract void logIn(); 
	public abstract void logout();
	public abstract void createUserAccount(); 
	//on the fence about this, but whatever..
	public abstract void whoseLoggedIn(); 
	public abstract void exit(); 
	//Done, further review 
	public abstract void addItem(); 
	
	public abstract void offerDecision(); 
	
	public abstract void removeItem(); 
	
	public abstract void viewAllPayment();
	
    public abstract void terminate();

    public abstract void viewSalesHistory(); 
    

    public abstract void createEmployeeAccount();

    public abstract void fireEmployee(); 
}
