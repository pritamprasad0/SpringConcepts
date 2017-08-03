/**
 * 
 */
package com.pritamprasad.spring_aop_demo.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Pritam
 *
 */
@Service
public class DefaultService {

	private Logger logger = Logger.getLogger(DefaultService.class);

	public String welcome() {		
		logger.info("Inside welcome method");		
		return "welcome!!!!";
	}
	
	public String welcome(String fName, String lName) {		
		logger.info("Inside modified welcome method");		
		return "welcome!!!! " + fName + " "+ lName;
	}

}
