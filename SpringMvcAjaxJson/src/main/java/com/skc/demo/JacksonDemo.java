package com.skc.demo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.map.ObjectMapper;

import com.skc.web.domain.Organization;
import com.skc.web.domain.User;

public class JacksonDemo {
	public static void main(String[] args) throws Exception {
		Organization organization = new Organization();
		User user = new User("SKC","S");
		User user2 = new User("SKC","S");
		User user3 = new User("SKC","S");
		User user4 = new User("SKC","S");
		List<User> users = new ArrayList<User>();
		users.add(user4);
		users.add(user);
		users.add(user2);
		users.add(user3);
		organization.setUsers(users);
		JAXBContext context = JAXBContext.newInstance(Organization.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(organization, System.out);
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(organization));
		
	}

}
