package utilities;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DownloadFolderWatcher {

	public static String findDownloadedFileFor(String fileExtension) {
		String targetFileName = null;
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path targetFolderPath = Paths.get(System.getProperty("user.home"), "Downloads");
			targetFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY);
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
				if (targetFileName.contains(fileExtension)) {
					System.out.println("Target downloaded file was found.");
					break;
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException("Target downloaded file not found!");
		}
		return targetFileName;
	}

}
