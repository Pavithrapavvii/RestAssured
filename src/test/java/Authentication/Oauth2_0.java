  package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0 {
	//
	@Test
	public void oauthToken()
	{
		Response resp = given().formParam("client_id", "meesho")
		.formParam("client_secret", "364d9290407dd74135b4dcd6044b6edb")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		 .when().post("http://coop.apps.symfonycasts.com/token");
		
		
		resp.then().log().all();
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
//		given().auth().oauth2(token).pathParam("pId", 4654)
//		.when().post("http://coop.apps.symfonycasts.com/api/{pId}/eggs-count")
//		.then().log().all();
		
//		given().auth().oauth2(token).pathParam("pid", 4654)
//		.when().post("http://coop.apps.symfonycasts.com/api/{pid}/eggs-collect")
//		.then().log().all();
		
		given().auth().oauth2(token).pathParam("uid", 4654)
		.when().post("http://coop.apps.symfonycasts.com/api/{uid}/chickens-feed")
		.then().log().all();
		
	}

}
