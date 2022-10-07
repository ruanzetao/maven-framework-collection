package factoryBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {

	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;

	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	public WebDriver createDriver() {
		BROWSER_LIST browser = BROWSER_LIST.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		if (browser == BROWSER_LIST.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capability);
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");
			driver = new FirefoxDriver(options);
		} else if (browser == BROWSER_LIST.CHROME) {
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			ChromeOptions options = new ChromeOptions();
			options.merge(capability);
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver(options);
		} else if (browser == BROWSER_LIST.IE) {
			WebDriverManager.iedriver().setup();
			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internetexplorer");
			capability.setPlatform(Platform.WINDOWS);
			capability.setJavascriptEnabled(true);
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Please input valid browser name value");
		}
		try {
			driver = new RemoteWebDriver(new URL(String.format("httpL//%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
