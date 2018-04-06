package com.skc.doubleton;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestEndpoint {

	/*@Autowired
	MyFactory factory;*/
	
	
	@InjectMe
	MyInstance instance1;
	
	@InjectMe
	MyInstance2 instance2;
	
	@InjectMe
	MyInstance instance3;
	
	@GetMapping("/test/{name}")
	public String sayHello(@PathVariable("name") String name) {
		//return "Hello <br/>"+name +"<br/>"+ ((MyInstance)factory.getInstance(MyInstance.class)).printValue() +"<br/>"+((MyInstance2)factory.getInstance(MyInstance2.class)).print();
		return "Hello <br/>"+name +"<br/>"+ instance1.printValue() +"<br/>"+instance2.print() + "<br/>"+instance3.printValue();
	}
	
}
