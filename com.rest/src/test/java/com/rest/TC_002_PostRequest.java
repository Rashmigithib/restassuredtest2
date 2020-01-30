package com.rest;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_PostRequest {
	@Test
	 void weatherpost1() throws ParseException {
		String baseURI="http://restapi.demoqa.com/customer/register";
		RequestSpecification httprequest = RestAssured.given();
	    JSONObject requestparam = new JSONObject();
	    requestparam.put("FirstName", "rashmi123");
	    requestparam.put("LastName", "gowda");
	    requestparam.put("UserName", "shashi1234");
	    requestparam.put("Password", "rashi");
	    requestparam.put("Email", "rashmiag90");
	   Response response= httprequest.body(requestparam.toJSONString()).header("Content-Type","application/json").when().post(baseURI);
	    System.out.println(response.getBody().asString());
	    System.out.println(response.getStatusCode());
	    
	   String test= response.jsonPath().get("FaultId");
	   
	   
	   Assert.assertEquals("User already exists", test);
	    
	    
	}

}
