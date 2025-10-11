package utilities;

import demo_app_pages.common_pages.LoginPage;
import demo_app_pages.common_pages.TopNavBar;
import demo_app_pages.demo_pages.TargetMainPage;
import demo_app_pages.home_pages.HomePage;
import demo_app_pages.work_items_pages.WorkItemsPage;

public class PageManager {

	private static TargetMainPage targetPage;
	private static TopNavBar topNavBar;
	private static LoginPage loginPage;
	private static HomePage homePage;
	private static WorkItemsPage workItemsPage;

	private PageManager() {
		// Singleton
	}

	public static TopNavBar findTopNavBar() {
		if (topNavBar == null) {
			topNavBar = new TopNavBar();
		}
		return topNavBar;
	}

	public static LoginPage findloginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public static HomePage findHomePage() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}

	public static WorkItemsPage findWorkItemsPage() {
		if (workItemsPage == null) {
			workItemsPage = new WorkItemsPage();
		}
		return workItemsPage;
	}

	public static TargetMainPage findTargetPage() {
		if (targetPage == null) {
			targetPage = new TargetMainPage();
		}
		return targetPage;
	}

	public static void forgetAllPages() {
		if (targetPage != null) {
			targetPage = null;
		}
	}

}