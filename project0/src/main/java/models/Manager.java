package models;

public abstract class Manager implements GenericUser {
//TODO
    public abstract void logout();
    
    public abstract void terminate();

    public abstract void viewSalesHistory(); 
    
    public abstract void logIn();

    public abstract void logOut(); 

    public abstract void whoseLoggedIn();

    public abstract void createEmployeeAccount();

    public abstract void fireEmployee(); 
}
