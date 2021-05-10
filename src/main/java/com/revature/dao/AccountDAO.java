package com.revature.dao;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDAO {

	List<Account> findAll();
	Account findById(int id);
	boolean addAccount(Account a);
	boolean updateAccount(Account a, int id);
	boolean withdraw(Account a, double amount);
	boolean deposit (Account a, double amount);
	boolean transfer(Account sourceAccount, Account targetAccount, double amount);
	List<Account> findByStatus(int id);
	List<Account> findByUser(User u);
	boolean deleteAccount(Account a);


}



