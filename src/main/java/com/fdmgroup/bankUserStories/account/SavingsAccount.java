package com.fdmgroup.bankUserStories.account;

import com.fdmgroup.bankUserStories.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account
{
	@Column(nullable = false)
	private double interestRate = 0.0;

	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SavingsAccount(double balance, String nickname, String type, double interestRate, Customer customer) {
		super(balance, nickname, type, customer);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	
}
