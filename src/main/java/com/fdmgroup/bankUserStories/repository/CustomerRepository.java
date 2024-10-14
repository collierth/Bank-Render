package com.fdmgroup.bankUserStories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.bankUserStories.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	@Query("SELECT c FROM Customer c JOIN c.address add WHERE add.city = :city")
	List<Customer> findAllByCity(@Param("city") String city);
}
