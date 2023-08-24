package DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.JavaUtilities;
import PojoClass.RequestUsingPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderProgramme {
	
	@DataProvider	
	public Object[][] data()
	{
		Object[][] data=new Object[3][4];
		data[0][0]="pavithra";
		data[0][1]="amazo";
		data[0][2]="OnGoing";
		data[0][3]=8;
		
		data[1][0]="prajju";
		data[1][1]="myntra";
		data[1][2]="Created";
		data[1][3]=6;
		
		data[2][0]="prakash";
		data[2][1]="flipkart1";
		data[2][2]="Completed";
		data[2][3]=9;
		
		return data;
		
	}
	
	@Test(dataProvider = "data")
	
		public void createProject(String createdBy,String projectName,String status,int teamSize)
		{
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtilities j=new JavaUtilities();
		int ran = j.randomNumber();
			RequestUsingPojo r=new RequestUsingPojo(createdBy, projectName+ran, status, teamSize);
			given().body(r).contentType(ContentType.JSON)
			.when().post("/addProject")
			.then().assertThat().contentType(ContentType.JSON).statusCode(201)
			.log().all();
		
			
		}
	}
		
	


