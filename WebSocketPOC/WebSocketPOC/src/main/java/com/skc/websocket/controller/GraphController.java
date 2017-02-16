package com.skc.websocket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.skc.websocket.model.Graph;
import com.skc.websocket.model.Message;

@Controller
public class GraphController {

	@MessageMapping("/graph")
	@SendTo("/topic/graph")
	public List<Graph> greeting(Message message) throws Exception {
		Graph graph1 = new Graph();
		graph1.setName("HPE");
		graph1.setNumber(Integer.valueOf(Math.abs(Integer.valueOf(Math.random()+""))/100));
		
		Graph graph2 = new Graph();
		graph1.setName("HP Inc");
		graph1.setNumber(Integer.valueOf(Math.abs(Integer.valueOf(Math.random()+""))/100));
		
		Graph graph3 = new Graph();
		graph1.setName("CSC");
		graph1.setNumber(Integer.valueOf(Math.abs(Integer.valueOf(Math.random()+""))/100));
		
		List<Graph> graphs = new ArrayList<>();
		graphs.add(graph1);
		graphs.add(graph2);
		graphs.add(graph3);
		
		return graphs;
	}
}
