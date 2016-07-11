/**
 * 
 */
package main.java.com.tradeo.tests.steps;

import java.util.Hashtable;

import org.jbehave.core.annotations.Given;

import junit.framework.Assert;
import main.java.com.tradeo.tests.TradeoTestsConfiguration;
import main.java.com.tradeo.tests.actions.HomepageActions;
import main.java.com.tradeo.tests.pages.MyAccountPage;
import main.java.com.tradeo.tests.pages.PagesConstants;

/**
 * @author krastiyan Implementations for all Given steps in project.
 */
public class GivenSteps {

	@Given("I'm logged in website")
	public void logInTradeoWebsite() {
		Assert.assertTrue("Logging in with user " + TradeoTestsConfiguration.User1, HomepageActions
				.signIn((Hashtable<String, String>) TradeoTestsConfiguration.get(TradeoTestsConfiguration.User1)));
	}

	@Given("$thepage page is displayed")
	public void checkAPageIsDisplayed(String thepage) {
		switch (thepage) {
		case PagesConstants.MyAccountPage:
			break;
		default:
			System.out.println("Unrecognized page provided: " + thepage);
			Assert.fail("Unrecognized page provided to checkAPageIsDisplayed(): " + thepage);
		}
	}

	@Given("I'm following at least $count trader(s)")
	public void checkIFollowNumberOfTraders(int count) {
		Assert.assertTrue("Checking at least " + count + "traders follwed by user",
				Integer.parseInt(MyAccountPage.numberFollwedTraders()) > count);
	}

}
