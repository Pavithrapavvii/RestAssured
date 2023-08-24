package SpecBuilder;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import DDT.DataProviderProgramme;
import GenericUtilities.JavaUtilities;
import PojoClass.RequestUsingPojo;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	@Test
	public void create()
	{
		JavaUtilities j=new JavaUtilities();
		int ran = j.randomNumber();
		
		RequestUsingPojo r=new RequestUsingPojo("pavithra", "nykaa"+ran, "Created", 10);
		
		
		RequestSpecification req=new RequestSpecBuilder()
		.setBaseUri("http://rmgtestingserver:8084")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201).expectResponseTime(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
				
				.build();
		
	     given().spec(req).body(r)
	     .when().post("/addProject")
	     .then().spec(resp).log().all();
		
//		baseURI="http://rmgtestingserver";
//		port=8084;
//	     
//	     DataProviderProgramme d=new DataProviderProgramme();
//	     d.createProject("pavi1", "bcgd", "Completed", 10);
//	     d.createProject("gowri1 ", "hsdfhj", "ongoing", 6);
//	     given().body(d).contentType(ContentType.JSON)
//	     .when().post("/addProject")
//	     .then().log().all();
		
				
	}
}
