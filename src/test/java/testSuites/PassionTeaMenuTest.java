package testSuites;

import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObjects.PassionTeaMenuPage;
import resources.FrameworkBase;

public class PassionTeaMenuTest extends FrameworkBase {
 
	PassionTeaMenuPage passionTeaMenuPage;
	Actions actions;
	
	public PassionTeaMenuTest() {
		super();
}
	
	@Test
	@BeforeTest
	public void testSetup() {
		
	}
	
	@Test
	@BeforeMethod
	public void testCaseSetup() {
		initializeDriver();
		actions = new Actions(driver);
		passionTeaMenuPage = new PassionTeaMenuPage();
		driver.get(prop.getProperty("PassionTea"));
		System.out.println("Page opened");
	}
	
	@Test
	@AfterMethod
	public void testMethodEnd() throws InterruptedException {
		Thread.sleep(3000);
		// TODO Take Screenshot
		driver.close();
		driver.quit();
	}
	
	@Test(enabled = false)
	public void checkPageTitle() {	
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
}
	
	@Test
	public void checkGreenTeaText() {	
		String greenTeaText = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451934628")).getText();
		System.out.println(greenTeaText);
	}
	
	@Test
	public void checkTextColor() {
		WebElement eleSearch = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451941184\"]/div/pre/span[1]"));
		// By this xpath it is selecting a particular span-style-color object within web-element. Otherwise when only the web-element is selected the color of the text is not coming as RED but just a body color 
		System.out.println(eleSearch.getText());
		
		String rgbFormat = eleSearch.getCssValue("color");
		
		System.out.println("RGB Format = " + rgbFormat);     //In RGB Format the value will be print => rgba(254, 189, 105, 1)

		String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
		System.out.println("HEX Format = " + hexcolor);// Output of Hex code will be  => #febd69
		
		if (hexcolor.equalsIgnoreCase("#FF0000"))
		System.out.println("Text color is RED"); 
		else
		System.out.println("Text color is NOT Red"); 	
			
	}
	
	
}
