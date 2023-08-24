  package CrudUsingPojo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidation {
	@Test
	public void dynamic()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		String expData="TY_PROJ_9786";
		Response resp = given().get("/projects");
		List<String> proId = resp.jsonPath().get("projectId");
		boolean flag=false;
		for(String pId:proId)
		{
			if(pId.equalsIgnoreCase(expData))
				flag=true; 
		}
		Assert.assertTrue(flag);
		   System.out.println("done");
//		if(proId.equals(expData)) {
//			System.out.println(proId);
//		}
		
//		SoftAssert s=new SoftAssert();
//		s.assertEquals(expData, flag);
		System.out.println("ok");
		
		
		
		
		
		
		
		baseURI="hgsjdjd";
		String expData1="TY_001";
		resp=given().get("/Projects");
		List<String> projId = resp.jsonPath().get("projectId");
		boolean flag1=true;
		for(String pId:projId)
		{
			if(pId.equals(projId))
				flag=true;
		}
		Assert.assertTrue(flag1);
		System.out.println("done");
			
		
	}

}
