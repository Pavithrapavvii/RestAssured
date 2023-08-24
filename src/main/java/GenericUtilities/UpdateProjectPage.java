package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateProjectPage {
	@FindBy(xpath = "//label[.='Project Name']/following-sibling::input")
	private WebElement proNametbx;
	
	@FindBy(xpath = "//label[.='Project Manager']/following-sibling::input")
	private WebElement createBytbx;
	
	@FindBy(name = "status")
	private WebElement statusDropDown;
	
	@FindBy(xpath  = "//input[@class='btn btn-info']")
	private WebElement savebtn;
	
	public UpdateProjectPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProNametbx() {
		return proNametbx;
	}

	public WebElement getCreateBytbx() {
		return createBytbx;
	}

	public WebElement getStatusDropDown() {
		return statusDropDown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	JavaUtilities j=new JavaUtilities();
	int ran = j.randomNumber();
	
	
	public void updateProject()
	{
		proNametbx.sendKeys("home"+ran);
		createBytbx.sendKeys("gowri");
		Select s=new Select(statusDropDown);
		s.selectByValue("On Going");
		savebtn.click();
	}

}
