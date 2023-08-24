package ScenerioBasedProgramme;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.DataBaseUtility;
import GenericUtilities.EndPointLibrary;
import GenericUtilities.IconStants;
import GenericUtilities.JavaUtilities;
import GenericUtilities.RestAssuredLibrary;
import PojoClass.RequestUsingPojo;
import freemarker.ext.jsp.TaglibFactory.WebInfPerLibJarMetaInfTldSource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class CreateProject extends BaseClass{
	@Test
	public void create() throws Throwable
	{
		
		baseURI=IconStants.URL;
		RequestUsingPojo r=new RequestUsingPojo("pavi", "abcde"+jLib.randomNumber(), "Completed", 10);
		
		DataBaseUtility d=new DataBaseUtility();
		
		
		Response resp = given().body(r).contentType(ContentType.JSON)
				.when().post(EndPointLibrary.createProject);
		
		String pId = rLib.getJsonData(resp, "projectId");
		
		System.out.println(pId);
//		
		String querry = "select* from project;";
		String actData = dbLib.executeQuerryAndVerify(querry, 1, pId);
		
		Assert.assertEquals(pId, actData );
		System.out.println("pass");
		resp.then().log().all();
		
		
	
	}

}
