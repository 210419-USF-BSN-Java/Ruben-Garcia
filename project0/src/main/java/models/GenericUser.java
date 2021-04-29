package models;

public interface GenericUser {
	public abstract void logIn(); 
	public abstract void logout();
	
	public abstract void createUserAccount(); 
	//on the fence about this, but whatever..
	public abstract void whoseLoggedIn(); 
	
	public abstract void exit(); 
	//Done, further review 
	
}
