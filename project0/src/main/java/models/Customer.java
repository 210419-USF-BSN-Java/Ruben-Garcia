package models;

public interface Customer extends GenericUser {
    //TODO add customer specific methods names 
    public abstract void itemsOwned(); 
    
    public abstract void makePayment(); 
    
    public abstract void viewRemainingPayments(); 
    
    public abstract void makeOffer(); 
    
    public abstract void viewAvailableItems(); 
    //TODO add specific return data types
}
