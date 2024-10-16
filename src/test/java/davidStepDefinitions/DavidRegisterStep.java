package davidStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import david_driverManager.WebDriverManager;
import david_pageObjects.DavidHomePage;
import david_pageObjects.DavidRegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigFileReader;
import utilities.ExcelFileReader;
import utilities.ExcelFileReader1;
import utilities.LoggerLoad;

public class DavidRegisterStep {
	WebDriver driver = WebDriverManager.getDriver();
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();
	DavidRegisterPage registerObj = new DavidRegisterPage();
	DavidHomePage homeObj = new DavidHomePage();
	String excelFilepath;
	String ExpectedMessage;
	String ExpectedResultsValidcred;
	String username;
	String regPassword;
	String passwordConfrimation;
	String userNameValidationMessage;
	String passwordValidationMessage;
	String confirmpasswordValidationMessage;
	String invalidgetMessage;
	// String ExpectedResultsInValidcred;

	@Given("The User is on the Home Page")
	public void the_user_is_on_the_home_page() {
		homeObj.getStartedhomeclick();
		registerObj.registerLinkclick();
	}

//*******************************************
//	@When("The User clicks on the Register link")
//	public void the_user_clicks_on_the_register_link() {
//		registerObj.registerLinkclick();
//		
//			//registerObj.setUsername();
////		registerObj.setPassword();
////		registerObj.setConfirmPassword();
//		registerObj.registerBtnclick();
//	}
//
//	@Then("The User should get navigated to Register Page")
//	public void the_user_should_get_navigated_to_register_page() {
//	rp.ValidateHomePage();   //Assert home page
//	//	registerObj.titlepage();
//	//  Assert.assertEquals(driver.getTitle(), "NumpyNinja");
//	}
//###########################3

