package com.revature.menus;

import java.util.Scanner;

public interface Menu {
	
public void displayOptions();

public Menu enhancedMenu();

public Menu previousMenu();

public void setScanner(Scanner in);


}
