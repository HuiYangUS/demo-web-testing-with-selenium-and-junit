package behavior_driven_development_with_cucumber.test_runners;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber") // Use Cucumber Test Engine for test detection
@SelectPackages("features") // Feature files directory path
// Step definitions path: Separated by comma between each directory
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "behavior_driven_development_with_cucumber.step_definitions")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/my-cucumber-report.html")
public class MyTestRunner {

}
