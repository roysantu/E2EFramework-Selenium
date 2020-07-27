package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FrameworkBase {
	
	public static WebDriver driver;
	public Properties prop;

	public FrameworkBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/santuroy/Documents/newWorkspace/E2EFramework"
					+ "/src/main/java/resources/data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initializeDriver() throws MalformedURLException {
		
		String browserName = prop.getProperty("browserName");
		DesiredCapabilities dc = new DesiredCapabilities();
		URL localSeleniumGridHost = new URL("http://192.168.0.10:4444/wd/hub");
		
		if(browserName.equals("chrome")) {
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.MAC);
			driver = new RemoteWebDriver(localSeleniumGridHost, dc);
			
		} else if(browserName.equals("firefox")) {
			// TODO update Desired capabilities for grid Firefox
			System.setProperty("webdriver.chrome.driver", prop.getProperty("geckoDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("safari")) {
			// TODO update Desired capabilities for grid Safari
			System.setProperty("webdriver.chrome.driver", prop.getProperty("safariDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("IE")) {
			// TODO update Desired capabilities for grid IE
			System.setProperty("webdriver.chrome.driver", prop.getProperty("safariDriverPath"));
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}
