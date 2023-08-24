package ScenerioBasedProgramme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.HomePage;
import GenericUtilities.IconStants;
import GenericUtilities.LoginPage;
import GenericUtilities.UpdateProjectPage;
import PojoClass.RequestUsingPojo;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class CreateProWithApi  extends BaseClass 
{
	@Test
	public void create() throws Throwable
	{
		baseURI=IconStants.URL;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		 wLib.waitForElementInDOM(driver);

		HomePage hp=new HomePage(driver);
		int ran = jLib.randomNumber();
		String ProjName ="nykaa"+ran;
		RequestUsingPojo r=new RequestUsingPojo("pavithra",ProjName , "Created", 10);
		Response resp = (Response) given().body(r).contentType(ContentType.JSON);
		when().post("/addProject");
		String proId = resp.jsonPath().get("projectId");
		//.then().log().all();
		
		System.out.println("project name: "+proId);
//		Thread.sleep(2000);
//		driver.navigate().refresh();
		driver.get(baseURI);
		LoginPage l=new LoginPage(driver);
		l.validLogin();
		HomePage h=new HomePage(driver);
		h.getProjectLink().click();
		//driver.findElement(By.linkText("projects")).click();
		
		String querry = "select * from project";
		String actData = dbLib.executeQuerryAndVerify(querry, 2, proId);
		System.out.println("Actual data: "+actData);
		Assert.assertEquals(proId, actData );
		System.out.println("pass");
		
		UpdateProjectPage uLib=new UpdateProjectPage(driver);
		uLib.updateProject();
		
		
	}

}
