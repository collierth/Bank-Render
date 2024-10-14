package com.fdmgroup.bankUserStories.service;

import java.util.List;

import com.fdmgroup.bankUserStories.account.Account;
import com.fdmgroup.bankUserStories.account.AccountDTO;

public interface AccountServiceInterface 
{
	public Account createAccount(AccountDTO accountDTO);
	
	public Account getAccountById(long id);
	
	public List<Account> getAllAccounts();
	
	public List<Account> getAccountsByCity(String city);
	
	public void deleteAccountById(long id);
	
}
