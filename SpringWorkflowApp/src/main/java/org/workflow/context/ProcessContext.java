package org.workflow.context;

import java.util.Map;

public class ProcessContext implements Context{
	private Map<String,Object> attributes;

	public Map<String,Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String,Object> attributes) {
		this.attributes = attributes;
	}
}
