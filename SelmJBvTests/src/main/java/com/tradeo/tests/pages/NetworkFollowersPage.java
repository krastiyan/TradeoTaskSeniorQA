/**
 * 
 */
package main.java.com.tradeo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author krastiyan PageObject instance for section Followers in the Network
 *         page.
 */
public class NetworkFollowersPage extends AbstractPage {

	/**
	 * Initialization of pageURL for Network->Followers page
	 */
	static {
		pageURL = "https://tradeo.com/profile/network#followers";
	}

	public static WebElement traderNameByDisplayOrder(int number) {
		return driver.findElement(traderNameByDisplayOrderXpath(number));
	}

	public static By traderNameByDisplayOrderXpath(int number) {
		return By.xpath("(" + PagesConstants.traderAccountNameInListLocator + ")[" + number + "]");
	}

}
