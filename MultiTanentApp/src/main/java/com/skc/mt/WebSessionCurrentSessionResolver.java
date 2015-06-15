package com.skc.mt;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p> Create an proxy per request to decide the tanent</p>
 * @author IgnatiusCipher
 * */
public class WebSessionCurrentSessionResolver implements
		CurrentTenantIdentifierResolver {
	
	@Autowired
    private HttpServletRequest request;

	public String resolveCurrentTenantIdentifier() {
		String tenantId = request.getHeader("X-TenantId");
		System.out.println("Choosen Tanent id is ========>"+tenantId);
		return tenantId;
	}

	public boolean validateExistingCurrentSessions() {
		return false;
	}

}
