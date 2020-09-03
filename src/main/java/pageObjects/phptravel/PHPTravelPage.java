package pageObjects.phptravel;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import resources.FrameworkBase;


public class PHPTravelPage extends FrameworkBase{
	
	@FindBy(partialLinkText = "FLIGHTS")
	WebElement flightLink;
	
	@FindBy(css = "#FlightsDateStart")
	public WebElement datePickerField;
	
	@FindBy(css = "i.bx-calendar")
	public WebElement calenderIconForFlightDepart;
	
	@FindBy(css = "div.active nav.datepicker--nav")
	public WebElement activeDatepickerNavBar;
	
	@FindBy(css = "div.datepicker.active div.datepicker--days.datepicker--body.active")
	public WebElement activeDatepickerCalenderDays;
	
	// Constructor
	public PHPTravelPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFlightLinkExists() {
		
		return flightLink.isDisplayed();
	}
	
	public void navigateToFlightTab() {
		flightLink.click();
		Assert.assertTrue(flightLink.getAttribute("class").contains("active"));
		
	}
	
	public void verifyDatePickerFieldDefaultState() {
		Assert.assertTrue(datePickerField.getAttribute("placeholder").contains("Depart"));
		Assert.assertTrue(calenderIconForFlightDepart.isDisplayed());
		datePickerField.click();
		Assert.assertTrue(activeDatepickerNavBar.isDisplayed());
//		Assert.assertTrue(activeDatepickerCalenderDays.isDisplayed());
	}
	
	

}
