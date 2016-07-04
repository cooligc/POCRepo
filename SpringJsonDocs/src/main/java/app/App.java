package app;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJSONDoc
@ComponentScan(basePackages="com.skc")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
