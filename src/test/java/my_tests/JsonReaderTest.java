package my_tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import pojos.UserPolicyFilter;
import tools.jackson.databind.ObjectMapper;

public class JsonReaderTest {

	@Test
	public void runTest() {
		ObjectMapper objectMapper = new ObjectMapper();
		File jsonFile = new File("src/test/resources/test-data/my-data/auto_select_certificate.json");
		UserPolicyFilter targetFilter = objectMapper.readValue(jsonFile, UserPolicyFilter.class);
		System.out.println(objectMapper.readTree(jsonFile).toPrettyString());
		System.out.println("\n" + targetFilter.filter.ISSUER.CN);
		System.out.println(targetFilter.filter.SUBJECT.CN);
		System.out.println(objectMapper.readTree(jsonFile).toString());

		Map<String, Object> autoSelectCert = new HashMap<>();
		autoSelectCert.put("pattern", "https://your.website.com/*");
		Map<String, Object> filter = new HashMap<>();
		Map<String, Object> issuer = new HashMap<>();
		Map<String, Object> subject = new HashMap<>();

		issuer.put("CN", "Your Certificate Issuer CN");
		subject.put("CN", "Your Certificate Issued Subject CN");
		filter.put("ISSUER", issuer);
		filter.put("SUBJECT", subject);
		autoSelectCert.put("filter", filter);

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("auto_select_certificate_for_urls", autoSelectCert);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
	}

}
