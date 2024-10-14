package com.fdmgroup.bankUserStories.customer;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fdmgroup.bankUserStories.account.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Customer_Type", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUST_ID_GEN")
	@SequenceGenerator(name="CUST_ID_GEN", sequenceName="CUST_ID_SEQ",  initialValue=1001, allocationSize=1)
	private long customerId;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_Address_Id", nullable = false)
	private Address address;

	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
	@JsonManagedReference
	private List<Account> accounts = new ArrayList<>();
	
	public Customer()
	{
		
	}

	public Customer(long customerId, String name, Address address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}
}
