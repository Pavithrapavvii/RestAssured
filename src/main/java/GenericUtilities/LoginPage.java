package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "username")
	private WebElement untbx;
	
	@FindBy(id = "inputPassword")
	private WebElement pwtbx;
	
	@FindBy(xpath  ="//button[.='Sign in']")
	private WebElement signInbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getSignInbtn() {
		return signInbtn;
	}
	
	public void validLogin()
	{
		untbx.sendKeys(IconStants.appUserName);
		pwtbx.sendKeys(IconStants.appPassword);
		signInbtn.click();
	}

}
