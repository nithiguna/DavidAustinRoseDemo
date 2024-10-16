package david_pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import david_driverManager.WebDriverManager;

public class DavidHomePage {
	WebDriver driver = WebDriverManager.getDriver();

	//@FindBy(xpath = "//button[text()='Get Started']")
	@FindBy(xpath = "//div[@class='content-area']//div/a/button")
	WebElement getStartedhome;

	@FindBy(xpath = "//a[text()='NumpyNinja']")
	WebElement numpyLogo;

	@FindBy(xpath = "//a[text()='Data Structures']")
	WebElement datastructure;

	@FindBy(xpath = "//div[@class='dropdown-menu show']")
	WebElement datastrcDropdown;

	@FindBy(xpath = "//div[@class='dropdown-menu show']/a[text()='Arrays']")
	WebElement dropDownarrays;

	@FindBy(xpath = "div[@class='dropdown-menu show']/a[text()='Linked List']")
	// a[text()='Linked List']")
	WebElement dropDownlinked;

	@FindBy(xpath = "div[@class='dropdown-menu show']/a[text()='Stack']")
	// a[text()='Stack']")
	WebElement dropDownstack;

	@FindBy(xpath = "//div[@class='dropdown-menu show']/a[text()='Queue']")
	WebElement dropDownqueue;

	@FindBy(xpath = "//div[@class='dropdown-menu show']/a[text()='Tree']")
	WebElement dropDowntree;

	@FindBy(xpath = "//div[@class='dropdown-menu show']/a[text()='Graph']")
	WebElement dropDowngraph;

	@FindBy(xpath = "//h5[text()='Data Structures-Introduction']")
	WebElement datastructureGetstarted;

	@FindBy(xpath = "//h5[text()='Array']/../a[text()='Get Started']")
	WebElement arrayGetstarted;

	@FindBy(xpath = "//h5[text()='Linked List']/../a[text()='Get Started']")
	WebElement linkedlistGetstarted;

	@FindBy(xpath = "//h5[text()='Stack']/../a[text()='Get Started']")
	WebElement stackGetstarted;

	@FindBy(xpath = "//h5[text()='Queue']/../a[text()='Get Started']")
	WebElement queueGetstarted;

	@FindBy(xpath = "//h5[text()='Tree']/../a[text()='Get Started']")
	WebElement treeGetstarted;

	@FindBy(xpath = "//h5[text()='Graph']/../a[text()='Get Started']")
	WebElement graphGetstarted;

	@FindBy(xpath = "//div[contains(text(),'You are not logged in')]")
	WebElement alertMessage;

	@FindBy(xpath = "//a[contains(text(),'DreamTeam')]")
	WebElement accountHoldername;

	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement logOut;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertSignout;

	public void getStartedhomeclick() {
		getStartedhome.click();
	}

	public void getStartedhomeclickwithoutlogin() {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(getStartedhome)).click();
		// getStartedhome.click();
	}

	public void numpyLogoclick() {
		numpyLogo.click();
	}

	public String getActualLogoMessage() {
		String logo = numpyLogo.getText();
		return logo;
	}

	public void dataStructureclick() {
		datastructure.click();

	}

	public String getDatastrucActualString()

	{
		String getActualString = datastructure.getText();
		return getActualString;

	}
//
//	public String getArraysActualString()
//
//	{
//		String getActualString = dropDownarrays.getText();
//		return getActualString;
//
//	}
//
//	public String getLinkedActualString()
//
//	{
//		String getActualString = dropDownlinked.getText();
//		return getActualString;
//
//	}
//
//	public String getStackActualString()
//
//	{
//		String getActualString = dropDownstack.getText();
//		return getActualString;
//
//	}
//
//	public String getQueueActualString()
//
//	{
//		String getActualString = dropDownqueue.getText();
//		return getActualString;
//
//	}
//
//	public String getTreeActualString()
//
//	{
//		String getActualString = dropDowntree.getText();
//		return getActualString;
//
//	}
//
//	public String getGraphActualString()
//
//	{
//		String getActualString = dropDowngraph.getText();
//		return getActualString;
//
//	}

	public List<WebElement> dropdownWithoutLogin() {
		List<WebElement> dropdownListNames = new ArrayList<>();
		dropdownListNames.add(datastructure);
		dropdownListNames.add(dropDownarrays);
		dropdownListNames.add(datastructure);
		dropdownListNames.add(dropDownlinked);
		dropdownListNames.add(datastructure);
		dropdownListNames.add(dropDownstack);
		dropdownListNames.add(datastructure);
		dropdownListNames.add(dropDownqueue);
		dropdownListNames.add(datastructure);
		dropdownListNames.add(dropDowntree);
		dropdownListNames.add(datastructure);
		dropdownListNames.add(dropDowngraph);
		return dropdownListNames;
	}

	public void clickspecificdropdownNames(WebElement eachclick) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(eachclick)).click();
	}

	public void datastrcDropdownclick() {
		datastrcDropdown.click();
	}

	public void dropDownarraysclick() {
		dropDownarrays.click();
	}

	public void dropDownlinkedclick() {
		dropDownlinked.click();
	}

	public void dropDownstackclick() {
		dropDownstack.click();
	}

	public void dropDownqueueclick() {
		dropDownqueue.click();
	}

	public void dropDowntreeclick() {
		dropDowntree.click();
	}

	public void dropDowngraphclick() {
		dropDowngraph.click();
	}

	public void accountHoldernameclick() {
		accountHoldername.click();
	}

	public void datastructureGetstartedclick() {
		datastructureGetstarted.click();
	}

	public void arrayGetstartedclick() {
		arrayGetstarted.click();
	}

	public void linkedlistGetstartedclick() {
		linkedlistGetstarted.click();
	}

	public void stackGetstartedclick() {
		stackGetstarted.click();
	}

	public void queueGetstartedclick() {
		queueGetstarted.click();
	}

	public void treeGetstartedclick() {
		treeGetstarted.click();
	}

	public void graphGetstartedclick() {
		graphGetstarted.click();
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	// Method to return all Get Started elements as a list
	public List<WebElement> getAnylinkofGetStarted() {
		List<WebElement> getStartedLinks = new ArrayList<>();
		getStartedLinks.add(datastructureGetstarted);
		getStartedLinks.add(arrayGetstarted);
		getStartedLinks.add(linkedlistGetstarted);
		getStartedLinks.add(stackGetstarted);
		getStartedLinks.add(queueGetstarted);
		getStartedLinks.add(treeGetstarted);
		getStartedLinks.add(graphGetstarted);
		return getStartedLinks;
	}

	// Method to click on specific Get Started buttons
	public void clickspecificGetStartedlink(WebElement link) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(link)).click();
		// link.click();
	}

	public String getActualMessage() {
		String actualMessage = alertMessage.getText();
		return actualMessage;
	}

	public String getAccountholdername() {
		return accountHoldername.getText();
	}

	public void logoutClick() {
		logOut.click();
	}

	public String alertSignout() {
		return alertSignout.getText();
	}

	public DavidHomePage() {
		PageFactory.initElements(driver, this);
	}

}
