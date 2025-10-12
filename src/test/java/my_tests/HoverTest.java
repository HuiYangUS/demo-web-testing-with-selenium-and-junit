package my_tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.DriverFactory;

public class HoverTest {

	protected WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

	@Test
	@Tag("parallel")
	public void runTest() {
		By demoHoverButton = By.xpath(
				"//h2[text()='CSS Hover Effects on Button'][1]/following-sibling::div//div[text()='Hover Me'][contains(@class, 'hover:text-green-100')]");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(demoHoverButton)).pause(Duration.ofSeconds(1)).build().perform();
	}

}
