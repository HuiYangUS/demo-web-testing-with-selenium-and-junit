package demo_app_pages.home_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class HomePage extends BasePage {

	private WebDriverWait pageWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	private By pageTitle = By.xpath("//h1[contains(text(), 'Dashboard')]");
	@SuppressWarnings("unused")
	private By welcomeMessage = By.xpath("//h1[contains(text(), 'Welcome')]");
	private By workItemsButton = By.xpath("//a/button/i[contains(@class, 'folder-open')]/..");
	private By vendorsButton = By.xpath("//button/i[contains(@class, 'truck')]/..");
	private By downloadVendorListDropdownLinkButton = By.xpath("//a[text()='Download Vendor List']");
	private By customerServiceButton = By.xpath("//a/button/i[contains(@class, 'phone')]/..");

	public void waitForPageTileToBeVisible() {
		pageWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void clickWorkItemsButton() {
		click(workItemsButton);
	}

	public void hoverVendorsButton() {
		hover(vendorsButton);
	}

	public void clickDownloadVendorListDropdownLinkButton() {
		click(downloadVendorListDropdownLinkButton);
	}

	public void clickCustomerServiceButton() {
		click(customerServiceButton);
	}

}
