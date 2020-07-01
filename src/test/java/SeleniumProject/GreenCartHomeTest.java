package SeleniumProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GreenCartHomeTest extends FrameworkBase {
	
	
	@BeforeTest
	public void testCaseSetup() throws IOException {
		driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
	}
	
	@AfterTest
	public void testCaseEnd() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void testMetaData() {
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
	}

}
