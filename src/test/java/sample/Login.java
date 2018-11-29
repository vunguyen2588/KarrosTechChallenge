package sample;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Common{
	WebDriver driver;
	By userName 	= By.id("formHorizontalEmail");
	By password 	= By.id("formHorizontalPassword");
	By loginButton 	= By.cssSelector("a.col-login__btn");
	By accountName	= By.cssSelector("#basic-nav-dropdown");
	By signOut		= By.xpath("//a[text()='Sign Out']");
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
		waitForLoad(driver);
	}

	public void clickSignOut() {
		driver.findElement(signOut).click();
		waitForLoad(driver);
	}
	public void loginToApplication(String strUserName, String strPasword) {
		this.setUserName(strUserName);
		this.setPassword(strPasword);
		this.clickLogin();
	}
	
	public void signOutApplication() {
		driver.findElement(accountName).click();
		this.clickSignOut();
	}
	
	public void verifyLoginPage() {
		Assert.assertTrue(driver.findElement(loginButton).isDisplayed());
	}
}