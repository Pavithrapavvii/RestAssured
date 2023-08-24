package CrudWithBDDReq;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	@Test
	public void delete()
	{
		baseURI="https://reqres.in";
		when().delete("/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(204)
		
		.log().all();
	}

}
