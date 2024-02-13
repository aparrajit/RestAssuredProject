package com.restapi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification Request = RestAssured.given();

		Response response = Request.get();

		String responseBody = response.body().asString();

		System.out.println(responseBody);

		System.out.println("Response code is " + response.statusCode());
		int stscode = response.statusCode();

		Assert.assertEquals(stscode, 200);

		JsonPath json = response.jsonPath();

		List<String> names = json.getList("name");

		for (String name : names) {

			System.out.println(name);

		}

		System.out.println(names.get(1));
		System.out.println(names.get(2));
	}

}
