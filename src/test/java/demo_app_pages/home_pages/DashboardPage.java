package demo_app_pages.home_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class DashboardPage extends BasePage {

	private By pageTitle = By.xpath("//h1[contains(text(), 'Dashboard')]");

	public void waitForPageTileToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
	}

}