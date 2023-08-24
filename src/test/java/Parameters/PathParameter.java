package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void createPro()
	{
		given().pathParam("projectId", "TY_PROJ_24677")
		.when().get("http://rmgtestingserver:8084/projects/{projectId}")
		.then().assertThat().log().all();
	}

}
