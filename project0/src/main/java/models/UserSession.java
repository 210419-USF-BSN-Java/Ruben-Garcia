package models;
import java.io.Serializable;


public class UserSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private Boolean userLoggedIn; 
	private String role; 
	
	public UserSession() {
		super(); 
	}
	
	public UserSession(Boolean userLoggedIn, String role) {
		this.userLoggedIn = userLoggedIn; 
		this.role = role; 
	}

	public Boolean getUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(Boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userLoggedIn == null) ? 0 : userLoggedIn.hashCode());
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
		UserSession other = (UserSession) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userLoggedIn == null) {
			if (other.userLoggedIn != null)
				return false;
		} else if (!userLoggedIn.equals(other.userLoggedIn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserSession [userLoggedIn=" + userLoggedIn + ", role=" + role + "]";
	}
	
	
}
