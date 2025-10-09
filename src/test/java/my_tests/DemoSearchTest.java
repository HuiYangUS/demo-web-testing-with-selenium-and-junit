package my_tests;

import org.junit.jupiter.api.Test;

import demo_app_pages.demo_pages.TargetMainPage;
import demo_web_tests.common_tests.PseudoBaseTest;
import utilities.PageManager;

public class DemoSearchTest extends PseudoBaseTest {

	protected TargetMainPage targetPage = PageManager.findTargetPage();

	@Test
	public void runTest() {
		targetPage.typeIntoSearchTextbox("Batman");
		targetPage.pressEnterToSearch();
	}

}