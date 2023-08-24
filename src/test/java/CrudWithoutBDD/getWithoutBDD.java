package CrudWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class getWithoutBDD {

	public static void main(String[] args) {
		
		Response resp = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(resp.prettyPeek());
		int code = resp.getStatusCode();
		
		Assert.assertTrue("200", true);
		System.out.println("pass");

	}

}
