package models;
import java.io.Serializable;

public class Manager implements GenericUser, Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String firstName; 
	private String lastName; 
	private String userName; 
	private String password; 
	
	public Manager() {
		super(); 
	}

	public Manager(Integer id, String firstName, String userName, String password) {
		super(); 
		this.id = id; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.userName = userName;
		this.password = password; 
	}
	
	public Integer getId() {
		return id; 
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id; 
		
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName; 
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName; 
		
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName; 
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName; 
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password; 
	}

	@Override
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
		Manager other = (Manager) obj;
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

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
}
