package com.fdmgroup.bankUserStories.account;

import com.fdmgroup.bankUserStories.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account
{
	@Column(nullable = false)
	private int nextCheckNumber = 1;

	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(double balance, String nickname, String type, int nextCheckNumber, Customer customer) {
		super(balance, nickname, type, customer);
		this.nextCheckNumber = nextCheckNumber;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}
	
	
	
	
}
