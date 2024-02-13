package restapi.BDD;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class getreq {

	@Test
	public void test() {

		RestAssured.given().baseUri("http://localhost:3000/employees").when().get().then().log().body().statusCode(200)
				.body("[0].name", Matchers.equalTo("Pankaj"));

	}

	@Test
	public void getoperationusingparameters() {

		RestAssured.given().baseUri("http://localhost:3000/employees").when().get("/1").then().log().all()
				.statusCode(200).body("name", Matchers.equalTo("Pankaj"));

	}

	@Test
	public void getoperationusingQueryparameters() {

		RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParams("PASSWORD", "1234!")
				.queryParam("Account_No", "1").baseUri("http://demo.guru99.com/V4/sinkministatement.php").when().get()
				.then().log().body().statusCode(200);

	}

	@Test
	public void postoperationusinghashmap() {

		HashMap<String, String> obj = new HashMap<>();
		obj.put("name", "john");
		obj.put("id", "4");
		obj.put("salary", "9");

		RestAssured.given().baseUri("http://localhost:3000/employees").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj).when().post().then().log().body().statusCode(201);

	}

	@Test
	public void putoperation() {

		HashMap<String, String> obj = new HashMap<>();
		obj.put("name", "johnAbraham");
		obj.put("id", "4");
		obj.put("salary", "900");

		RestAssured.given().baseUri("http://localhost:3000/employees").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj).when().put("/4").then().log().body().statusCode(200);

	}

	@Test
	public void patchoperation() {

		HashMap<String, String> obj = new HashMap<>();
		obj.put("name", "johnAbrahamLinconnn");
		obj.put("id", "40");
		obj.put("salary", "9000");

		RestAssured.given().baseUri("http://localhost:3000/employees").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj).when().patch("/4").then().log().body().statusCode(200);

	}

	@Test
	public void deleteoperation() {

		RestAssured.given().baseUri("http://localhost:3000/employees").when().delete("/4").then().log().body()
				.statusCode(200);

	}
}
