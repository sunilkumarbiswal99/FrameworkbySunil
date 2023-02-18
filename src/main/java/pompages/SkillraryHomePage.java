package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {
    
	//Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;
	@FindBy(name = "q")
	private WebElement search_TF;
	@FindBy(xpath = "//input[@value='go']")
	private WebElement search_Button;
	@FindBy(xpath = " //a[text()=' GEARS '] ")
	private WebElement gearsTab;
	@FindBy(xpath = " //ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement demoAppLink;
	
	//Initialization
	public SkillraryHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLogo()
	{
		return logo;
	}
	
	public void searchFor(String data)
	{
		search_TF.sendKeys(data);
		search_Button.click();
	}
	
	public void clickGears()
	{
		gearsTab.click();
	}
	
	
	public void clickSkilraryDemoApp()
	{
		demoAppLink.click();
	}
}
