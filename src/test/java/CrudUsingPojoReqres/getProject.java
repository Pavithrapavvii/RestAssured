package CrudUsingPojoReqres;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class getProject {
	@Test
	public void getPro()
	{
		baseURI="https://reqres.in/";
		when().get("/api/users/22")
		.then().assertThat().time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON).statusCode(200)
		.log().all();
	}

}
