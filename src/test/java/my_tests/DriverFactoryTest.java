package my_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import utilities.CommonTestLibrary;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class DriverFactoryTest {

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = DriverFactory.getDriver();
		// Open test app
		driver.get(ConfigReader.getTestURL());
	}

	@AfterEach
	void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

	@Test
	@Tag("parallel")
	public void runTestA() {
		CommonTestLibrary.waitInSecondsFor(3);
		System.out.println("Web test A passed.");
	}

	@Test
	@Tag("parallel")

	public void runTestB() {
		CommonTestLibrary.waitInSecondsFor(3);
		System.out.println("Web test B passed.");
	}

	@Test
	@Tag("parallel")
	public void runTestC() {
		CommonTestLibrary.waitInSecondsFor(3);
		System.out.println("Web test C passed.");
	}

}
