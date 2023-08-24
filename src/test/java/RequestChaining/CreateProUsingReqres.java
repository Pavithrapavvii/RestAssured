package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class CreateProUsingReqres {
	@Test
	public void create()
	{
		baseURI="https://reqres.in";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "Gowri");
		jobj.put("job", "AE");

		Response resp = given().body(jobj).contentType(ContentType.JSON)
	    .when().post("/api/users");
		Object pId = resp.jsonPath().get("id");
		System.out.println(pId);
		
		given().pathParam("id", 2)
		.when().get("/api/users/{id}")
		.then().log().all();
		
		

	}

}
