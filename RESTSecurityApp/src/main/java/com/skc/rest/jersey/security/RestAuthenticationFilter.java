package com.skc.rest.jersey.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.skc.rest.auth.AuthenticateService;
import com.skc.rest.auth.AuthenticateServiceImpl;

/**
 * <p>Here is the filter whose responsibility to authenticate the web service call using basic authentication</p>
 * @author IgnatiusCipher
 * @version 1.0
 * */
@Component
public class RestAuthenticationFilter implements Filter {
	
	@Autowired
	@Qualifier("authService")
	AuthenticateService authService;
	
	public static final String AUTHENTICATION_HEADER = "Authorization";

	public void destroy() {
		
	}

	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain filter) throws IOException, ServletException {
		if(request instanceof HttpServletRequest){
			HttpServletRequest httpServletRequest = (HttpServletRequest)request;
			String authCredential = httpServletRequest.getHeader(AUTHENTICATION_HEADER);
			boolean isAuthenticated = new AuthenticateServiceImpl().authenticate(authCredential);
			if(isAuthenticated){
				filter.doFilter(request, response);
			}else{
				if(response instanceof HttpServletResponse){
					HttpServletResponse httpServletResponse = (HttpServletResponse)response;
					httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED, "Basic Authenticate Failed");
				}
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
