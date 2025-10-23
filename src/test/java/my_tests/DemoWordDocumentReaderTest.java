package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utilities.DocumentLibrary;

public class DemoWordDocumentReaderTest {

	@Test
	@DisplayName("Test a user to read a .docx file")
	public void readDocxTest() {
		String targetFilePath = "src/test/resources/test-data/my-data/test-doc.docx";
		String targetContent = DocumentLibrary.getDocumentContentFromFilePath(targetFilePath);
		assertNotNull(targetContent, "There is no content in this document.");
		System.out.println(targetContent);
	}

}
