package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
	
	public void initializeDriver() {
		
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("firefox")) {
			// TODO add correct driver details for firefox
			System.setProperty("webdriver.chrome.driver", prop.getProperty("geckoDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("safari")) {
			// TODO add correct driver details for Safari
			System.setProperty("webdriver.chrome.driver", prop.getProperty("safariDriverPath"));
			driver = new ChromeDriver();
			
		} else if(browserName.equals("IE")) {
			// TODO add correct driver details for IE
			System.setProperty("webdriver.chrome.driver", prop.getProperty("iePath"));
			driver = new ChromeDriver();
			
			// TODO add headless driver capabilities
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public String getScreenshot(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports/screenshots/" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}

}
