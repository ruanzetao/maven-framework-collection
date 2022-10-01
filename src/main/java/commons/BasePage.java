package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

//Reformat code: Ctrl Alt L
public class BasePage {
    public static BasePage getBasePageObject() {
        return new BasePage();
    }
    protected void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }
    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
    protected String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }
    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }
    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }
    protected Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    protected void acceptAlert(WebDriver driver) {
        Alert alert = waitForAlertPresence(driver);
        alert.accept();
    }
    protected void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }
    protected void getAlertText(WebDriver driver) {
        waitForAlertPresence(driver).getText();
    }
    protected void sendKeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }
    protected void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }
    protected void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }
    protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    protected By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }
    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported. Please try another one.");
        }
        return by;
    }
    //Target: Generate dynamicXpath
    /*
    for example: xpath=//input[@class='%s'] , values=Manager
    => result: xpath=//input[@class='Manager']
     */
    private String getDynamicXpath(String locatorType, String... values) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
            locatorType = String.format(locatorType, (Object) values);
        }
        return locatorType;
    }
    protected WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }
    protected List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }
    protected void clickToElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }
    protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
        getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
    }
    protected void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }
    protected void sendKeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }
    public String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }
    public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
    }

}

