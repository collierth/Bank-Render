package com.fdmgroup.bankUserStories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.bankUserStories.account.Account;
import com.fdmgroup.bankUserStories.account.AccountDTO;
import com.fdmgroup.bankUserStories.account.AccountFactory;
import com.fdmgroup.bankUserStories.customer.Company;
import com.fdmgroup.bankUserStories.customer.Customer;
import com.fdmgroup.bankUserStories.customer.CustomerDTO;
import com.fdmgroup.bankUserStories.customer.CustomerFactory;
import com.fdmgroup.bankUserStories.customer.Person;
import com.fdmgroup.bankUserStories.exception.CustomerNotFoundException;
import com.fdmgroup.bankUserStories.geoCoder.Geodata;
import com.fdmgroup.bankUserStories.repository.AccountRepository;
import com.fdmgroup.bankUserStories.repository.CustomerRepository;
import com.fdmgroup.bankUserStories.webClient.GeoCoderWebClient;

@Service
public class CustomerService implements CustomerServiceInterface
{
	private CustomerRepository custRepo;
	
	private GeoCoderWebClient geoCoderWebClient;
	
	public CustomerService(CustomerRepository custRepo, GeoCoderWebClient geoCoderWebClient) 
	{
		super();
		this.custRepo = custRepo;
		this.geoCoderWebClient = geoCoderWebClient;
	}
	
	public Customer createCustomer(CustomerDTO customer)
	{
		String postalCode = customer.getAddress().getPostalCode();
		Geodata geoCoderResponse = geoCoderWebClient.fetchCityAndProvince(postalCode);
		
		Customer newCustomer = CustomerFactory.getChildCustomer(customer);
		
		newCustomer.setName(customer.getName());
		newCustomer.setAddress(customer.getAddress());
		newCustomer.getAddress().setStreetNumber(customer.getAddress().getStreetNumber());
		newCustomer.getAddress().setPostalCode(postalCode);
		newCustomer.getAddress().setCity(geoCoderResponse.getStandard().getCity());
		newCustomer.getAddress().setProvince(geoCoderResponse.getStandard().getProv());
		
		return custRepo.save(newCustomer);
	}
	
	public Customer getCustomerById(long id)
	{
		return custRepo.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Customer with id "+id+" could not be found"));
	}
	
	public List<Customer> getCustomersByCity(String city) 
	{
		return custRepo.findAllByCity(city);
	}
	
	public List<Customer> getAllCustomers()
	{
		return custRepo.findAll();
	}
	
	public Customer updateCustomer(long id, CustomerDTO updatedCustomer)
	{
		return custRepo.findById(id).map(existingCustomer 
		-> {
			if (updatedCustomer.getName() != null)
			{
				existingCustomer.setName(updatedCustomer.getName());
			}
			
			
			if (updatedCustomer.getAddress() != null)
			{
				String postalCode = updatedCustomer.getAddress().getPostalCode();

				if (postalCode != null)
				{
					Geodata geoCoderResponse = geoCoderWebClient.fetchCityAndProvince(postalCode);
					existingCustomer.getAddress().setPostalCode(postalCode);
					existingCustomer.getAddress().setCity(geoCoderResponse.getStandard().getCity());
					existingCustomer.getAddress().setProvince(geoCoderResponse.getStandard().getProv());
				}
			}
			
			return custRepo.save(existingCustomer);
		}).orElseThrow(() ->
		new CustomerNotFoundException("Customer with id "+ id +" could not be found"));
	}
	
	public void deleteCustomerById(long id)
	{
		custRepo.deleteById(id);
	}	
}
