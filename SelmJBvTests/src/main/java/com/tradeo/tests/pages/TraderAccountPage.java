/**
 * 
 */
package main.java.com.tradeo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author krastiyan PageObject instance for the pages displaying TraderAccount
 *         information.
 */
public class TraderAccountPage extends AbstractPage {

	/**
	 * Initialization of pageURL for TraderAccount lists displaying pages
	 */
	static {
		pageURL = "https://tradeo.com/traders/";
	}

	public static WebElement buttonCopyTrader() {
		return driver.findElement(By.xpath("(" + PagesConstants.copyTraderButtonLocator + ")[1]"));
	}

	public static WebElement traderNameInCpoyingPopup() {
		return driver.findElement(traderNameInCpoyingPopupXPath());
	}

	public static WebElement insufficientBalanceNotification() {
		return driver.findElement(By.xpath(PagesConstants.insufficientBalanceNotificationLocator));
	}

	public static String traderNameInUserProfile() {
		return driver.findElement(traderNameInUserProfileXPath()).getText();
	}

	public static By traderNameInUserProfileXPath() {
		return By.xpath(PagesConstants.traderAccountNameInUserProfileLocator);
	}

	public static By traderNameInCpoyingPopupXPath() {
		return By.xpath(PagesConstants.traderAccountNameInCopyingInfoPopup);
	}

}
