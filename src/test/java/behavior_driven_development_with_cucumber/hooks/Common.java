package behavior_driven_development_with_cucumber.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Common {

	@Before(order = 1)
	public void setUp() {
		System.out.println("1st Order:");
	}

	@Before(order = 2)
	public void setUpV2() {
		System.out.println("2nd Order:");
	}

	@After(order = 2)
	public void tearDown() {
		System.out.println("1st Order: completed");
	}

	@After(order = 1)
	public void tearDownV2() {
		System.out.println("2nd Order: completed");
	}

}
