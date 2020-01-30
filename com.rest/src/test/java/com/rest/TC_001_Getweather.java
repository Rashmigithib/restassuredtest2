package com.rest;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Getweather {

	@Test
	 void weathertest1() throws ParseException {
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "london");
		String responseBody=response.getBody().asString();
		System.out.println("response body is : " +responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("status code is : " +response.getStatusCode());
		Assert.assertEquals(statusCode, 401);;
		
		String statusmessage = response.getStatusLine();
		System.out.println("statusline message " +response.getStatusLine());
		Assert.assertEquals(statusmessage, "Invalid API key");

	}
}
