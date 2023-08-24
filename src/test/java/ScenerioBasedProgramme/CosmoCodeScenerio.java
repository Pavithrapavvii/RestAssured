package ScenerioBasedProgramme;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CosmoCodeScenerio {
	@Test
	public void test()
	{
//		WebDriver driver;
//		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://cosmocode.io/");
		driver.manage().window().maximize();
		//driver.findElement(By.id("mega-menu-item-5318")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.xpath("//div[1][@id='mega-menu-wrap-primary']/descendant::li[@id='mega-menu-item-5318']/descendant::a[.='Automation Practice | WebTable']")).click();
		List<WebElement> data = driver.findElements(By.xpath("//table/tbody/tr[*]/td[4][contains(text(),'Dollar')]/following-sibling::td[contains(text(),'English')]/preceding-sibling::td[3]"));
		int count=data.size();
		System.out.println(count);
		for(int i=0;i<data.size();i++)
		{
			String text = data.get(i).getText();
			System.out.println(text);
		}
	}

}
