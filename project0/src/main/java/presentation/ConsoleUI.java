package presentation;
import java.util.Scanner;
import services.customerLogin;

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
		System.out.println("please input your username"); 
		userName = sc.nextLine(); 
		System.out.println("please input your password"); 
		password = sc.nextLine(); 
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
  
		customerLogin a = new customerLogin(); 
		Boolean accessGranted = a.userAuth(username, password);
		if(accessGranted == true) {
    		System.out.println("login successful");
    	}else {
    		System.out.println("login unsuccessful"); 
    	}
		sc.close();
		return accessGranted;
	}
	 
	
	
	
	
}
