package InterviewQuestions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class CheckResponseIsJsonObj_Arr_String {
	@Test
	public void checkUser()
	{
		baseURI="https://reqres.in";
		when().get("/api/users/2")
		.then().assertThat().body("", Matchers.instanceOf(Map.class))
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		System.out.println("it is a json data");
	}
	
	@Test
	public void passingCookies_using_With()
	{
//		baseURI="https://reqres.in";
//		when().get("/api/users/2");
		Response resp = given()
		.with()
		.cookies("statusLine", "HTTP/1.1 200")
		.cookie("Vary", "Accept-Encoding")
		.when()
		.get("/api/users?page=2");
		System.out.println(resp.getCookies());
	}

}
