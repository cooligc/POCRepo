package com.redhat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class RedhatProbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedhatProbsApplication.class, args);
	}
}
