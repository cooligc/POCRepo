package com.skc.rest.auth;

import java.io.IOException;
import java.util.StringTokenizer;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sun.jersey.core.util.Base64;

/**
 * <p>Here is the Authenticate Service which will implement the Basic 
 * Authenticate as well as Other Authenticate Algos </p>
 * @author IgnatiusCipher
 * @version 1.0
 * */

@Component("authService")
public class AuthenticateServiceImpl implements AuthenticateService{

	/**
	 * <p>Method to provide BASIC Authentication to all the web service</p>
	 * @param credential type of {@link String}
	 * @return {@link Boolean}
	 * */
	public boolean authenticate(String credential) {
		if(StringUtils.isEmpty(credential)){
			return false;
		}
		
		final String encodedPassword = credential.replace("Basic ", "");
		String userNameAndPwd = null;
		try{
			byte[] decodedBytes = Base64.decode(encodedPassword);
			userNameAndPwd = new String(decodedBytes,"UTF-8");
		}catch(IOException exception){
			exception.printStackTrace();
		}
		
		final StringTokenizer tokenizer = new StringTokenizer(userNameAndPwd, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		boolean authenticationStatus = "admin".equals(username)
				&& "admin".equals(password);
		return authenticationStatus;
	}
}
