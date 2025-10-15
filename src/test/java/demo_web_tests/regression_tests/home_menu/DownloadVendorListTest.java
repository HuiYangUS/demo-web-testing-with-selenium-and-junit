package demo_web_tests.regression_tests.home_menu;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import demo_app_pages.home_pages.HomePage;
import demo_web_tests.common_tests.WebBaseTest;
import utilities.DownloadsFolderWatcher;
import utilities.FileExtension;
import utilities.WorkbookLibrary;

@TestMethodOrder(OrderAnnotation.class)
public class DownloadVendorListTest extends WebBaseTest {

	HomePage homePage = new HomePage();

	@Test
	@Order(1)
	@DisplayName("Test a user downloads and then view the vendor list")
	@Tags({ @Tag("regression"), @Tag("ID1002"), @Tag("active") })
	public void downloadThenViewVendorList() throws InterruptedException {
		homePage.hoverVendorsButton();
		DownloadsFolderWatcher.registerDownloadsFolder();
		homePage.clickDownloadVendorListDropdownLinkButton();
		String targetFileName = DownloadsFolderWatcher.findDownloadedFileFor(FileExtension.EXCEL);
		assertNotNull(targetFileName, "Target file not found!");
		assertTrue(targetFileName.contains("Vendor List"), "Wrong file!");
		String targetFilePath = "C:/Users/" + System.getProperty("user.name") + "/Downloads/" + targetFileName;
		System.out.println("Read file at --> " + targetFilePath);
		XSSFWorkbook targetWorkbook = WorkbookLibrary.findWorkbookFromFilePath(targetFilePath);
		try {
			XSSFSheet dataSheet = targetWorkbook.getSheet("Vendor list");
			int dataRowCount = dataSheet.getLastRowNum();
			assertTrue(dataRowCount > 0);
			System.out.println("Number of data rows = " + dataRowCount);
			int columnCount = WorkbookLibrary.findColumnHeaders(dataSheet).size();
			assertTrue(columnCount > 0);
			System.out.println("Number of data columns = " + columnCount);

			WorkbookLibrary.closeWorkbook(targetWorkbook);
		} catch (Exception e) {
			System.err.println("Failed to read target workbook!");
			WorkbookLibrary.closeWorkbook(targetWorkbook);
		}
	}

}
