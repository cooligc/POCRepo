/**
 * 
 */
package com.skc.kafka;

import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

/**
 * @author sitakant
 *
 */
@FunctionalInterface
public interface CommonKafkaListenerErrorHandler {
	Object handleError(Message<?> message, ListenerExecutionFailedException exception) throws Exception;
}
