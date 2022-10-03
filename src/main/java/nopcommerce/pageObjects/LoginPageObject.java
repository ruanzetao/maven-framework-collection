package nopcommerce.pageObjects;

import commons.BasePage;
import nopcommerce.pageUIs.BasePageUI;
import nopcommerce.pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getWebElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE).getText();
	}
	public String getSummaryErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
		return getWebElement(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE).getText();
	}

}
