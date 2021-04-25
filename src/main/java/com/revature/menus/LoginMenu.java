package com.revature.menus;

import java.util.Scanner;

import com.revature.models.User;

public class LoginMenu implements Menu {
	
	
	
	public LoginMenu() {}
	

	public void displayOptions() {
	
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter user name: ");
	String username = in.nextLine();
	System.out.println("Please enter your password");
	String password = in.nextLine();
		
	
	User user = new User(0, username, password, password, password, password, null);
	}

	public Menu enhancedMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setScanner(Scanner in) {
		// TODO Auto-generated method stub
		
	}

	


}
