package CrudUsingPojo;

import org.testng.annotations.Test;

import PojoClass.RequestUsingPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProject {
	@Test
	public void getPro()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects/TY_PROJ_24552")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200)
		.log().all();
	}

}
