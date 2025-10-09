package demo_web_tests.common_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class PseudoBaseTest {

	protected WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.target.com/");
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

}
