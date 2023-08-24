package CrudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updatePro()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("name", "gowri");
		jobj.put("job", "ATE");
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		Response update = req.put("https://reqres.in/api/users/2");
		System.out.println(update.prettyPeek());
	}

	
}
