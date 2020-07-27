package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.FrameworkBase;

public class PassionTeaMenuPage extends FrameworkBase {

	@FindBy(id = "wsb-element-00000000-0000-0000-0000-000450914921")
	public WebElement headerMenu;

	@FindBy(className = "wsb-image-inner")
	WebElement pageLogoPic;
	
	@FindBy(xpath = "//div[@class='img']/a")
	WebElement mainPageLinkinLogo;

	@FindBy(linkText = "welcome.html")
	WebElement welcomeLink;
	
	@FindBy(linkText = "check-out.html")
	WebElement checkOutLink;
	
	@FindBy(css = "#wsb-button-00000000-0000-0000-0000-000451955160 > span")
	WebElement checkOutButton1;	

	
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
}
