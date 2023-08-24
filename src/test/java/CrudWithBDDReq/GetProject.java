package CrudWithBDDReq;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProject {
	@Test
	public void getPro()
	{
		baseURI="https://reqres.in";
		
		when().get("/api/users/2")
		
		.then()
		
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
		
		
		
	}

}
