package Authentication;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearearToken {
	@Test
	public void bearearToken()
	{
		baseURI="https://api.github.com";
		JSONObject j=new JSONObject();
		j.put("name", "gowri");
		
		given().auth().oauth2("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")
		.body(j).contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().assertThat().statusCode(201)
		.log().all();
	}
	

}
