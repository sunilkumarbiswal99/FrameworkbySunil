package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class FirstTest extends BaseClass{
     
	@Test
	public void firstTest()
	{
		SoftAssert soft = new SoftAssert();
		
		home.clickGears();
		home.clickSkilraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
		
		skillraryDemo.mouseHoverToCourse(web);
		skillraryDemo.clickSeleniumTraining();
		
		soft.assertEquals(seleniumTraining.getPageHeader(), "Selenium Training");
		seleniumTraining.doubleClickPlusButton(web);
		seleniumTraining.clickAddToCart();
		web.handleAlert();
		web.explicitWait(time, seleniumTraining.getItemAddedMessage());
		web.takeScreenshot();
		soft.assertTrue(seleniumTraining.getItemAddedMessage().isDisplayed());
		
		soft.assertAll();
	}
	
}
