package com.revature.dao;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;

public interface UserDAO {
	
	List<User> findAll();
	User findUserById(int id);
	User findUserByName(String user);
	
	boolean addUser(User u);
	boolean updateUser(User u, int id);
	boolean registerAccount(double balance, int type, User user);
	User findByUsername(String username);

}
