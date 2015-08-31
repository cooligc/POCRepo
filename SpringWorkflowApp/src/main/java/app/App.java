package app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.workflow.data.ActivityDTO;
import org.workflow.data.WorkflowDTO;
import org.workflow.processor.Processor;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
		Processor processor = (Processor) applicationContext.getBean("sequence");
		WorkflowDTO dto = new ActivityDTO();
		Map< String, Object> attributes  = new HashMap<String, Object>();
		attributes.put("a", "b");
		attributes.put("b", "b");
		attributes.put("c", "b");
		attributes.put("d", "b");
		dto.setAttribute(attributes);
		processor.doActivities(dto);
	}
}
