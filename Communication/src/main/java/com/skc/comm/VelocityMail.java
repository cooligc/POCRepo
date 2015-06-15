package com.skc.comm;

import java.io.StringWriter;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class VelocityMail {

	
	JavaMailSenderImpl mailSender;
	
	
	VelocityEngine velocityEngine;
	
	
	
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}



	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}



	public void sendMail(String dear,String message2){
		SimpleMailMessage message = new SimpleMailMessage();
		  
		  message.setFrom("from_username@gmail.com");
		  message.setTo("to_username@gmail.com");
		  message.setSubject("Test");

		  Template template = velocityEngine.getTemplate("./templates/" + "message.vm");

		  VelocityContext velocityContext = new VelocityContext();
		  velocityContext.put("firstName", dear);
		  velocityContext.put("lastName", "Chaudhury");
		  velocityContext.put("location", "Pune");
		  
		  StringWriter stringWriter = new StringWriter();
		  
		  template.merge(velocityContext, stringWriter);
		  
		  message.setText(stringWriter.toString());
		  
		  mailSender.send(message);
		
	}
	
	public void sendMail(){
		
		MimeMessagePreparator message = new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				 MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					  message.setFrom("from_username@gmail.com");
					  message.setTo("to_username@gmail.com");
					  message.setSubject("Test");
					  Template template = velocityEngine.getTemplate("./templates/" + "message.vm");

					  VelocityContext velocityContext = new VelocityContext();
					  velocityContext.put("firstName", "Sitakant");
					  velocityContext.put("lastName", "Chaudhury");
					  velocityContext.put("location", "Pune");
					  
					  StringWriter stringWriter = new StringWriter();
					  
					  template.merge(velocityContext, stringWriter);
					  
					  message.setText(stringWriter.toString(),true);
			}
		};
		  
		  
		  mailSender.send(message);
		
	}
}
