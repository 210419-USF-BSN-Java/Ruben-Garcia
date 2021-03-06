package controller;
import java.util.Scanner;

import daos.CustomerPostgres;
import daos.ItemPostgres;
import models.Employee;
import services.CustomerLogin;
import services.ManagerLogin;
import services.EmployeeLogin;

//public methods relating to the console
public class ConsoleUI {
	
	public String testUserName = "user"; 
	public String testPassword = "password";
	public Boolean loggedIn = false; 
	Scanner sc = new Scanner(System.in); 
	protected String userName;
	public int menuView = 0;
	public int loginView = 0; 
	protected String password; 
	
	public ConsoleUI welcome() {
		System.out.println("welcome, please login");
		menuView = Integer.parseInt(sc.nextLine());
		return null; 
	}
	
	public void menuMaster() {
		do {
			switch(menuView) {
			case 0:
				System.out.println("login as customer");
				//call a customer method from services 
			case 1: 
				System.out.println("create customer account");
				//call a customer service method that creates a new account
				//this method  
			case 2: 
				System.out.println("View all avalaible items");
				//calls a service store method
			case 3: 
				System.out.println("login as employee"); 
			case 4:
				System.out.println("login as manager"); 
			case 5: 
				System.out.println("help"); 
			case 6: 
				System.out.println("about this console app"); 
			case 7: 
				System.out.println("quit"); 
			default: 
				System.out.println("please input a number 0-7 according to the menu options"); 
			} 
		} while (menuView < 8 ); 
	}	
	
	public void loginMenu() {
		do {
			switch(loginView) {
			case 0: 
				System.out.println("login as a customer"); 
			case 1: 
				System.out.print("login as a employee");
			case 2:
				System.out.print("login as a manager");
			}
			
		}while(loginView <3); 
		
	}
	
	public void login() {
		//TODO switch statement for several options , customer, manager, employee
	}
	
	public void createAccountUI() {
		System.out.println("press 0 to confirm or 1 to go back");
		System.out.println("creating a new account"); 
		System.out.println("input a username"); 
		System.out.println("input a password"); 
		//TODO create switch statement to chain UI experience for creating an account
	}
	//TODO
	//should be default user depending on what account they want to sign up for  
	public Boolean customerLogin() {
		Scanner sc = new Scanner(System.in); 
    	System.out.println("please input username"); 
    	String username = sc.nextLine(); 
    	System.out.println("please input password"); 
    	String password = sc.nextLine(); 
  
		CustomerLogin a = new CustomerLogin(); 
		Boolean accessGranted = a.userAuth(username, password);
		if(accessGranted == true) {
    		System.out.println("login successful");
    	}else {
    		System.out.println("login unsuccessful"); 
    	}
		sc.close();
		return accessGranted;
	}
	
	public Boolean EmployeeLogin() {
		Scanner sc = new Scanner(System.in); 
    	System.out.println("please input username"); 
    	String username = sc.nextLine(); 
    	System.out.println("please input password"); 
    	String password = sc.nextLine(); 
  
		EmployeeLogin a = new EmployeeLogin(); 
		Boolean accessGranted = a.userAuth(username, password);
		if(accessGranted == true) {
    		System.out.println("login successful");
    	}else {
    		System.out.println("login unsuccessful"); 
    	}
		sc.close();
		return accessGranted;
	}
	
	public Boolean ManagerLogin() {
		Scanner sc = new Scanner(System.in); 
    	System.out.println("Hello, you are trying to login in as an Manager. Please input your username"); 
    	String username = sc.nextLine(); 
    	System.out.println("please input password"); 
    	String password = sc.nextLine(); 
  
		ManagerLogin a = new ManagerLogin(); 
		Boolean accessGranted = a.userAuth(username, password);
		if(accessGranted == true) {
    		System.out.println("login successful");
    	}else {
    		System.out.println("login unsuccessful"); 
    	}
		sc.close();
		return accessGranted;
	}
	
	public int addItem() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("hello, you are trying to add an item. please input a name");
		String n = sc.nextLine(); 
		System.out.println("please input a price");
		double p = sc.nextDouble(); 
		ItemPostgres ip = new ItemPostgres(); 
		int a = ip.add(n, p); //returns a number based if user was successfully completed
		sc.close();
		return a; 
	
	}
	public int createCustomerAccount() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("hello, you are trying to create a customer account. please input a username");
		String u = sc.nextLine(); 
		System.out.println("please input a first name");
		String fn = sc.nextLine(); 
		System.out.println("please input a last name");
		String ln = sc.nextLine(); 
		System.out.println("please input a paswword");
		String pw = sc.nextLine(); 
		CustomerPostgres cp = new CustomerPostgres(); 
		int a = cp.add(u, fn, ln, pw); 
		sc.close();
		return a; 
	
	}
	
	public int deleteItem() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("hello, you are trying to remove an item. Please specify an id number of the item");
		//System.out.println("press one of the options for how you would like to remove an item");
		int id = sc.nextInt(); 
		ItemPostgres ip = new ItemPostgres(); 
		int a = ip.delete(id); 
		sc.close();
		return a; 
	}
	
	
	
}
