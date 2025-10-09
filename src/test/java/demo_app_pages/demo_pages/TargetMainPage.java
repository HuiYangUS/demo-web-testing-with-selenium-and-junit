package demo_app_pages.demo_pages;

import org.openqa.selenium.By;

import demo_app_pages.common_pages.BasePage;
import utilities.CommonTestLibrary;

public class TargetMainPage extends BasePage {

	private By searchTextbox = By.xpath("//input[@type='search']");

	public void typeIntoSearchTextbox(String data) {
		typeTextTo(searchTextbox, data);
		CommonTestLibrary.waitInSecondsFor(1);
	}

	public void pressEnterToSearch() {
		pressEnterTo(searchTextbox);
		CommonTestLibrary.waitInSecondsFor(3);
	}

}
