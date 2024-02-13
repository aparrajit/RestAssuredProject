package com.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReq {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(
				"{\r\n" + "    \"name\": \"Apps\",\r\n" + "    \"salary\": \"9000\",\r\n" + "    \"id\": 4\r\n" + "}")
				.post();

		System.out.println("The response code is " + response.getStatusCode());

		System.out.println("The response body is " + response.body().asString());

	}

}
