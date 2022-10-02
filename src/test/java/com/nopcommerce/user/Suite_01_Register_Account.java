package com.nopcommerce.user;

import commons.BaseTest;
import nopcommerce.pageObjects.HomePageObject;
import nopcommerce.pageObjects.PageGeneratorManager;
import nopcommerce.pageObjects.RegisterPageObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Suite_01_Register_Account extends BaseTest {

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	//Generate a valid account
	String firstName = "Nguyen";
	String lastName = "XSang";
	String validEmail = "afcxansan" + generateFakeNumber() + "@mailinator.com";
	String validPassword = "Abc@123";
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser name: " + browserName);
		getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	@Test
	public void TC_01_Register_Empty_Data() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}
	@Test
	public void TC_02_Register_Invalid_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox("XSang");
		//Missing @ at email
		registerPage.inputToEmailTextbox("xansanafc" + generateFakeNumber() + "mailinator.com");
		registerPage.inputToPasswordTextbox("Abc@123");
		registerPage.inputToConfirmPasswordTextbox("Abc@123");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}
	@Test
	public void TC_03_Register_Valid_Information() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}
	@Test
	public void TC_04_Register_Existing_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox(validEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox("afcxansan" + generateFakeNumber() + "@mailinator.com");
		String invalidPassword = "1235";
		registerPage.inputToPasswordTextbox(invalidPassword);
		registerPage.inputToConfirmPasswordTextbox(invalidPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		//Missing @ at email
		registerPage.inputToEmailTextbox("afcxansan" + generateFakeNumber() + "@mailinator.com");
		String invalidPassword = "1235";
		registerPage.inputToPasswordTextbox(invalidPassword);
		registerPage.inputToConfirmPasswordTextbox("Abc@123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
