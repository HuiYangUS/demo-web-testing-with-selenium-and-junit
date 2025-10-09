package my_tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import utilities.ConfigReader;

public class ConfigTest {

	@Test
	public void runTest() {
		String targetTestValue = ConfigReader.getTestValue();
		assertNotNull(targetTestValue, "Test value failed to be located on config file!");
		System.out.println("Test value = " + targetTestValue);
	}

}
