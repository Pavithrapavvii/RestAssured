package DDT;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.mozilla.javascript.ObjArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import PojoClass.RequestUsingPojo;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;


import io.restassured.http.ContentType;
import  io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Practice {
	@Test
	public void create()
	{
		baseURI="https://reqres.in";
		//port=8084;
		JSONObject j=new JSONObject();
		j.put("name", "pavi");
		j.put("job", "ATE");
		
		given().body(j).contentType(ContentType.JSON)
		.when().post("/api/users")
		.then().assertThat().contentType(ContentType.JSON).time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
	
	@Test
	public void path()
	{
		baseURI="https://reqres.in";
		given().pathParam("id", 2)
		.when().get("/api/users/{id}")
		.then().log().all();
	}
	
	@Test
	public void query()
	{
		baseURI="https://reqres.in";
		given().queryParam("page", 2)
		.when().get("/api/users")
		.then().log().all();
	}
	
	@Test
	public void basic()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}
	
	@Test
	public void digestive()
	{
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}
	@Test
	public void preEmptive()
	{
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}
	
	
	
	
	
}


