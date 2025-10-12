package my_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.ConfigReader;

public class ProjectConfigTest {

	@Test
	public void findConfigFile() {
		String targetTestValue = ConfigReader.getTestValue();
		assertNotNull(targetTestValue, "Test value failed to be located on config file!");
		System.out.println("Test value = " + targetTestValue);
	}

}
