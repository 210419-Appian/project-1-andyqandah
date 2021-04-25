package com.revature.dao;

public interface AccountDAO {
	
	
	void deposit (double amount);
	void withdraw(double amount);
	void transfer(double amounte);
	void showManu();
	void getPreivousTransaction();
	

}
