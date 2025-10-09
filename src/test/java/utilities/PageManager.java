package utilities;

import demo_app_pages.demo_pages.TargetMainPage;

public class PageManager {

	private static TargetMainPage targetPage;

	private PageManager() {
		// Singleton
	}

	public static TargetMainPage findTargetPage() {
		if (targetPage == null) {
			targetPage = new TargetMainPage();
		}
		return targetPage;
	}

	public static void loseAllPages() {
		if (targetPage != null) {
			targetPage = null;
		}
	}

}