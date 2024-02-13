package com.restapi;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutReq {

	@Test
	public void test() {

		HashMap<String, String> obj = new HashMap<String, String>();

		obj.put("name", "Priyaa");
		obj.put("salary", "1000");
		obj.put("id", "4");

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(obj).put("/4");

		System.out.println("The response code is " + response.getStatusCode());

		System.out.println("The response body is " + response.body().asString());

		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
