package com.revature.menus;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Menu nextMenu;
	private Menu registractionMenu;
	private Menu loginMenu;

	public  WelcomeMenu() {
		super();
	}

	public WelcomeMenu( Menu loginMenu, Menu registractionMenu) {
		super();
		this.registractionMenu = registractionMenu;
		this.loginMenu = loginMenu;
	}

	
	public void displayOptions(){

		System.out.println("Welcome to AndrewQandah Bank");
		System.out.println("*****************************");
		System.out.println("Please enter: \n0 to Register \nor \n1 to Sign-in");
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();

		if (1 ==answer){	
			nextMenu = loginMenu;
		} else if (1 == answer) {
			nextMenu = registractionMenu;
		} else { System.out.println("Invalid input");
		setNextMenu(registractionMenu);
		}
	}

	public Menu enhancedMenu() {
		return loginMenu;
		// TODO Auto-generated method stub

	}

	public  Menu previousMenu() {
		return null;

	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}}




