package com.pritamprasad.spring_intercepter.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class HttpRequestValidator {
    
    public boolean printHeaderParams(HttpServletRequest request) {
	System.out.println("***** Custom : " + request.getHeader("custom"));
	System.out.println("***** Host : " + request.getHeader("Host"));

	return true;
    }
    

    
}
