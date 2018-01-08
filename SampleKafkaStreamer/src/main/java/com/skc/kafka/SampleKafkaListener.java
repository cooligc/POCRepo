/**
 * 
 */
package com.skc.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
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
@KafkaListener(id=SampleKafkaListener.KAFKA_ID,topics="${kafka.server.topic}")
public class SampleKafkaListener implements CommonKafkaListener {
	
	private static final Logger LOG = Logger.getLogger(SampleKafkaSender.class);
	
	@Value("${kafka.server.topic}")
	private String topicName;
	protected static final String KAFKA_ID="main-1";
	
	public static List<Details> DETAIL_DATABASE = new CopyOnWriteArrayList<Details>();
	
	private final CountDownLatch countDownLatch = new CountDownLatch(1);
	
	@Override
	@KafkaHandler
	public void doListen(Message<String> data) {
		LOG.debug("Recieve ---- > "+data.getPayload());
		
		Map<String,Object> headers = new HashMap<>();
		LOG.debug("-------------------------");
		LOG.debug("DATA RECIEVED");
		LOG.debug("RECIEVED --> "+data.getPayload());
		data.getHeaders().entrySet().forEach(entry -> {
			LOG.debug(entry.getKey() +" --- "+entry.getValue());
			headers.put(entry.getKey(), entry.getValue());
		});
		
		Details details = new Details();
		details.setMessage(data.getPayload());
		//TODO This is not the real Co-relation ID
		details.setCorelationId(UUID.randomUUID().toString());
		details.setHeaders(headers);
		DETAIL_DATABASE.add(details);
		
		LOG.debug("-------------------------");
		
		countDownLatch.countDown();
	}

	@Override
	//TODO Though it is a type of Message<String> type data, It always Listen on this listener
//	@KafkaHandler
	public void doListen(String data) {
		LOG.debug("String Recieve ---- > "+data + "[TOPIC-NAME="+topicName+"]");
	}

}
