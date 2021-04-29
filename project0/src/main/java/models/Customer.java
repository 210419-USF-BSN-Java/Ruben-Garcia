package models;
import java.io.Serializable;

public class Customer implements GenericUser, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String firstName; 
	private String lastName;
	private String password; 

	public Customer() {
		super(); 
	}
	
	public Customer(Integer id, String firstName, String lastName, String password) {
		super(); 
		this.id = id; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.password = password; 
	}
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id; 
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName; 
	}

	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName; 
		
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName; 
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName; 
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password; 
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password; 
	}
}
