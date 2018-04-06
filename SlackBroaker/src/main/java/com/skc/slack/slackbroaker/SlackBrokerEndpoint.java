/**
 * 
 */
package com.skc.slack.slackbroaker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chaudhsi
 *
 */
@RestController
@RequestMapping("/v1/broker")
public class SlackBrokerEndpoint {

	@Autowired
	private RestTemplate template;
	
	@Value("${slack.auth.token}")
	String slackToken;
	
	@Value("${slack.url}")
	String slackUrl;
	
	@PostMapping
	public MessageResponse postMessageToSlack(@RequestBody MessageRequest messageRequest) {
	    SlackRequest request = convertToSlackRequest(messageRequest);
		ResponseEntity<SlackResponse> slackResponseEntity = template.postForEntity("https://slack.com/api/chat.postMessage", request, SlackResponse.class);
		return convertToMessageResponse(slackResponseEntity);
	}

	private MessageResponse convertToMessageResponse(ResponseEntity<SlackResponse> slackResponseEntity) {
		MessageResponse messageResponse= new MessageResponse();
		messageResponse.setStatus(slackResponseEntity.getStatusCode().name());
		messageResponse.setMessage(slackResponseEntity.getBody().getMessage().getText());
		Map<String, Object> meta = new HashMap<>();
		meta.put("slack_response", slackResponseEntity.getBody());
		messageResponse.setMeta(meta);
		return messageResponse;
	}

	private SlackRequest convertToSlackRequest(MessageRequest messageRequest) {
		SlackRequest request = new SlackRequest();
		request.setChannel(messageRequest.getChannel());
		request.setMessage(messageRequest.getMessage());
		request.setToken(slackToken);
		request.setUsername("SKC_BOT");
		return request;
	}
	
}
