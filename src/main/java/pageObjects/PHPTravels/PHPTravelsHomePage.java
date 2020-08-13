package pageObjects.PHPTravels;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		@FindBy(css = "ul.select2-results li")
		})
		public List<WebElement> FromSearchList;
		
		@FindBy(css = "ul.select2-results li div span")
		WebElement firstSearchElement;
		
		//for adult,child & infant field create a single list of + & - buttons and then use index to add count for a particular field
		
		// Constructor
		public PHPTravelsHomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public void goToFlightTab() {	
			//Generalize this code for all the tabs
		
			flightMenuTab.click();
			
			Boolean radioCheck = oneWayRadioButton.isSelected();
			//System.out.println(radioCheck);
					
			if(radioCheck==true)
			System.out.println("One Way radio button is checked");
			
		}
		
		public void inputinFromLocation(String org, String expectedLoc){
			int elemIndex = 0;
			
			fromTextBox.sendKeys(org);
			
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.visibilityOf(firstSearchElement));
			
			for(int i=0; i<FromSearchList.size(); i++) {
			System.out.println(FromSearchList.get(i).getText());	
						
			if (FromSearchList.get(i).getText().contains(expectedLoc)) {
				elemIndex = i;	}
			}
			
			FromSearchList.get(elemIndex).click();
	        System.out.println("Expected Origin Selected");
		}
		
		}

