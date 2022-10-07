package factoryBrowser;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LambdaFactory {

	private WebDriver driver;
	private String browserName;
	private String osName;

	public LambdaFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browserName);
		capability.setCapability("platform", osName);
		capability.setCapability("record_video", "true");
		capability.setCapability("screenResolution", "1920x1080");
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.CROSS_BROWSER_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
