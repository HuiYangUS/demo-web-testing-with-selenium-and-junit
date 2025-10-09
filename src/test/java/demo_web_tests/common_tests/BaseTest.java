package demo_web_tests.common_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getDemoAppURL());
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

}
