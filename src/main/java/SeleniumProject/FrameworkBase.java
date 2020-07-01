package SeleniumProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkBase {
	
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/santuroy/Documents/newWorkspace/E2EFramework/src/main/java/SeleniumProject/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("geckoDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("safari")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("safariDriverPath"));
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}

}
