/**
 * 
 */
package com.skc.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class SampleKafkaSender implements KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.server.topic}")
	private String kafkaTopic;
	
	
	@Override
	public void send(Message<String> data) {
		//TODO Tectical solution
		kafkaTemplate.setDefaultTopic(kafkaTopic);
		processCallBack(kafkaTemplate.send(data));
		LOG.debug("Sent --> "+data);
	}

	@Override
	public void send(String topicName, Message<String> data) {
		//TODO Tectical Solution
		kafkaTemplate.setDefaultTopic(topicName);
		processCallBack(kafkaTemplate.send(data));
	}

	@Override
	public void send(String topic,String data) {
		processCallBack(kafkaTemplate.send(topic, data));
		LOG.debug("Sent --> "+data);
	}

}
