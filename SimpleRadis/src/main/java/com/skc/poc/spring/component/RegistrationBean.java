package com.skc.poc.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.skc.poc.spring.component.model.Address;
import com.skc.poc.spring.component.model.User;

@Component("register")
public class RegistrationBean {
	
	@Autowired
	RedisTemplate<String, User> redisTemplate;
	
	
	public void createUser(){
		Address address = new Address();
		address.setAddressId(2L);
		address.setAddressValue("XYZ");
		User user = new User();
		user.setAddress(address);
		user.setAge(25+"");
		user.setFullName("SKC");
		user.setStatus("ACTIVE");
		user.setId("8");
		redisTemplate.opsForHash().put("User", user.hashCode(), user);
		System.out.println(redisTemplate.opsForHash().get("User", user.hashCode()));
	}
	
	
}