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

public AccountDAOImpl() {
	// TODO Auto-generated constructor stub
}
	public AccountDAOImpl(double balance, double amount, double preivousTransacion, double userId, double transfer,
			String firstName, String lastName) {
		super();
		this.balance = balance;
		this.amount = amount;
		this.preivousTransacion = preivousTransacion;
		this.userId = userId;
		this.transfer = transfer;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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
			System.out.println("You withdrew $" + amount + "\nYour new balance is $" + balance);
		}

	}

	public void transfer(double amount) {
		balance= balance - amount;	
	}

	public void showManu() {
		// TODO Auto-generated method stub

		char option = '\0';
		Scanner in = new Scanner(System.in);

		System.out.println(" Welcome " + firstName + " " + lastName );
		System.out.println("User ID: " + userId);
		System.out.println("\n");
		System.out.println("**************************************************************************");

		System.out.println("Please enter a letter from A to E based on the rquested service as follow" );
		System.out.println("\n");
		System.out.println("**************************************************************************");
		
		System.out.println("A to Check Balance");
		System.out.println("B to Deposit");
		System.out.println("C to Withdraw");
		System.out.println("D to Preivous Tranaction");
		System.out.println("E to Exit");

		


		do {
			option = in.next().charAt(0);
			System.out.println("\n");


			switch (option) 
			{

			case 'A' :
				System.out.println("**************************************************************************");
				System.out.println( "Balance = " + balance);
				System.out.println("**************************************************************************");
				System.out.println("\n");
				break;
				
			case 'B' :
				System.out.println("**************************************************************************");
				System.out.println("Please enter the deposit amount");
				System.out.println("**************************************************************************");
				double amount = in.nextDouble();
				deposit(amount);
				System.out.println("You deposited $" + amount + "\nYour new Balance is $"+balance );
				System.out.println("\n");
				break;

			case 'C' :
				System.out.println("**************************************************************************");
				System.out.println("Please enter your withdraw amount");
				double amount2 = in.nextDouble();
				withdraw(amount2);
				System.out.println("**************************************************************************");
				System.out.println("\n");
				break;

			case 'D' :
				System.out.println("**************************************************************************");
				getPreivousTransaction();
				System.out.println("**************************************************************************");
				System.out.println("\n");
				break;

			case 'E' :
				System.out.println("**************************************************************************");
				break;
				
				default:
					System.out.println("Invalid Option. Try Again");
			}

		}while(option != 'E');

		System.out.println("Thank you for choosing Andrew's Bank");
		System.out.println("**************************************************************************");

	}

	public void balance(double balance) {
		this.balance= balance;

	}

	public void getPreivousTransaction() {
		if (preivousTransacion > 0) {
			
			System.out.println("Deposited : " + preivousTransacion);
		}
		else if ( preivousTransacion < 0) {
			System.out.println("Withdrew :" + Math.abs(preivousTransacion)) ;
		}
		
		else {
			
			System.out.println("No transactions reported");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPreivousTransacion() {
		return preivousTransacion;
	}

	public void setPreivousTransacion(double preivousTransacion) {
		this.preivousTransacion = preivousTransacion;
	}

	public double getUserId() {
		return userId;
	}

	public void setUserId(double userId) {
		this.userId = userId;
	}

	public double getTransfer() {
		return transfer;
	}

	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
