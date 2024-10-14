package com.fdmgroup.bankUserStories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.bankUserStories.account.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	@Query("SELECT a FROM Account a JOIN a.customer c JOIN c.address add WHERE add.city = :city")
	List<Account> findAllByCity(@Param("city") String city);

}
