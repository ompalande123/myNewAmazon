package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageWaits {
	
	private WebDriver driver;
	
	//constructor
	public ManageWaits(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	// explicit wait to handle click action with visibilityOf element
	public static void clickOnAfterVisible(WebDriver driver, WebElement element, long timeout)
	{
		new WebDriverWait(driver,Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	//explit wait for visibility of element only
	public static void isVisible(WebDriver driver, WebElement element, long timeout)
	{
		new WebDriverWait(driver,Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	//explicit wait to handle sendKeys with visibilityOf element
	public static void sendKeysAfterVisible(WebDriver driver, WebElement element, long timeout, String value)
	{
		new WebDriverWait(driver,Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	
	

}
