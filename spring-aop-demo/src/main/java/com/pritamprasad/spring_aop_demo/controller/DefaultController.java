/**
 * 
 */
package com.pritamprasad.spring_aop_demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pritamprasad.spring_aop_demo.service.DefaultService;

/**
 * @author Pritam
 *
 */
@RestController
public class DefaultController {

	private Logger logger = Logger.getLogger(DefaultController.class);

	@Autowired
	private DefaultService defaultService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexGet() {
		logger.info("Entering index controller..");	
		return defaultService.welcome();
	}

	@RequestMapping(value = "/welcome/{fname}/{lname}", method = RequestMethod.GET)
	public String modIndex(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
		logger.info("Entering index controller..");
		return defaultService.welcome(fname, lname);
	}
}
