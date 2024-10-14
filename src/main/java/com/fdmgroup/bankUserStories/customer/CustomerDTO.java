package com.fdmgroup.bankUserStories.customer;

import org.springframework.stereotype.Component;

public class CustomerDTO 
{
	private String type;
	private String name;
	private Address address;
	
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String type, String name, Address address) {
		super();
		this.type = type;
		this.name = name;
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [type=" + type + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
