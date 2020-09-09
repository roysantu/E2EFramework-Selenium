package pageObjects.PHPTravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.FrameworkBase;

	public class PHPTravelsHomePage extends FrameworkBase {
		
		int i;
		String v;
	
		@FindBy(partialLinkText = "FLIGHTS")
		//also works with --- @FindBy(xpath = "//a[contains(text(),'Flights')]")
		public WebElement flightMenuTab;
		
		@FindBy(id = "flightSearchRadio-2")
		WebElement oneWayRadioButton;
		
		@FindBy(xpath = "//input[@id='s2id_autogen9']")
		WebElement fromTextBox;
		
		@FindBy(xpath = "//input[@id='s2id_autogen10']")
		WebElement toTextBox;
		
		@FindBy(xpath = "//form[@name='flightmanualSearch']//button[contains(text(),'Search')]")
		WebElement flightSearchButton;
		
		@FindAll({
		@FindBy(css = "ul.select2-results li")
		})
		public List<WebElement> FromToSearchList;
		
		@FindBy(css = "ul.select2-results li div span")
		WebElement firstSearchElement;
		
		@FindAll({
			@FindBy(xpath = "//form[@name='flightmanualSearch']//button[contains(text(),'+')]")
			})
			public List<WebElement> addCountList;
		
		@FindAll({
			@FindBy(xpath = "//form[@name='flightmanualSearch']//button[contains(text(),'-')]")
			})
			public List<WebElement> subtractCountList;
		
		@FindBy(xpath = "//input[@name='fadults']")
		WebElement adultCount;
		
		@FindBy(xpath = "//input[@name='fchildren']")
		WebElement childrenCount;
		
		@FindBy(xpath = "//input[@name='finfant']")
		WebElement infantCount;
		
		@FindBy(xpath = "//input[@name='fadults']/following-sibling::span/button[contains(text(),'+')]")
		WebElement addCountAdult;
		
		@FindBy(xpath = "//input[@name='fadults']/following-sibling::span/button[contains(text(),'-')]")
		WebElement subtractCountAdult;
		
		@FindBy(xpath = "//input[@name='fchildren']/following-sibling::span/button[contains(text(),'+')]")
		WebElement addCountChildren;
		
		@FindBy(xpath = "//input[@name='fchildren']/following-sibling::span/button[contains(text(),'-')]")
		WebElement subtractCountChildren;
		
		@FindBy(xpath = "//input[@name='finfant']/following-sibling::span/button[contains(text(),'+')]")
		WebElement addCountInfant;
		
		@FindBy(xpath = "//input[@name='finfant']/following-sibling::span/button[contains(text(),'-')]")
		WebElement subtractCountInfant;
		
		//for adult,child & infant field create a single list of + & - buttons and then use index to add count for a particular field
		
		@FindBy(partialLinkText = "FLIGHTS")
		WebElement offerLink;
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
			
			for(i=0; i<FromToSearchList.size(); i++) {
			System.out.println(FromToSearchList.get(i).getText());	
						
			if (FromToSearchList.get(i).getText().contains(expectedLoc)) {
				elemIndex = i;	}
			}
			
			FromToSearchList.get(elemIndex).click();
	        System.out.println("Expected Origin Selected");
		}
		
		public void inputinToLocation(String dest, String expectedDest){
			int elemIndex = 0;
			
			toTextBox.sendKeys(dest);
			
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.visibilityOf(firstSearchElement));
			
			for(i=0; i<FromToSearchList.size(); i++) {
				System.out.println(FromToSearchList.get(i).getText());	
						
			if (FromToSearchList.get(i).getText().contains(expectedDest)) {
				elemIndex = i;	}
			}
			
			FromToSearchList.get(elemIndex).click();
	        System.out.println("Expected Destination Selected");
		}
		
		public void inputGuestAddCountbyList(int adult, int child, int infant){
		
			v = adultCount.getAttribute("value");
			System.out.println("default value in Adult guest field:" + v);
			
			//System.out.println(addCountList.size());
			for(i=Integer.parseInt(v); i<adult; i++) {
				addCountList.get(0).click(); 
			}	
			System.out.println("Adult guest count is added to:" + i);	
			
			v = childrenCount.getAttribute("value");
			System.out.println("default value in Children guest field:" + v);
			
			//System.out.println(addCountList.size());
			for(i=Integer.parseInt(v); i<child; i++) {
				addCountList.get(1).click(); 
			}	
			System.out.println("Children guest count is added to:" + i);	
			
			v = infantCount.getAttribute("value");
			System.out.println("default value in Infant guest field:" + v);
			
			for(i=Integer.parseInt(v); i<infant; i++) {
				addCountList.get(2).click(); 
			}	
			System.out.println("Infant guest count is added to:" + i);
		}
		
		public void inputGuestSubtractCountbyList(int adult, int child, int infant){
			
			v = adultCount.getAttribute("value");
			System.out.println("default value in Adult guest field:" + v);
			
			//System.out.println(addCountList.size());
			for(i=Integer.parseInt(v); i>adult; i--) {
				subtractCountList.get(0).click(); 
			}	
			System.out.println("Adult guest count is reduced to:" + i);	
			
			v = childrenCount.getAttribute("value");
			System.out.println("default value in Children guest field:" + v);
			
			//System.out.println(addCountList.size());
			for(i=Integer.parseInt(v); i>child; i--) {
				subtractCountList.get(1).click(); 
			}	
			System.out.println("Children guest count is reduced to:" + i);	
			
			v = infantCount.getAttribute("value");
			System.out.println("default value in Infant guest field:" + v);
			
			for(i=Integer.parseInt(v); i>infant; i--) {
				subtractCountList.get(2).click(); 
			}	
			System.out.println("Infant guest count is reduced to:" + i);
		}
		
		public void inputGuestAddCountbyCategory(int adult, int child, int infant){
		
			
			v = adultCount.getAttribute("value");
			System.out.println("default value in Adult guest field:" + v);
			
			for(i=Integer.parseInt(v); i<adult; i++) {
				addCountAdult.click(); 
			}	
			System.out.println("Adult guest count is:" + i);	
			
			v = childrenCount.getAttribute("value");
			System.out.println("default value in Children guest field:" + v);
			
			for(i=Integer.parseInt(v); i<child; i++) {
				addCountChildren.click(); 
			}	
			System.out.println("Children guest count is:" + i);
			
			v = infantCount.getAttribute("value");
			System.out.println("default value in Infant guest field:" + v);
			
			for(i=Integer.parseInt(v); i<infant; i++) {
				addCountInfant.click(); 
			}	
			System.out.println("Infant guest count is:" + i);
			
	
			}
		
		public void verifyDatePickerFieldDefaultState(String todaysDate) {
			Assert.assertTrue(datePickerField.getAttribute("placeholder").contains("Depart"));
						
			datePickerField.click();
			Assert.assertTrue(activeDatepickerNavBar.isDisplayed());
			Assert.assertTrue(activeDatepickerCalenderDays.isDisplayed());
			String currentDate = activeDatepickerCalenderDays.findElement(By.cssSelector("div.datepicker--cells-days div.datepicker--cell.-current-")).getAttribute("data-date");
			Assert.assertEquals(currentDate, todaysDate, "Current Date matched");
			
		}
		
		public void selectDeptDate(int deptDate) {
		String cssDeptDate = "div.datepicker--cells-days div[data-date='" + deptDate +"']";
		activeDatepickerCalenderDays.findElement(By.cssSelector(cssDeptDate)).click();
				
		}
		
		public void clickOnSearchButton() {
			flightSearchButton.click();
		}		
			
	}

