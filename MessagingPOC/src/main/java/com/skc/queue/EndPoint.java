package com.skc.queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.skc.utils.ObjectUtils;

/**
 * Class is having initial Configuration for the Queue
 * @author sitakant
 * */
public abstract class EndPoint {
	
	protected Connection connection;
	protected Channel channel;

	protected String host;
	
	protected String queueName;
	
	public EndPoint(){
		queueName="dummy";
		System.out.println("================================>");
		initializeAMQPDetails("52.36.13.111");
	}
	
	public EndPoint(String queueName){
		this.queueName = queueName;
		initializeAMQPDetails(host);
	}
	public EndPoint(String queueName,String host){
		this.queueName = queueName;
		initializeAMQPDetails(host);
	}
	
	/**
	 * Method to close the connection
	 * */
	public void closeConnection(){
		try {
			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Method to initialize the AMQP details
	 * */
	private void initializeAMQPDetails(String hostDetails){
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		if(ObjectUtils.isNull(hostDetails)){
			hostDetails=host;
		}
		
		connectionFactory.setHost(hostDetails);
		try {
			connection = connectionFactory.newConnection();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			channel = connection.createChannel();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			channel.queueDeclare(queueName, false, false, false, null);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
