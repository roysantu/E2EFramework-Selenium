package pageObjects.alerts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import resources.FrameworkBase;

public class PracticeAlertPage extends FrameworkBase {
	@FindBy(css = "h2.title")
	WebElement pageTitle;
	
	@FindBy(css = "input[name='alert'] [type='button']")
	WebElement alertButton;
}
