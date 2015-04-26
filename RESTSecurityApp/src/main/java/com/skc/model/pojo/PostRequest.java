package com.skc.model.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Pojo Class for Posts</p>
 * @author IgnatiusCipher
 * @version 1.0
 * */

@XmlRootElement(name="request")
public class PostRequest {
	
	private int id;
	
	private String postedBy;
	
	private String postTitle;
	
	private String postBody;
	
	private String postedAt;
	
	
	public String getPostedBy() {
		return postedBy;
	}
	@XmlElement
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getPostTitle() {
		return postTitle;
	}
	@XmlElement
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
	public String getPostBody() {
		return postBody;
	}
	@XmlElement
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	public String getPostedAt() {
		return postedAt;
	}
	@XmlElement
	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((postBody == null) ? 0 : postBody.hashCode());
		result = prime * result
				+ ((postTitle == null) ? 0 : postTitle.hashCode());
		result = prime * result
				+ ((postedAt == null) ? 0 : postedAt.hashCode());
		result = prime * result
				+ ((postedBy == null) ? 0 : postedBy.hashCode());
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
		PostRequest other = (PostRequest) obj;
		if (postBody == null) {
			if (other.postBody != null)
				return false;
		} else if (!postBody.equals(other.postBody))
			return false;
		if (postTitle == null) {
			if (other.postTitle != null)
				return false;
		} else if (!postTitle.equals(other.postTitle))
			return false;
		if (postedAt == null) {
			if (other.postedAt != null)
				return false;
		} else if (!postedAt.equals(other.postedAt))
			return false;
		if (postedBy == null) {
			if (other.postedBy != null)
				return false;
		} else if (!postedBy.equals(other.postedBy))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
