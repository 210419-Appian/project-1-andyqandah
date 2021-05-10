package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDAOImpl;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.dao.AccountDAO;

public class AccountService  {
	
		private static AccountDAO accDAO = new AccountDAOImpl();

		public static List<Account> findAll() {
			return accDAO.findAll();
		}


		public Account findById(int id) {
			return accDAO.findById(id);
		}

		public boolean addAccount(Account a) {
			return accDAO.addAccount(a);}
		
		
		public boolean updateAccount(Account myAccount, int id) {
			Account acc = findById(id);
			if(acc != null) {
				if (acc.getAccountId() == id) {
					return accDAO.updateAccount(acc, id);				
				}else {
					return false;
				}
			}else {
				return accDAO.updateAccount(acc, id);
			}

		}
		
		public boolean withdraw(Account account, double amount) {
			try {
				if(account.getBalance() < amount) {
					throw new Exception("Insufficient fund for this transaction");
				}else {
					return accDAO.withdraw(account, amount);
				}
			}catch(Exception  e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean deposit(Account account, double amount) {
			return accDAO.deposit(account, amount);
		}
		
		
		
		public boolean transfer(Account sourceAccount, Account targetAccount, double amount) {
			try {
				if(sourceAccount.getBalance() < amount) {
					throw new Exception("Insufficient fund for this transaction");
				}else {
					return accDAO.transfer(sourceAccount, targetAccount, amount);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public List<Account> findByStatus(int status) {
			return accDAO.findByStatus(status);
		}

		
		}


	
	
