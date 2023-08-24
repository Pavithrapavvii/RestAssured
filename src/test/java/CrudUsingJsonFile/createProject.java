package CrudUsingJsonFile;

import org.testng.annotations.Test;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import GenericUtilities.JavaUtilities;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProject {
	@Test
	public void create()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		java.io.File f=new java.io.File("./pavi.json");
		given().body(f).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().contentType(ContentType.JSON).statusCode(201)
		.log().all();
	}

}
