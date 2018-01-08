package com.skc.kafka;

import java.io.Serializable;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

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
public class JsonDeserializer<T extends Serializable> implements Deserializer<T> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
	    T t = null;
	    try {
	      t = (T) mapper.readValue(data,Serializable.class);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return t;
	}

	@Override
	public void close() {
		
	}

}
