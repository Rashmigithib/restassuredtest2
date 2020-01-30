package com.rest.DataDriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {

	@Test
	public void testaddnewemployees() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", "ramu67722");
		requestparam.put("salary", "2000");
		requestparam.put("age", "13");
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparam.toJSONString());
		Response response = httprequest.request(Method.POST,"/create");
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		Assert.assertEquals(responsebody.contains("ramu67722"), true);
		Assert.assertEquals(responsebody.contains("2000"), true);
		Assert.assertEquals(responsebody.contains("13"), true);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);

	}

}
