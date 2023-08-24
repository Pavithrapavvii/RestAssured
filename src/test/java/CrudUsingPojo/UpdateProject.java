package CrudUsingPojo;

import org.testng.annotations.Test;

import PojoClass.RequestUsingPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void updatePro()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		RequestUsingPojo rp=new RequestUsingPojo("gowri", "abcd", "Completed", 10);
		
		given().body(rp).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_24552")
		.then().assertThat().contentType(ContentType.JSON).statusCode(200)
		.log().all();
		
		
	}

}
