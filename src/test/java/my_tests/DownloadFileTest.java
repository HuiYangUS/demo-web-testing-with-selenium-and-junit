package my_tests;

import org.junit.jupiter.api.Test;

import utilities.DownloadFolderWatcher;

public class DownloadFileTest {

	@Test
	public void runTest() {
		DownloadFolderWatcher.findDownloadedFileFor(".xlsx");
	}

}
