/**
 * 
 */
package com.skc.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
@KafkaListener(id="main-2",topics="${kafka.server.topic.request}")
public class MyKafkaTopicListener implements CommonKafkaListener {
	
	@Value("${kafka.server.topic.request}")
	String topicName;

	@Override
	@KafkaHandler
	public void doListen(Message<String> data) {
		LOG.debug("Message data recieved from [TOPIC="+topicName+"] is ["+data.getPayload()+"]");
	}

	@Override
	@KafkaHandler
	public void doListen(String data) {
		LOG.debug("Message data recieved from [TOPIC="+topicName+"] is ["+data+"]");
	}

}
