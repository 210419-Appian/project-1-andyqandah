package com.revature.driver;

import java.util.Scanner;

import com.revature.menus.LoginMenu;
import com.revature.menus.Menu;
import com.revature.menus.WelcomeMenu;
import com.revature.menus.registractionMenu;

public class Driver {

	public static void main(String[] args) {
		
	
		Scanner in = new Scanner(System.in);
		Menu register = new registractionMenu();
		Menu login = new LoginMenu();
		Menu welcomeMenu = new WelcomeMenu(login, register);
		((registractionMenu)register).setWelcomeMenu(welcomeMenu);
		login.setScanner(in);
		register.setScanner(in);
		welcomeMenu.setScanner(in);
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.enhancedMenu();
			
		} while (nextMenu != null);
		

		
	}

}

	


	


