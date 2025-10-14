package demo_app_pages.demo_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class TargetMainPage extends BasePage {

	private By searchTextbox = By.xpath("//input[@type='search']");
	private By searchTermResultsValue = By.xpath("//h2/span[contains(text(), 'results')]");
	private By searchTerm = By.xpath("//h2/span[contains(text(), 'results')]/../following-sibling::span");

	public void typeIntoSearchTextbox(String data) {
		typeTextTo(searchTextbox, data);
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void pressEnterToSearch() {
		pressEnterTo(searchTextbox);
		CommonTestLibrary.waitInSecondsFor(3);
	}

	public void waitForSearchResultsToBeVisible() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(searchTermResultsValue));
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public String getSearchTermText() {
		String uneditedText = locate(searchTerm).getText().replace("for", "").trim();
		String uneditedTextV2 = uneditedText.substring(1);
		String editedText = uneditedTextV2.substring(0, uneditedTextV2.length() - 1);
		return editedText;
	}

}
