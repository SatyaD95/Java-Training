package com.rgt.training.session2basics.simpleatm;

import java.util.Scanner;


public class PublicBank {
	  public static void main(String[] args) {
		  BankOperation bank = new BankOperation();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("Welcome to the  Public Bank");
	            System.out.println("1. Create new account");
	            System.out.println("2. Login");
	            System.out.println("3. Logout");
	            System.out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                	bank.createAccount();
	                    break;
	                case 2:
	                	bank.login();
	                    break;
	                case 3:
	                    System.out.print("Logged out Succesfully ");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }

	            System.out.println();

	        } while (choice !=3);

	        scanner.close();
	    }
}
