package com.skc.comm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
       // mm.sendMail("Sitakant", "This is text content");
        System.out.println("Done");
        
        VelocityMail velocityMail = (VelocityMail) context.getBean("mail");
        velocityMail.sendMail();
        System.out.println("Done");
    }
}
