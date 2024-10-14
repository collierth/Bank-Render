package com.fdmgroup.bankUserStories.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.bankUserStories.account.Account;
import com.fdmgroup.bankUserStories.account.AccountDTO;
import com.fdmgroup.bankUserStories.customer.Customer;
import com.fdmgroup.bankUserStories.customer.CustomerDTO;
import com.fdmgroup.bankUserStories.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/accounts")
public class AccountController 
{
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@Operation(summary = "Creates an account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody AccountDTO account)
	{
		Account createdAccount = accountService.createAccount(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdAccount.getAccountId()).toUri();
		
		return ResponseEntity.created(location).body(createdAccount);
	}
	
	@Operation(summary = "Grabs one account by id number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/id/search")
	public Account getAccountById(@RequestParam long id)
	{
		return accountService.getAccountById(id);
	}
	
	@Operation(summary = "Grabs all accounts stored")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@GetMapping
	public List<Account> getAccounts()
	{
		return accountService.getAllAccounts();
	}
	
	@Operation(summary = "Grabs all accounts of customers in a particular city")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/city/search")
	public List<Account> getAccountsOfCustomersInCity(@RequestParam String city)
	{
		return accountService.getAccountsByCity(city);
	}
	
	@Operation(summary = "Deletes one account by id number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@DeleteMapping("/id/{id}")
	public void deleteAccount(@PathVariable long id)
	{
		accountService.deleteAccountById(id);
	}
	
	@Operation(summary = "Deposits money into one account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@PatchMapping("/deposit/{id}/{amount}")
	public Account deposit(@PathVariable long id, @PathVariable double amount)
	{
		return accountService.deposit(id, amount);
	}
	
	@Operation(summary = "Deposits money into one account")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@PatchMapping("/withdraw/{id}/{amount}")
	public Account withdraw(@PathVariable long id, @PathVariable double amount)
	{
		return accountService.withdraw(id, amount);
	}
	
	
}
