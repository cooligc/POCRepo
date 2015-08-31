package org.workflow.data;

import java.util.Map;

public class ActivityDTO implements WorkflowDTO{
	
	private Map<String,Object> attributes;

	public void setAttribute(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

}
