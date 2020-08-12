package pageObjects.PHPTravels;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.FrameworkBase;

	public class PHPTravelsHomePage extends FrameworkBase {
	
		@FindBy(partialLinkText = "FLIGHTS")
		//also works with --- @FindBy(xpath = "//a[contains(text(),'Flights')]")
		public WebElement flightMenuTab;
		
		@FindBy(id = "flightSearchRadio-2")
		WebElement oneWayRadioButton;
		
		@FindBy(xpath = "//input[@id='s2id_autogen9']")
		WebElement fromTextBox;
		
		@FindAll({
		@FindBy(className = "select2-results")
		})
		public List<WebElement> FromKOLSearchList;
		
		
		// Constructor
		public PHPTravelsHomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public void goToFlightTab() {	
		
			flightMenuTab.click();
			
			Boolean radioCheck = oneWayRadioButton.isSelected();
			//System.out.println(radioCheck);
					
			if(radioCheck==true)
			System.out.println("One Way radio button is checked");
			
		}
		
		public void inputinFromLocation(){
			fromTextBox.sendKeys("Kol");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			java.util.Iterator<WebElement> i = FromKOLSearchList.iterator();
			while(i.hasNext()) {
			    WebElement loc = i.next();
			    String Origin = loc.getText();
			    System.out.println(Origin);
			    
			    if (Origin.equalsIgnoreCase("Kolkata (CCU)")) {
		        loc.click();
		        System.out.println("Kolkata Selected");
		}
		
		}
		}}

