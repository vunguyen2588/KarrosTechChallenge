package sample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
          ExpectedCondition<Boolean>() {
              public Boolean apply(WebDriver driver) {
                  return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
              }
          };
          WebDriverWait wait = new WebDriverWait(driver, 30);
          wait.until(pageLoadCondition);
	}
}
