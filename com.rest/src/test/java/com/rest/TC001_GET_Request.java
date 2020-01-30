package com.rest;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	 void weathertest() throws ParseException {
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Username", "rashmi");
		map.put("pwd", "123");
		RequestSpecification httprequest = RestAssured.given().headers(map);
		Response response = httprequest.request(Method.GET, "london");
		String responseBody=response.getBody().asString();
		System.out.println("response body is : " +responseBody);
		System.out.println("status code is : " +response.getStatusCode());
		JSONParser parser = new JSONParser();

        

            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
            System.out.println("message is  " + jsonObject.get("message"));
		  assertTrue(jsonObject.get("message").toString().contains("Invalid API key"));
	}

}
