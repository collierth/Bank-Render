package com.fdmgroup.bankUserStories.service;

import java.util.List;

import com.fdmgroup.bankUserStories.customer.Customer;
import com.fdmgroup.bankUserStories.customer.CustomerDTO;

public interface CustomerServiceInterface 
{
	
	public Customer createCustomer(CustomerDTO customer);
	
	public Customer getCustomerById(long id);
	
	public List<Customer> getAllCustomers();
	
	public Customer updateCustomer(long id, CustomerDTO updatedCustomer);
	
	public void deleteCustomerById(long id);
	
	
}
