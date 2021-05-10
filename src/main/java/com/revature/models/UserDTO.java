package com.revature.models;

import java.io.Serializable;

public class UserDTO {

	
		public String username;
		public String password;
		
		public UserDTO() {
			super();
		}
		
		public UserDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
	}

