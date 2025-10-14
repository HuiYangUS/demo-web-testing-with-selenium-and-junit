package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonTestLibrary;
import utilities.DriverFactory;

public class UploadFileTest {

	WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

	@Disabled
	@Test
	@Tag("file")
	public void runTest() {
		By uploadFileButton = By.id("file");
		String targetFilePath = System.getProperty("user.dir").replace("\\", "/")
				+ "/src/test/resources/test-data/my-data/git-cheat-sheet-education.pdf";
		driver.findElement(uploadFileButton).sendKeys(targetFilePath);
		By confirmationMessage = By.id("error");
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmationMessage));
		CommonTestLibrary.waitInSecondsFor(1);
		String displayConfirmationMessage = driver.findElement(confirmationMessage).getText();
		assertEquals("File Successfully Uploaded", displayConfirmationMessage);
		CommonTestLibrary.waitInSecondsFor(3);
	}

	@Test
	@Tag("file")
	public void runTestV2() throws AWTException {
		By uploadFileButton = By.xpath("//input[@id='file']/..");
		String targetFilePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\test-data\\my-data\\git-cheat-sheet-education.pdf";
		driver.findElement(uploadFileButton).click();
		CommonTestLibrary.waitInSecondsFor(1);
		// Setup
		StringSelection stringSelection = new StringSelection(targetFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); // No signature
		// Paste target file path
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Submission
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		By confirmationMessage = By.id("error");
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmationMessage));
		CommonTestLibrary.waitInSecondsFor(1);
		String displayConfirmationMessage = driver.findElement(confirmationMessage).getText();
		assertEquals("File Successfully Uploaded", displayConfirmationMessage);
		CommonTestLibrary.waitInSecondsFor(3);
	}

}
