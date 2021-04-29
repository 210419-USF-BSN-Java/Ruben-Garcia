package models;

public interface Employee extends GenericUser{

	public void logIn();

	public void logOut();

	public void whoseLoggedIn();

	public void viewAvailibleItems();

}
