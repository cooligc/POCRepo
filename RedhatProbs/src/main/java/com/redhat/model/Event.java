package com.redhat.model;

import java.io.Serializable;

public class Event implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String server;
	private String directory;
	private String volumeId;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the server
	 */
	public String getServer() {
		return server;
	}
	/**
	 * @param server the server to set
	 */
	public void setServer(String server) {
		this.server = server;
	}
	/**
	 * @return the directory
	 */
	public String getDirectory() {
		return directory;
	}
	/**
	 * @param directory the directory to set
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	/**
	 * @return the volumeId
	 */
	public String getVolumeId() {
		return volumeId;
	}
	/**
	 * @param volumeId the volumeId to set
	 */
	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}
	
	
	
}
