package david_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import david_driverManager.WebDriverManager;


public class DavidRegisterPage {
	WebDriver driver = WebDriverManager.getDriver();

	// locators
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//input[@id='id_username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='id_password1']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='id_password2']")
	WebElement regConfirmpassword;
	
	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginLink;
	
//	// After successful registered the user account comes this signin password
//	@FindBy(xpath = "//input[@id='id_password']")
//	WebElement loginPassword;
	
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertInvalidcredentials;
	

	public void registerLinkclick() {

		registerLink.click();
	}
//	public void username() {
//	
//		username.sendKeys("DreamTeam");
//	}

	public void setRegUsername(String userName) {
//		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement wait= w1.until(ExpectedConditions.visibilityOf(username));
//				//elementToBeClickable(username));
//		
		username.sendKeys(userName);
	}
	
//	public void password() {
//	
//		password.sendKeys("Dre@mTe@m123");
//	}
	public String getUserNameValidationMessage() {
		return username.getAttribute("validationMessage");
	}

	public void setRegpassword(String regPassword) {
																//add for 44 to 47
			password.sendKeys(regPassword);
		}
	
//	public void setLoginPassword(String passWord) {
//		loginPassword.sendKeys(passWord);                          //i changed to login 
//	}
//	
	public String getRegPasswordNameValidationMessage() {
		return password.getAttribute("validationMessage");
	}

//	public void setConfirmPassword() {
//
//		confirmPassword.sendKeys("Dre@mTe@m123");
//	}

	public void setRegConfirmPassword(String confirmPassword) {
	
				regConfirmpassword.sendKeys(confirmPassword);
			}

	public String getConfirmPasswordNameValidationMessage() {
		return regConfirmpassword.getAttribute("validationMessage");
	}
	public void registerBtnclick() {

		registerBtn.click();
	}

//	public void signInPassword() {
//		signInPassword.sendKeys("Dre@mTe@m123");
//	}
	
//	public void ValidateHomePage() {
//		Assert.assertEquals(titlepage(), "NumpyNinja");
//	}

	public String getInvalidLoginValidationMessage() {
		return alertInvalidcredentials.getText();
	}
	public String getActualTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle;
	}
	public DavidRegisterPage() {
		PageFactory.initElements(driver, this);
	}


}
