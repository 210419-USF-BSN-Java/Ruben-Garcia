package ServiceLayerTest;
import daos.CustomerPostgres;
import services.CustomerLogin;
import services.EmployeeLogin;
import services.ManagerLogin;

import org.junit.*; 
import java.util.*; 
import static org.junit.Assert.*;

import models.Customer;
import models.Item; 


public class LoginTests {
	String testUsername = "rubens1729"; 
	String testPassword = "password"; 
	String testUsername2 = "john1";
	String testPassword2 = "password1";
	String testU = "rubens1729";
	String testP = "wrongpassword"; 
	@Test 
	public void testCustomerLogin() {
		Boolean c = new CustomerLogin().userAuth(testUsername, testPassword);
		assertEquals(true, c);
	}
	@Test 
	public void testCustomerLogin2() {
		Boolean c = new CustomerLogin().userAuth(testUsername2, testPassword2); 
		assertEquals(true, c);
	}
	@Test 
	public void testCustomerLogin3() {
		Boolean c = new CustomerLogin().userAuth(testU, testP); 
		assertEquals(false, c);
	}
	@Test
	public void testEmployeeLogin1() {
		Boolean c = new EmployeeLogin().userAuth(testU, testP); 
		assertEquals(false, c);
	}
	@Test
	public void testEmployeeLogin2() {
		Boolean c = new EmployeeLogin().userAuth("snake", "password"); 
		assertEquals(true, c);
	}
	
	@Test
	public void testManagerLogin1() {
		Boolean c = new ManagerLogin().userAuth(testU, testP); 
		assertEquals(false, c);
	}
	@Test
	public void testManagerLogin2() {
		String testu = "bigboss";
		String testp = "Garcia";
		Boolean c = new ManagerLogin().userAuth( testu,testp); 
		assertEquals(true, c);
	}
}
