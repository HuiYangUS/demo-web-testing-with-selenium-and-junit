package my_tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ProcessTest {

	@Test
	public void runTest() throws IOException {
		Process process = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		List<String> targetList = new ArrayList<>();
		while (true) {
			String targetName = input.readLine();
			if (targetName == null) {
				break;
			} else {
				targetList.add(targetName);
			}
		}
		input.close();

		for (String item : targetList) {
			System.out.println(item);
		}
	}

}
