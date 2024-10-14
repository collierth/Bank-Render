package com.fdmgroup.bankUserStories.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdmgroup.bankUserStories.account.Account;
import com.fdmgroup.bankUserStories.account.AccountDTO;
import com.fdmgroup.bankUserStories.account.AccountFactory;
import com.fdmgroup.bankUserStories.customer.Customer;
import com.fdmgroup.bankUserStories.customer.CustomerDTO;
import com.fdmgroup.bankUserStories.customer.CustomerFactory;
import com.fdmgroup.bankUserStories.exception.AccountNotFoundException;
import com.fdmgroup.bankUserStories.geoCoder.Geodata;
import com.fdmgroup.bankUserStories.repository.AccountRepository;

@Service
public class AccountService implements AccountServiceInterface
{
	private AccountRepository accRepo;
	private CustomerService customerService;
	
	
	public AccountService(AccountRepository accRepo, CustomerService customerService) {
		super();
		this.accRepo = accRepo;
		this.customerService = customerService;
	}

	public Account createAccount(AccountDTO accountDTO)
	{
		Customer customer = customerService.getCustomerById(accountDTO.getCustomerId());
		
		Account newAccount = AccountFactory.getChildAccount(accountDTO, customer);
		
		return accRepo.save(newAccount);
	}
	
	public Account getAccountById(long id)
	{
		return accRepo.findById(id).orElseThrow(
				() -> new AccountNotFoundException("Account with id "+id+" could not be found"));
	}
	
	public List<Account> getAllAccounts()
	{
		return accRepo.findAll();
	}

	public List<Account> getAccountsByCity(String city) 
	{
		return accRepo.findAllByCity(city);
	}

	public void deleteAccountById(long id) 
	{
		accRepo.deleteById(id);
	}
	
	public Account deposit(long id, double amount)
	{
		Account existingAccount = getAccountById(id);
		double currentBalance = existingAccount.getBalance();
		existingAccount.setBalance(currentBalance + amount);
		return accRepo.save(existingAccount);
	}
	
	public Account withdraw(long id, double amount)
	{
		Account existingAccount = getAccountById(id);
		double currentBalance = existingAccount.getBalance();
		existingAccount.setBalance(currentBalance - amount);
		return accRepo.save(existingAccount);
	}

}
