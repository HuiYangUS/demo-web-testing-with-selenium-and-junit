package demo_web_tests.regression_tests.customer_service_menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import demo_app_pages.customer_service_pages.CustomerServicePage;
import demo_app_pages.home_pages.HomePage;
import demo_web_tests.common_tests.WebBaseTest;
import utilities.CommonTestLibrary;

public class CustomerServiceTests extends WebBaseTest {

	HomePage homePage = new HomePage();
	CustomerServicePage customerServicePage = new CustomerServicePage();

	@ParameterizedTest
	@CsvFileSource(files = "src/test/resources/test-data/my-data/Data_Driven_Test.csv", numLinesToSkip = 1)
	@DisplayName("Test a customer service representative takes a caller's information")
	@Tags({ @Tag("regression"), @Tag("ID1003"), @Tag("active") })
	public void enterCallerInformation(String name, String city, String status) {
		homePage.clickCustomerServiceButton();
		customerServicePage.waitForPageTileToBeVisible();
		customerServicePage.typeTextToCallerNameTextbox(name);
		customerServicePage.typeTextToCallerCityTextbox(city);
		customerServicePage.typeTextToCallerStatusTextbox(status);
		CommonTestLibrary.waitInSecondsFor(3);
	}

}
