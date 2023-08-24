package CrudUsingJsonFile;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class getProject {
	
	@Test
	public void getPro()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File f=new File("./pavi.json");
		
		when().get("/projects/TY_PROJ_24579")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
