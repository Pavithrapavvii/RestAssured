package CrudUsingJsonFile;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class DeleteProject {
	@Test
	public void delete()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File f=new File("./pavi.json");
		when().delete("/projects/TY_PROJ_24513")
		.then().assertThat().contentType(ContentType.JSON).statusCode(204)
		.log().all();
		
	}

}
