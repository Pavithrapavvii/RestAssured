package CrudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void deleteProject()
	{
		Response resp = RestAssured.delete("https://reqres.in/api/users/2");
		System.out.println(resp.prettyPeek ());
	}

}
