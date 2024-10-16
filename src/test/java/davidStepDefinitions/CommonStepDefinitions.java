package davidStepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import david_driverManager.WebDriverManager;
import david_pageObjects.DavidLinkedListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigFileReader;
import utilities.LoggerLoad;

public class CommonStepDefinitions {
	WebDriver driver = WebDriverManager.getDriver();
	// ConfigFileReader configFileReader = WebDriverManager.configReader();
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	DavidLinkedListPage linkedObj = new DavidLinkedListPage();

	@Given("the user is in homepage and logged in")
	public void the_user_is_in_homepage_and_logged_in() {
		// driver.get(configFileReader.getHomeUrl());
		LoggerLoad.info("You are in " + driver.getTitle() + "home page.");
	}

	@Then("the User should get navigated to the Try Editor Page")
	public void the_user_should_get_navigated_to_the_try_editor_page() {
		String tryEditorPageTitle = driver.getTitle();
		Assert.assertEquals(tryEditorPageTitle, configFileReader.getPageTitle("tryEditor"));
	}

	@When("the User enters a sample code as {string} in the Editor section and click Run")
	public void the_user_enters_a_sample_code_as_in_the_editor_section_and_click_run(String code) {
		System.out.println(code);
		linkedObj.setCode(code);
		linkedObj.clickRunBtn();
	}

	@Then("the User should get the {string} in the screen")
	public void the_user_should_get_the_output_in_the_screen(String expectedOutput) {
		String actualCodeOutput = linkedObj.getOutput();
		Assert.assertEquals(actualCodeOutput, expectedOutput);
		LoggerLoad.info("User get the code ouput as  : " + expectedOutput);
	}

	@Then("the User should get the {string} in the alert")
	public void the_user_should_get_the_in_the_alert(String errorOutput) {
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), errorOutput);
		alert.accept();
		LoggerLoad.error("User get the error message : " + errorOutput);

	}

}

//		try {
//
//			try {
//	            Alert alert = driver.switchTo().alert();
//	            // Get the alert text to verify if it's the correct alert
//	            String alertText = alert.getText();
//	            System.out.println("Alert text is: " + alertText);
//	            // Accept the alert
//	            alert.accept();
//	        } catch(NoAlertPresentException e) {
//	            System.out.println("No alert was found.");
//	        }
//	    }catch(org.openqa.selenium.UnhandledAlertException e) {
//	        // Handle the unexpected alert exception if it's not already caught
//	        System.out.println("Unhandled Alert Exception caught. Handling it...");
//	        // Switch to the alert and accept it
//	        Alert alert = driver.switchTo().alert();
//	        System.out.println("Alert text is: " + alert.getText());
//	        alert.accept();
//	       }

// try {
// try {

//				Alert alert = driver.switchTo().alert();
//				System.out.println("Alert text is: " + alert.getText());
//				alert.accept();
//				Assert.assertEquals(alert.getText(), expectedOutput);
//				}
//			} catch (NoAlertPresentException e) {
//				System.out.println("No alert was found.");
//			}
//		} catch (org.openqa.selenium.UnhandledAlertException e) {
//			System.out.println("Unhandled Alert Exception caught. Handling it...");
//			Alert alert = driver.switchTo().alert();
//			System.out.println("Alert text is: " + alert.getText());
//			alert.accept();
//		}

// if(linkedObj.getOutput().isEmpty()) {
// System.out.println("Alert text is: " + alert.getText());

//	@Then("the User should get the {string} in the screen")
//	public void the_user_should_get_the_output_in_the_screen(String expectedOutput) {
//		try {
//			Alert alert = driver.switchTo().alert();
//			Assert.assertEquals(alert.getText(), expectedOutput);
//			alert.accept();
//			LoggerLoad.error("Try editor python code have error: " + expectedOutput);
//		} catch (NoAlertPresentException e) {
//			Assert.assertEquals(linkedObj.getOutput(), expectedOutput);
//			LoggerLoad.info("Try editor python code output : " + expectedOutput);
//		}
//		
// if(linkedObj.getOutput().isEmpty())
// {

//		if(linkedObj.getOutput().isEmpty())
//		{
//			
//		}
//		

//			Alert alert = driver.switchTo().alert();
//			Assert.assertEquals(alert.getText(), expectedOutput);
//			alert.accept();
//			LoggerLoad.error("Try editor python code have error: " + expectedOutput);

//		else
//			
//		{Assert.assertEquals(linkedObj.getOutput(), expectedOutput);
//		LoggerLoad.info("Try editor python code output : " + expectedOutput);
//			
//		}

/*
 * try {
 * 
 * RunBtn.click();
 * 
 * try { Alert alert = driver.switchTo().alert() ; // Get the alert text to
 * verify if it's the correct alert String alertText = alert.getText();
 * System.out.println("Alert text is: " + alertText); // Accept the alert
 * alert.accept(); } catch (NoAlertPresentException e) {
 * System.out.println("No alert was found."); } } catch (UnhandledAlertException
 * e) { // Handle the unexpected alert exception if it's not already caught
 * System.out.println("Unhandled Alert Exception caught. Handling it..."); //
 * Switch to the alert and accept it Alert alert = driver.switchTo().alert();
 * System.out.println("Alert text is: " + alert.getText()); alert.accept(); }
 * 
 * try { //wait.until(ExpectedConditions.alertIsPresent())
 * driver.switchTo().alert().accept(); } catch(Exception e) {
 * System.out.println("alert not present");
 * LoggerLoad.error("alert not present in try editor"); } finally {
 * //driver.switchTo().alert().accept(); System.out.println(string); String
 * output = lp.getOutput(); Assert.assertEquals(output,string); }
 * 
 * 
 * 
 * 
 */
