package com.rest;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_ResponseBody {
	@Test
	public  void responsebodyvalidation() throws ParseException {
	    RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/Delhi");
		String responseBody=response.getBody().asString();
		System.out.println("response body is : " +responseBody);
		Assert.assertEquals(responseBody.contains("Delhi"), true);
		
	}
	

}
