package main.java.com.tradeo.tests.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import main.java.com.tradeo.tests.Constants;
import main.java.com.tradeo.tests.TradeoTestsConfiguration;
import main.java.com.tradeo.tests.pages.NetworkFollowersPage;
import main.java.com.tradeo.tests.pages.PagesConstants;
import main.java.com.tradeo.tests.pages.TraderAccountPage;

/**
 * @author krastiyan Actions done in pages displaying trader accounts'
 *         information.
 */
public class TraderAccountPageActions {

	/**
	 * WebDriver instance is taken once from configuration at class' first call.
	 */
	protected static WebDriver driver = (WebDriver) TradeoTestsConfiguration.get(Constants.DRIVER);

	/**
	 * Abstract implementation of tapping any button in a TraderAccount page.
	 * 
	 * @param button
	 *            The button to tap on.
	 */
	public static void handleTapOnBtton(String button) {
		switch (button) {
		case PagesConstants.CopyAccountButton:
			TraderAccountPage.buttonCopyTrader().click();
			TraderAccountPage.waitForWebElementByLocator(TraderAccountPage.traderNameInCpoyingPopupXPath());
			break;
		default:
			System.out.println("Unrecognized button provided: " + button);
			Assert.fail("Unrecognized button provided to handleTapOnBtton(): " + button);
		}
	}

	public static String tapAtTraderByNumberInList(int number) {
		WebElement element = NetworkFollowersPage.traderNameByDisplayOrder(number);
		String traderName = element.getText();
		TradeoTestsConfiguration.set(Constants.TRADER_NAME, traderName);
		element.click();
		TraderAccountPage.waitForWebElementByLocator(TraderAccountPage.traderNameInUserProfileXPath());
		return traderName;
	}
}
