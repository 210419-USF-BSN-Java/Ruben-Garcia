package daosTests;
import org.junit.*; 
import java.util.*; 
import static org.junit.Assert.*;

import daos.CustomerPostgres;
import models.Customer;
import models.Item; 

public class CustomerAccountCreateTest {
	private String u = "jake123";
	private String fn = "jake"; 
	private String ln = "doe";
	private String pw = "password"; 
	
	@Test
	public void testCustomerAccountCreate() {
		CustomerPostgres cp = new CustomerPostgres(); 
		int a = cp.add(u, fn, ln, pw); 
		assertEquals(1, a); 
	}
}
