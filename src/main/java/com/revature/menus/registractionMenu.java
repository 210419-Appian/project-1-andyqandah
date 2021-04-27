package com.revature.menus;

import java.util.Scanner;

import com.revature.models.User;

public class registractionMenu implements Menu { // i see the spilling error

	private Menu welcomeMenu;
	private Menu nextMenu;


	public Menu enhancedMenu() {
		// TODO Auto-generated method stub
		return nextMenu;
		
	}
	public void displayOptions() {
		User user = new User();
		Scanner in = new Scanner(System.in);
		System.out.println("**************************************************************************");
		System.out.println("PLease create a new username: ");
		System.out.println("**************************************************************************");
		String username = in.nextLine();
		System.out.println("**************************************************************************");
		System.out.println("PLease create a new password: ");
		System.out.println("**************************************************************************");
		String password = in.nextLine();
		
		nextMenu = welcomeMenu;
	}
	
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public registractionMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public registractionMenu(Menu welcomeMenu, Menu nextMenu) {
		super();
		this.welcomeMenu = welcomeMenu;
	}
	
	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}
	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}
	public Menu getNextMenu() {
		return nextMenu;
	}
	public void setScanner(Scanner in) {
		// TODO Auto-generated method stub
		
	}
	


}
