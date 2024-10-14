package com.fdmgroup.bankUserStories.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fdmgroup.bankUserStories.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACC_ID_GEN")
	@SequenceGenerator(name="ACC_ID_GEN", sequenceName="ACC_ID_SEQ",  initialValue=2000000, allocationSize=1)
	private long accountId;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private double balance = 0.0;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "FK_Cust_Id")
	private Customer customer;

	public Account() {
		super();
	}

	public Account(double balance, String nickname, String type, Customer customer) {
		super();
		this.balance = balance;
		this.nickname = nickname;
		this.type = type;
		this.customer = customer;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
