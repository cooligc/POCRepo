/**
 * 
 */
package com.skc.topic.data.consumer;

import java.io.IOException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.skc.topic.InitialConfig;

/**
 * Class to have a listener that will listen the queue data and can process the same
 * @author sitakant
 */
public class TopicDataListener extends InitialConfig implements Consumer,Runnable {

	protected String queueName;
	
	public TopicDataListener(String exchangeName, String topicName,String routingKey, String host,String queueName) {
		super(exchangeName, topicName, routingKey, host);
		this.queueName = queueName;
	}

	public void run() {
		try {
			queueName = channel.queueDeclare().getQueue();
			channel.queueBind(queueName, exchangeName, routingKey);
			channel.basicConsume(queueName, true,this);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void handleCancel(String arg0) throws IOException {
		System.out.println("Connection cancel");
	}

	public void handleCancelOk(String arg0) {
		System.out.println("Handling the cancel request with proper stuff");
	}

	public void handleConsumeOk(String arg0) {
		System.out.println("Handling consume message");
	}

	/**
	 * Method to be executed by listener while there will be a data in the queue
	 * */
	public void handleDelivery(String arg0, Envelope arg1,BasicProperties arg2, byte[] body) throws IOException {
		String string = (String)SerializationUtils.deserialize(body);
	    System.out.println("Message received (START)=====================>.");
	    System.out.println(string);
	    System.out.println("Message recieved (END)==========================>");
	}

	public void handleRecoverOk(String arg0) {
		System.out.println("Handling recovery");
	}

	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		System.out.println("Handling the shutdown signal from Server");
	}

}
