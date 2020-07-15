package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkBase {
	
	public static WebDriver driver;
	public Properties prop;

	public FrameworkBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\CodeRepository\\E2EFramework-Selenium\\src\\main\\java\\resources\\data.properties");
			prop.load(fis); // Read data from Property file
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initializeDriver() {
		
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
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// return driver;
		driver.get(prop.getProperty("url"));
		
	}

}
