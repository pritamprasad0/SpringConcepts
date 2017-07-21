/**
 * 
 */
package com.pritamprasad.spring_rest_client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pritamprasad.spring_rest_client.service.DefaultService;


/**
 * @author Pritam
 *
 */
@RestController
public class SpringClientController {

    private Logger logger = Logger.getLogger(SpringClientController.class);

    @Autowired
    private DefaultService defaultService;
    
    @RequestMapping(value = "/sendrequest", method = RequestMethod.GET)
    public String indexGet() {
	logger.info("Entering sendrequest controller..");
	return defaultService.sendDefaultRequest();
    }
}
