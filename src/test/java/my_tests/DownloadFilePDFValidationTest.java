package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonTestLibrary;
import utilities.DownloadsFolderWatcher;
import utilities.DriverFactory;
import utilities.FileExtension;

public class DownloadFilePDFValidationTest {

	WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/download-file-demo");
	}

	@AfterEach
	public void tearDown() {
		DriverFactory.shutDownAllDrivers();
	}

	@Test
	@DisplayName("Test a user downloads a PDF file then validates its content")
	@Tag("pdf")
	public void runTest() throws IOException, InterruptedException {
		By pageTitle = By.xpath("//h1[text()='Download File Demo']");
		By downloadFileButton = By.xpath("//button[text()='Download File']");
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pageTitle));
		CommonTestLibrary.waitInSecondsFor(1);
		DownloadsFolderWatcher.registerDownloadsFolder();
		driver.findElement(downloadFileButton).click();
		String targetFileName = DownloadsFolderWatcher.findDownloadedFileFor(FileExtension.PDF);
		System.out.println("File name = " + targetFileName);
		String targetFilePath = "C:/Users/" + System.getProperty("user.name") + "/Downloads/" + targetFileName;
		System.out.println("Read file at --> " + targetFilePath);
		PDDocument pdDocument = Loader.loadPDF(new File(targetFilePath));
		PDFTextStripper textStripper = new PDFTextStripper();
		String contentPDF = textStripper.getText(pdDocument);
		assertNotNull(contentPDF, "There is no data in this PDF file.");
		System.out.println(contentPDF);
	}

}
