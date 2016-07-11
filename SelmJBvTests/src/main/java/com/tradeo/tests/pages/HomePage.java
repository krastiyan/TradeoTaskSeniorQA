/**
 * 
 */
package main.java.com.tradeo.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**
 * @author krastiyan
 * PageObject instance for the website Homepage.
 */
public class HomePage extends AbstractPage{
	
	/**
	 * Initialization of pageURL for Homepage
	 */
	static{
		pageURL="https://tradeo.com";
	}

	public static WebElement signInLinkButton(){
		return driver.findElement(By.xpath(PagesConstants.signInLinkButtonLocator));
	}
	
	public static WebElement userNameField(){
		return driver.findElement(By.xpath(PagesConstants.userNameFieldLocator));
	}
	
	public static WebElement passwordField(){
		return driver.findElement(By.xpath(PagesConstants.passwordFieldLocator));
	}
	
	public static WebElement singInFormButton(){
		return driver.findElement(By.xpath(PagesConstants.singInFormButtonLocator));
	}
	
}
