package com.rest.DataDriven;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriventestwithmultiple {


	@Test(dataProvider="empdataprovider")
	public void testaddnewemployeesmultiple(String empname,String empage,String empsal) {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject requestparam = new JSONObject();
		requestparam.put("name", empname);
		requestparam.put("age", empage);
		requestparam.put("salary", empsal);
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparam.toJSONString());
		Response response = httprequest.request(Method.POST,"/create");
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		Assert.assertEquals(responsebody.contains(empname), true);
		Assert.assertEquals(responsebody.contains(empage), true);	
		Assert.assertEquals(responsebody.contains(empsal), true);
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
	
	}
		
		@DataProvider(name="empdataprovider")
		String [][] getData() throws IOException {
			String path = "C:\\Users\\rag4\\Documents\\workspace-spring-tool-suite-4-4.1.0.RELEASE\\com.rest\\src\\test\\resources\\empdata.xlsx";
		int rownum1 =	XLUtils.getRowCount(path, "Sheet1");
		System.out.println(rownum1);	
		int colcount1 = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(colcount1);
			String empdata[][]= new String[rownum1][colcount1];
			for(int i=1;i<=rownum1;i++) {
				
				for(int j=0;j<colcount1;j++) {
					empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
					
				}
			}
			return(empdata);
		}

	
}
