package demo_web_seqs.common_seqs;

import demo_app_pages.common_pages.LoginPage;
import demo_app_pages.common_pages.TopNavBar;
import demo_app_pages.home_pages.HomePage;
import utilities.CommonTestLibrary;
import utilities.ConfigReader;
import utilities.PageManager;

public class UserAccess {

	private static LoginPage loginPage = PageManager.findloginPage();
	private static HomePage homePage = PageManager.findHomePage();
	private static TopNavBar topNavBar = PageManager.findTopNavBar();

	public static void userLogin() {
		loginPage.waitForPageTileToBeVisible();
		loginPage.typeTextToEmailTextbox(ConfigReader.getUsername());
		loginPage.typeTextToPasswordTextbox(ConfigReader.getPassword());
		loginPage.clickLoginButton();
		homePage.waitForPageTileToBeVisible();
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public static void userLogout() throws Exception {
		topNavBar.clickLogoutButton();
		CommonTestLibrary.waitInSecondsFor(1);
		loginPage.waitForPageTileToBeVisible();
		CommonTestLibrary.waitInSecondsFor(1);
	}

}
