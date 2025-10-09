package demo_app_pages.common_pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.DriverFactory;

public class BasePage {

	public static WebDriver driver = DriverFactory.getDriver();

	protected WebElement locate(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> locateMany(By locator) {
		return driver.findElements(locator);
	}

	protected void typeTextTo(By locator, String data) {
		locate(locator).clear();
		locate(locator).sendKeys(data);
	}

	protected void typeTextThenEnter(By locator, String data) {
		locate(locator).clear();
		locate(locator).sendKeys(data + Keys.ENTER);
	}

	protected void pressEnterTo(By locator) {
		locate(locator).sendKeys(Keys.ENTER);
	}

	protected void click(By locator) {
		locate(locator).click();
	}

	protected void hover(By locator) {
		new Actions(driver, Duration.ofSeconds(1)).moveToElement(locate(locator)).perform();
	}

}
