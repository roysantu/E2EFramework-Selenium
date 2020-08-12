package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.FrameworkBase;

public class PassionTeaMenuPage extends FrameworkBase {

	//@FindBy(css = "div#wsb-element-00000000-0000-0000-0000-000450914921")
	//@FindBy(xpath = "//div[@id='wsb-element-00000000-0000-0000-0000-000453231735']/descendant::span[2]"))
	@FindBy(xpath = ("//div[@id='wsb-element-00000000-0000-0000-0000-000450914921']//h1"))
	public WebElement headerMenu;

	@FindBy(className = "wsb-image-inner")
	WebElement pageLogoPic;
	
	@FindBy(xpath = "//div[@class='img']/a")
	WebElement mainPageLinkinLogo;

	@FindBy(linkText = "welcome.html")
	WebElement welcomeLink;
	
	@FindBy(linkText = "check-out.html")
	WebElement checkOutLink;
	
	@FindBy(css = "a#wsb-button-00000000-0000-0000-0000-000451955160")
	WebElement checkOutButton1;	
	
	@FindBy(xpath = ("//div[@id='wsb-element-00000000-0000-0000-0000-000453231735']//span/strong"))
	WebElement oolongTeaHeaderText;

	
	// Constructor
		public PassionTeaMenuPage() {
			PageFactory.initElements(driver, this);
		}
		
		// Methods
		public boolean verifyLogoExists() { 
			return pageLogoPic.isDisplayed();
			
		}
		
		public boolean verifyLogo() { 
			if(pageLogoPic.getText().equals("PASSION")) {
				return true;
			} else {
				return false;
			}
		}
	
		public void clickOnLogo() {	
			
			String script = "document.querySelector('div.img a').click();";
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(script);
	          			
			System.out.println("Clicked");
			
			String ActualTitle = driver.getTitle();
			String ExpectedTitle = "Welcome";
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			System.out.println("Welcome Page Navigation is successful");
					
			
		}
		
		public void checkoutButtonFunc() {	
			
			checkOutButton1.click();
			System.out.println("checkOutButton1 Clicked");
			
			Assert.assertEquals(driver.getTitle(),"Check Out");
			System.out.println("Check Out Navigation is successful");
		}
		
		public ArrayList<String> verifyOolongTeaHeaderStyle() {

			ArrayList<String> styleList1 = new ArrayList<String>(7);
			
			styleList1.add(oolongTeaHeaderText.getCssValue("Color"));
			styleList1.add(oolongTeaHeaderText.getCssValue("font-size"));
			styleList1.add(oolongTeaHeaderText.getCssValue("font-family"));
			styleList1.add(oolongTeaHeaderText.getText());
			//styleList.add(headerMenu.getAttribute("style"));
			
			return styleList1;
		}
		
		public ArrayList<String> verifyHeaderStyle() {

			ArrayList<String> styleList2 = new ArrayList<String>(7);
			
			styleList2.add(headerMenu.getCssValue("Color"));
			styleList2.add(headerMenu.getCssValue("font-size"));
			styleList2.add(headerMenu.getCssValue("font-family"));
			styleList2.add(headerMenu.getText());
			//styleList.add(headerMenu.getAttribute("style"));
			
			return styleList2;
		}
		
}
