/**
 * 
 */
package com.skc.kafka;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author sitakant
 *
 */
public class KafkaMessageBuilder {
	
	private Map<String, Object> headers;
	private Map<String,String> payload;
	
	
	private KafkaMessageBuilder(Map<String, Object> headers, Map<String, String> payload) {
		this.headers = headers;
		this.payload = payload;
	}

	public static KafkaMessageBuilder create(){
		return new KafkaMessageBuilder(new HashMap<String,Object>(),new HashMap<String,String>());
	}
	
	public KafkaMessageBuilder messageWithPayload(Map<String,String> payload){
		this.payload = payload;
		return this;
	}
	
	public KafkaMessageBuilder messageWithHeader(String headerKey,String headerValue){
		headers.put(headerKey, headerValue);
		return this;
	}
	
	public GenericMessage<String> build(){
		MessageHeaders messageHeaders = new MessageHeaders(headers);
		return new GenericMessage<String>(payload.toString(),messageHeaders);
	}
	
	
}
