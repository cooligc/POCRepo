/**
 * 
 */
package com.skc.kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sitakant
 *
 */
@RestController
@RequestMapping("/api/messages")
public class AsyncRESTEndpoint {
	
	private static final Logger LOG = Logger.getLogger(AsyncRESTEndpoint.class);
	
	@Autowired
	private KafkaAsyncProcessor asyncProcessor;

	@PostMapping
	public Map<String,String> recieve(@RequestBody Map<String,String> requestMap){
		LOG.info("Sync Thread Name --- > "+Thread.currentThread().getName());
		Map<String,String> responseMap = new HashMap<>();
		responseMap.put("message", "We are processing the request.");
		asyncProcessor.process(requestMap);
		return responseMap;
	}
	
	@GetMapping
	public List<Details> getAllMessages(){
		LOG.info("Sync Thread Name --- > "+Thread.currentThread().getName());
		List<Details> messages = new ArrayList<>();
		messages.addAll(SampleKafkaListener.DETAIL_DATABASE);
		SampleKafkaListener.DETAIL_DATABASE.clear();
		return messages;
	}
	
}
