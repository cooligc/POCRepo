package com.skc.utils;

import java.io.Serializable;

/**
 * Serialize class to send the object via network
 * @author sitakant
 * */
public class Object2Share implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	public Object2Share(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Getter for First name
	 * */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter for firstname
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for First name
	 * */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for firstname
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Object2Share [firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
}
