package mainmethod;
import java.util.List;
import java.util.Scanner;
import presentation.ConsoleUI; 
import models.Item;
import daos.ItemPostgres;

public class MainMethod {
    //where program will start 
	
    public static void main(String[] args) {
    /*	
	Scanner sc = new Scanner(System.in);
	ConsoleUI welcome = new ConsoleUI().welcome(); 
	*/
    	/*
    	ItemPostgres item = new ItemPostgres(); 
    	
    	List<Item> li = item.getAll();
    	for (Item i: li) {
    		System.out.println(i);
    		}
    	}
    	*/ 
    	//Boolean customerLogin = new ConsoleUI().customerLogin(); 
    	
    	//Boolean employeeLogin = new ConsoleUI().EmployeeLogin(); 
    	//Boolean managerLogin = new ConsoleUI().ManagerLogin();
    	ConsoleUI test = new ConsoleUI(); 
    	/*
    	ItemPostgres ip = new ItemPostgres(); 
    	ip.add("broom", 9.99); 
    	*/ 
    	
    	//test.createCustomerAccount();
    	test.deleteItem(); 
 
    	
    }
}
