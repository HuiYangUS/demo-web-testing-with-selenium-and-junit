package my_tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utilities.WorkbookLibrary;

public class WorkbookTest {

	@Test
	@DisplayName("Demo Apache POI")
	public void readExcel() {
		int rowCount = 0;
		XSSFWorkbook targetWorkbook = null;
		try {
			targetWorkbook = WorkbookLibrary
					.findWorkbookFromFilePath("src/test/resources/test-data/my-data/POI-Test.xlsx");
			XSSFSheet dataSheet = targetWorkbook.getSheet("Test Data");
			rowCount = dataSheet.getLastRowNum();

			String targetColumnHeader = dataSheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println("Target column header = " + targetColumnHeader + "\n");

			// Skip headers
			for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
				for (int columnIndex = 0; columnIndex < dataSheet.getRow(rowIndex).getLastCellNum(); columnIndex++) {
					// Print all cell values across a row
					System.out.print(dataSheet.getRow(rowIndex).getCell(columnIndex) + " ");
				}
				System.out.println();
			}
			targetWorkbook.close();
		} catch (IOException e) {
			WorkbookLibrary.closeWorkbook(targetWorkbook);
		}
		assertTrue(rowCount > 0, "No data found.");
		System.out.println("\nNumber of data rows = " + rowCount);
	}

}
