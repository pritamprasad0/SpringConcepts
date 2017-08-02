package com.pritamprasad.spring_jpa.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pritamprasad.spring_jpa.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastname);

}
