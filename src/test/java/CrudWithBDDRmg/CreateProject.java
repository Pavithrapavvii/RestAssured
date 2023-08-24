package CrudWithBDDRmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void create()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtilities j=new JavaUtilities();
		int ran = j.randomNumber();
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "malli");
		jobj.put("projectName", "Home_lease"+ran);
		jobj.put("status", "onGoing");
		jobj.put("teamSize", 5);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	}

}
