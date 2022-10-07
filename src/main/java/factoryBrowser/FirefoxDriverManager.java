package factoryBrowser;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folder.list", 2);
		options.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FILE);
		options.addPreference("browser.helperApps.alwaysAsk.force", false);
		options.addPreference("browser.download.manager.showWhenStarting", false);
		return new FirefoxDriver(options);
	}

}
