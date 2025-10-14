package demo_web_tests.regression_tests.customer_service_menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import demo_app_pages.customer_service_pages.CustomerServicePage;
import demo_app_pages.home_pages.HomePage;
import demo_web_tests.common_tests.WebBaseTest;
import utilities.CommonTestLibrary;

@SuppressWarnings("unused")
public class CustomerServiceTests extends WebBaseTest {

	HomePage homePage = new HomePage();
	CustomerServicePage customerServicePage = new CustomerServicePage();

	@ParameterizedTest
	@CsvFileSource(files = "src/test/resources/test-data/my-data/Data_Driven_Test.csv", numLinesToSkip = 1)
//	@CsvSource({ "Bat, Gotham, On Hold" })
	@DisplayName("Test a customer service representative takes a caller's information")
	@Tags({ @Tag("regression"), @Tag("ID1003"), @Tag("active") })
	public void enterCallerInformation(String name, String city, String status) {
		homePage.clickCustomerServiceButton();
		customerServicePage.waitForPageTileToBeVisible();
		System.out.println("Incoming phone status (before call): " + customerServicePage.getIncomingPhoneCallStatus());
		customerServicePage.typeTextToCallerNameTextbox(name);
		customerServicePage.typeTextToCallerCityTextbox(city);
		customerServicePage.typeTextToCallerStatusTextbox(status);
		CommonTestLibrary.waitInSecondsFor(1);
		String incomingPhoneNumber = customerServicePage.getPhoneNumber();
		assertTrue(incomingPhoneNumber.contains("No"), "There is no call yet.");
		customerServicePage.triggerMockPhoneCall();
		CommonTestLibrary.waitInSecondsFor(3);
		incomingPhoneNumber = customerServicePage.getPhoneNumber();
		assertFalse(incomingPhoneNumber.contains("No"), "Where is my number?");
		System.out.println("Incoming phone number: " + incomingPhoneNumber);
		System.out.println("Incoming phone status (call trigger): " + customerServicePage.getIncomingPhoneCallStatus());
	}

}
