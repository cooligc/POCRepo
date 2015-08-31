package org.workflow.data;

import java.util.Map;

public interface WorkflowDTO {
	public void setAttribute(Map<String,Object> attributes);
	Map<String,Object> getAttributes();
}
