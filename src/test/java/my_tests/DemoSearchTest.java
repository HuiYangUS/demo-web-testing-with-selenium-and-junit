package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import demo_app_pages.demo_pages.TargetMainPage;
import demo_web_tests.common_tests.PseudoBaseTest;

public class DemoSearchTest extends PseudoBaseTest {

	protected TargetMainPage targetPage = new TargetMainPage();

	/*
	 * Scenario: This test serves as a demo as well as testing on failed test
	 * extension.
	 */
	@ParameterizedTest
	@DisplayName("Test demo web search")
	@ValueSource(strings = { "Batman", "Brassiere", "Cheese" })
	public void runTest(String searchValue) {
		targetPage.typeIntoSearchTextbox(searchValue);
		targetPage.pressEnterToSearch();
		targetPage.waitForSearchResultsToBeVisible();
		String targetValue = targetPage.getSearchTermText();
		assertTrue(targetValue.contains(searchValue),
				"Failed to locate the search term value, but found: " + targetValue);
		System.out.println("Search for: " + targetValue);
		if (targetValue.equals("Cheese")) {
			fail("I hate cheese!");
		}
	}

}
