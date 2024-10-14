package com.fdmgroup.bankUserStories.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_ID_GEN")
	@SequenceGenerator(name="ADDRESS_ID_GEN", sequenceName="ADDRESS_ID_SEQ", allocationSize=1)
	private long addressId;
	
	@Column(nullable = false)
	private String streetNumber;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String province;
	
	@Column(nullable = false)
	private String postalCode;
	
	public Address() {
		
	}
	
	public Address(long addressId, String streetNumber, String city, String province, String postalCode) {
		super();
		this.addressId = addressId;
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
}
