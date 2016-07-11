/**
 * 
 */
package main.java.com.tradeo.tests.steps;

//import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import junit.framework.Assert;
import main.java.com.tradeo.tests.actions.MyAccountPageActions;
import main.java.com.tradeo.tests.actions.TraderAccountPageActions;
import main.java.com.tradeo.tests.pages.PagesConstants;

/**
 * @author krastiyan
 * Implementations for all When steps in project.
 */
public class WhenSteps {

	@When("I open $thepage section")
	public void openAPage(String thepage) {
		switch (thepage) {
		case PagesConstants.MyAccount_FollowingPage:
			break;
		default:
			System.out.println("Unrecognized page provided: " + thepage);
			Assert.fail("Unrecognized page provided to openAPage(): " + thepage);
		}
	}

	@When("Traders I follow get listed")
	public void checkTradersListed() {
		MyAccountPageActions.listFollowedTraders();
	}

	@When("I tap on trader account name for user $number in list")
	public void tapOnTraderNameByNumberInList(int number) {
		TraderAccountPageActions.tapAtTraderByNumberInList(number);
	}

	@When("I tap on $button button in $page page")
	public void tapOnPageButton(String button, String page) {
		switch (page) {
		case PagesConstants.TraderAccountPage:
			TraderAccountPageActions.handleTapOnBtton(button);
			break;
		default:
			System.out.println("Unrecognized page provided: " + page);
			Assert.fail("Unrecognized page provided to tapOnPageButton(): " + page);
		}
	}

}
