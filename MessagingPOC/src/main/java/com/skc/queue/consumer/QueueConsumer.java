package com.skc.queue.consumer;

import java.io.IOException;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.skc.queue.EndPoint;

/**
 * Class for Queue to consume the data from the MQ Server
 * @author sitakant 
 * */
@Component
public class QueueConsumer extends EndPoint implements Runnable , Consumer{

	public QueueConsumer(){
		super();
	}
	
	public QueueConsumer(String queueName, String host) {
		super(queueName, host);
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
	 * Method to execute the by listener while there will be a data in the Queue
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

	public void run() {
		try {
			//This will open the connection and listen from queue
			channel.basicConsume(queueName, true, this);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
