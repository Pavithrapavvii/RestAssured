package CrudUsingPojo;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import PojoClass.RequestUsingPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class SendReq {
	
	@Test
	public void sendReq()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtilities j=new JavaUtilities();
		int ran = j.randomNumber();
		
		RequestUsingPojo rp=new RequestUsingPojo("pavi", "abc"+ran, "Creatrd", 10);
		
		given().body(rp).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().time(Matchers.lessThan(8000l),TimeUnit.MILLISECONDS).contentType(ContentType.JSON)
		.log().all();
		
	}

}
