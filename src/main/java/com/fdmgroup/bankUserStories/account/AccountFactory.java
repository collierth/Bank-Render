package com.fdmgroup.bankUserStories.account;

import com.fdmgroup.bankUserStories.customer.Company;
import com.fdmgroup.bankUserStories.customer.Customer;
import com.fdmgroup.bankUserStories.customer.CustomerDTO;
import com.fdmgroup.bankUserStories.customer.Person;
import com.fdmgroup.bankUserStories.exception.IllegalAccountTypeException;

public class AccountFactory 
{
	public static Account getChildAccount(AccountDTO account, Customer customer)
	{
		Account newAccount = null;
		
		double balance = 0;
		
		if (account.getType().equalsIgnoreCase("Savings"))
		{
			newAccount = new SavingsAccount(account.getBalance(), "i[save]", "savings", account.getInterestRate(), customer);
		}
		else if (account.getType().equalsIgnoreCase("Checking"))
		{
			newAccount = new CheckingAccount(account.getBalance(), "i[check]", "checking", account.getNextCheckNumber(), customer);
		}
		else
		{
			throw new IllegalAccountTypeException("The account type "+account.getType()+" is not a valid type.");
		}
		
		return newAccount;
	}
}
