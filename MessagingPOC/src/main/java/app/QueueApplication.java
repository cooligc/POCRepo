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

import com.skc.queue.consumer.QueueConsumer;
import com.skc.queue.producer.Producer;
import com.skc.utils.Object2Share;

/**
 * Application main class to demonstrate the usage of queue in Rabbit MQ
 * This program is a type of {@link CommandLineRunner} i.e stand alone application using
 * Spring Boot
 * @author sitakant
 * */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.skc.queue.*")
@PropertySources(value = {@PropertySource("classpath:app.properties")})
public class QueueApplication implements CommandLineRunner{
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Autowired
	Producer producer;
	
	@Autowired
	QueueConsumer queueConsumer;
	
	
	public static void main(String[] args) {
		SpringApplication.run(QueueApplication.class, args);
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
	public Producer producer(@Value("${amqp.host}") String host,@Value("${amqp.queue.name}") String queueName){
		System.out.println("----------------->"+host+"<---------------->"+queueName+"<-------------------");
		return new Producer(queueName, host);
	}
	
	/**
	 * Consumer bean
	 * */
	@Bean
	public QueueConsumer consumer(@Value("${amqp.host}") String host,@Value("${amqp.queue.name}") String queueName){
		System.out.println("----------------->"+host+"<---------------->"+queueName+"<-------------------2");
		return new QueueConsumer(queueName, host);
	}

	/**
	 * Starting point of {@link CommandLineRunner} type of application
	 * */
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		producer.sendMessage(mapper.writeValueAsString(new Object2Share("Timson", "Burg")));
		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) context.getBean("threadPoolTaskExecutor");
		executor.execute(queueConsumer);
	}
	
}
