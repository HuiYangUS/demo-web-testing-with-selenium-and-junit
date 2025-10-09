package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.CommonTestLibrary;

public class MyFirstWebTest {

	WebDriver driver;

	@BeforeEach
	void setUp() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		options.setBrowserVersion("140");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// Login
		driver.get("https://www.saucedemo.com/");
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	public void demoLoginTest() {
		WebElement usernameTextbox = driver.findElement(By.id("user-name"));
		usernameTextbox.sendKeys("standard_user");
		WebElement passwordTextbox = driver.findElement(By.id("password"));
		passwordTextbox.sendKeys("secret_sauce");
		CommonTestLibrary.waitInSecondsFor(1);
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		CommonTestLibrary.waitInSecondsFor(3);
		WebElement pageTitle = driver.findElement(By.xpath("//*[@class=\"title\" and text()=\"Products\"]"));
		assertTrue(pageTitle.isDisplayed(), "Target page title not found!");
		System.out.println("Target page title found.");
	}

}
