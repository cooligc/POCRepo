/**
 * 
 */
package com.skc.kafka;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author sitakant
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Details implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,Object> headers;
	private String message;
	private String corelationId;
	/**
	 * @return the headers
	 */
	public Map<String, Object> getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Map<String, Object> headers) {
		this.headers = headers;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the corelationId
	 */
	public String getCorelationId() {
		return corelationId;
	}
	/**
	 * @param corelationId the corelationId to set
	 */
	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}
	
	

}
