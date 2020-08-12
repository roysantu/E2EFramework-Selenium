package testSuites;

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
	
	@Test
	public void verifyHeaderSection() {
		AssertJUnit.assertTrue(phpTravelPage.verifyFlightLinkExists());
		
	}
	

}
