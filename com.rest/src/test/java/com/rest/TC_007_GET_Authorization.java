package com.rest;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_GET_Authorization {
	@Test
	 public void authorization() throws ParseException {
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication/";
		
		  PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		  authscheme.setUserName("ToolsQA1"); authscheme.setPassword("TestPassword1");
		  RestAssured.authentication = authscheme;
		 
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/");
		int statuscode= response.getStatusCode();
		System.out.println(statuscode);
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		
		

		
	}
}
