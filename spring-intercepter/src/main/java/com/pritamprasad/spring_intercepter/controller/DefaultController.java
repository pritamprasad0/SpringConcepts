/**
 * 
 */
package com.pritamprasad.spring_intercepter.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pritamprasad.spring_intercepter.service.DefaultService;

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
	return defaultService.defaultContent();
    }
    
    @RequestMapping(value = "/modindex", method = RequestMethod.GET)
    public String modIndexGet() {
	logger.info("Entering modindex controller..");
	return defaultService.defaultContent() + " Modified!!!!";
    }
}
