/**
 * 
 */
package main.java.com.tradeo.tests.pages;

/**
 * @author krastiyan Class with constants used by implementation for steps in
 *         all pages.</br>
 *         Not all listed might be used, by all used are listed here.
 */
public class PagesConstants {

	public static final String signInLinkButtonLocator = "//div[contains(@id,'sign-in-button')]/span";
	public static final String userNameFieldLocator = "//input[contains(@id,'user_login')]";
	public static final String passwordFieldLocator = "//input[contains(@id,'user_password')]";
	public static final String singInFormButtonLocator = "//input[contains(@value,'Sign in')]";
	public static final String myAccountLabelLocator = "//div[contains(.,'My Account')]";
	public static final String signOutLinkLocator = "//*[contains(@href,'sign=out')]";
	public static final String followingSectionLinkLocator = "//*[contains(@href,'following')]";
	public static final String followersNumberLocator = "//*[contains(@href,'following')]/span";
	public static final String traderAccountNameInListLocator = "//div[contains(@class,'trader-profile')]//*[@class='name']";
	public static final String traderAccountNameInUserProfileLocator = "//div[@class='user-info-box']//*[@class='info']/h4";
	public static final String traderAccountNameInCopyingInfoPopup = "//div[contains(@class,'copying-user-info')]//*[@data-user-name]";
	public static final String followTraderButtonLocator = "//button[contains(@class,'follow-trader')]";
	public static final String copyTraderButtonLocator = "//button[contains(@class,'copy-ribbon')]";
	public static final String insufficientBalanceNotificationLocator = "//div[@class='settings']//*[contains(.,'account is out of money')]";

	public static final String HomePage = "Homepage";
	public static final String MyAccountPage = "MyAccount";
	public static final String MyAccount_FollowingPage = "MyAccount_Following";
	public static final String TraderAccountPage = "TraderAccount";
	public static final String TradersSearchPage = "TradersSearch";
	public static final String FollowersPage = "Followers";
	public static final String FolwoingPage = "Folwoing";
	public static final String CopyTraderForm = "CopyTrader";
	public static final String CopyAccountButton = "CopyAccount";

}