	@When("The User enter valid username and password confirmpassword from sheet {string}")
	public void the_user_enter_valid_username_and_password_confirmpassword_from_sheet(String RegisterData)
			throws EncryptedDocumentException, IOException, Exception {
		excelFilepath = System.getProperty("user.dir") + "/src/test/resources/Excel/TestData.xlsx";
		System.out.println("File Path :" + excelFilepath);
		//ExcelFileReader1 reader = ExcelFileReader1.getInstance();
		ExcelFileReader reader = new ExcelFileReader();
		//System.out.println("Sheetname" + RegisterData);
		List<Map<String, String>> testdata = reader.getData(excelFilepath, RegisterData);

		username = testdata.get(0).get("username");
		regPassword = testdata.get(0).get("password");
		passwordConfrimation = testdata.get(0).get("password confrimation");
		ExpectedMessage = testdata.get(0).get("Expected Output");

		userNameValidationMessage = registerObj.getUserNameValidationMessage();
		// System.out.println("userNameValidationMessage:" + userNameValidationMessage);

		passwordValidationMessage = registerObj.getRegPasswordNameValidationMessage();

		System.out.println("The Reg Username : " + username);
		System.out.println("The Reg pwd : " + regPassword);
		System.out.println("The Reg confrimpwd : " + passwordConfrimation);

		LoggerLoad.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ regPassword + "\" " + "\" and confrimpassword  as " + passwordConfrimation + "\" ");
		if (username != null || regPassword != null || passwordConfrimation != null) {
			registerObj.setRegUsername(username);
			registerObj.setRegpassword(regPassword);
			registerObj.setRegConfirmPassword(passwordConfrimation);
			registerObj.registerBtnclick();
		}

	}

	@Then("The User should get navigated to Login Page")
	public void the_user_should_get_navigated_to_login_page() {

		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}

	@When("The User enters the Invalid username {string} and Invalid password and clicks on Register button {int}")
	public void the_user_enters_the_Invalid_username_and_Invalid_password_and_clicks_on_Register_button(
			String sheetName, int RowNumber) throws EncryptedDocumentException, IOException, Exception {
		excelFilepath = System.getProperty("user.dir") + "/src/test/resources/Excel/TestData.xlsx";
		// System.out.println("File Path :" + excelFilepath);
		//ExcelFileReader1 reader = ExcelFileReader1.getInstance();
		ExcelFileReader reader = new ExcelFileReader();
		// System.out.println("Sheetname" + sheetName);
	//	List<Map<String, String>> testdata = reader.getData(excelFilepath, sheetName);
		List<Map<String, String>> testdata = reader.getData(excelFilepath, sheetName);
		// System.out.println("# of Rows:" + reader.countRow());

		username = testdata.get(RowNumber).get("username");
		regPassword = testdata.get(RowNumber).get("password");
		passwordConfrimation = testdata.get(RowNumber).get("password confirmation");
		ExpectedMessage = testdata.get(RowNumber).get("Expected Output");

		userNameValidationMessage = registerObj.getUserNameValidationMessage();
		// System.out.println("userNameValidationMessage:" + userNameValidationMessage);

		passwordValidationMessage = registerObj.getRegPasswordNameValidationMessage();
		confirmpasswordValidationMessage = registerObj.getConfirmPasswordNameValidationMessage();

		System.out.println("The Reg Username : " + username);
		System.out.println("The Reg pwd : " + regPassword);
		System.out.println("The Reg confrimpwd : " + passwordConfrimation);

		LoggerLoad.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ regPassword + "\" " + "\" and confrimpassword  as " + passwordConfrimation + "\" ");
		if (username != null || regPassword != null || passwordConfrimation != null) {
			registerObj.setRegUsername(username);
			registerObj.setRegpassword(regPassword);
			registerObj.setRegConfirmPassword(passwordConfrimation);
			registerObj.registerBtnclick();

		}
	}

	// @Then The User validate the Excepted Output for Registration Page
	@Then("The User get the suggested message for to get the successful Registration Page")
	public void The_User_get_the_suggested_message_for_to_get_the_successful_Registration_Page() {

		LoggerLoad.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ regPassword + "\" ");
		try {
			if (username.isEmpty()) {
				Assert.assertEquals(userNameValidationMessage, ExpectedMessage);
				System.out.println(userNameValidationMessage + ExpectedMessage);
				LoggerLoad.error("The username textfield alert :" + userNameValidationMessage + ExpectedMessage);

			} else if (regPassword.isEmpty()) {
				Assert.assertEquals(passwordValidationMessage, ExpectedMessage);
				System.out.println(passwordValidationMessage + ExpectedMessage);
				LoggerLoad.error("The password textfield alert :" + passwordValidationMessage + ExpectedMessage);

			} else if (passwordConfrimation.isEmpty()) {
				Assert.assertEquals(passwordValidationMessage, ExpectedMessage);
				System.out.println(passwordValidationMessage + ExpectedMessage);
				LoggerLoad.error("The password textfield alert :" + passwordValidationMessage + ExpectedMessage);
			} else if ((username.isEmpty() && regPassword.isEmpty() && passwordConfrimation.isEmpty())) {
				Assert.assertEquals(userNameValidationMessage, ExpectedMessage);
				System.out.println(userNameValidationMessage + ExpectedMessage);
				LoggerLoad.error("The username textfield alert :" + userNameValidationMessage + ExpectedMessage);
			} else {
				invalidgetMessage = registerObj.getInvalidLoginValidationMessage();
				Assert.assertEquals(invalidgetMessage, ExpectedMessage);
				System.out.println(invalidgetMessage + ExpectedMessage);

				if (ExpectedMessage.equals("password_mismatch:The two password fields didn’t match.")) {
					LoggerLoad.info("User is suggested to enter the valid data for the Registeration");
					// registerObj.registerLinkclick();
				} else {
					LoggerLoad.info("User is able to Register successful");
					// registerObj.registerLinkclick();
				}
			}
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("User is able to Register");
		}
	}
}
