package CrudWithBDDRmg;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	@Test
	public void delete()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_24421")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
