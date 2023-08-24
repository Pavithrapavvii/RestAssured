package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	JavaUtilities j=new JavaUtilities();
	int ran = j.randomNumber();
	public String proName="myntra"+ran;
	
	@FindBy(xpath  = "//a[.='Projects']")
	private WebElement projectLink;
	
	@FindBy(xpath = "//span[.='Create Project']")
	private WebElement createProBtn;
	
	@FindBy(name = "projectName")
	private WebElement proNametbx;
	
	@FindBy(name = "createdBy")
	private WebElement proManagertbx;
	
	@FindBy(name = "status")
	private WebElement statustbx;
	
	@FindBy(xpath  = "//input[@class='btn btn-success']")
	private WebElement addProtbx;
	
//	@FindBy(xpath="//td[text()='"+proName+"']")
//	private WebElement search;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProjectLink() {
		return projectLink;
	}

	public WebElement getCreateProBtn() {
		return createProBtn;
	}

	public WebElement getProNametbx() {
		return proNametbx;
	}

	public WebElement getProManagertbx() {
		return proManagertbx;
	}

	public WebElement getStatustbx() {
		return statustbx;
	}

	public WebElement getAddProtbx() {
		return addProtbx;
	}
	
	
	
	public void createProject()
	{
		projectLink.click();
		createProBtn.click();
		 proNametbx.sendKeys(proName);
		proManagertbx.sendKeys("pavithra");
		Select s=new Select(statustbx);
		s.selectByValue("Created");
		addProtbx.click();
		
		
	}

}
