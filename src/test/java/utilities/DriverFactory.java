package utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	private DriverFactory() {
		// Singleton
	}

	public static WebDriver getDriver() {
		if (threadLocalDriver.get() == null) {
			String browser = ConfigReader.getBrowser().toLowerCase();
			switch (browser) {
			case "chrome": {
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.password_manager_leak_detection", false);
				options.setExperimentalOption("prefs", prefs);
				options.setBrowserVersion(ConfigReader.getBrowserVersion());
				if (isAutomatedChromeHeadless()) {
					options.addArguments("--headless");
				}
				ChromeDriver driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				threadLocalDriver.set(driver);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + browser);
			}
		}
		return threadLocalDriver.get();
	}

	public static void shutDownAllDrivers() {
		if (threadLocalDriver.get() != null) {
			threadLocalDriver.get().quit();
			threadLocalDriver.set(null);
		}
	}

	private static boolean isAutomatedChromeHeadless() {
		String targetValue = System.getProperty("headless");
		boolean isChromeHeadless = false;
		if (targetValue != null) {
			try {
				isChromeHeadless = Boolean.parseBoolean(targetValue);
			} catch (Exception e) {
				System.err.println("Failed to locate automated chrome status, default to GUI.");
			}
		}
		return isChromeHeadless;
	}

}
