package com.revature.dao;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.models.Transactions;
import com.revature.models.User;

public interface TransacionsDAO {
	
	List<Transactions> findAll();
	List<Transactions> findUsersById(User userId);
	List<Transactions> findAllAccounts();
	List<Transactions> findAllAccountsById(Account accountId);
	List<Transactions> findAccountsByStatus(AccountStatus statusId);
	//List<Transactions> findAccountsByUser(User );
	
	void updateUser();
	void submitAccount();
	void withdraw();
	void deposit();
	void transfer();
	void passTime(); // This endpoint is designed to simulate the passing of time for Savings Accounts to accrue interest
	
	
	


}
