package my_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.CommonTestLibrary;
import utilities.DriverFactory;

public class DemoSelectionsTest {

	WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/jquery-dual-list-box-demo");
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

	@Test
	@Tag("parallel")
	public void runTest() {
		By demoDataSelectionsBox = By.xpath("//div[@id='pickList']//select[contains(@class, 'pickData')]");
		Select demoDataSelections = new Select(driver.findElement(demoDataSelectionsBox));
		demoDataSelections.selectByVisibleText("West");
		By addButton = By.xpath("//button[text()='Add']");
		driver.findElement(addButton).click();
		CommonTestLibrary.waitInSecondsFor(1);
	}

}
