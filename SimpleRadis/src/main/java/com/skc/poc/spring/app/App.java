package com.skc.poc.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skc.poc.spring.component.RegistrationBean;

public class App {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		RegistrationBean registrationBean = (RegistrationBean) applicationContext.getBean("register");
		registrationBean.createUser();
		System.out.println("==========> DONE");
	}
}
