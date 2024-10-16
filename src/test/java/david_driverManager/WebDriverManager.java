package david_driverManager;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;



public class WebDriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	//public static  ConfigFileReader configFileReader;

	public static ChromeOptions chromeOp=new ChromeOptions();
	public static EdgeOptions edgeOp=new EdgeOptions();
	
	public static FirefoxOptions firefoxOp=new FirefoxOptions();
//	public static WebDriver initializeDriver() {

	
public static WebDriver initalizeDriver(@Optional("Chrome") String browser) {
	//public static WebDriver initalizeDriver(String browser) {
//	System.out.println("The Browser from WebDrivermanager Class"+ browser);

	//	configFileReader= new ConfigFileReader();
		//String browserName = configFileReader.getBrowser();
//		if (browserName != null && browserName.equalsIgnoreCase("CHROME")) {
//			driver.set(new ChromeDriver());
//			//driver = new ChromeDriver();
//			
//		} else if (browserName != null && browserName.equalsIgnoreCase("EDGE")) {
//			driver.set(new EdgeDriver());
//			
//		}
		if(browser.equalsIgnoreCase("Chrome")) {
			chromeOp.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.set(new ChromeDriver(chromeOp));
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			edgeOp.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.set(new EdgeDriver(edgeOp));
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			firefoxOp.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.set(new FirefoxDriver(firefoxOp));
		}

		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver.get();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}
	
//	public static ConfigFileReader configReader() {
//		return configFileReader;
//	}
		
	public static void closeDriver() {
			driver.get().quit();
	}
}
