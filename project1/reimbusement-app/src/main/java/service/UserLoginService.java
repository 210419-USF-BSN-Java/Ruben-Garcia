package service;

import dao.UserDaoPostgres;

public class UserLoginService {
	UserDaoPostgres up = new UserDaoPostgres(); 
	
	public boolean validateAuth (String username, String password) {
		Boolean status = up.validate(username, password); 
		return status;
		
	}
}
