package InterviewQuestions;

import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.response.Response;

public class GetCookiesInfo {

	public static void main(String[] args) {
		Response res = given()
		.when().get("https://google.com/");
		Map<String, String> cookie_value = res.getCookies();
		//System.out.println(cookie_value.keySet());
		for(String k:cookie_value.keySet())
		{
			String value = res.getCookie(k);
			System.out.println(k+"  "+value);
		}
		

	}

}
