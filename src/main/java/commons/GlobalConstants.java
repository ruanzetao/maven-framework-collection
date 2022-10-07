package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com/";
	// Systems
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	// Path
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORT_NG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	// DB, Account, IP, User, Pass, Port
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static final long RETRY_TEST_FAIL = 3;
	//Browser Stack parameters:
	public static final String BROWSER_USERNAME = "automationfc1";
	public static final String BROWSER_AUTOMATE_KEY = "automate_key";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	//SauceLab parameters:
	public static final String SAUCE_USERNAME = "automationfc1";
	public static final String SAUCE_AUTOMATE_KEY = "automate_key";
	public static final String SAUCE_LAB_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	//CrossBrowser parameters:
	public static final String CROSS_USERNAME = "automationfc1";
	public static final String CROSS_AUTOMATE_KEY = "automate_key";
	public static final String CROSS_BROWSER_URL = "https://" + CROSS_USERNAME + ":" + CROSS_AUTOMATE_KEY + "@hub.crossbrowsertesting.com:80/wd/hub";
	//Lambda parameters:
	public static final String LAMBDA_USERNAME = "automationfc1";
	public static final String LAMBDA_AUTOMATE_KEY = "automate_key";
	public static final String LAMBDA_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_AUTOMATE_KEY + "@hub.crossbrowsertesting.com:80/wd/hub";

}
