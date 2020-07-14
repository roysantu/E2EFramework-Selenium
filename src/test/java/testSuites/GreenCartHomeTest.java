package testSuites;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.NavigationPage;
import resources.FrameworkBase;
import pageObjects.GreenCartHomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class GreenCartHomeTest extends FrameworkBase {
	GreenCartHomePage greenCartHomePage;
	
	public GreenCartHomeTest() {
		super();
	}
	

	@BeforeTest
	public void testSetup() {

	}
	
	@BeforeMethod
	public void testCaseSetup() {
		initializeDriver();
		greenCartHomePage = new GreenCartHomePage();
	}
	
	@AfterMethod
	public void testEnd() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
		
	@Test(enabled = false)
	public void testMetaData() {	
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test()
	public void verifyHeaderSection() {
		AssertJUnit.assertTrue(greenCartHomePage.verifyLogoExists());
		AssertJUnit.assertTrue(greenCartHomePage.verifyLogoText());
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(0), "margin-left: -121px;");
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(1), "-121px");
		AssertJUnit.assertEquals(greenCartHomePage.verifyHeaderSectionStyle().get(2), "0.3s linear 0s 1 normal none running slideUp");
		greenCartHomePage.verifySmallCartInitialState();
	}
	
	@Test(dependsOnMethods = {"testMetaData", "verifyHeaderSection"}, enabled = false)
	public void verifyProductSection() {
		
		// TODO update product test including pseudo elements
	}

}
