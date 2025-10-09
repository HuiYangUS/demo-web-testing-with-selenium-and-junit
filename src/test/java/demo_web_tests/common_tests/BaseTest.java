package demo_web_tests.common_tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import demo_app_pages.common_pages.BasePage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected BasePage basePage;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getDemoAppURL());
	}

}
