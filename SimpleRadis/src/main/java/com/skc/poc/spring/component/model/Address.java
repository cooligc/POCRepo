package com.skc.poc.spring.component.model;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long addressId;
	private String addressValue;
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getAddressValue() {
		return addressValue;
	}
	public void setAddressValue(String addressValue) {
		this.addressValue = addressValue;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressValue=" + addressValue + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((addressValue == null) ? 0 : addressValue.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (addressValue == null) {
			if (other.addressValue != null)
				return false;
		} else if (!addressValue.equals(other.addressValue))
			return false;
		return true;
	}
	
	
	
	
	
}
