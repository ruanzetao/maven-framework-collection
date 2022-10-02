package nopcommerce.pageObjects;

import commons.BasePage;
import nopcommerce.pageUIs.BasePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, BasePageUI.REGISTER_LINK);
		clickToElement(driver, BasePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

}
