package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverFactory;
import utilities.ManageWaits;
import utilities.PropertiesManager;

public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	private long timeout;

	// constructor to load Original WebDriver from DriverFactory class so that same
	// driver can be used for further testing
	public LoginSteps() throws IOException {
		this.driver = DriverFactory.getDriver();
		loginPage = new LoginPage(DriverFactory.getDriver());
		homePage = new HomePage(DriverFactory.getDriver());

		// To get Page Load Timeout value from config file
		String strTimeout = PropertiesManager.configProp().getProperty("timeout");
		this.timeout = Long.valueOf(strTimeout);

	}

	@Given("user is navigated to amazon home page")
	public void user_is_navigated_to_amazon_home_page() {
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));

			driver.get(PropertiesManager.configProp().getProperty("appURL"));
			Assert.assertTrue(true, "Page loaded successfully within time");
		} catch (Exception e) {
			System.out.println("Page Load timeout exceeded" + e.getMessage());
			Assert.fail("Page load timeout issue occured" + e.getMessage());
		}

	}

	@And("user clicks on signIn button")
	public void user_clicks_on_signIn_button() {
		ManageWaits.clickOnAfterVisible(driver, homePage.clickSignIn(), timeout);

	}

	@And("user entered valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String user, String pswd) throws IOException {
		ManageWaits.sendKeysAfterVisible(driver, loginPage.setInputEmail(), timeout, user);

		ManageWaits.clickOnAfterVisible(driver, loginPage.clickContinue(), timeout);

		ManageWaits.sendKeysAfterVisible(driver, loginPage.setPassword(), timeout, pswd);

	}

	@And("user clicked on submit button")
	public void user_clicked_on_submit_button() {
		ManageWaits.clickOnAfterVisible(driver, loginPage.clickSignIn(), timeout);
	}

	@And("user is logged in successfully on dashboard page")
	public void user_logged_on_dashboard_page() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
