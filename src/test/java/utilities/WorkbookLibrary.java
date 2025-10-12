package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkbookLibrary {

	public static XSSFWorkbook findWorkbookFromFilePath(String targetFilePath) {
		try {
			XSSFWorkbook targetWorkbook = new XSSFWorkbook(targetFilePath);
			return targetWorkbook;
		} catch (IOException e) {
			throw new RuntimeException("Failed to locate target workbook!");
		}
	}

	public static List<String> findColumnHeaders(XSSFSheet dataSheet) {
		List<String> columnHeaders = new ArrayList<>();
		for (int i = 0; i < dataSheet.getRow(0).getLastCellNum(); i++) {
			String tempCellValue = getCellValueAsString(dataSheet.getRow(0).getCell(i));
			columnHeaders.add(tempCellValue);
		}
		return columnHeaders;
	}

	public static void closeWorkbook(XSSFWorkbook targetWorkbook) {
		try {
			targetWorkbook.close();
		} catch (IOException e) {
			throw new RuntimeException("Failed to close target workbook.");
		}

	}

	public static String getCellValueAsString(Cell cell) {
		String targetValue = "";

		switch (cell.getCellType()) {
		case STRING: {
			targetValue = cell.getStringCellValue();
			break;
		}
		case BOOLEAN: {
			targetValue = String.valueOf(cell.getBooleanCellValue());
			break;
		}
		case NUMERIC: {
			if (DateUtil.isCellDateFormatted(cell)) {
				targetValue = new SimpleDateFormat("MM/dd/yyyy").format(cell.getDateCellValue());
			} else {
				targetValue = String.valueOf(cell.getNumericCellValue());
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
		}

		return targetValue;
	}

}
