package CrudWithBDDReq;

import java.net.URL;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	@Test
	public void createPro()
	{
		baseURI="https://reqres.in";
		
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", "rathna");
		jobj.put("job", "HM");
		
		//step 1: pre-condition
		 given()
		.body(jobj)
		.contentType(ContentType.JSON)
		 
		 //step 2: actions
		 .when().post("/api/users")
		 
		 //step 3: validation
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .contentType(ContentType.JSON)
		 .log().all();
		
		
		
	}

}
