package org.workflow.activity.impl;

import org.workflow.activity.Activity;
import org.workflow.data.WorkflowDTO;

public class ConfirmationActivity extends Activity {

	@Override
	public WorkflowDTO doActivity(WorkflowDTO dto) {
		dto.getAttributes().put("message", "Confirmation Activity invoked");
		for (String key : dto.getAttributes().keySet()) {
			System.out.println(key+"\t"+dto.getAttributes().get(key));
		}
		return dto;
	}
}
