package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo_app_pages.demo_pages.TargetMainPage;
import demo_web_tests.common_tests.PseudoBaseTest;

public class DemoSearchTest extends PseudoBaseTest {

	protected TargetMainPage targetPage = new TargetMainPage();

	/*
	 * Scenario: This test serves as a demo as well as testing on failed test
	 * extension.
	 */
	@Test
	@DisplayName("Test demo web search")
	public void runTest() {
		targetPage.typeIntoSearchTextbox("Batman");
		targetPage.pressEnterToSearch();
		fail();
	}

}
