
package com.git;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getallrepo {

	@Test
	public void test1() {

		RestAssured.baseURI = "https://api.github.com/users/aparrajit/repos";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println(response.body().asString());
	}

}
