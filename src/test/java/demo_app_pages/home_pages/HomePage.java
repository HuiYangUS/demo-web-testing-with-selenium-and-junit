package demo_app_pages.home_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class HomePage extends BasePage {

	private By pageTitle = By.xpath("//h1[contains(text(), 'Dashboard')]");
	@SuppressWarnings("unused")
	private By welcomeMessage = By.xpath("//h1[contains(text(), 'Welcome')]");
	private By workItemsButton = By.xpath("//a/button/i[contains(@class, 'folder-open')]/..");

	public void waitForPageTileToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void clickWorkItemsButton() {
		click(workItemsButton);
	}

}
