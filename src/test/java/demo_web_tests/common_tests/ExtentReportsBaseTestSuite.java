package demo_web_tests.common_tests;

import org.junit.platform.suite.api.AfterSuite;
import org.junit.platform.suite.api.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.CommonTestLibrary;

public class ExtentReportsBaseTestSuite {

	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;

	@BeforeSuite
	public static void setUpSuite() {
		String targetFileName = "my-extent-test-report-" + CommonTestLibrary.getTestDateString() + "-"
				+ System.currentTimeMillis();
		extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/target/extent-reports/" + targetFileName + ".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

		extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
		extentSparkReporter.config().setReportName("Test Report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		System.err.println("Created my extent report:");
	}

	@AfterSuite
	public static void tearDownSuite() {
		extentReports.flush();
	}

}
