package com.skc.api;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.skc.ApiWebApplicationTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EmployeeRepositoryTestCase extends ApiWebApplicationTests{
	
	private final static String RESOURCE_URL="http://localhost:8090";
	private final static String RESOURCE_PATH="/employee";
	
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = RESOURCE_URL;
        RestAssured.basePath = RESOURCE_PATH;
	}
	
	@Test
	public void testEmployeeCreate(){
		 Map<String,String> employee = new HashMap<>();
		 employee.put("name", "Sitakant");
		 employee.put("age", "25");
		 employee.put("dept", "A");
		
		
		Response response = RestAssured.given().contentType("application/json").body(employee).auth().basic("user", "user").post().andReturn();
		
		assert response.statusCode() == 201;
	}
	
	@Test
	public void testGetEmployee(){
		Response response = RestAssured.given().auth().basic("user", "user").get().andReturn();
		assert response.statusCode() == 200;
		response = RestAssured.given().get("/1").andReturn();
		assert response.statusCode() == 200;
	}
	
	@Test
	public void testUpdateEmployee(){
		 Map<String,String> employee = new HashMap<>();
		 employee.put("age", "15");
		Response response = RestAssured.given().contentType("application/json").body(employee).auth().basic("user", "user").put("/1").andReturn();
		assert response.statusCode() == 200;
		assert Integer.valueOf(response.jsonPath().get("age").toString()) == 15;
	}
	
	@Test
	public void testDeleteEmployee(){
		Response response = RestAssured.given().auth().basic("user", "user").delete("/1").andReturn();
		assert response.statusCode() == 204;
	}
	
	
}
