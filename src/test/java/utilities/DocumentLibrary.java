package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocumentLibrary {

	public static XWPFDocument findDocumentFromFilePath(String targetFilePath) {
		try {
			XWPFDocument targetDocument = new XWPFDocument(new FileInputStream(targetFilePath));
			return targetDocument;
		} catch (IOException e) {
			throw new RuntimeException("Failed to locate target document!");
		}
	}

	public static String getDocumentContentFromFilePath(String targetFilePath) {
		String targetContent = null;
		XWPFWordExtractor extractor = new XWPFWordExtractor(findDocumentFromFilePath(targetFilePath));
		targetContent = extractor.getText();
		try {
			extractor.close();
		} catch (IOException e) {
			throw new RuntimeException("Failed to close the document extractor!");
		}
		return targetContent;
	}

}
