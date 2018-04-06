package com.skc.slack.slackbroaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SlackBroakerApplication {

	public static void main(String[] args) {
		/*-Dhttp.proxyHost=somesite.com -Dhttp.proxyPort=4321 
		-Dhttps.proxyHost=somesite.com -Dhttps.proxyPort=4321 -Dhttps.proxySet=true 
				-Dhttp.proxySet=true
						https://web-proxy.sgp.hp.com:8080
						*/
		System.setProperty("http.proxyHost", "web-proxy.sgp.hp.com");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "web-proxy.sgp.hp.com");
		System.setProperty("https.proxyPort", "8080");
		
		SpringApplication.run(SlackBroakerApplication.class, args);
	}
	
	@Bean(name = "appRestClient")
	public RestTemplate getRestClient() {

	    RestTemplate  restClient = new RestTemplate(
	        new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

	    //List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
	    //interceptors.add(new RestServiceLoggingInterceptor());
	    //restClient.setInterceptors(interceptors);

	    return restClient;
	}
}
