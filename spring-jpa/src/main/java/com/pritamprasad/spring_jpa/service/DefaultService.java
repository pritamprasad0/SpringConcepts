/**
 * 
 */
package com.pritamprasad.spring_jpa.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pritamprasad.spring_jpa.dto.Customer;
import com.pritamprasad.spring_jpa.repository.CustomerRepository;

/**
 * @author Pritam
 *
 */
@Service
public class DefaultService {

	private Logger logger = Logger.getLogger(DefaultService.class);

	@Autowired
	private Customer customer;

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomer() {
		logger.info(String.format("Entering %1$s", "getAllCustomer"));
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer getCustomer(String customerId) {
		return customerRepository.findOne(Long.valueOf(customerId));
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);		 
	}

}
