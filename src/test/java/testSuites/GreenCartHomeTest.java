package testSuites;

import org.testng.annotations.Test;

import pageObjects.greencart.GreenCartHomePage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import resources.FrameworkBase;

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
		
	@Test(enabled = true)
	public void testMetaData() {	
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test(dependsOnMethods = {"testMetaData"}, enabled = true)
	public void verifyHeaderSection() {
		AssertJUnit.assertTrue(greenCartHomePage.verifyLogoExists());
		AssertJUnit.assertTrue(greenCartHomePage.verifyLogoText());
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(0), "margin-left: -121px;");
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(1), "-121px");
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(2), "0.3s linear 0s 1 normal none running slideUp");
		greenCartHomePage.verifySmallCartInitialState();
	}
	// (dependsOnMethods = {"testMetaData", "verifyHeaderSection"}, enabled = true)
	
	@Test(enabled = true)
	public void verifyProductSection() {
		// Verify product count
		Assert.assertEquals(31, greenCartHomePage.verifyProductCount());
		// Select Dynamic products based on Index or any attribute using Parent xpath
		String firstProductText = greenCartHomePage.getProductByIndex(0).getText();
		assertTrue(firstProductText.contains("Brocolli"), "First Product matched!!!");;
		actions.moveToElement(greenCartHomePage.getProductCardByName("Walnuts"));
		Assert.assertEquals
		(greenCartHomePage.getProductDetails(greenCartHomePage.getProductCardByName("Walnuts"), "product-name"), 
				"Walnuts - 1/4 Kg");
		// Verify product currency pseudo elements "₹"
		assertTrue(greenCartHomePage.getPseudoStyleOfIndex(0).contains("₹"));
		// Verify all images
		try {
			greenCartHomePage.verifyIfImageIfBroken(greenCartHomePage.allProductImages);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test(enabled = true)
	public void verifyProductCanBeAddedToCart() {
		greenCartHomePage.addProductToCartByIndex(1);
		greenCartHomePage.verifyCartPreviewForItemAdded(greenCartHomePage.getProductByIndex(1));
		// TODO update rest of the validations
		
	}

}
