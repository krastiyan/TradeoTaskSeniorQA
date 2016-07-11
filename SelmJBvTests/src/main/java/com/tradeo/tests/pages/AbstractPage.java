/**
 * 
 */
package main.java.com.tradeo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import main.java.com.tradeo.tests.Constants;
import main.java.com.tradeo.tests.TradeoTestsConfiguration;

/**
 * @author krastiyan Abstract class with common for all pages objects methods
 *         and attributes, that each needs to extend. Used to implement
 *         PageObjects pattern in project.
 */
public abstract class AbstractPage {

	/**
	 * This attribute to be filled by each concrete page object class!
	 */
	public static String pageURL = null;

	/**
	 * WebDriver instance is taken once from configuration at the first call. of
	 * any class from PageObjects hierarchy.
	 */
	public static WebDriver driver = (WebDriver) TradeoTestsConfiguration.get(Constants.DRIVER);

	/**
	 * Waits provided WebElement instance to get visible.</br>
	 * Used when no major page resfresh/reload occurs after tap/click action.
	 * 
	 * @param element
	 */
	public static void waitForWebElementVisible(WebElement element) {
		System.out.println("\n\tElement with " + element.getTagName() + " and text:" + element.getText());
		WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(myDynamicElement.isDisplayed());
	}

	/**
	 * Waits the WebElement instance looked up by provided By locator to get
	 * visible.</br>
	 * Used when major page resfresh/reload occurs after tap/click action, e.g.
	 * redirecting to another website page.
	 * 
	 * @param locator
	 */
	public static void waitForWebElementByLocator(By locator) {
		System.out.println("\n\tElement " + locator);
		WebElement myDynamicElement = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Assert.assertTrue(myDynamicElement.isDisplayed());
	}
}
