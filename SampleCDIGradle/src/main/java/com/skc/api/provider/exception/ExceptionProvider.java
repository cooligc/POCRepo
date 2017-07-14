/**
 * 
 */
package com.skc.api.provider.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author sitakant
 *
 */

@Provider
public class ExceptionProvider implements ExceptionMapper<UndefinedException>{

	@Override
	public Response toResponse(UndefinedException exception) {
		return Response.status(400).entity(new ErrorWrapper(exception.getErrorCode(),exception.getErrorMessage())).build();
	}

}
