package CrudWithoutBDDRmg;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProject {
	@Test
	public void getProject()
	{
		Response data = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_24346");
		System.out.println(data.prettyPeek());
		int stcode = data.getStatusCode();
		System.out.println(stcode);
		String statusname=data.getStatusLine();
		System.out.println(statusname); 
		
//	    Assert.assertEquals(200, stcode);
//		System.out.println("pass");
		
//		Assert.assertTrue(true, "200");
//		System.out.println("pass");
		
//		Assert.assertNotNull(data, null);
//		System.out.println("pass");
		
//		Assert.assertSame(data, 200);
//		System.out.println("pass");
		
		
	}
	
	

}
