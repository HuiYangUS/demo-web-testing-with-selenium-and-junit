package demo_web_tests.regression_tests.home_menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import demo_app_pages.home_pages.HomePage;
import demo_web_tests.common_tests.WebBaseTest;
import utilities.DownloadFolderWatcher;
import utilities.FileExtension;
import utilities.PageManager;

public class DownloadVendorListTest extends WebBaseTest {

	HomePage homePage = PageManager.findHomePage();

	@Test
	@DisplayName("Test a user downloads and then view the vendor list")
	@Tags({ @Tag("regression"), @Tag("ID1002"), @Tag("active") })
	public void downloadThenViewVendorList() {
		homePage.hoverVendorsButton();
		homePage.clickDownloadVendorListDropdownLinkButton();
		String targetFileName = DownloadFolderWatcher.findDownloadedFileFor(FileExtension.EXCEL);
		assertNotNull(targetFileName, "Target file not found!");
	}

}
