package pageObjects.phptravel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.FrameworkBase;


public class PHPTravelPage extends FrameworkBase{
	
	@FindBy(partialLinkText = "FLIGHTS")
	WebElement offerLink;
	
	// Constructor
	public PHPTravelPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFlightLinkExists() {
		
		return offerLink.isDisplayed();
	}

}
