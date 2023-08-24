package CrudUsingPojo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PojoClass.RequestUsingReqres;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicUsingReqres {
	@Test
	public void dynamic()
	{
		baseURI="https://reqres.in/";
		int expData=7;
		Response resp = when().get("/api/users?page=2");
		List<Integer> proId = resp.jsonPath().get("data.id");
		boolean flag=false;
		for(Integer pId:proId)
		{
			if(pId.equals(expData))
				flag=true;
//			SoftAssert s=new SoftAssert();
//			s.assertEquals(expData, pId);
		}
		Assert.assertTrue(flag);
		System.out.println("done");
		
		
	}

}
