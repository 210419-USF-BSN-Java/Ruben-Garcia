package controller;

import services.*; 
import java.util.Scanner;

import daos.CustomerPostgres;



public class StoreApp {
	Services services = new Services(); 
	Scanner sc = new Scanner(System.in); 
	
	public StoreApp() {
		super(); 
	}
	
	public void start() {
		greeting(); 
	}
	
	public void greeting() {
		System.out.println("hello, welcome to the generic item shop");
		introMenu(); 
	}
	
	public void introMenu() {
		System.out.println("You arrived to the main menu");
		System.out.println("Please, input a number" );
		System.out.println("Press 1 to create a new customer account." );
		System.out.println("Press 2 to log in into an exisiting account." );
		int input = Integer.parseInt(sc.nextLine()); 
		System.out.println("Are you sure you want to proceed with the input " + input);
		System.out.println("Press Y for yes");
		System.out.println("Press N for no"); 
		String confirmInput = sc.nextLine();
		if(confirmInput.equalsIgnoreCase("y")) {
			callDecisionIntroMenu(input); 
		}else if(confirmInput.equalsIgnoreCase("n")) {
			//repeat intromenu 
			introMenu(); 
		}
	}
	
	public void callDecisionIntroMenu(int i) {
		if(i == 1) {
			createCustomerAccount(); 
		}else if(i ==2) {
			loginExisitingAccountMenu(); 
		}
	}
	
	public void createCustomerAccount() {
	 System.out.println("You are at the create customer page.");
	 System.out.println("Please, input a username for your new account");
	 String newUsername = sc.nextLine(); 
	 System.out.println("Please, input a password for your new account"); 
	 String password = sc.nextLine();
	 System.out.println("Please input your first name");
	 String fn = sc.nextLine(); 
	 System.out.println("Please input your last name");
	 String ln = sc.nextLine(); 
	 CustomerPostgres cp = new CustomerPostgres(); 
	 int status = cp.add(newUsername, fn, ln, password);
	 if(status > 0) {
		 System.out.println("you will go back to the main menu");
		 
	 }else if(status == 0) {
		 System.out.println("Do you want to try to create a customer account again?");
	 }
	 
	}

	public void loginExisitingAccountMenu() {
		// TODO Auto-generated method stub
		System.out.println("Belwo are the account types you can login to");
		System.out.println("Please, input the number that corresponds to the account type you wish to login to." );
		System.out.println("Press 1 to log in into a customer account type." );
		System.out.println("Press 2 to log in into a employee account type." );
		System.out.println("Press 3 to log in into a manager account type." );
		int input = Integer.parseInt(sc.nextLine()); 
		System.out.println("Are you sure you want to proceed with the input " + input);
		System.out.println("Press Y for yes");
		System.out.println("Press N for no"); 
		String confirmInput = sc.nextLine();
		if(confirmInput.equalsIgnoreCase("y")) {
			callDecisionLoginMenu(input); 
		}else if(confirmInput.equalsIgnoreCase("n")) {
			//repeat intromenu 
			loginExisitingAccountMenu(); 
		}
		
	}
	
	public void callDecisionLoginMenu(int i) {
		if(i == 1) {
			customerLogin();
		}else if(i ==2) {
			employeeLogin(); 
		}else if(i == 3) {
			managerLogin(); 
		}
	}
	
	public void customerLogin() {
		CustomerLogin cls = new CustomerLogin(); 
		System.out.println("Please input the account's username"); 
		String un = sc.nextLine();
		System.out.println("Please input the account's password"); 
		String pw = sc.nextLine();
		Boolean status = cls.userAuth(un, pw);
		if(status) {
			System.out.println("login successful");
			customerDashboard(); 
		}else if(status != false) {
			System.out.println("Login was not successful. Please try again or go back to the main menu"); 
		}
	}
	public void employeeLogin() {
		EmployeeLogin el = new EmployeeLogin(); 
		System.out.println("Please input the account's username"); 
		String un = sc.nextLine();
		System.out.println("Please input the account's password"); 
		String pw = sc.nextLine();
		Boolean status = el.userAuth(un, pw);
		if(status) {
			System.out.println("login successful");
			employeeDashboard();
			
		}else if(status != false) {
			System.out.println("Login was not successful. Please try again or go back to the main menu"); 
		}
	}
	
	public void managerLogin() {
		ManagerLogin ml = new ManagerLogin(); 
		System.out.println("Please input the account's username"); 
		String un = sc.nextLine();
		System.out.println("Please input the account's password"); 
		String pw = sc.nextLine();
		Boolean status = ml.userAuth(un, pw);
		if(status) {
			System.out.println("login successful");
			managerDashboard(); 
		}else if(status != false) {
			System.out.println("Login was not successful. Please try again or go back to the main menu"); 
		}
	}
	
	public void managerDashboard() {
		//prioritize last since stories related to manager are bonuses
		System.out.println("Welcome, you are logged in as a manager.");
		System.out.println("Below are your options as an manager.");
		System.out.println("Please input a number according to your needs.");
		
	}
	
	public void callDecisionManager(int i) {
		if(i == 1) {
			customerLogin();
		}else if(i ==2) {
			employeeLogin(); 
		}else if(i == 3) {
			managerLogin(); 
		}
	}
	
	public void employeeDashboard() {
		System.out.println("Welcome, you are logged in as an employee.");
		System.out.println("Below are your options as an employee.");
		System.out.println("Please input a number according to your needs.");
	}
	
	public void callDecisionEmployeeDashboard(int i) {
		if(i == 1) {
			customerLogin();
		}else if(i ==2) {
			employeeLogin(); 
		}else if(i == 3) {
			managerLogin(); 
		}
	}
	
	public void customerDashboard() {
		System.out.println("Welcome, you are logged in as a customer.");
		System.out.println("Below are your options as a customer.");
		System.out.println("Please input a number according to your needs.");
		System.out.println("Press 1 to view all of the store's availaible items.");
		System.out.println("Press 2 to make a bid on an availaible item");
		System.out.println("Press 3 to view all items that you own");
		System.out.println("Press 4 to view your remaining payments for your items");
		
	}
	
	public void callDecisionCustomerDashboard(int i) {
		if(i == 1) {
			customerLogin();
		}else if(i ==2) {
			employeeLogin(); 
		}else if(i == 3) {
			managerLogin(); 
		}
	}
}
