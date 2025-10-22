package behavior_driven_development_with_cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;

public class DemoSteps {

	static String productA = "tea";
	static String productB = "coffee";
	static String productC = "water";
	static List<String> productList = new ArrayList<>(Arrays.asList(productA, productB, productC));
	static Map<String, Integer> inventory = new HashMap<>() {
		{
			put(productA, 2);
			put(productB, 1);
			put(productC, 4);
		}
	};

	String targetProduct;

	@Given("a user asks for {string}")
	public void a_user_asks_for(String productName) {
		assertTrue(productList.contains(productName.toLowerCase()), "We do NOT have it!");
		targetProduct = productName.toLowerCase();
	}

	@When("a server checks the inventory")
	public void a_server_checks_the_inventory() {
		int currentNum = inventory.get(targetProduct);
		assertTrue(currentNum > 0, "We ran out of " + targetProduct + "!");
		inventory.put(targetProduct, --currentNum);
	}

	@Then("the order is served")
	public void the_order_is_served() {
		System.out.println("Your " + targetProduct + " is here.");
	}

}
