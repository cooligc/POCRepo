/**
 * 
 */
package com.skc.queue.producer;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.stereotype.Component;

import com.skc.queue.EndPoint;
import com.skc.utils.ApplicationConstants;

/**
 * Class to produce the object and push the same to MQ server
 * @author sitakant
 */
@Component
public class Producer extends EndPoint{
	
	public Producer(String queueName, String host) {
		super(queueName, host);
	}
	
	/**
	 * Method to push the message into MQ
	 * */
	public void sendMessage(Serializable object) throws IOException{
		channel.basicPublish(ApplicationConstants.EMPTY,queueName, null, SerializationUtils.serialize(object));
	}
}
