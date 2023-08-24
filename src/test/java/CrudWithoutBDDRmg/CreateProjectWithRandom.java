package CrudWithoutBDDRmg;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectWithRandom {
	@Test
	public void withRandomNumber()
	{
		JavaUtilities j=new JavaUtilities();
		int ran = j.randomNumber();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Gowri");
		jobj.put("projectName", "Flipkart"+ran);
		jobj.put("status", "Created");
		jobj.put("teamSize", 12);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		Response data = req.post("http://rmgtestingserver:8084/addProject");
		System.out.println(data.prettyPeek());
		
	}

}
