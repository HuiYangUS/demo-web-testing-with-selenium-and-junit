package demo_app_pages.common_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.CommonTestLibrary;

public class TopNavBar extends BasePage {

	private By logoutButton = By.xpath("//a[contains(text(), 'Log Out')]");

	public void clickLogoutButton() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
		CommonTestLibrary.waitInSecondsFor(1);
		click(logoutButton);
	}

}
