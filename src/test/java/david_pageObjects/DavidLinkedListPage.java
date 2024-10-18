package david_pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import david_driverManager.WebDriverManager;
import utilities.LoggerLoad;

public class DavidLinkedListPage {
	WebDriver driver = WebDriverManager.getDriver();

	@FindBy(xpath = "//h5[text()='Linked List']/../a")
	WebElement getStartedButton;

	@FindBy(partialLinkText = "Introduction")
	WebElement introductionLink;

	@FindBy(partialLinkText = "Creating Linked LIst")
	WebElement creatingLinkedListLink;

	@FindBy(partialLinkText = "Types of Linked List")
	WebElement typesOfLinkedListLink;

	@FindBy(partialLinkText = "Implement Linked List in Python")
	WebElement implementLinkedListLink;

	@FindBy(partialLinkText = "Traversal")
	WebElement traversalLink;

	@FindBy(partialLinkText = "Insertion")
	WebElement insertionLink;

	@FindBy(partialLinkText = "Deletion")
	WebElement deletionLink;

	@FindBy(partialLinkText = "Practice Questions")
	WebElement linkedListPracticeLink;

	@FindAll(value = { @FindBy(className = "list-group") })
	List<WebElement> practiceQuestions;

	@FindBy(partialLinkText = "Try here>>>")
	WebElement tryEditor;
	// @FindBy (name = "code") WebElement inputCode;

	@FindBy(xpath = "//div[contains(@class , 'CodeMirror') and contains(@class,'cm-s-default')]//textarea")
	WebElement inputCode;

	@FindBy(xpath = "//button")
	WebElement runButton;

	@FindBy(xpath = "//*[@id='output']")
	WebElement output;

	@FindBy(id = "answer_form")
	WebElement formText;

	public void clickGetStartedBtn() {
		getStartedButton.click();
	}

	public void clickIntroductionLink() {
		introductionLink.click();

	}

	public void clickCreatingLinkedListLink() {
		creatingLinkedListLink.click();

	}

	public void clickTypesOfLinkedListLink() {
		typesOfLinkedListLink.click();

	}

	public void clickImplementLinkedListLink() {
		implementLinkedListLink.click();

	}

	public void clickinsertionLink() {
		insertionLink.click();

	}

	public void clicktraversalLink() {
		traversalLink.click();

	}

	public void clickdeletionLink() {
		deletionLink.click();

	}

	public void clicktryEditor() {
		tryEditor.click();
	}

	public void setCode(String input) {

//		WebElement element = driver.findElement(By.xpath("//div[contains(@class , 'CodeMirror') and contains(@class,'cm-s-default')]//textarea"));
//		element.click();  // Click to focus
//		element.sendKeys("Your text here");

		// ************************************************************
		// WebElement element = driver.findElement(By.xpath("//div[contains(@class ,
		// 'CodeMirror') and contains(@class,'cm-s-default')]//textarea"));
				//((JavascriptExecutor) driver).executeScript("arguments[0].value='"+input+"';", inputCode);
		
		driver.switchTo().frame("frame_name_or_id");  // Switch to the frame
		WebElement codeMirrorTextArea = driver.findElement(By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class,'cm-s-default')]//textarea"));
		codeMirrorTextArea.sendKeys(input);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].value='"+input+"';", inputCode);
		//((JavascriptExecutor) driver).executeScript("arguments[0].value='input';", inputCode);
		// element1.sendKeys(input);

		// ****************************************************************************
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class , 'CodeMirror') and contains(@class,'cm-s-default')]//textarea")));
//				
		// element.sendKeys(input);
		//

		// ************************************************************************
		// try {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
//					   WebElement enterText = new WebDriverWait(driver, Duration.ofSeconds(60))
//					       		  .until(ExpectedConditions.elementToBeClickable(inputCode));

//					   enterText.click();
		// inputCode.sendKeys(input);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// }

		// catch(Exception e) {
		// System.out.println("try editor not displayed");
		// LoggerLoad.error("Interactable exception try editor not displayed ");
		// }

	}

	public void clickRunBtn() {
		runButton.click();
	}

	public String getOutput() {
		return output.getText();
		//output.clear();
	}

	public void getOutput1() {
		//return output.getText();
		output.clear();
	}
	public void clickPracticeLink() {
		linkedListPracticeLink.click();
	}

	public int getPracticeQuestionsCount() {
		return practiceQuestions.size();
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	// consructor
	public DavidLinkedListPage() {
		PageFactory.initElements(driver, this);
	}
}