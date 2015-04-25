package com.skc.validator;

import java.util.List;

import org.springframework.validation.ObjectError;

public class JsonResponse {
	private String status;
	private List<ObjectError> messages;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ObjectError> getMessages() {
		return messages;
	}
	public void setMessages(List<ObjectError> messages) {
		this.messages = messages;
	}
	
	
	
}
