package com.revature.dao;

public interface AccountDAO {
	
	
	void deposit (double amount);
	void withdraw(double amount);
	void transfer(double amount);
	void showManu();
	void balance(double amount);
	void getPreivousTransaction();
	

}
