package david_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import david_driverManager.WebDriverManager;

public class DavidLoginPage {
	WebDriver driver = WebDriverManager.getDriver();

	//@FindBy(xpath = "//a[text()='Sign in']")
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signIn;

	//***************************************************
	@FindBy(xpath = "//input[@id='id_username']")
	WebElement username;

	@FindBy(id = "id_password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertInvalidcredentials;

	@FindBy(xpath = "//a[text()='Register!']")
	WebElement loginpageRegisterlink;

	//*********************************************88
	// After successful registered the user account comes this signin password
	@FindBy(xpath = "//input[@id='id_password']")
	WebElement loginPassword;

	public void signInclick() {
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		w1.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
	}
	
	//*********************************************

	public void setUsername(String userName) {
		username.sendKeys(userName);
	}

	public String getUserNameValidationMessage() {
		return username.getAttribute("validationMessage");
	}

	public void setLoginPassword(String passWord) {
		loginPassword.sendKeys(passWord); // i changed to login
	}
	
	public String getPasswordNameValidationMessage() {
		return loginPassword.getAttribute("validationMessage");
	}
	
	// ************************
//	public void usernameLogin()
//	{
//		usernameLogin.sendKeys("DreamTeam");
//	}

//	public void password()
//	{
//		
//		password.sendKeys("Dre@mTe@m123");
//	}

	// *********************************
	public void loginBtnclick() {
		loginbtn.click();
	}

	public String getInvalidLoginValidationMessage() {
		return alertInvalidcredentials.getText();
	}

	public String getActualTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle;
	}

	public void loginpageRegisterlink() {
		loginpageRegisterlink.click();
	}

	public DavidLoginPage() {
		PageFactory.initElements(driver, this);
	}

}
