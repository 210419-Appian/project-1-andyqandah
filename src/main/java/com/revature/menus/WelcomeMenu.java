package com.revature.menus;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Menu nextMenu;
	private Menu registractionMenu;
	private Menu loginMenu;

	
	public Menu enhancedMenu() {
		return nextMenu;
		// TODO Auto-generated method stub

	}
	
	public void displayOptions(){
		System.out.println("\n");
		System.out.println("Welcome to Andrew Qandah's Bank");
		System.out.println("**************************************************************************");
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter : A to Sign-in or B to Register");
		System.out.println("**************************************************************************");
		String answer = in.nextLine();

		if ("A".equals(answer)){	
			nextMenu = loginMenu;
		} else if ("B".equals(answer)) {
			nextMenu = registractionMenu;
		} else { System.out.println("Invalid input");
		  	nextMenu = this;
		}
	}

	public  Menu previousMenu() {
		return null;
	}
	public Menu getNextMenu() {
		return nextMenu;
	}
	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}
	public  WelcomeMenu() {
		super();
	}

	public WelcomeMenu( Menu loginMenu, Menu registractionMenu) {
		super();
		this.registractionMenu = registractionMenu;
		this.loginMenu = loginMenu;
}

	public void setScanner(Scanner in) {
		// TODO Auto-generated method stub
		
	}

}


