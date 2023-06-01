package com.rgt.training.session2basics.simpleatm;

import java.util.Scanner;

public class BankOperation {
	private int accountNumber;
	private int pin;
	private double balance;
	private double[] transactions;
	private int transactionCount;
	private String accHolderName;  
	private String accountType;
	int choice;
	
	Accounts ac;
	Scanner sc;

	public BankOperation() {
	    sc = new Scanner(System.in);  
		transactions = new double[100];
		transactionCount = 0;
		
	}
	
	public void createAccount() {
		System.out.println("Please proceeds with below steps to create account");
		System.out.print("Please enter your Full Name: ");
		accHolderName=sc.nextLine();
		System.out.print("Please select Account type: ");
		accountType=sc.next();
		System.out.print("Enter Account Number: ");
		accountNumber=sc.nextInt();
		System.out.print("Set pin to your account: ");
		pin=sc.nextInt();
		System.out.print("Please deposit the initial ammount to your: ");
		balance=sc.nextDouble();
		ac=new Accounts(accountNumber, pin, balance);
		System.out.println("Account created Succefully");
		
	}
	
	public void login() {
		 System.out.print("Enter the account number: ");
	        int acc_no=sc.nextInt();
	        try {
	        if(acc_no==ac.getAccNumber()) {
	            System.out.print("Enter the pin number: ");
	            int pin=sc.nextInt();
	            System.out.println();
	            if(pin==ac.getPin()) {
	                System.out.println("Logged in sucessfull");
	                do {
	                    System.out.println("Welcome "+acc_no);
	                    System.out.println("1. Account deatils");
	                    System.out.println("2. Check Balance");
	                    System.out.println("3. Deposit");
	                    System.out.println("4. Withdraw");
	                    System.out.println("5. View Transaction History");
	                    System.out.println("6. Exit");
	                    System.out.print("Choose an option: ");
	                    choice = sc.nextInt();
	                    switch (choice) {
	                    	case 1:
	                    		showAccount();
	                    		break;
	                        case 2:
	                            System.out.println("Current balance: $" + ac.getbalance());
	                            break;
	                        case 3:
	                            System.out.print("Enter deposit amount: $");
	                            double depositAmount = sc.nextDouble();
	                           deposit(depositAmount);
	                            break;
	                        case 4:
	                            System.out.print("Enter withdrawal amount: $");
	                            double withdrawalAmount = sc.nextDouble();
	                            withdraw(withdrawalAmount);
	                            break;
	                        case 5:
	                        	showTransactionHistory();
	                            break;
	                        case 6:
	                            System.out.println("Goodbye!");
	                            break;
	                        default:
	                            System.out.println("Invalid option. Please try again.");
	                    }
	                    System.out.println();
	                } while (choice != 6);
	            }else {
	                System.out.println("Pin is Invalid");
	            }
	        }else {
	            System.out.println("Account number is Invalid");
	        }
	        }catch (Exception e) {
	        	System.out.println("Invalid account");
			}
	}
	

	public double checkBalance() {
		return ac.getbalance();
	}

	public void deposit(double amount) {
		if (amount > 0) {
			ac.setbalance(ac.getbalance()+ amount);
			transactions[transactionCount++] = amount;
			System.out.println("Deposit successful!");
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient balance.");
		} else if (amount < 0) {
			System.out.println("Invalid withdrawal amount.");
		} else {
			ac.setbalance(ac.getbalance()- amount);
			transactions[transactionCount++] = -amount;
			System.out.println("Withdrawal successful!");
		}
	}

	public void showTransactionHistory() {
		System.out.println("Transaction History:");
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i] > 0) {
				System.out.println("Deposit: $" + transactions[i]);
			} else {
				System.out.println("Withdraw: $" + (-transactions[i]));
			}
		}
	}
	
	 public void showAccount() {  
	        System.out.println("Name of account holder: " +accHolderName );  
	        System.out.println("Account no.: " + ac.getAccNumber());  
	        System.out.println("Account type: " + accountType);  
	        System.out.println("Balance: " + ac.getbalance());  
	    } 
}
