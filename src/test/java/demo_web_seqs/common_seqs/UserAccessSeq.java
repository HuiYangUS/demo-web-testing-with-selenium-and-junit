package demo_web_seqs.common_seqs;

import demo_app_pages.common_pages.LoginPage;
import demo_app_pages.common_pages.TopNavBar;
import demo_app_pages.home_pages.HomePage;
import utilities.CommonTestLibrary;
import utilities.ConfigReader;

/**
 * Warning: Without using PageManager, every web sequence must initialize all
 * the page objects that are being used.
 */
public class UserAccessSeq {

	public static void userLogin() {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		System.out.println("User accesses the login page.");
		loginPage.waitForPageTileToBeVisible();
		loginPage.typeTextToEmailTextbox(ConfigReader.getUsername());
		loginPage.typeTextToPasswordTextbox(ConfigReader.getPassword());
		loginPage.clickLoginButton();
		homePage.waitForPageTileToBeVisible();
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public static void userLogout() throws Exception {
		TopNavBar topNavBar = new TopNavBar();
		LoginPage loginPage = new LoginPage();
		topNavBar.clickLogoutButton();
		CommonTestLibrary.waitInSecondsFor(1);
		loginPage.waitForPageTileToBeVisible();
		CommonTestLibrary.waitInSecondsFor(1);
		System.out.println("User has successfully logged out.");
	}

}
