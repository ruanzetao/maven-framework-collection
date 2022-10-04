package nopcommerce.pageObjects;

import commons.BasePage;
import nopcommerce.pageUIs.BasePageUI;
import nopcommerce.pageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;

public class MyAccountPageObject extends BasePage {

	private WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, BasePageUI.REGISTER_LINK);
		clickToElement(driver, BasePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, BasePageUI.LOGIN_LINK);
		clickToElement(driver, BasePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
