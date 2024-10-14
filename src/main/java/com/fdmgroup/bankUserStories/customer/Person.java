package com.fdmgroup.bankUserStories.customer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PERSON")
public class Person extends Customer{

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(long customerId, String name, Address address) {
		super(customerId, name, address);
	}

	

	
}
