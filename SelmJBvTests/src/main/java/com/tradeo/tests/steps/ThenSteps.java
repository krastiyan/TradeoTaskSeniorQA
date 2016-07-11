/**
 * 
 */
package main.java.com.tradeo.tests.steps;

import org.jbehave.core.annotations.Then;

import junit.framework.Assert;
import main.java.com.tradeo.tests.Constants;
import main.java.com.tradeo.tests.TradeoTestsConfiguration;
import main.java.com.tradeo.tests.pages.PagesConstants;
import main.java.com.tradeo.tests.pages.TraderAccountPage;

/**
 * @author krastiyan
 * Implementations for all Then steps in project.
 */
public class ThenSteps {

	@Then("chosen trader's account is displayed")
	public void checkChosenTraderAccountDisplayed() {
		String traderAccount = TraderAccountPage.traderNameInUserProfile();
		String traderInContext = (String) TradeoTestsConfiguration.get(Constants.TRADER_NAME);
		System.out.println("\n\ttraderAccount:" + traderAccount + "\ntraderInContext:" + traderInContext);
		Assert.assertTrue(traderAccount.contains(traderInContext));
	}

	@Then("$form form is displayed")
	public void checkAFormDisplayed(String form) {
		switch (form) {
		case PagesConstants.CopyTraderForm:
			Assert.assertTrue("Checking TraderAccountPage.traderNameInCpoyingPopup().isDisplayed()",
					TraderAccountPage.traderNameInCpoyingPopup().isDisplayed());
			break;
		default:
			System.out.println("Unrecognized form provided: " + form);
			Assert.fail("Unrecognized form provided to checkAFormDisplayed(): " + form);
		}
	}

	@Then("notification for insufficient balance is displayed")
	public void insufficientBalanceNotificationDisplayed() {
		Assert.assertTrue("Checking TraderAccountPage.insufficientBalanceNotification().isDisplayed()",
				TraderAccountPage.insufficientBalanceNotification().isDisplayed());
	}

}
