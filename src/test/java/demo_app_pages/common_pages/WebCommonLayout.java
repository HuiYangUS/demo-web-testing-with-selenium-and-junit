package demo_app_pages.common_pages;

import org.openqa.selenium.By;

public class WebCommonLayout extends BasePage {

	private By logoutButton = By.xpath("//a[contains(text(), 'Log Out')]");

	public void clickLogoutButton() {
		click(logoutButton);
	}

}
