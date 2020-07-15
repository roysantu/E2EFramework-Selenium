package testSuites;

import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import resources.FrameworkBase;
import pageObjects.GreenCartHomePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class GreenCartHomeTest extends FrameworkBase {
	GreenCartHomePage greenCartHomePage;
	Actions actions;
	
	public GreenCartHomeTest() {
		super();
	}
	
	@BeforeTest
	public void testSetup() {
		
	}
	
	@BeforeMethod
	public void testCaseSetup() {
		initializeDriver();
		actions = new Actions(driver);
		greenCartHomePage = new GreenCartHomePage();
		driver.get(prop.getProperty("greenCartURL"));
	}
	
	@AfterMethod
	public void testMethodEnd() throws InterruptedException {
		Thread.sleep(3000);
		// TODO Take Screenshot
		driver.close();
		driver.quit();
	}
		
	@Test(enabled = false)
	public void testMetaData() {	
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test(dependsOnMethods = {"testMetaData"}, enabled = false)
	public void verifyHeaderSection() {
		AssertJUnit.assertTrue(greenCartHomePage.verifyLogoExists());
		AssertJUnit.assertTrue(greenCartHomePage.verifyLogoText());
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(0), "margin-left: -121px;");
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(1), "-121px");
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(2), "0.3s linear 0s 1 normal none running slideUp");
		greenCartHomePage.verifySmallCartInitialState();
	}
	// (dependsOnMethods = {"testMetaData", "verifyHeaderSection"}, enabled = true)
	
	@Test
	public void verifyProductSection() {
		Assert.assertEquals(31, greenCartHomePage.verifyProductCount());
		// TODO update product test including pseudo elements
		System.out.println(greenCartHomePage.getProductByIndex(1).getText());
		System.out.println(greenCartHomePage.getProductCardByName("Walnuts").getText());
		actions.moveToElement(greenCartHomePage.getProductCardByName("Walnuts"));
		
		Assert.assertEquals
		(greenCartHomePage.getProductDetails(greenCartHomePage.getProductCardByName("Walnuts"), "product-name"), 
				"Walnuts - 1/4 Kg");
		
	}

}
