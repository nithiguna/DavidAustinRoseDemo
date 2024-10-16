package davidStepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import david_driverManager.WebDriverManager;
import david_pageObjects.DavidDataStructurePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigFileReader;
import utilities.ExcelFileReader;
import utilities.ExcelFileReader1;
import utilities.LoggerLoad;

public class DavidDataStructureStep {

	WebDriver driver = WebDriverManager.getDriver();
	ConfigFileReader configFileReader = ConfigFileReader.getInstance();
	//ExcelFileReader1 reader = ExcelFileReader1.getInstance();
	ExcelFileReader reader = new ExcelFileReader();
	DavidDataStructurePage dataStructureObj = new DavidDataStructurePage();

	// --------------------------- @DataIntro @DataTC_001----------------

	@When("user clicked on the Data Structure Get Started link button")
	public void user_clicked_on_the_data_structure_get_started_link_button() {
		dataStructureObj.getStartedclick();

	}

	@Then("user is able view the Data Structure Introduction Page")
	public void user_is_able_view_the_data_structure_introduction_page() {

		Assert.assertEquals(dataStructureObj.getActualTitle(), configFileReader.getPageTitle("dataStructures"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");

	}

	// ------------------@DataTimecomp @DataTC_002----------------------------------
	@Given("user is on the DataStructure Introduction page")
	public void user_is_on_the_data_structure_introduction_page() {
		dataStructureObj.getStartedclick();
		LoggerLoad.info("You are in " + driver.getTitle() + " page.");
	}

	@When("user clicked the Time complexity link from the DataStructure page")
	public void user_clicked_the_page_time_complexity_link_from_the_DataStructure_page() {
		dataStructureObj.timeComplexclick();

	}

	@Then("user is able to view the Time Complexity Page")
	public void user_is_able_to_view_the_time_complexity_page() {
		Assert.assertEquals(dataStructureObj.getActualTitle(), configFileReader.getPageTitle("timeComplexity"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");

	}

	// ------------------ @TimeCompTryhere @DataTC_003------------------------------
	@Given("user is on the time complexity page")
	public void user_is_on_the_time_complexity_page() {
		dataStructureObj.getStartedclick();
		dataStructureObj.timeComplexclick();
		LoggerLoad.info("You are in " + driver.getTitle() + " page.");

	}

	@When("user clicked the Try here link from the time complexity Page")
	public void user_clicked_the_try_here_link_from_the_time_complexity_page() {
		dataStructureObj.tryHereclick();

	}

	// ------------------ @TimeCompTryEditor @TreeTC_004--------------------

	@Given("the User is on the Try Editor page from Time Complexity page")
	public void the_User_is_on_the_Try_Editor_page_from_Time_Complexity_page() {
		dataStructureObj.getStartedclick();
		dataStructureObj.timeComplexclick();
		dataStructureObj.tryHereclick();
		LoggerLoad.info("You are in " + driver.getTitle() + " page.");
	}

	// ------------------@DataTimecompPracQues @TreeTC_005------------

	@When("user clicked the Practice Questions from the time complexity Page")
	public void user_clicked_the_Practice_Questions_from_the_time_complexity_Page() {
		dataStructureObj.pracQuesclick();

	}

//	@Then("user is get navigated to the Time Complexity link Practice Questions Page")
//	public void user_is_get_navigated_to_the_Time_Complexity_link_Practice_Questions_Page() {
//		Assert.assertEquals(dataStructureObj.getActualTitle(), configFileReader.getPageTitle("practiceQuestions"));
//		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
//	}
	
	@Then("user should view the Practice Questions of DataStructure")
	public void user_should_view_the_Practice_Questions_of_DataStructure() {
		int practiceCount = dataStructureObj.getPracticeQuestionsCount();
		if (practiceCount < 1) {
			Assert.fail("No questions found");
		}
	}

}
