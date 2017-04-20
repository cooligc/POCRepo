package com.redhat.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class GlusterVolume implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String name;
	private String status;
	private Integer replicaCount;
	
	private Set<Set<Bricks>> bricks;

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the replicaCount
	 */
	public Integer getReplicaCount() {
		return replicaCount;
	}

	/**
	 * @param replicaCount the replicaCount to set
	 */
	public void setReplicaCount(Integer replicaCount) {
		this.replicaCount = replicaCount;
	}

	/**
	 * @return the bricks
	 */
	public Set<Set<Bricks>> getBricks() {
		return bricks;
	}

	/**
	 * @param bricks the bricks to set
	 */
	public void setBricks(Set<Set<Bricks>> bricks) {
		this.bricks = bricks;
	}
	
	
	
}
