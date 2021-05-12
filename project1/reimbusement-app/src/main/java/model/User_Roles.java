package model;

import java.io.Serializable;

public class User_Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_role_Id; 
	private String user_role;
	
	public User_Roles() {
		super(); 
	}
	
	public User_Roles(int user_role_Id, String user_role) {
		this.user_role_Id = user_role_Id;  
		this.user_role = user_role; 
	}
	
	public int getUser_role_ID() {
		return user_role_Id;
	}
	public void setUser_role_ID(int user_role_ID) {
		this.user_role_Id = user_role_ID;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
		result = prime * result + user_role_Id;
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
		User_Roles other = (User_Roles) obj;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		if (user_role_Id != other.user_role_Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User_Roles [user_role_ID=" + user_role_Id + ", user_role=" + user_role + "]";
	} 
	
	
}
