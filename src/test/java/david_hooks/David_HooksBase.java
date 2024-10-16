package david_hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import david_driverManager.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigFileReader;

public class David_HooksBase {

	ConfigFileReader configFileReader = ConfigFileReader.getInstance();
	WebDriver driver;
	@Before
	public void launchBrowser() throws Throwable {
		// configFileReader.loadProperties();
		String browser = ConfigFileReader.getBrowserType();
		 driver = WebDriverManager.initalizeDriver(browser);
		//System.out.println("configFileReader:"+configFileReader);
		driver.get(configFileReader.getIndexUrl());
	}

	
	
	

	@AfterStep
	public void takeScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png",scenario.getName());
					//"Screenshots");
		}
	}
//
//	@After(order = 0)
//	public void quitbrowser() {
//		WebDriverManager.closeDriver();
//
//	}
	 
//	 @AfterStep
//	 public void getScreenshot(Scenario scenario) {
//		 if(scenario.isFailed()) {
//	            final byte[] screenshot = ((TakesScreenshot) WebdriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//	            scenario.attach(screenshot, "image/png", scenario.getName());   
//	        }  
//	 }
//	
	@After
	public void quitbrowser() {
		WebDriverManager.closeDriver();

	}
}

//driver.get(configFileReader.getIndexUrl());
// configFileReader.getIndexUrl();
// configFileReader.initElements();

// WebDriver driver = WebDriverManager.initializeDriver();
// ConfigFileReader configFileReader = WebDriverManager.configReader();
// driver.get("https://dsportalapp.herokuapp.com");

//driver.get(configFileReader.getIndexUrl());
