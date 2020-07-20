package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.FrameworkBase;

public class PassionTeaMenuPage extends FrameworkBase {

	@FindBy(id = "wsb-element-00000000-0000-0000-0000-000450914921")
	WebElement headerMenu;

	@FindBy(className = "wsb-image-inner")
	WebElement pageLogoPic;
	
	@FindBy(xpath = "*[@id=\"wsb-element-00000000-0000-0000-0000-000450914873\"]/div/div/a/img")
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
	
	
}
