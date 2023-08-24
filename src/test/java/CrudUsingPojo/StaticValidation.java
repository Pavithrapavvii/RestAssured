package CrudUsingPojo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidation {
	@Test
	public void staticvalid()
	{
		baseURI="http://rmgtestingserver";
	    port=8084;
	    
//	    when()
//	    .get("/projects");
//	    String expData="TY_PROJ_12318";
//	    Response resp = given().get("/projects");
//	    Object actData = resp.jsonPath().get("[0].projectId");
//	    Assert.assertEquals(expData, actData);
//	    
//	    System.out.println("data is verified");
	    
	    when()
	    .get("/projects");
	    String expData="TY_PROJ_12323";
	    Response resp = get("/projects");
	    Object actData = resp.jsonPath().get("[2].projectId");
	    Assert.assertEquals(expData, actData);
	    System.out.println("done");
	    
	    
	    
	    
	}

}
