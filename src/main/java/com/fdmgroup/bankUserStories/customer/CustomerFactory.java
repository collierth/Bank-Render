package com.fdmgroup.bankUserStories.customer;

import com.fdmgroup.bankUserStories.exception.IllegalCustomerTypeException;

public class CustomerFactory 
{
	public static Customer getChildCustomer(CustomerDTO customer)
	{
		Customer newCustomer = null;
		
		if (customer.getType().equalsIgnoreCase("Person"))
		{
			newCustomer = new Person();
		}
		else if (customer.getType().equalsIgnoreCase("Company"))
		{
			newCustomer = new Company();
		}
		else
		{
			throw new IllegalCustomerTypeException("The customer type "+customer.getType()+" is not a valid type.");
		}
		
		return newCustomer;
	}
}
