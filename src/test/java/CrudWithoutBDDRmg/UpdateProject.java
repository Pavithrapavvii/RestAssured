package CrudWithoutBDDRmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Gowri");
		jobj.put("projectName", "Home_lease");
		jobj.put("status", "OnGoing");
		jobj.put("teamSize", 16);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		Response data = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_24291");
		System.out.println(data.prettyPeek());
	}

}
