package CrudUsingJsonFile;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class UpdateProject {
	@Test
	public void update()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File f=new File("./pavi.json");
		
		given().body(f).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_24513")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
	}

}
