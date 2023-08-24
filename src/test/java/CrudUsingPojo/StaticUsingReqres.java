package CrudUsingPojo;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.RequestUsingPojo;
import PojoClass.RequestUsingReqres;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticUsingReqres {
	@Test
	public void staticValid()
	{
		baseURI="https://reqres.in/";
//		RequestUsingReqres rp=new RequestUsingReqres("pavithra", "sfghg");
//		given().body(rp).contentType(ContentType.JSON)
//		.when().post("/api/users")
//		.then().assertThat().contentType(ContentType.JSON).statusCode(201)
//		.log().all();
		
		
		when()
	    .get("/api/users?page=2");
	    int expData=8;
	    Response resp = when().get("/api/users?page=2");
	    Object actData = resp.jsonPath().get("data[1].id");
	    Assert.assertEquals(expData, actData);
	    System.out.println("done");
		
	}

}
