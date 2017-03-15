package org.naetag.app;

import org.jboss.aerogear.security.otp.Totp;
import org.jboss.aerogear.security.otp.api.Base32;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		String secret = "NaeTag";//Base32.random();
		Totp totp = new Totp(secret);
		String otp = totp.now();
		System.out.println(totp.now()); //868748

		System.out.println(totp.verify(otp)); //true
		Thread.sleep(40);
		System.out.println(totp.verify(otp)); //false
	}
}
