package CrudWithoutBDDRmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createPro()
	{
		JavaUtilities j=new JavaUtilities();
		int ran = j.randomNumber();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Gowri");
		jobj.put("projectName", "Home_lease"+ran);
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		System.out.println(response.prettyPeek());
		
	}

}
