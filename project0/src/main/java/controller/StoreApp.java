package controller;

import services.Services; 
import java.util.Scanner;



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
		System.out.println("Please, input a number" );
		System.out.println("Press 1 to create a new customer account." );
		System.out.println("Press 2 to log in into an exisiting account." );
		int input = Integer.parseInt(sc.nextLine()); 
		System.out.println("Are you sure you want to proceed with the input " + input);
		System.out.println("Press Y for yes");
		System.out.println("Press N for no"); 
		String confirmInput = sc.nextLine();
		if(confirmInput.equalsIgnoreCase("y")) {
			callDecision(input); 
		}else if(confirmInput.equalsIgnoreCase("n")) {
			//repeat intromenu 
			introMenu(); 
		}
	}
	
	public void callDecision(int i) {
		if(i == 1) {
			createCustomerAccount(); 
		}else if(i ==2) {
			loginExisitingAccountMenu(); 
		}
	}
	
	public Object createCustomerAccount() {
	 System.out.println("You are at the create customer page.");
		return null;
	}

	public Object loginExisitingAccountMenu() {
		// TODO Auto-generated method stub
		System.out.println("Please choose what account type you will like to login into");
		return null;
	}
}
