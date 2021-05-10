package com.revature.service;



import java.util.List;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.models.UserDTO;



public class UserService{

	private UserDAO uDAO = new UserDAOImpl();

	public List<User> getAll() {
		return uDAO.findAll(); 	
	}

	public User findUserById(int id) {
		return uDAO.findUserById(id);
	}

	public boolean registerAccount(double balance, int type, User user) {
		if(balance >= 0 && type == 2 || type == 1) {
			return uDAO.registerAccount(balance, type, user);
		}
		return false;
	}

	public boolean updateUser(User u, int id) {
		User u2 = findByName(u.getUsername());
		if(u2 != null) {
			if(u2.getUserId() == id) {
				return uDAO.updateUser(u, id);				
			}else {
				return false;
			}
		}else {
			return uDAO.updateUser(u, id);
		}
	}

	public User findByName(String username) {

		return uDAO.findUserByName(username);

	}

	public User findById(int id) {
		return uDAO.findUserById(id);
	}
	
	public User findByUsername(String username) {
		return uDAO.findByUsername(username);
	}
	
	

	public boolean AuthService(UserDTO userDTO) {

		boolean success = false;
		User myUser = findByName(userDTO.username);

		if(myUser != null) {
			if(userDTO.password.equals(myUser.getPassword())) {
				success = true;
			}
		}
		return success;
	}

	public boolean addUser(User u) {
		// TODO Auto-generated method stub
			return uDAO.addUser(u);
	
		}
}

