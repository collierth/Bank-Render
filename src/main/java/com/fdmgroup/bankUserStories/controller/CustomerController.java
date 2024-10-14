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
import org.springframework.web.bind.annotation.PutMapping;
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
import com.fdmgroup.bankUserStories.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/customers")
public class CustomerController 
{
	private CustomerService customerService;
	private AccountService accountService;

	public CustomerController(CustomerService customerService, AccountService accountService) 
	{
		super();
		this.customerService = customerService;
		this.accountService = accountService;
	}
	
	@Operation(summary = "Creates a customer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customer)
	{
		Customer createdCustomer = customerService.createCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdCustomer.getCustomerId()).toUri();
		
		return ResponseEntity.created(location).body(createdCustomer);
	}
	
	@Operation(summary = "Grabs all customers stored")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@GetMapping
	public List<Customer> getCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@Operation(summary = "Grabs one customer by id number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/id/search")
	public Customer getCustomerById(@RequestParam long id)
	{
		return customerService.getCustomerById(id);
	}
	
	@Operation(summary = "Grabs all customers in a particular city")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/city/search")
	public List<Customer> getCustomersInCity(@RequestParam String city)
	{
		return customerService.getCustomersByCity(city);
	}
	
	@Operation(summary = "Updates one or more customer fields, excluding the customer's street number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@PatchMapping("/id/{id}")
	public Customer updateCustomer(@PathVariable long id, @RequestBody CustomerDTO customerUpdates)
	{
		return customerService.updateCustomer(id, customerUpdates);
	}
	
	@Operation(summary = "Deletes one customer by id number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@DeleteMapping("/id/{id}")
	public void deleteCustomer(@PathVariable long id)
	{
		customerService.deleteCustomerById(id);
	}

}
