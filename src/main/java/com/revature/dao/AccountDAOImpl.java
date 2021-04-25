package com.revature.dao;

import java.util.Scanner;

public class AccountDAOImpl implements AccountDAO{
	
	private double balance;
	private double amount;
	private double preivousTransacion;
	private double userId;
	private double  transfer;
	private String firstName;
	private String lastName;
	
	
	
	

	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
		if (amount != 0) {
			 balance = balance + amount;
		}
		
		
		
		
	}

	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if (amount != 0) {
			
			balance = balance - amount;
		}
		
	}

	public void transfer(double amount) {
		balance= balance - amount;	
	}

	public void showManu() {
		// TODO Auto-generated method stub
		
		char obtion = '\0';
		Scanner in = new Scanner(System.in);
		
		System.out.println(" Welcome " + firstName + " " + lastName );
		System.out.println("User ID: " + userId);
		System.out.println("\n");
		System.out.println("**************************************************************************");
		
		System.out.println("Please enter a letter from A to E based on the rquested dervice as follow" );
		System.out.println("A to Check Balance");
		System.out.println("B to Check Balance");
		System.out.println("C to Check Balance");
		System.out.println("D to Check Balance");
		System.out.println("E to Check Balance");
		
		System.out.println("\n");
		System.out.println("**************************************************************************");
	
		
	}

	public void balance() {
		// TODO Auto-generated method stub
		
	}

	public void getPreivousTransaction() {
		// TODO Auto-generated method stub
		
	}

}
