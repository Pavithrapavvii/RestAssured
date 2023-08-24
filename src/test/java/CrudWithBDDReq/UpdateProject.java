package CrudWithBDDReq;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void update()
	{
		baseURI="https://reqres.in";
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", "rathna");
		jobj.put("job", "HM");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON).log().all();
	}

}
