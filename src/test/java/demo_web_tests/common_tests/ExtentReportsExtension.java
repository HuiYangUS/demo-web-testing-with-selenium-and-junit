package demo_web_tests.common_tests;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportsExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	ExtentTest extentTest;

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		if (ExtentReportsBaseTestSuite.extentReports != null)
			extentTest = ExtentReportsBaseTestSuite.extentReports.createTest(context.getDisplayName());
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		if (ExtentReportsBaseTestSuite.extentReports != null) {
			if (context.getExecutionException().isPresent()) {
				extentTest.log(Status.FAIL, context.getExecutionException().get());
			} else {
				extentTest.log(Status.PASS, context.getDisplayName());
			}
		}

	}

}
