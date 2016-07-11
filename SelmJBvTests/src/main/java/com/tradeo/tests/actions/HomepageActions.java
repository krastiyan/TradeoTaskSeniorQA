/**
 * 
 */
package main.java.com.tradeo.tests.actions;

import java.util.Hashtable;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import main.java.com.tradeo.tests.Constants;
import main.java.com.tradeo.tests.TradeoTestsConfiguration;
import main.java.com.tradeo.tests.pages.HomePage;
import main.java.com.tradeo.tests.pages.MyAccountPage;

/**
 * @author krastiyan Actions done on website's Homepage.
 */
public class HomepageActions {

	/**
	 * WebDriver instance is taken once from configuration at class' first call.
	 */
	protected static WebDriver driver = (WebDriver) TradeoTestsConfiguration.get(Constants.DRIVER);

	/**
	 * Launches website Homepage, and if needed concrete page to allow user
	 * login.
	 * 
	 * @param userDetails
	 * @return
	 */
	public static boolean signIn(Hashtable<String, String> userDetails) {
		driver.get((String) TradeoTestsConfiguration.get(Constants.WEBSITE_URL));
		if (!HomePage.signInLinkButton().isDisplayed()) {
			System.out.println("Navigating to Homepage, since sign in link not displayed on current page!");
			driver.navigate().to((String) TradeoTestsConfiguration.get(Constants.WEBSITE_URL));
		}

		HomePage.signInLinkButton().click();
		HomePage.waitForWebElementVisible(HomePage.passwordField());

		HomePage.userNameField().sendKeys(userDetails.get(Constants.USER_NAME));
		HomePage.passwordField().sendKeys(userDetails.get(Constants.USER_PASSWORD));
		HomePage.singInFormButton().click();
		MyAccountPage.waitForWebElementVisible(MyAccountPage.myAccountLabel());

		// This return result is useful for larger scope steps implementation
		// E.g. When I login and list my followers
		return true;// if all went well, including waiting for elements didn't
					// throw exceptions, we can return success
	}
}
