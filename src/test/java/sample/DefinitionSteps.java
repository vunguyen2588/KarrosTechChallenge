package sample;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DefinitionSteps extends Driver{
	public static String url = "http://ktvn-test.s3-website.us-east-1.amazonaws.com/";
	
	private ChromeOptions setOptionsForChrome() {
        String downloadFilepath = "D:\\04_Automation\\Eclipse\\Demo\\src\\test\\";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("disable-infobars");
        return options;
    }
	
	public void startChromeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\driver\\chromedriver.exe");
        ChromeOptions options = setOptionsForChrome();
        obj = new ChromeDriver(options);
		obj.manage().window().maximize();
		obj.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Given("^I navigate to the web application$")
	public void iNavigateToApplication() {
		startChromeDriver();
		obj.get(url);
	}
	
	@And ("^I login with username (.*) and password (.*)$")
	public void loginWebApplication(String username, String password) {
		Login objLogin = new Login(obj);
		objLogin.loginToApplication(username, password);
	}
	
	@And ("^I sign out the application$")
	public void signOutWebApplication() {
		Login objLogin = new Login(obj);
		objLogin.signOutApplication();
	}
	
	@And ("^I should see login page$")
	public void verifyLoginPage() {
		Login objLogin = new Login(obj);
		objLogin.verifyLoginPage();
	}
	
	@And ("^I should see Parent Portal page is (.*)$")
	public void verifyParentPortalPage(String status) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyParentPortalPage(status);
	}
	
	@And ("^I click on header name (.*)$")
	public void clickHeaderName(String headerName) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.clickHeader(headerName);
	}
	
	@Then ("^I should see (request status|requester|first name|last name|date submitted|date of birthday) with (ascending order|descending order)$")
	public void seeRequestStatusDecrease(String header, String order) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyListSortedOrder(header, order);
	}
	
	@And ("^I click on Filters button$")
	public void clickOnFiltersButton() {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.clickOnFiltersButton();
	}
	
	@And ("^I select Request Status (.*)$")
	public void selectRequestStatus(String requestStatus) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.selectRequestStatus(requestStatus);
	}
	
	@And ("^I enter email (.*)$")
	public void enterEmail(String email) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.enterEmail(email);
	}
	
	@And ("^I enter Student ID (.*)$")
	public void enterStudentID(String studentID) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.enterStudentID(studentID);
	}
	
	@And ("^I enter Student First Name (.*)$")
	public void enterStudentFirstName(String firstName) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.enterStudentFirstName(firstName);
	}
	
	@And ("^I enter Student Last Name (.*)$")
	public void enterStudentLastName(String lastName) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.enterStudentLastName(lastName);
	}
	
	@And ("^I click Apply Filters button$")
	public void clickApplyFilters() {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.clickApplyFilters();
	}
	
	@And ("^I should see Request Status is (.*)$")
	public void verifyRequestStatus(String requestStatus) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyRequestStatus(requestStatus);
	}
	
	@And ("^I should see Requester is (.*)$")
	public void verifyRequesterContainsEmail(String email) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyRequesterContainsEmail(email);
	}
	
	@And ("^I should see Student ID is (.*)$")
	public void verifyStudentID(String studentID) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyStudentID(studentID);
	}
	
	@And ("^I should see Student First Name is (.*)$")
	public void verifyStudentFistName(String firstName) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyStudentFirstName(firstName);
	}
	
	@And ("^I should see Student Last Name is (.*)$")
	public void verifyStudentLastName(String lastName) {
		ParentPortal parentPortal = new ParentPortal(obj);
		parentPortal.verifyStudentLastName(lastName);
	}
	
//	@And ("^I click on Rejected status of the first record$")
//	public void clickRequestStatus(String status) {
//		ParentPortal parentPortal = new ParentPortal(obj);
//		parentPortal.clickRequestStatus(status);
//	}
//	
//	@And ("^I change to status of this record to Approved status$")
//	public void changeToRequestStatus(String status) {
//		ParentPortal parentPortal = new ParentPortal(obj);
//		parentPortal.changeToRequestStatus(status);
//	}
}