package service;

import dao.UserDaoPostgres;

public class UserLoginService {
	UserDaoPostgres up = new UserDaoPostgres(); 
	
	public boolean validateAuth (String username, String password) {
		Boolean status = up.validate(username, password); 
		return status;
	}
	
	//login role_id of 1 is a manager 
	//login_role id of 2 is a employee
	
	public int getRoleId(String username) {
		int role_id = up.getRoleIdOfUser(username);
		return role_id;
	}
}
