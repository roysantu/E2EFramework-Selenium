package testSuites;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.phptravel.PHPTravelPage;
import resources.FrameworkBase;

public class PHPTravelTest  extends FrameworkBase{
	
	PHPTravelPage phpTravelPage;
	
	public PHPTravelTest() {
		super();
	}
	
	@BeforeMethod
	public void testCaseSetup() {
		initializeDriver();
//		actions = new Actions(driver);
		phpTravelPage = new PHPTravelPage();
		driver.get("https://www.phptravels.net/home");
		
	}
	
	@AfterMethod
	public void testMethodEnd() throws InterruptedException {
		Thread.sleep(3000);
		// TODO Take Screenshot
		driver.close();
		driver.quit();
	}
	
	@Test(enabled=false)
	public void verifyHeaderSection() {
		AssertJUnit.assertTrue(phpTravelPage.verifyFlightLinkExists());
		
	}
	
	@Test(enabled=true)
	public void verifyDatePickerInFlightTab() {
		phpTravelPage.navigateToFlightTab();
//		phpTravelPage.verifyDatePickerFieldDefaultState();
		
		phpTravelPage.datePickerField.click();
		phpTravelPage.activeDatepickerCalenderDays.isDisplayed();
		String currentDate = phpTravelPage.activeDatepickerCalenderDays.findElement(By.cssSelector("div.datepicker--cells-days div.datepicker--cell.-current-")).getAttribute("data-date");
		Assert.assertEquals(currentDate, "2", "Current Date matched");
	}
	

}
