package org.workflow.processor;

import java.util.List;

import org.workflow.activity.Activity;
import org.workflow.data.WorkflowDTO;

public class SequenceProcessor implements Processor{
	
	private List<? extends Activity> activities;
	private WorkflowDTO workflowDTO;
	
	
	public void doActivities(WorkflowDTO dto){
		for (Activity activity : activities) {
			WorkflowDTO dto2 = activity.doActivity(dto);
			dto=dto2;
		}
	}

	public List<? extends Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<? extends Activity> activities) {
		this.activities = activities;
	}

	public void setSeedData(WorkflowDTO dto) {
		this.workflowDTO=dto;
	}

	public WorkflowDTO getSeedData() {
		return workflowDTO;
	}
}
