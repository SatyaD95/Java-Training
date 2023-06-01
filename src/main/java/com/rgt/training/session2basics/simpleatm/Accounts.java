package com.rgt.training.session2basics.simpleatm;

public class Accounts {
	private int accountNumber;
	private int pin;
	private double balance;

	public Accounts(int accountNumber, int pin, double balance) {
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}

	public int getAccNumber() {
		return accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public double getbalance() {
		return balance;
	}
	
	public double setbalance(double balance) {
		 return this.balance=balance;
	}

}
