package com.rest;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_EachNodeJson {
	@Test
	 public void jsonValues() throws ParseException {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/Hyderabad");
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temprature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		
		
		
		  String responseBody = response.getBody().asString();
		  System.out.println("response body is : " + responseBody);
		 // Assert.assertEquals(responseBody.contains("Delhi"), true);
		 

	}

}
