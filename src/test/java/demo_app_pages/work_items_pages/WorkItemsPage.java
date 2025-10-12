package demo_app_pages.work_items_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class WorkItemsPage extends BasePage {

	private By pageTitle = By.xpath("//h1[contains(text(), 'Work Items')]");
	private By descriptionColumnHeader = By.xpath("//table/tbody//tr/th[3][text()='Description']");
	private By descriptionColumn = By.xpath("//table/tbody//tr/td[3]");

	public void waitForPageTileToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void waitForDescriptionColumnHeaderToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(descriptionColumnHeader));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public List<String> findAllWorkItemsFromOpeningPage() {
		List<WebElement> workItemsList = driver.findElements(descriptionColumn);
		List<String> workDescriptionList = new ArrayList<>();
		for (WebElement workItem : workItemsList) {
			workDescriptionList.add(workItem.getText());
		}
		return workDescriptionList;
	}

}
