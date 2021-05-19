package dao;

import model.User;

public interface UserDao extends GenericDaos<User>{
	public boolean validate(String username, String password);
}
