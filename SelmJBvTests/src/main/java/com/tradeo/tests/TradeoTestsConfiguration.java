/**
 * 
 */
package main.java.com.tradeo.tests;

import java.util.Hashtable;

/**
 * @author krastiyan Contains static Hashtable allowing transfer of context data
 *         between executed steps.
 */
public class TradeoTestsConfiguration {

	/**
	 * First of the two users created while implementing tests.
	 */
	public static final String User1 = "User1";
	/**
	 * Second of the two users created while implementing tests.
	 */
	public static final String User2 = "User2";

	private static Hashtable<String, Object> configuration = initTrTConfiguration();

	public static Hashtable<String, Object> initTrTConfiguration() {
		Hashtable<String, Object> configuration = new Hashtable<String, Object>();
		Hashtable<String, String> user = new Hashtable<String, String>();
		user.put(Constants.USER_NAME, "novpotrebitel_93@abv.bg");
		user.put(Constants.USER_PASSWORD, "Myfulln0vpotrenitel");
		user.put(Constants.USER_FULL_NAME, "MyFull NameRight InHere");
		configuration.put(User1, user);
		user = new Hashtable<String, String>();
		user.put(Constants.USER_NAME, "doma6enusermoi@abv.bg");
		user.put(Constants.USER_PASSWORD, "theOther0ne");
		user.put(Constants.USER_FULL_NAME, "Another User Camein");
		configuration.put(User2, user);
		user = null;
		// TODO: Do remove above two test users from production website after
		// evaluating current work!
		configuration.put(Constants.WEBSITE_URL, "https://tradeo.com");
		return configuration;
	}

	/**
	 * Getter allowing later to be added some inputs control.
	 * 
	 * @param key
	 *            The key to search in configuration
	 * @return Object reference to the value behind key, null if no such key
	 *         present in configuration
	 */
	public static Object get(String key) {
		return configuration.get(key);
	}

	/**
	 * Setter allowing later to be added some inputs control.
	 * 
	 * @param key
	 *            The key to set in configuration
	 * @param value
	 *            The value to set mapped to key in configuration
	 */
	public static void set(String key, Object value) {
		configuration.put(key, value);
	}
}
