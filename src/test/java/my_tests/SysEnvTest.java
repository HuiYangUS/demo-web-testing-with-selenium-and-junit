package my_tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SysEnvTest {

	@Test
	@DisplayName("Test to find a target environment variable")
	public void runTest() {
		String targetValue = System.getProperty("headless");
		assertNotNull(targetValue);
		boolean isChromeHeadless;
		try {
			isChromeHeadless = Boolean.parseBoolean(targetValue);
		} catch (Exception e) {
			throw new RuntimeException("Invalid automated chrome status");
		}
		if (isChromeHeadless) {
			assertTrue(isChromeHeadless);
		} else {
			assertFalse(isChromeHeadless);
		}
	}

}
