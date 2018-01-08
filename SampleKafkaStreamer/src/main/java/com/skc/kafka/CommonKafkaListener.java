/**
 * 
 */
package com.skc.kafka;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author sitakant
 *
 */
public interface CommonKafkaListener {
	
	Logger LOG = Logger.getLogger(CommonKafkaListener.class);
	
	void doListen(Message<String> data);
	void doListen(String data);
}
