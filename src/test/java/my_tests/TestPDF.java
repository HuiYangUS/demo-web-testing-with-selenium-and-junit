package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

public class TestPDF {

	@Test
	public void readPDF() {
		PDDocument pdDocument = null;
		try {
			pdDocument = Loader.loadPDF(new File("src/test/resources/test-data/my-data/git-cheat-sheet-education.pdf"));
		} catch (IOException e) {
			System.err.println("Failed to load target PDF file");
		}
		String contentPDF = null;
		PDFTextStripper textStripper = new PDFTextStripper();
		try {
			contentPDF = textStripper.getText(pdDocument);
		} catch (IOException e) {
			System.err.println("Failed to extract textual content from a PDF file");
		}
		assertNotNull(contentPDF, "There is no data in this PDF file.");
		System.out.println(contentPDF);
	}

}
