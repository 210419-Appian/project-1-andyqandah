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

		System.out.println("Welcome to AndrewQandah Bank");
		System.out.println("*****************************");
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter: \nregister to Register \nor \nsignin to Sign-in");
		String answer = in.nextLine();

		if ("signin".equals(answer)){	
			nextMenu = loginMenu;
		} else if ("register".equals(answer)) {
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


