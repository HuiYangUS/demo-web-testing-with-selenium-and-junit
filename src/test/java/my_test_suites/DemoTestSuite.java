package my_test_suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Demo Test Set")
@SelectPackages("demo_web_tests.smoke_tests")
public class DemoTestSuite {

}
