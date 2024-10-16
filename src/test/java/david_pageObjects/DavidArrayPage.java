package david_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import david_driverManager.WebDriverManager;

public class DavidArrayPage {

	WebDriver driver = WebDriverManager.getDriver();

	// Array Page
	@FindBy(xpath = "//div[@class='card-body d-flex flex-column']/*[contains(text(),'Array')]/../a")
	WebElement arrGetStarted;
	@FindBy(xpath = "//a[text()='Arrays in Python']")
	WebElement arrArrInPy;
	@FindBy(xpath = "//a[text()='Arrays Using List']")
	WebElement arrArrUseList;
	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	WebElement arrBaseOperInList;
	@FindBy(xpath = "//a[text()='Applications of Array']")
	WebElement arrAppOfArr;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQnsLink;
	@FindBy(xpath = "//a[text()='Search the array']")
	WebElement pracQnsQn1;
	@FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	WebElement pracQnsQn2;
	@FindBy(xpath = "//a[text()='Find Numbers with Even Number of Digits']")
	WebElement pracQnsQn3;
	@FindBy(xpath = "//a[text()='Squares of  a Sorted Array']")
	WebElement pracQnsQn4;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereBtn;
	@FindBy(xpath = "//div[contains(@class,'CodeMirror') and contains(@class,'cm-s-default')]//textarea")
	WebElement tryHereEditor;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement tryHereRun;
	@FindBy(id = "output")
	WebElement tryHereOutput;

	@FindBy(xpath = "//input[@class='button']")
	WebElement clickSubmitBtn;
	
	@FindBy(xpath = "//div[@class='code-area']/form")
	
	//@FindBy(id = "answer_form")
	WebElement answerForm;

	public void clickArrGetStartedBtn() {
		arrGetStarted.click();
	}

	public void clickArrAIPLink() {
		arrArrInPy.click();
	}

	public void clickArrAULLink() {
		arrArrUseList.click();
	}

	public void clickArrBOLLink() {
		arrBaseOperInList.click();
	}

	public void clickArrAOALink() {
		arrAppOfArr.click();
	}

	public void clickArrPracticeQnsLink() {
		practiceQnsLink.click();
	}

	public void clickArrPracQnsQn1() {
		pracQnsQn1.click();
	}

	public void clickArrPracQnsQn2() {
		pracQnsQn2.click();
	}

	public void clickArrPracQnsQn3() {
		pracQnsQn3.click();
	}

	public void clickArrPracQnsQn4() {
		pracQnsQn4.click();
	}

	public void clickArrTryHereBtn() {
		tryHereBtn.click();
	}

	public void clickSubmitBtn() {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		w1.until(ExpectedConditions.elementToBeClickable(clickSubmitBtn));
		clickSubmitBtn.click();
	}

	public String getTryHereEditorValue() {
		return tryHereEditor.getText();
	}

	public void enterCodePractice(String code) {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		w1.until(ExpectedConditions.visibilityOf(answerForm));
//String[] str1 = code.split("\\\\n");
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+code+"';",tryHereEditor);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", tryHereEditor);
		String[] str1 = code.split("\\\\n");
		//System.out.println("Str1:" + str1);
		// "Hello;how;are;you".split(";"); --> ["Hello","how","are","you"]
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", tryHereEditor);
		// w1.until(ExpectedConditions.visibilityOf(tryHereEditor));
		// w1.until(ExpectedConditions.elementToBeClickable(tryHereEditor));

		// tryHereEditor.click();

		// tryHereEditor.sendKeys("Hello");
		// w1.until(ExpectedConditions.visibilityOf(tryHereEditor));
		//((JavascriptExecutor) driver).executeScript("arguments[0].value='Dummy Code';", tryHereEditor);
	//	System.out.println("tryHereEditor.getText():" + tryHereEditor.getText());
//		new WebDriverWait(driver, Duration.ofSeconds(10))
//	    .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

	
	//	tryHereEditor.sendKeys("your code here");
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tryHereEditor);
//		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(20));
//		w2.until(ExpectedConditions.elementToBeClickable(tryHereEditor));
		tryHereEditor.sendKeys(Keys.CONTROL + "a");
		tryHereEditor.sendKeys(Keys.DELETE);

		for (int i = 0; i < str1.length; i++) {
			//System.out.println("Str1[" + i + "]=" + str1[i]);
			if (str1[i].contains("\\b")) {

				
				// tryHereEditor.click();

				tryHereEditor.sendKeys(Keys.BACK_SPACE);
			} else {

				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].scrollIntoView(true);", tryHereEditor);
				// tryHereEditor.click();

				tryHereEditor.sendKeys(str1[i]);
			//	((JavascriptExecutor) driver).executeScript("arguments[0].value='str1[i]';", tryHereEditor);
				tryHereEditor.sendKeys(Keys.ENTER);
			//	((JavascriptExecutor) driver).executeScript("arguments[0].value='Keys.ENTER';", tryHereEditor);

			}
		}

	}

	public void clickTryHereRunBtn() {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		w1.until(ExpectedConditions.elementToBeClickable(tryHereRun));
		tryHereRun.click();
	}

	public String getTryHereOutputText() {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		w1.until(ExpectedConditions.visibilityOf(tryHereOutput));
		System.out.println("The STep : "+ tryHereOutput);
		return tryHereOutput.getText().trim();
	}

	public DavidArrayPage() {
		PageFactory.initElements(driver, this);
	}

}
