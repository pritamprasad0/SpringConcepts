package com.pritamprasad.spring_jpa.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pritamprasad.spring_jpa.dto.Customer;
import com.pritamprasad.spring_jpa.service.DefaultService;



@RestController
public class DataController {

	private Logger logger = Logger.getLogger(DataController.class);

    @Autowired
    private DefaultService defaultService;
    
    @RequestMapping(value="/customer", method = RequestMethod.GET)
    public @ResponseBody List<Customer> getAllCustomer(){
    	logger.info("Getting all Customers!!!");
    	return defaultService.getAllCustomer();
    }
    
    @RequestMapping(value="/customer/{customer_id}", method = RequestMethod.GET)    
    public @ResponseBody Customer getAllCustomer(@PathVariable("customer_id") String customerId){
    	logger.info("Getting all Customers!!!");
    	Customer customer = defaultService.getCustomer(customerId);
    	return customer;
    }
    
    @RequestMapping(value="/customer", method = RequestMethod.POST)
    public @ResponseBody Customer AddCustomer(@RequestBody Customer customer){
    	logger.info("Adding custome with name : "+ customer.getFirstName());
    	return defaultService.addCustomer(customer);
    }
}
