package demo_web_tests.regression_tests.work_items_menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import demo_app_pages.home_pages.HomePage;
import demo_app_pages.work_items_pages.WorkItemsPage;
import demo_web_tests.common_tests.WebBaseTest;
import utilities.PageManager;

public class WorkItemsTest extends WebBaseTest {

	HomePage homePage = PageManager.findHomePage();
	WorkItemsPage workItemsPage = PageManager.findWorkItemsPage();

	@Test
	@DisplayName("Test a user views current assigned work items")
	@Tags({ @Tag("regression"), @Tag("ID1001"), @Tag("active") })
	public void ViewWorkItems() {
		homePage.clickWorkItemsButton();
		workItemsPage.waitForPageTileToBeVisible();
		workItemsPage.waitForDescriptionColumnHeaderToBeVisible();
		List<String> workItems = workItemsPage.findAllWorkItemsFromOpeningPage();
		assertTrue(workItems.size() > 0, "Failed to locate any work item!");
		for (String workItem : workItems) {
			System.out.println("Work Item = " + workItem);
		}
	}

}
