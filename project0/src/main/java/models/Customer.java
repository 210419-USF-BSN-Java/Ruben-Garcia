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
	private String userName; 

	public Customer() {
		super(); 
	}
	
	public Customer(Integer id, String firstName, String lastName, String password, String userName) {
		super(); 
		this.id = id; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.password = password; 
		this.userName = userName; 
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

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName; 
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
	
}
