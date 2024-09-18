package stepDefinitions;

import io.cucumber.java.After;
import utilities.DriverFactory;

public class Hooks {

	@After
	public void afterScenario() {
		DriverFactory.quitDriver();
	}

}
