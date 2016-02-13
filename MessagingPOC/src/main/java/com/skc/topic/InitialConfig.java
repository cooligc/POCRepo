package com.skc.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Class to load the initial configuration for topic
 * @author sitakant
 * */
public abstract class InitialConfig {
	
	protected String exchangeName;
	protected String topicName;
	protected String routingKey;
	protected String host;
	
	protected Channel channel;
	protected Connection connection;
	
	public InitialConfig(String exchangeName,String topicName,String routingKey,String host){
		this.exchangeName = exchangeName;
		this.topicName = topicName;
		this.routingKey= routingKey;
		this.host = host;
		init();
	}

	/**
	 * Method to initialize the channel
	 * */
	private void init() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(host);
		try {
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(exchangeName,topicName);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
