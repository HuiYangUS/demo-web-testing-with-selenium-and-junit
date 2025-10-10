package demo_web_tests.common_tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utilities.CommonTestLibrary;
import utilities.DriverFactory;

public class FailedTestExtension implements AfterTestExecutionCallback {

	private WebDriver driver = DriverFactory.getDriver();

	/*
	 * Scenario: When a test failed, a screenshot is taken.
	 */
	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		String imgFileName = context.getDisplayName().replace(" ", "_").replace("()", "") + "_failed-"
				+ CommonTestLibrary.getTestDateString() + "-" + System.currentTimeMillis();
		if (context.getExecutionException().isPresent()) {
			try {
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("target/test-screenshots/" + imgFileName + ".png"));
			} catch (IOException e) {
				System.err.println("Selenium WebDriver failed to take a screenshot!");
				e.printStackTrace();
			}
		}
	}

}
