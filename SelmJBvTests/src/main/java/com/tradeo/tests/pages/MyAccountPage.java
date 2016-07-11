/**
 * 
 */
package main.java.com.tradeo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author krastiyan PageObject instance for the My Account page.
 */
public class MyAccountPage extends AbstractPage {

	/**
	 * Initialization of pageURL for My Account page
	 */
	static {
		pageURL = "https://tradeo.com/my-account";
	}

	public static WebElement myAccountLabel() {
		return driver.findElement(By.xpath(PagesConstants.myAccountLabelLocator));
	}

	public static String numberFollwedTraders() {
		return followedTradersButton().getText();
	}

	public static WebElement followedTradersButton() {
		return driver.findElement(By.xpath(PagesConstants.followersNumberLocator));
	}
}
