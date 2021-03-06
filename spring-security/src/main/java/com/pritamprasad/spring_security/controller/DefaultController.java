/**
 * 
 */
package com.pritamprasad.spring_security.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pritamprasad.spring_security.service.DefaultService;

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

    @CrossOrigin(origins = "http://::1:8080")
    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String indexPost() {
	logger.info("Entering index post controller..");
	return defaultService.defaultContent();
    }

}
