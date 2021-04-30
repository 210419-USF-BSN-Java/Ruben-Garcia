package driver;
import java.util.Scanner;
import presentation.ConsoleUI; 

public class Driver {
    //where program will start 
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ConsoleUI welcome = new ConsoleUI().welcome(); 
    }
}
