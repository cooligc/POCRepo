package com.skc.kafka;

import org.apache.log4j.Logger;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public interface KafkaSender {
	
	Logger LOG = Logger.getLogger(KafkaSender.class);
	
	void send(Message<String> data);
	void send(String topicName,Message<String> data);
	void send(String topic,String data);
	
	default void processCallBack(ListenableFuture<SendResult<String, String>> future){
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>(){
			@Override
			public void onFailure(Throwable ex) {
				LOG.error(ex);
				throw new RuntimeException("Oops ! Unable to send the data to topic");
			}
			
			@Override
			public void onSuccess(SendResult<String, String> result) {
				LOG.debug("Successfully posted the data");
			}
		});
	}
}
