package demo_app_pages.common_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonTestLibrary;

public class LoginPage extends BasePage {

	private By pageTitle = By.xpath("//h1[contains(text(), 'Login')]");
	private By emailTextbox = By.id("email");
	private By passwordTextbox = By.id("password");
	private By loginButton = By.xpath("//button[@type='submit' and contains(text(), 'Login')]");

	public void waitForPageTileToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void typeTextToEmailTextbox(String email) {
		locate(emailTextbox).clear();
		typeTextTo(emailTextbox, email);
	}

	public void typeTextToPasswordTextbox(String password) {
		locate(passwordTextbox).clear();
		typeTextTo(passwordTextbox, password);
	}

	public void clickLoginButton() {
		click(loginButton);
	}

}
