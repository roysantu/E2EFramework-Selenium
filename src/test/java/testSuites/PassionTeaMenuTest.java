package testSuites;

import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	@BeforeTest
	public void testSetup() {
		
	}
	
	@BeforeMethod
	public void testCaseSetup() {
		initializeDriver();
		actions = new Actions(driver);
		passionTeaMenuPage = new PassionTeaMenuPage();
		driver.get(prop.getProperty("PassionTea"));
	
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.elementToBeClickable(passionTeaMenuPage.headerMenu));
		//System.out.println("Page opened");
	}
	
	@AfterMethod
	public void testMethodEnd() throws InterruptedException {
		Thread.sleep(3000);
		// TODO Take Screenshot
		driver.close();
		driver.quit();
	}
	
/*	@Test(enabled = false)
	public void checkPageTitle() {	
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
}
*/	
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
	
	@Test
	public void verifyLogoClickWorks() {
		passionTeaMenuPage.clickOnLogo();
		System.out.println("Click on Logo navigates to Welcome Page"); 	
		
	}
	
	@Test
	public void verifyCheckoutButton() {
		passionTeaMenuPage.checkoutButtonFunc();
		System.out.println("Check Out page is opened"); 	
		
	}
	@Test
	public void verifyOolongTeaHeader() {
		String color = passionTeaMenuPage.verifyOolongTeaHeaderStyle().get(0);
		System.out.println("Oolong Tea Header Color = " + color); 	
		String font_size = passionTeaMenuPage.verifyOolongTeaHeaderStyle().get(1);
		System.out.println("Oolong Tea Header font size = " +font_size);
		String font_family = passionTeaMenuPage.verifyOolongTeaHeaderStyle().get(2);
		System.out.println("Oolong Tea Header font family = " +font_family);
		String header_text = passionTeaMenuPage.verifyOolongTeaHeaderStyle().get(3);
		System.out.println("Oolong Tea Header Text = " + header_text);
		
		//String style = passionTeaMenuPage.verifyHeaderSectionStyle().get(5);
		//System.out.println("Header style = " +style);
	}
	
	@Test
	public void verifyHeader() {
		String color = passionTeaMenuPage.verifyHeaderStyle().get(0);
		System.out.println("Menu Color = " + color); 	
		String font_size = passionTeaMenuPage.verifyHeaderStyle().get(1);
		System.out.println("Menu font size = " +font_size);
		String font_family = passionTeaMenuPage.verifyHeaderStyle().get(2);
		System.out.println("Menu font family = " +font_family);
		String header_text = passionTeaMenuPage.verifyHeaderStyle().get(3);
		System.out.println("Menu Text = " + header_text);
		
		//String style = passionTeaMenuPage.verifyHeaderSectionStyle().get(5);
		//System.out.println("Header style = " +style);
	}
	
}
