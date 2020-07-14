package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy(css = "tr:nth-child(1) td:nth-child(3)")
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

	public ArrayList<String> verifyHeaderSectionStyle() {

		ArrayList<String> styleList = new ArrayList<String>(3);
		
		styleList.add(headerSection.getAttribute("style"));
		styleList.add(headerSection.getCssValue("margin-left"));
		styleList.add(headerSection.getCssValue("animation"));
		
		return styleList;
	}
	
	public void verifySmallCartInitialState() {
		Assert.assertEquals(smallCartItemCount.getText(), "0", "Default Item Count is 0");
		Assert.assertEquals(smallCartItemPrice.getText(), "0", "Default Item Price is 0");
		
	}
	
}
