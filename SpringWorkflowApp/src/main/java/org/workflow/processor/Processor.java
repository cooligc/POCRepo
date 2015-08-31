package org.workflow.processor;

import org.workflow.data.WorkflowDTO;

public interface Processor {
	public void setSeedData(WorkflowDTO dto);
	public WorkflowDTO getSeedData();
	public void doActivities(WorkflowDTO dto);
}
