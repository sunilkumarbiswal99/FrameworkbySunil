package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUs;
import pompages.CoreJavaForSelenium;
import pompages.CoreJavaVideoPage;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.SkillraryHomePage;
import pompages.TestingPage;

public class BaseClass {
    
	protected PropertiesFilesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected SeleniumTrainingPage seleniumTraining;
	protected TestingPage testing;
	protected CoreJavaForSelenium coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUs contact;
	protected long time;
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classConfiguration() 
	{
	    property = new PropertiesFilesUtility();
		excel = new ExcelUtility();
	    web = new WebDriverUtility();
		
		property.propertyFileInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		
	}
	
	@BeforeMethod
	public void methodConfiguration()
	{
	    time=Long.parseLong(property.fetchproperty("timeouts"));
		driver = web.openApplication(property.fetchproperty("browser"), property.fetchproperty("url"), time);
		
		home = new SkillraryHomePage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		skillraryDemo = new SkillraryDemoAppPage(driver);
		seleniumTraining = new SeleniumTrainingPage(driver);
		testing = new TestingPage(driver);
		coreJava = new CoreJavaForSelenium(driver);
		javaVideo = new  CoreJavaVideoPage(driver);
		contact = new ContactUs(driver);
	}
	@AfterMethod
	public void methodTearDown()
	{
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite
	
}
