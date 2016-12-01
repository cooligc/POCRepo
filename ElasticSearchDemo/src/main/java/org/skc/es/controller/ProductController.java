package org.skc.es.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.skc.es.core.ESEndPoint;
import org.skc.es.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
@Api(value="product",description="API for Product")
public class ProductController {
	
	@Autowired
	ESEndPoint endPoint;
	
	private static List<Product> products = new ArrayList<Product>();
	
	private static final String INDEX_NAME="ecommerce";
	private static final String TYPE="product";
	
	
	@RequestMapping(method=RequestMethod.POST,consumes={"application/json"})
	@ApiOperation(value = "Returns user details", notes = "Create a Product", response = Product.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful retrieval of user detail", response = String.class),
	    @ApiResponse(code = 404, message = "User with given username does not exist"),
	    @ApiResponse(code = 500, message = "Internal server error")}
	)
	public String createProduct(@ApiParam Product product){
		
		products.add(product);
		endPoint.createIndex(INDEX_NAME, TYPE, UUID.randomUUID().toString(), createMap(product));
		
		return "Product Created Successfully";
	}


	private Map<String, String> createMap(Product product) {
		Map<String,String> productMap = new HashMap<String, String>();
		productMap.put("category", product.getCategory());
		productMap.put("name", product.getName());
		productMap.put("price", product.getPrice());
		productMap.put("url", product.getUrl());		
		return productMap;
	}

}
