package JsonSchemaValidation;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class SchemaValidation {
	@Test
	public void validation()
	{
		File f=new File("./schema.json");
		when().get("https://reqres.in/api/users?page=2")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(f))
		.log().all();
	}
	
	
	@Test
	public void valid()
	{
		File f=new File("./schema.json");
		when().get("https://reqres.in/api/users?page=2")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(f))
		.log().all();
		
	}

}
