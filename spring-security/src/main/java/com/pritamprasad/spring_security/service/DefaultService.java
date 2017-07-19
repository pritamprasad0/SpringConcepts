/**
 * 
 */
package com.pritamprasad.spring_security.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.pritamprasad.spring_security.model.DefaultModel;

/**
 * @author Pritam
 *
 */
@Service
public class DefaultService {

    private Logger logger = Logger.getLogger(DefaultService.class);

    @Autowired
    private DefaultModel defaultModel;

    public String defaultContent() {
	logger.info("Inside defaultContent method");
	return "deafult String " + defaultModel.getId();
    }

    public ModelAndView welcome() {
	logger.info("Inside welcome method");
	
	ModelAndView model = new ModelAndView();
	model.addObject("title", "Spring Security Hello World");
	model.addObject("message", "This is welcome page!");
	model.setViewName("hello");
	return model;
    }

}
