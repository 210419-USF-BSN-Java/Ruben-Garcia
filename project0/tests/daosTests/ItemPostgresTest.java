package daosTests;
import org.junit.*; 
import java.util.*; 
import static org.junit.Assert.*;

import daos.ItemPostgres;
import models.Customer;
import models.Item; 

public class ItemPostgresTest {
	String t = "broom"; 
	Double d = 9.99; 
	@Test
	public void testAddItem() {
		ItemPostgres ip = new ItemPostgres(); 
		ip.add(t, d); 
		assertEquals(1, a); 
	}
}
