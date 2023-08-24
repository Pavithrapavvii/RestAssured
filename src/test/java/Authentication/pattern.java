package Authentication;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.RequestUsingPojo;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class pattern {
	@DataProvider
	public Object[][] data()
	{
		Object[][] data=new Object[2][4];
		data[0][0]="pavithra";
		data[0][1]="meesho1";
		data[0][2]="Created";
		data[0][3]=10; 
		
		data[1][0]="pavithra";
		data[1][1]="meesho1";
		data[1][2]="Created";
		data[1][3]=10;
		
		return data;
	}
	
	@Test(dataProvider = "data")
	public void createProject(String createdBy,String projectName,String status,int teamSize)
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		RequestUsingPojo r=new RequestUsingPojo(createdBy, projectName, status, teamSize);
		given().body(r).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test
	public void chaining()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		JSONObject j=new JSONObject();
		j.put("createdBy", "pavi");
		j.put("projectName", "12345");
		j.put( "teamSize", 10);
	    
		Response resp = given().body(j).contentType(ContentType.JSON)
		.when().post("/addProject");
		Object proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		
		given().pathParam("id", proId)
		.when().get("/projects/{id}")
		.then().assertThat().log().all();
	}
	
	@Test
	public void authentication()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given().auth().basic("rmgyantra", "rmg@9999")
		.get("/login")
		.then().log().all();
	}
	
	@Test
	public void bearer()
	{
		baseURI="https://api.github.com";
		JSONObject j=new JSONObject();
		j.put("name", "pavi");
		
		given().auth().oauth2("")
		.body(j).contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().assertThat().contentType(ContentType.JSON).log().all();
	}
	@Test
	public void response()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		String expected_statusLine="";
		String expected_contentType="";
		String expected_vary="";
		String expected_pragma="";
		String expected_connection="";
		
		Response resp = when().get("/projects/TY_PROJ_25153");
		String act_status_line=resp.statusLine();
		System.out.println(act_status_line);
		Assert.assertEquals(act_status_line, expected_statusLine);
		
		Headers headers = resp.getHeaders();
		System.out.println(headers);
		
		String act_contentType = resp.getHeader("content_type");
		Assert.assertEquals(expected_contentType, act_contentType);
		
		String act_vary=resp.getHeader("vary");
		Assert.assertEquals(expected_vary, act_vary);
		
		String act_pragma=resp.getHeader("pragma");
		Assert.assertEquals(expected_pragma, act_pragma);
		
		String act_connection=resp.getHeader("connection");
		Assert.assertEquals(expected_connection, act_connection);
		
		resp.then().log().all();
		
	}

}
