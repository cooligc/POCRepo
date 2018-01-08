/**
 * 
 */
package com.skc.kafka;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class SampleSchedule {
	
	@Autowired
	private KafkaSender sender;
	
	@Value("${kafka.server.topic.request}")
	private String topic;
	
	@SuppressWarnings("deprecation")
	@Scheduled(fixedRate = 500000)
	public void putData(){
		Map<String,String> userMaps = new HashMap<>();
		userMaps.put("corelation-id", UUID.randomUUID().toString());
		userMaps.put("created_date", new Date().toGMTString());
		userMaps.put("message", "My Message for "+userMaps.get("corelation-id")+" from SCHEDULER");
		
		
		Message<String> message =  KafkaMessageBuilder.create()
						   .messageWithPayload(userMaps)
						   .messageWithHeader("from", UUID.randomUUID().toString())
						   .messageWithHeader("e-tag", UUID.randomUUID().toString())
						   .messageWithHeader("co-relationId", UUID.randomUUID().toString())
						   .build();
		
		sender.send(message);
	}
	
//	@Scheduled(fixedRate = 5000)
	public void putRandomData(){
		sender.send(topic, "My String data "+UUID.randomUUID().toString());
	}

}
