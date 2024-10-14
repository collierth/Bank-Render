package com.fdmgroup.bankUserStories.account;

import org.springframework.stereotype.Component;

import com.fdmgroup.bankUserStories.customer.Customer;

public class AccountDTO 
{
	private long customerId;
	private String type;
	private double balance;
	private double interestRate;
	private int nextCheckNumber;
	
	public AccountDTO() {
		super();
	}

	public AccountDTO(long customerId, String type, double balance, double interestRate, int nextCheckNumber) {
		super();
		this.customerId = customerId;
		this.type = type;
		this.balance = balance;
		this.interestRate = interestRate;
		this.nextCheckNumber = nextCheckNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}	
}
