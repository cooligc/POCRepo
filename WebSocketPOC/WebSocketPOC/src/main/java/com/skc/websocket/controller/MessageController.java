package com.skc.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.skc.websocket.model.Message;

@Controller
public class MessageController {

	@MessageMapping("/hello")
	@SendTo("/topic/message")
	public Message greeting(Message message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Message("test","Hello, " + message.getFrom() + "!");
	}
}
