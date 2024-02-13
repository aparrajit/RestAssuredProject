package com.git;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepoUsingAuth {

	@Test
	public void test() throws IOException {

		byte[] file = Files.readAllBytes(Paths.get("githubcreaterepo.json"));

		RestAssured.baseURI = "https://api.github.com/user/repos";

		RequestSpecification request = RestAssured.given();

		Response response = request.auth().oauth2("token").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(file).post();

		System.out.println(response.body().asString());
		System.out.println(response.statusCode());

	}

}
