package CrudWithBDDRmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void updateProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Gowri");
		jobj.put("projectName", "Home_lease");
		jobj.put("status", "OnGoing");
		jobj.put("teamSize", 12);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/TY_PROJ_24421")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		
		
	}

}
