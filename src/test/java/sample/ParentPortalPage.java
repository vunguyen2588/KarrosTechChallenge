package sample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParentPortalPage {
	WebDriver driver;
	String strRequestStatus = "//th[text()='%s']";
	By parentPortalEle 		= By.xpath("//a[contains(text(),'Parent Portal')]");
	By filtersButton 		= By.cssSelector("button.btn-filter");
	By requestStatusEle 	= By.id("formControlsSelect");
	String statusValue 		= "//option[text()='%s']";
	By emailEle 			= By.id("formHorizontalEmail");
	By studentIDEle 		= By.id("formHorizontalStudentID");
	By studentFirstNameEle 	= By.id("formHorizontalStudentFN");
	By studentLastNameEle 	= By.id("formHorizontalStudentLN");
	By applyFiltersEle 		= By.xpath("//button[text()='Apply Filters']");
	By requestStatusEles 	= By.xpath("//div[@class='ct-drop-group dropdown btn-group']/p");
	By requesterEles 		= By.xpath("//div[@class='ct-drop-group dropdown btn-group']/ancestor::tr/td[4]");
	By studentIDEles 		= By.xpath("//div[@class='ct-drop-group dropdown btn-group']/ancestor::tr/td[5]");
	By studentFirstNameEles = By.xpath("//div[@class='ct-drop-group dropdown btn-group']/ancestor::tr/td[6]");
	By studentLastNameEles 	= By.xpath("//div[@class='ct-drop-group dropdown btn-group']/ancestor::tr/td[7]");
	By dateSubmittedEles 	= By.xpath("//div[@class='ct-drop-group dropdown btn-group']/ancestor::tr/td[3]");
	By DOBEles 				= By.xpath("//div[@class='ct-drop-group dropdown btn-group']/ancestor::tr/td[8]");
	String requestStatus 	= "//div[@class='ct-drop-group dropdown btn-group']/p[text()='%s']";
	String statusItem 		= "//div[@class='ct-drop-group dropdown open btn-group']//ul[@class='dropdown-menu']//p[text()='%s']";

	public ParentPortalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHeader(String header) {
		String headerXPath = String.format(strRequestStatus, header);
		driver.findElement(By.xpath(headerXPath)).click();
	}

	public void clickOnFiltersButton() {
		driver.findElement(filtersButton).click();
	}

	public void selectRequestStatus(String requestStatus) {
		driver.findElement(requestStatusEle).click();
		driver.findElement(By.xpath(String.format(statusValue, requestStatus)))
				.click();
		driver.findElement(requestStatusEle).click();
	}

	public void enterEmail(String email) {
		driver.findElement(emailEle).sendKeys(email);
	}

	public void enterStudentID(String studentID) {
		driver.findElement(studentIDEle).sendKeys(studentID);
	}

	public void enterStudentFirstName(String firstName) {
		driver.findElement(studentFirstNameEle).sendKeys(firstName);
	}

	public void enterStudentLastName(String lastName) {
		driver.findElement(studentLastNameEle).sendKeys(lastName);
	}

	public void clickApplyFilters() {
		driver.findElement(applyFiltersEle).click();
	}

	public void verifyParentPortalPage(String status) {
		if (status.equalsIgnoreCase("displayed")) {
			Assert.assertTrue(driver.findElement(parentPortalEle).isDisplayed());
		} else if (status.equalsIgnoreCase("not displayed")) {
			Assert.assertNull(driver.findElement(parentPortalEle));
		}
	}

	public void verifyRequestStatus(String requestStatus) {
		for (int i = 0; i < driver.findElements(requestStatusEles).size(); i++) {
			if (!driver.findElements(requestStatusEles).get(i).getText()
					.equals(requestStatus)) {
				Assert.assertTrue(false);
				break;
			}
		}
	}

	public void verifyRequesterContainsEmail(String email) {
		for (int i = 0; i < driver.findElements(requesterEles).size(); i++) {
			if (!driver.findElements(requesterEles).get(i).getText()
					.equals(email)) {
				Assert.assertTrue(false);
				break;
			}
		}
	}

	public void verifyStudentID(String studentID) {
		for (int i = 0; i < driver.findElements(studentIDEles).size(); i++) {
			if (!driver.findElements(studentIDEles).get(i).getText()
					.contains(studentID)) {
				Assert.assertTrue(false);
				break;
			}
		}
	}

	public void verifyStudentFirstName(String firstName) {
		for (int i = 0; i < driver.findElements(studentFirstNameEles).size(); i++) {
			if (!driver.findElements(studentIDEles).get(i).getText()
					.contains(firstName)) {
				Assert.assertTrue(false);
				break;
			}
		}
	}

	public void verifyStudentLastName(String lastName) {
		for (int i = 0; i < driver.findElements(studentLastNameEles).size(); i++) {
			if (!driver.findElements(studentLastNameEles).get(i).getText()
					.contains(lastName)) {
				Assert.assertTrue(false);
				break;
			}
		}
	}

	public void verifyListSortedOrder(String header, String order) {
		boolean sorted = true;
		List<String> compareLst = new ArrayList<String>();
		
		if (header.equalsIgnoreCase("request status")) {
			for (int i = 0; i < driver.findElements(requestStatusEles).size(); i++)
				compareLst.add(driver.findElements(requestStatusEles).get(i).getText());
		} else if (header.equalsIgnoreCase("requester")) {
			for (int i = 0; i < driver.findElements(requesterEles).size(); i++)
				compareLst.add(driver.findElements(requesterEles).get(i).getText());
		} else if (header.equalsIgnoreCase("first name")) {
			for (int i = 0; i < driver.findElements(studentFirstNameEles).size(); i++)
				compareLst.add(driver.findElements(studentFirstNameEles).get(i).getText());
		} else if (header.equalsIgnoreCase("last name")) {
			for (int i = 0; i < driver.findElements(studentLastNameEles).size(); i++)
				compareLst.add(driver.findElements(studentLastNameEles).get(i).getText());
		} else if (header.equalsIgnoreCase("date submitted")) {
			for (int i = 0; i < driver.findElements(dateSubmittedEles).size(); i++)
				compareLst.add(driver.findElements(dateSubmittedEles).get(i).getText());
		} else if (header.equalsIgnoreCase("date of birthday")) {
			for (int i = 0; i < driver.findElements(DOBEles).size(); i++)
				compareLst.add(driver.findElements(DOBEles).get(i).getText());
		}

		if (order.equalsIgnoreCase("descending order")) {
			if (header.equalsIgnoreCase("date submitted")){
				sorted = verifyDateDescendingOrder(compareLst, "submitted");
			} else if (header.equalsIgnoreCase("date of birthday")) {
				sorted = verifyDateDescendingOrder(compareLst, "dob");
			} else {
				sorted = verifyDescendingOrder(compareLst);
			}
		} else if (order.equalsIgnoreCase("ascending order")) {
			if (header.equalsIgnoreCase("date submitted")){
				sorted = verifyDateAscendingOrder(compareLst, "submitted");
			} else if (header.equalsIgnoreCase("date of birthday")) {
				sorted = verifyDateAscendingOrder(compareLst, "dob");
			} else {
				sorted = verifyAscendingOrder(compareLst);
			}
		}
		
		Assert.assertTrue(sorted);
	}

	private boolean verifyDescendingOrder(List<String> lstEle) {
		boolean sorted = true;
		
		for (int i = 1; i < lstEle.size(); i++) {
			if (lstEle.get(i - 1).toLowerCase().compareTo(lstEle.get(i).toLowerCase()) < 0) {
				System.out.println(lstEle.get(i - 1));
				System.out.println(lstEle.get(i));
				sorted = false;
				break;
			}
		}
		
		return sorted;
	}

	private boolean verifyAscendingOrder(List<String> lstEle) {
		boolean sorted = true;
		
		for (int i = 1; i < lstEle.size(); i++) {
			if (lstEle.get(i - 1).toLowerCase().compareTo(lstEle.get(i).toLowerCase()) > 0) {
				System.out.println(lstEle.get(i - 1));
				System.out.println(lstEle.get(i));
				sorted = false;
				break;
			}
		}
		
		return sorted;
	}

	private boolean verifyDateDescendingOrder(List<String> lstEle, String type) {
		try {
			boolean sorted = true;
			SimpleDateFormat format;
			if(type.equals("submitted"))
				format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			else
				format = new SimpleDateFormat("MM/dd/yyyy");
			for (int i = 1; i < lstEle.size(); i++) {
				String str1 = lstEle.get(i - 1).trim();
				String str2 = lstEle.get(i).trim();
				Date date1 = format.parse(str1);
				Date date2 = format.parse(str2);
				if (date1.before(date2)) {
					System.out.println(str1);
					System.out.println(str2);
					sorted = false;
					break;
				}
			}
			return sorted;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean verifyDateAscendingOrder(List<String> lstEle, String type) {
		try {
			boolean sorted = true;
			SimpleDateFormat format;
			if(type.equals("submitted"))
				format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			else 
				format = new SimpleDateFormat("MM/dd/yyyy");
			for (int i = 1; i < lstEle.size(); i++) {
				String str1 = lstEle.get(i - 1);
				String str2 = lstEle.get(i);
				Date date1 = format.parse(str1);
				Date date2 = format.parse(str2);
				if (date1.after(date2)) {
					System.out.println(date1);
					System.out.println(date2);
					sorted = false;
					break;
				}
			}
			return sorted;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	public void clickRequestStatus(String status) {
//		String requestStatusXPath = String.format(requestStatus, status);
//		driver.findElement(By.xpath(requestStatusXPath)).click();
//	}
//
//	public void changeToRequestStatus(String status) {
//		String requestStatusItemXPath = String.format(statusItem, status);
//		driver.findElement(By.xpath(requestStatusItemXPath)).click();
//		// Assert.assertTrue(condition);
//	}
}