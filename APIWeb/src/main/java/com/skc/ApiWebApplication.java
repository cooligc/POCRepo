package com.skc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages={"com.skc"})
/**
 * Main class for Spring boot 
 * */
public class ApiWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWebApplication.class, args);
	}
}
