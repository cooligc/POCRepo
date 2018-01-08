/**
 * 
 */
package com.skc.kafka;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * {@link https://www.dineshonjava.com/async-in-spring/} for {@link Async} usage
 * @author sitakant
 */
@Component
public class KafkaAsyncProcessor {
	
	private static final Logger LOG = Logger.getLogger(KafkaAsyncProcessor.class);

	@Autowired
	private KafkaSender kafkaSender;
	
	@Async
	public CompletableFuture<Map<String,String>> process(Map<String,String> requestMap) {
		LOG.debug("Processing request \n"+requestMap);
		
		
		Message<String> message = KafkaMessageBuilder.create()
													 .messageWithPayload(requestMap)
													 .messageWithHeader("from", "Web-Request")
													 .messageWithHeader("co-relationId", UUID.randomUUID().toString())
													 .build();
		LOG.info("Async Thread Name --- > "+Thread.currentThread().getName());
        try {
			Thread.sleep(10000L);
			kafkaSender.send(message);
		} catch (InterruptedException e) {
			LOG.error(e);
		}
        return CompletableFuture.completedFuture(requestMap);
	}

}
