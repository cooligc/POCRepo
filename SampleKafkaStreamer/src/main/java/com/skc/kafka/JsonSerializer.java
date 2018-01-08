package com.skc.kafka;

import java.io.Serializable;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


/***
 * 
 * {@link https://www.codenotfound.com/spring-kafka-json-serializer-deserializer-example.html}
 * {@link https://dzone.com/articles/kafka-sending-object-as-a-message}
 * 
 * @author sitakant
 *
 * @param <T> type of {@link Serializable}
 */
public class JsonSerializer<T extends Serializable> implements Serializer<T> {
	
	private static final Logger LOG = Logger.getLogger(JsonSerializer.class);

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		
	}

	@Override
	public byte[] serialize(String topic, T data) {
		byte[] retVal = null;
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	      retVal = objectMapper.writeValueAsString(data).getBytes();
	    } catch (Exception e) {
	    	LOG.error(e);
	    }
	    return retVal;
	}

	@Override
	public void close() {
		
	}

}
