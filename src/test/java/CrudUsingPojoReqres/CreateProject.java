package CrudUsingPojoReqres;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClass.RequestUsingReqres;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProject {
	@Test
	public void create()
	{
		baseURI="https://reqres.in/";
		RequestUsingReqres rp=new RequestUsingReqres("pavithra", "JE");
		given().body(rp).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().assertThat().time(Matchers.lessThan(8000l),TimeUnit.MILLISECONDS).contentType(ContentType.JSON).statusCode(201)
		.log().all();
	}

}
