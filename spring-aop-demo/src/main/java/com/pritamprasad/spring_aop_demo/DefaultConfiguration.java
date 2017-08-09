package com.pritamprasad.spring_aop_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class DefaultConfiguration extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DefaultConfiguration.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DefaultConfiguration.class, args);
	}
}
