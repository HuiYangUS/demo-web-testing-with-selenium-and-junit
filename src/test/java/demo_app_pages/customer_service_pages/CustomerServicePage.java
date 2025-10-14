package demo_app_pages.customer_service_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class CustomerServicePage extends BasePage {

	private By pageTitle = By.xpath("//h1[contains(text(), 'Customer Service')]");
	private By callerNameTextbox = By.id("callername");
	private By callerCityTextbox = By.id("callercity");
	private By callerStatusTextbox = By.id("callerstatus");
	private By mockIncomingPhoneCallButton = By.id("btn-trigger");
	private By phoneNumber = By.id("phoneNumber");
	private By incomingCallStatus = By.id("incomingCallSpan");

	public void waitForPageTileToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void typeTextToCallerNameTextbox(String callerName) {
		typeTextTo(callerNameTextbox, callerName);
	}

	public void typeTextToCallerCityTextbox(String callerCity) {
		typeTextTo(callerCityTextbox, callerCity);
	}

	public void typeTextToCallerStatusTextbox(String callerStatus) {
		typeTextTo(callerStatusTextbox, callerStatus);
	}

	public void triggerMockPhoneCall() {
		click(mockIncomingPhoneCallButton);
	}

	public String getPhoneNumber() {
		return locate(phoneNumber).getText();
	}

	public String getIncomingPhoneCallStatus() {
		return locate(incomingCallStatus).getText();
	}

}
