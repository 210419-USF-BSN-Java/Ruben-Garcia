package models;

public interface GenericUser {
	public abstract void logIn(); 
	public abstract void logout();
	public abstract void whoseLoggedIn(); 
	public abstract void terminate(); 
	public abstract void viewItems(); 
	
	
}
