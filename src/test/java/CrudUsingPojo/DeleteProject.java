package CrudUsingPojo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	@Test
	public void delete()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		when().delete("/projects/TY_PROJ_24552")
		.then().assertThat().contentType(ContentType.JSON).statusCode(204)
		.log().all();
	}

}
