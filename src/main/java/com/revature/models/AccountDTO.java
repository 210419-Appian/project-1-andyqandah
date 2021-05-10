package com.revature.models;

import javax.servlet.http.HttpServlet;

public class AccountDTO extends HttpServlet {
		public int accountId;

		public AccountDTO() {
			super();
		}

		public AccountDTO(int accountId) {
			super();
			this.accountId = accountId;
		}
		
		
	}

