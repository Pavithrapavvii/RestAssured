package InterviewQuestions;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Cookies {
	@Test
	public void sendCookies()
	{
		Response resp = given()
		.when().get("https://www.google.com/");
	     String cookie_value = resp.getCookie("AEC");
	     System.out.println("value of cookie is "+cookie_value);
		
	}

}
