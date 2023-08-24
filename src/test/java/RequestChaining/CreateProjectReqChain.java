 package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectReqChain {
	@Test
	public void createPro()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtilities ju=new JavaUtilities();
		int ran = ju.randomNumber();
		
		JSONObject j=new JSONObject();
		j.put("createdBy", "pavithra");
		j.put("projectName", "abcd"+ran);
		j.put("status", "Completed");
		j.put("teamSize", 5);
		
		Response resp = given().body(j).contentType(ContentType.JSON)
		.when().post("/addProject");
		Object pId = resp.jsonPath().get("projectId");
		System.out.println(pId);
		
		given().pathParam("id", pId) 
		.when().get("/projects/{id}")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200)
		.log().all();
		
		JSONObject j1=new JSONObject();
		j1.put("createdBy", "gowri");
		j1.put("projectName", "amaz"+ran);
		j1.put("status", "Ongoing");
		j1.put("teamSize", 6);
		
		given().pathParam("id", pId).body(j1).contentType(ContentType.JSON)
		.when().put("projects/{id}")
		.then().log().all();
		
		System.out.println("done");
		
		
	}

}
