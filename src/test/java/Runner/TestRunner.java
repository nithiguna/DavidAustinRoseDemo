package Runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigFileReader;

@CucumberOptions(
		 features = {"./src/test/resources/davidfeature"},
   glue = {"davidStepDefinitions","david_hooks"},
   monochrome = true,

   tags= "@DavidLogin or @RegistrationTest002 or @DavidLinkedList or @DavidStack or @DavidTree or @DavidDataStructure or @DavidQueue or @DavidGraph or @DavidHome or @DavidArray",
   plugin= {"pretty","html:target/cucumber-reports/cucumber.html",
   		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
   		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
   		// "rerun:target/rerun.txt",
   		})

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeTest
	@Parameters({ "browserType" })
	public void defineBrowser(String browser) throws Throwable {
		ConfigFileReader.setBrowserType(browser);
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

//@Test(dataProvider = "Login",dataProviderClass = utilities.ExcelFileReader1.class)

// public void defineBrowser(@Optional("Chrome")String browserType) throws
// Throwable {

//	@Test(dataProvider = "getData")
//	pubic void runTest(String browser) throws Exception {
//	    TestBase base = new TestBase();
//	    base.initialization(browser);
//	    WebDriver driver = base.getDriver();
//	    driver.get("https://www.example.com");
//	    // Test logic...
//	    base.closedrivers();
//	}

//WebDriverManager base=new WebDriverManager();
//base.initalizeDriver(browserType);
// WebDriver driver = base.getDriver();

//System.out.println("browser from Runner class: " + browserType);
//"json:target/cucumber-reports/cucumber.json",// JSON report
//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
