/**
 * 
 */
package com.pritamprasad.spring_jpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.pritamprasad.spring_jpa.util.Helper.emptyIfNull;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pritamprasad.spring_jpa.dto.Customer;

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
		List<Customer> allCustomer = null;
		allCustomer = new ArrayList<Customer>();
		for (Customer customer : emptyIfNull(customerRepository.findAll())) {
			allCustomer.add(customer);
		}
		return allCustomer;
	}

	public Customer getCustomer(String customerId) {
		return customerRepository.findOne(Long.valueOf(customerId));
	}

}
