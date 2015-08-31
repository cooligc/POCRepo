package org.workflow.activity.impl;

import org.workflow.activity.Activity;
import org.workflow.data.WorkflowDTO;

public class SendEmailActivity extends Activity {
	
	@Override
	public WorkflowDTO doActivity(WorkflowDTO dto) {
		dto.getAttributes().put("message", "Sending Mail Activity called");
		for (String key : dto.getAttributes().keySet()) {
			System.out.println(key+"\t"+dto.getAttributes().get(key));
		}
		return dto;
	}
}
