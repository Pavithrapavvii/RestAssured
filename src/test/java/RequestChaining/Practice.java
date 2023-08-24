package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Practice {
	@Test
	public void practice()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtilities j1=new JavaUtilities();
		int ran = j1.randomNumber();
		
		JSONObject j=new JSONObject();
		j.put("createdBy", "malli");
		j.put("projectName", "rmg"+ran);
		j.put("status", "Completed");
		j.put("teamSize", 10);
		
	     Response resp = given().body(j).contentType(ContentType.JSON)
	    .when().post("/addProject");
	     Object pId = resp.jsonPath().get("projectId");
	     given().pathParam("id", pId);
	    		
		
	}

}
