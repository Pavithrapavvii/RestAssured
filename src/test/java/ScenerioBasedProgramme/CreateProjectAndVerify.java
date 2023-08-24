package ScenerioBasedProgramme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.DataBaseUtility;
import GenericUtilities.EndPointLibrary;
import GenericUtilities.HomePage;
import GenericUtilities.IconStants;
import GenericUtilities.JavaUtilities;
import GenericUtilities.LoginPage;
import GenericUtilities.RestAssuredLibrary;
import PojoClass.RequestUsingPojo;
import io.github.bonigarcia.wdm.WebDriverManager;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateProjectAndVerify extends BaseClass{
	WebDriver driver;
	@Test
	public void createAndVerifyWrtDB() throws Throwable
	{
		baseURI=IconStants.URL;
		
		 WebDriver driver = WebDriverManager.chromedriver().create();
		 wLib.waitForElementInDOM(driver);
		
		 driver.get(baseURI);
		LoginPage lp=new LoginPage(driver);
		lp.validLogin();
		HomePage hp=new HomePage(driver);
		hp.createProject();
		String ProjName = hp.proName;
		
		String proId = driver.findElement(By.xpath("//td[text()='"+ProjName+"']/preceding-sibling::td")).getText();
		System.out.println(proId);
		
		int upRan = jLib.randomNumber();
		RequestUsingPojo r=new RequestUsingPojo("pavi", "myntra111"+upRan, "Completed", 8);
		given().body(r).contentType(ContentType.JSON)
		.when().put(EndPointLibrary.updateProject+proId)
		.then().log().all();
		
		String querry="select * from Project";
		DataBaseUtility dLib=new DataBaseUtility();
		dLib.executeQuerryAndVerify(querry, upRan, proId);
		
//		@FindBy(xpath = "//td[text()='"+ProjName+"']")
//		private WebElement tb;
		
		//String expData1 = rLib.getJsonData( resp, "projectId");
//		System.out.println(expData);
//		given().pathParam("id", expData) 
//		.when().get(EndPointLibrary.getSingleProject+"/{id}")
//		.then().log().all();
		
		
		
		
		
		
	}
	
	

}
