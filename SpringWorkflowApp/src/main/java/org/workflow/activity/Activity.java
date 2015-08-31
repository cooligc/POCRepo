package org.workflow.activity;

import org.workflow.context.ProcessContext;
import org.workflow.data.WorkflowDTO;

public class Activity {
	
	private ProcessContext context;
	
	public WorkflowDTO doActivity(WorkflowDTO dto){
		return dto;
	}

	public ProcessContext getContext() {
		return context;
	}

	public void setContext(ProcessContext context) {
		this.context = context;
	}
}
