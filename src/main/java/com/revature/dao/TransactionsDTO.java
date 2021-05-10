package com.revature.dao;

import javax.servlet.http.HttpServlet;

public class TransactionsDTO extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3882102327292019501L;
			public String username;
			public String password;

			private int accountId;
			private double amount;
			
			public TransactionsDTO() {
				super();
			}
			
			public TransactionsDTO(int accountId, double amount) {
				super();
				this.accountId = accountId;
				this.amount = amount;
			}
		}

