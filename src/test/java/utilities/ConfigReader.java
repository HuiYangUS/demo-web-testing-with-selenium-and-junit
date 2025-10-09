package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static String configFilePath = "src/test/resources/config.properties";
	private static Properties p = new Properties();;

	private static void load() {
		try {
			p.load(new FileInputStream(new File(configFilePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Test config file not found!");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Target values failed to be located in test config file!");
		}
	}

	private static String read(String key) {
		load();
		return p.getProperty(key);
	}

	public static String getTestValue() {
		return read("test");
	}

	public static String getTestURL() {
		return read("testURL");
	}

	public static String getBrowser() {
		return read("browser");
	}

	public static String getBrowserVersion() {
		return read("browserVersion");
	}

}
