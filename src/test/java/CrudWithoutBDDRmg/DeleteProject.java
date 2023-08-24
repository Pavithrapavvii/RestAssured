package CrudWithoutBDDRmg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void deleteProject()
	{
		Response req = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_24291");
		System.out.println(req.prettyPeek());
	}

}
