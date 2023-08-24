package GenericUtilities;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public WebDriver driver;
	
	public DataBaseUtility dbLib=new DataBaseUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public WebActionUtility wLib=new WebActionUtility(driver);
	
	
	public JavaUtilities jLib=new JavaUtilities();
	
	@BeforeSuite
	public void bSCong() throws SQLException
	{
		dbLib.connectDB();
	}
	
	@AfterSuite
	public void aSCong() throws SQLException
	{
		dbLib.closeDB();
	}
	
//	@BeforeClass
//	public void openBrowser() throws Throwable
//	{
//		WebDriverManager.chromedriver().setup();
//		 driver = new ChromeDriver();
//		
//		 wLib.waitForElementInDOM(driver);
//	}
	
//	@AfterClass
//	public void closeBrowser()
//	{
//		driver.close();
//	}
	
	

}
