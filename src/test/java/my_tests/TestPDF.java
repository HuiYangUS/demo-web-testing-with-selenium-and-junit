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
	public void readPDF() throws IOException {
		PDDocument pdDocument = Loader
				.loadPDF(new File("src/test/resources/test-data/my-data/git-cheat-sheet-education.pdf"));
		PDFTextStripper textStripper = new PDFTextStripper();
		String contentPDF = textStripper.getText(pdDocument);
		assertNotNull(contentPDF, "There is no data in this PDF file.");
		System.out.println(contentPDF);
	}

}
