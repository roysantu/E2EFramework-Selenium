package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.FrameworkBase;

public class GreenCartHomePage extends FrameworkBase{
	// Elements
	// Hearder Elements
	@FindBy(xpath = ".//div/header")
	WebElement headerSection;
	
	@FindBy(partialLinkText = "Limited offer")
	WebElement offerLink;
	
	@FindBy(className = "greenLogo")
	WebElement pageNameLogo;
	
	@FindBy(linkText = "Top Deals")
	WebElement topDeals;
	
	@FindBy(css = ".cartinfo")
	WebElement smallCartTable;
	
	@FindBy(css = "div['.cart-info tr:nth-child(1) td:nth-child(3)")
	WebElement smallCartItemCount;
	
	@FindBy(xpath = ".//div[@class='cart-info']/table/tbody/tr[2]/td[3]")
	WebElement smallCartItemPrice;
	
	// Product list
	@FindBy(className = "product")
	WebElement allProducts;
	
	
	
	// Constructor
	public GreenCartHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	public boolean verifyLogoExists() { 
		return pageNameLogo.isDisplayed();
	}
	
	public boolean verifyLogoText() { 
		if(pageNameLogo.getText().equals("GREENKART")) {
			return true;
		} else {
			return false;
		}
	}

}
