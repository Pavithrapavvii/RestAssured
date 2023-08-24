package Parameters;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	@Test
	public void queryParam()
	{
		baseURI="https://reqres.in/";
		given().queryParam("page", 2)
		//given().pathParam("id", 2)
		.when().get("/api/users")
		.then().assertThat().log().all();
	}

}
