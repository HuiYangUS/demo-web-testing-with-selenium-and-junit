package my_test_suites;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Demo Parallel Test Set V2")
@SelectPackages("demo_web_tests.regression_tests")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.enabled", value = "true")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.mode.default", value = "concurrent")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.strategy", value = "fixed")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.fixed.parallelism", value = "2")
@ConfigurationParameter(key = "junit.jupiter.execution.parallel.config.fixed.max-pool-size", value = "3")
public class MyV2ParallelTestSuite {

}
