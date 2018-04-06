/**
 * 
 */
package com.skc.slack.slackbroaker;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author chaudhsi
 *
 */
public class SlackResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Message message;
	private String ts;
	private String ok;
	private String channel;

	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * @return the ts
	 */
	public String getTs() {
		return ts;
	}

	/**
	 * @param ts
	 *            the ts to set
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}

	/**
	 * @return the ok
	 */
	public String getOk() {
		return ok;
	}

	/**
	 * @param ok
	 *            the ok to set
	 */
	public void setOk(String ok) {
		this.ok = ok;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel
	 *            the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SlackResponse [message=" + message + ", ts=" + ts + ", ok=" + ok + ", channel=" + channel + "]";
	}

	
}

class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String text;
	private String ts;
	private String subtype;
	private String bot_id;
	private Attachments[] attachments;
	private String type;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the ts
	 */
	public String getTs() {
		return ts;
	}

	/**
	 * @param ts
	 *            the ts to set
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}

	/**
	 * @return the subtype
	 */
	public String getSubtype() {
		return subtype;
	}

	/**
	 * @param subtype
	 *            the subtype to set
	 */
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	/**
	 * @return the bot_id
	 */
	public String getBot_id() {
		return bot_id;
	}

	/**
	 * @param bot_id
	 *            the bot_id to set
	 */
	public void setBot_id(String bot_id) {
		this.bot_id = bot_id;
	}

	/**
	 * @return the attachments
	 */
	public Attachments[] getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments
	 *            the attachments to set
	 */
	public void setAttachments(Attachments[] attachments) {
		this.attachments = attachments;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [username=" + username + ", text=" + text + ", ts=" + ts + ", subtype=" + subtype + ", bot_id="
				+ bot_id + ", attachments=" + Arrays.toString(attachments) + ", type=" + type + "]";
	}
	
	
}

class Attachments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fallback;
	private String text;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the fallback
	 */
	public String getFallback() {
		return fallback;
	}
	/**
	 * @param fallback the fallback to set
	 */
	public void setFallback(String fallback) {
		this.fallback = fallback;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attachments [id=" + id + ", fallback=" + fallback + ", text=" + text + "]";
	}
	
	
}
