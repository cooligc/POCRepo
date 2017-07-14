/**
 * 
 */
package com.skc.api.resource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skc.api.storage.DataStorage;

/**
 * @author sitakant
 *
 */
@Path("/employee")
public class EmployeeApi {

	
	@Context
	HttpServletRequest httpServletRequest;
	
	@Context
	HttpServletResponse httpServletResponse;
	
	@Inject
	DataStorage dataStorage;
	
	@Inject
	@Named("myStorage")
	DataStorage dataStorage1;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee() {
		
		System.out.println(dataStorage);
		System.out.println(dataStorage1);
		
		return Response.status(200).entity(new Employee("Test", "D1", 1111)).build();
	}
	
	
}
