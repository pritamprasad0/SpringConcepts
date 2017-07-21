package com.pritamprasad.spring_intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.pritamprasad.spring_intercepter.service.CustomHandlerInterceptor;

/**
 * Configuration and Start class
 *
 */
@SpringBootApplication
public class DefaultConfiguration {

    @Bean
    @Autowired
    public MappedInterceptor getMappedInterceptor(CustomHandlerInterceptor customHandlerInterceptor) {
	return new MappedInterceptor(new String[] {"/**"}, customHandlerInterceptor);
    }
    
    public static void main(String[] args) {
	SpringApplication.run(DefaultConfiguration.class, args);
    }

}
