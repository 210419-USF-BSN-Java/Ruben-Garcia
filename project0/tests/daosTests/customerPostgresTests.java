package daosTests;
import org.junit.*; 
import java.util.*; 
import static org.junit.Assert.*;

import daos.CustomerPostgres;
import daos.CustomerPostgres.*;
import models.Customer;
import models.Item; 


public class customerPostgresTests {
	String testUsername = "rubens1729"; 
	Boolean cp = new CustomerPostgres().checkforUsername(testUsername);
	
	@Test
	public void testCheckforUsername() {
		assertEquals(true, cp);
	}
	
	@Test
	public void tesGetCustomerInfoByUsername() {
		Customer testCustomer = new CustomerPostgres().getCustomerByUserName(testUsername);
		String u = testCustomer.getUserName();
		assertEquals(testUsername, u);
	}
	
	@Test 
	public void testItemsOwned() {
		List<Item> t = new CustomerPostgres().getAllItemsOwned(testUsername); 
		assertEquals(t, "hello");
	}
	
}
