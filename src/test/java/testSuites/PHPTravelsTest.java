package testSuites;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.PHPTravels.PHPTravelsHomePage;
import resources.FrameworkBase;

public class PHPTravelsTest extends FrameworkBase {
	 
	PHPTravelsHomePage PHPTravelsHomePage;
	Actions actions;

	@BeforeMethod
	public void testCaseSetup() {
		initializeDriver();
		actions = new Actions(driver);
		PHPTravelsHomePage = new PHPTravelsHomePage();
		driver.get(prop.getProperty("PHPTravels"));
	
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(PHPTravelsHomePage.flightMenuTab));
		//System.out.println("Page opened");
	}
	
	@AfterMethod
	public void testMethodEnd() throws InterruptedException {
		Thread.sleep(3000);
		// TODO Take Screenshot
		driver.close();
		driver.quit();
	}
	
	@Test
	public void verifyFlightBooking() {
		PHPTravelsHomePage.goToFlightTab();
		System.out.println("Flight Tab is accessable");
		
		PHPTravelsHomePage.inputinFromLocation("Mum","BOM");
		PHPTravelsHomePage.inputinToLocation("Kol","CCU");
		
		PHPTravelsHomePage.verifyDatePickerFieldDefaultState("8");
		PHPTravelsHomePage.selectDeptDate(12);
		System.out.println("Date function is working");	
		
		PHPTravelsHomePage.inputGuestAddCountbyCategory(4,2,1);
		
		PHPTravelsHomePage.clickOnSearchButton();
	}
	
	@Test
	public void verifyAddGuestbyList() {
		PHPTravelsHomePage.goToFlightTab();
		System.out.println("Flight Tab is accessable");
		
		PHPTravelsHomePage.inputGuestAddCountbyList(7,5,3);
		PHPTravelsHomePage.inputGuestSubtractCountbyList(5,3,1);
		
	}
	
	}
	
	
	

