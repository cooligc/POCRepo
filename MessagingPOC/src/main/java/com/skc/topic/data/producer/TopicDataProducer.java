package com.skc.topic.data.producer;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

import com.skc.topic.InitialConfig;

/**
 * Class to produce the object and send it to Topic 
 * @author sitakant
 * */
public class TopicDataProducer extends InitialConfig {

	public TopicDataProducer(String exchangeName, String topicName,String routingKey, String host) {
		super(exchangeName, topicName, routingKey, host);
	}
	
	/**
	 * method to push the data into topic
	 * */
	public void sendMessage(Serializable message){
		try {
			System.out.println("Sending message");
			channel.basicPublish(exchangeName, routingKey, null, SerializationUtils.serialize(message));
			System.out.println("Message Sent to topic");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
