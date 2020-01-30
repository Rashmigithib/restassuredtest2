package com.rest;

import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_Request {
	@Test
	 void googlemaptest() throws ParseException {
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httprequest = RestAssured.given();
		//Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,155.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("loaction", "-33.8670522,155.1957362");
		map.put("radius", "1500");
		Response response = httprequest.queryParams(map).request(Method.GET, "/maps/api/place/nearbysearch/xml");
		
		String responseBody=response.getBody().asString();
		System.out.println("response body is : " +responseBody);
		String contentType = response.header("Content-Type");
		String date = response.header("date");
		String expries= response.header("expires");
		System.out.println(contentType);
		System.out.println(date);
		System.out.println(expries);
		//Assert.assertEquals(contentType, "text/html;charset=utf-8");
		//Assert.assertEquals(expries, "Fri, 01 Jan 1990 00:00:00 GMT");
		
	}

}
