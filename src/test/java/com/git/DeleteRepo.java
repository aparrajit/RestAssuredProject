package com.git;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {

	@Test
	public void test() {

		RestAssured.baseURI = "https://api.github.com/repos/aparrajit/RestAssured";

		RequestSpecification request = RestAssured.given();

		Response response = request.auth().oauth2("token").delete();

		System.out.println(response.body().asString());
		System.out.println(response.statusLine());

	}

}
