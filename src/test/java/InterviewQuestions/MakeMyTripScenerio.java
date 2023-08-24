package InterviewQuestions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTripScenerio {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("__disable_notifications");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		try {
			a.click().perform();
		}
		catch (Exception e) {
			
		}
			
		driver.findElement(By.id("fromCity")).sendKeys("g");
		 List<WebElement> autosugg = driver.findElements(By.xpath("//p[contains(text(),'Goa')]"));
		 int count=autosugg.size();
		 for(int i=0;i<count;i++)
		 {
			 String text = autosugg.get(i).getText();
			 System.out.println(text);
		 }
		 autosugg.get(0).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id("toCity")).sendKeys("b");
		 List<WebElement> autosug = driver.findElements(By.xpath("//p[contains(text(),'Bengaluru')]"));
		 for(int i=0;i<autosug.size();i++)
		 {
			 String text1 = autosug.get(i).getText();
			 System.out.println(text1);
			 autosug.get(0).click();
		 }
//		 Date dateObj = new Date();
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		String date = sim.format(dateObj);
//		String rdata = sim.format(date);
		 LocalDate currentdate=LocalDate.now();
		 LocalDate departureDate=currentdate.plusDays(2);
		 LocalDate arrivalDate=departureDate.plusDays(1);
		 DateTimeFormatter formatter=DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
		 
		 WebElement departure = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-label='"+departureDate.format(formatter)+"']"));
		 departure.click();
		 driver.findElement(By.xpath("//p[@class='latoBlack font12 greyText lineHeight16']")).click();
		 WebElement arrival = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-label='"+arrivalDate.format(formatter)+"']"));
		 arrival.click();
		 driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		
	}
	
//		
		
		
	

}
