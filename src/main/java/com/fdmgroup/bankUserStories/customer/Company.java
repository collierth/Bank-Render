package com.fdmgroup.bankUserStories.customer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMPANY")
public class Company extends Customer
{

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(long customerId, String name, Address address) {
		super(customerId, name, address);
	}

	
	
}
