/**
 * 
 */
package main.java.com.tradeo.tests.actions;

import org.openqa.selenium.WebDriver;

import main.java.com.tradeo.tests.Constants;
import main.java.com.tradeo.tests.TradeoTestsConfiguration;
import main.java.com.tradeo.tests.pages.MyAccountPage;
import main.java.com.tradeo.tests.pages.NetworkFollowersPage;;

/**
 * @author krastiyan Actions done on website's My Account page, when user is
 *         already logged in.
 */
public class MyAccountPageActions {

	/**
	 * WebDriver instance is taken once from configuration at class' first call.
	 */
	protected static WebDriver driver = (WebDriver) TradeoTestsConfiguration.get(Constants.DRIVER);

	/**
	 * Checks if My Account page is displayed in browser
	 * 
	 * @return result of check if current URL loaded in browser corresponds to
	 *         configured page URL
	 */
	public static boolean pageDisplayed() {
		return driver.getCurrentUrl().equalsIgnoreCase(MyAccountPage.pageURL);
	}

	/**
	 * Click Following button and checks if expected WebElement instance load in
	 * new page.
	 */
	public static void listFollowedTraders() {
		MyAccountPage.followedTradersButton().click();
		NetworkFollowersPage.waitForWebElementByLocator(NetworkFollowersPage.traderNameByDisplayOrderXpath(1));
		NetworkFollowersPage.waitForWebElementVisible(NetworkFollowersPage.traderNameByDisplayOrder(1));
	}
}
