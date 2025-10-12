package utilities;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DownloadsFolderWatcher {

	private static WatchService watchService;

	public static void registerDownloadsFolder() {
		try {
			watchService = FileSystems.getDefault().newWatchService();
			Path targetFolderPath = Paths.get(System.getProperty("user.home"), "Downloads");
			targetFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("Failed to locate the Downloads folder.");
		}
	}

	public static String findDownloadedFileFor(FileExtension extension) {
		String targetFileName = null;
		try {
			long startTime = System.currentTimeMillis();
			long endTime = startTime + 30 * 1000;
			while (System.currentTimeMillis() < endTime) {
				WatchKey key = watchService.take();

				for (WatchEvent<?> event : key.pollEvents()) {
					// Handle the specific event
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						targetFileName = event.context().toString();
						System.out.println("File created: " + targetFileName);
					} else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
						targetFileName = event.context().toString();
						System.out.println("File modified: " + event.context());
					}

					// To receive further events, reset the key
					key.reset();
				}
				if (targetFileName.contains(FileExtension.EXCEL.extension) && !targetFileName.contains(".crdownload")) {
					System.out.println("Target downloaded file was found.");
					break;
				}
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
			throw new RuntimeException("Failed to finish scanning the Downloads folder.");
		}
		return targetFileName;
	}

}
