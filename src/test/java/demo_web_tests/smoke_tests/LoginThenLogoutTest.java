package demo_web_tests.smoke_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import demo_app_pages.common_pages.LoginPage;
import demo_app_pages.common_pages.TopNavBar;
import demo_app_pages.home_pages.HomePage;
import demo_web_tests.common_tests.BaseTest;
import utilities.CommonTestLibrary;
import utilities.ConfigReader;

public class LoginThenLogoutTest extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	TopNavBar topNavBar = new TopNavBar();

	@Test
	@DisplayName("Test a user login then logout successfully")
	@Tags({ @Tag("smoke"), @Tag("ID0001"), @Tag("active") })
	public void testUserLoginThenOutSuccessfully() {
		loginPage.waitForPageTileToBeVisible();
		loginPage.typeTextToEmailTextbox(ConfigReader.getUsername());
		loginPage.typeTextToPasswordTextbox(ConfigReader.getPassword());
		loginPage.clickLoginButton();
		homePage.waitForPageTileToBeVisible();
		CommonTestLibrary.waitInSecondsFor(3);
		topNavBar.clickLogoutButton();
		CommonTestLibrary.waitInSecondsFor(1);
		loginPage.waitForPageTileToBeVisible();
		CommonTestLibrary.waitInSecondsFor(1);
	}

}
