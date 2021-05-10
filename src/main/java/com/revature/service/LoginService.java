package com.revature.service;

import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;
import com.revature.models.UserDTO;

public class LoginService {

	private UserService uService = new UserService();
	UserDAOImpl uDAO = new UserDAOImpl();
	UserDTO uDTO = new UserDTO();
	public boolean login(String username, String password) {
		User myUser = uService.findByUsername(username);
		//UserDTO myUser = new UserDTO();
		if (myUser!= null) {
			if (myUser.getPassword().equals(password)) {

				return true;
			}
			return false;
		}else {
			return false;
		}
	}

}
