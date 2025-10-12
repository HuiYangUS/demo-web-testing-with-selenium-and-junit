package demo_web_tests.common_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import demo_web_seqs.common_seqs.UserAccessSeq;
import utilities.ConfigReader;
import utilities.DriverFactory;

@ExtendWith(FailedTestExtension.class)
public class WebBaseTest {

	protected WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getDemoAppURL());
		UserAccessSeq.userLogin();
	}

	@AfterEach
	public void tearDown() {
		try {
			UserAccessSeq.userLogout();
		} catch (Exception e) {
			System.err.println("User failed to logout!");
		}
		DriverFactory.shutDownAllDrivers();
	}

}
