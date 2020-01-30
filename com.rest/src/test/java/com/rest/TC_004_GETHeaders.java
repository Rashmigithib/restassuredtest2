package com.rest;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_GETHeaders {
	@Test
	 void googlemapallhearderstest() throws ParseException {
		String baseURI="https://maps.googleapis.com";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,155.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		String responseBody=response.getBody().asString();
		System.out.println("response body is : " +responseBody);
		 Headers allheaders = response.headers();
		 for(Header header:allheaders) {
		System.out.println(header.getName()+"      "+header.getValue());
		 }
		 
		
	}
	

}
