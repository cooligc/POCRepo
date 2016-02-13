package app;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.skc.topic.data.consumer.TopicDataListener;
import com.skc.topic.data.producer.TopicDataProducer;
import com.skc.utils.Object2Share;


/**
 * Application main class to demonstrate the usage of queue in Rabbit MQ
 * This program is a type of {@link CommandLineRunner} i.e stand alone application using
 * Spring Boot
 * @author sitakant
 * */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.skc.topic.*"})
@PropertySources(value = {@PropertySource("classpath:app.properties")})
public class TopicApplication implements CommandLineRunner{
	
	@Autowired
	AnnotationConfigApplicationContext context;

	@Autowired
	TopicDataProducer dataProducer;
	
	@Autowired
	TopicDataListener dataListener;
	
	public static void main(String[] args) {
		SpringApplication.run(TopicApplication.class, args);
	}
	

	/**
	 * Threadpool bean 
	 * */
	@Bean(name="threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(5);
		pool.setMaxPoolSize(10);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}
	

	/**
	 * Producer bean
	 * */
	@Bean
	public TopicDataProducer producer(@Value("${amqp.topic.exchange.name}") String exchangeName,@Value("${amqp.topic.name}")String topicName,@Value("${amqp.topic.route.key}")String routingKey,@Value("${amqp.host}")String host){
		System.out.println("Topic Producer Meta Data(START) :----------------------------------------------------------------->");
		System.out.println("Exchange Name : "+exchangeName+"\nTopic Name :"+topicName+"\nRouting Key :"+routingKey+"\nHost : "+host);
		System.out.println("Topic Producer Meta Data(END) :----------------------------------------------------------------->");
		return new TopicDataProducer(exchangeName, topicName, routingKey, host);
	}
	

	/**
	 * Consumer bean
	 * */
	@Bean
	public TopicDataListener consumber(@Value("${amqp.topic.exchange.name}") String exchangeName,@Value("${amqp.topic.name}")String topicName,@Value("${amqp.topic.route.key}")String routingKey,@Value("${amqp.host}")String host,@Value("${amqp.queue.name}")String queueName){
		System.out.println("TopicDataListener Meta Data(START) :----------------------------------------------------------------->");
		System.out.println("Exchange Name : "+exchangeName+"\nTopic Name :"+topicName+"\nRouting Key :"+routingKey+"\nHost : "+host);
		System.out.println("TopicDataListener Meta Data(END) :----------------------------------------------------------------->");
		return new TopicDataListener(exchangeName, topicName, routingKey, host, queueName);
	}


	/**
	 * Starting point of {@link CommandLineRunner} type of application
	 * */
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(new Object2Share("Timson", "Burg")));
		dataProducer.sendMessage(mapper.writeValueAsString(new Object2Share("Timson", "Burg")));
		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context.getBean("threadPoolTaskExecutor");
		executor.execute(dataListener);
	}
	
	
}
