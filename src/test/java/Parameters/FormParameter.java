package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameter {
	@Test
	public void formParam()
	{
//		baseURI="http://rmgtestingserver";
//		port=8084;
//		
//		given().formParam("createdBy", "pavi")
//		.formParam("projectName", "xyz")
//		.formParam("status", "on Going")
//		.formParam("teamSize", 8)
//		
//		.when().post("/addProject")
//		.then().assertThat().log().all();
		baseURI="https://reqres.in/";
		given().formParam("name", "gowri")
		.formParam("job", "PWDEngineer")
		.when().post("/api/users")
		.then().assertThat().log().all();
	}

}
