package base;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.LoginPage;
import utils.ReadProperty;
import utils.ReadXMLData;
import utils.Utility;

public class SetupInit extends CommonConstants {
	public WebDriver getDriver() {
		return this.driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeSetupInit(@Optional String browserType, @Optional String testUrl, ITestContext testContext) {
		this.targetBrowser = browserType;
		this.testUrl = testUrl;
		test_data_folder_path = new File(TESTDATA_FOLDER).getAbsolutePath() + File.separator;
		screenshot_folder_path = new File(SCREENSHOT_FOLDER).getAbsolutePath() + File.separator;
		resources_folder_path = new File(RESOURCES_FOLDER).getAbsolutePath() + File.separator;
		configFilePath = test_data_folder_path + CONFIG_FILE_NAME;
		File downloadsDirectoryName = new File(DOWNLOADS_FOLDER);
		if (!downloadsDirectoryName.exists())
			downloadsDirectoryName.mkdir();
		if (setupCounter == 0) {
			Utility.removeFolder(ReadProperty.getPropertyValue("REPORT_FOLDER"));
			setupCounter++;
		}
		fetchSuiteConfiguration("Master");
		testStartTime = new Date();
		if (isRemoteEnable) {
			try {
				remote_grid = new URL("http://" + hubUrl + ":" + hubPort + "/wd/hub");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (recordSessionVideo == true) {
			File f = new File(REPORT_FOLDER + VIDEOS_FOLDER);
			if (!f.exists())
				f.mkdirs();
		}
		try {
			setDriver(targetBrowser);
			pauseInSeconds(5);
			testContext.setAttribute("WebDriver", this.driver);
		} catch (Exception e) {
			System.out.println(e);
		}
		this.driver.get(testUrl);
		String userNameVal = Utility.getTestData(configFilePath, "Admin", "username");
		String passwordVal = Utility.getTestData(configFilePath, "Admin", "password");
		loginPage = new LoginPage(this.driver);
		loginPage.login(userNameVal, passwordVal);
	}

	private void setDriver(String browserType) {
		String toLowerCase = browserType.toLowerCase();
		switch (toLowerCase.hashCode()) {
		case -1361128838:
			if (toLowerCase.equals("chrome")) {
				this.driver = initChromeDriver();
				return;
			}
		case -1115062407:
			if (toLowerCase.equals("headless")) {
				this.driver = initChromeHeadlessDriver();
				return;
			}
		case -849452327:
			if (toLowerCase.equals("firefox")) {
				this.driver = initFirefoxDriver();
				return;
			}
		case 3356:
			if (toLowerCase.equals("ie")) {
				this.driver = initIEDriver();
				return;
			}
		case 472085556:
			if (toLowerCase.equals("chromeproxy")) {
				this.driver = initChromeProxyDriver();
				return;
			}
		case -1862645963:
			if (toLowerCase.equals("firefoxproxy")) {
				this.driver = initFirefoxProxyDriver();
				return;
			}
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			this.driver = initFirefoxDriver();
			return;
		}
	}

	private WebDriver initChromeHeadlessDriver() {
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(new String[] { "headless" });
		chromeOptions.addArguments(new String[] { "window-size=1200x600" });
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initChromeDriver() {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		ChromeOptions option = setChromeOptions();
		if (isRemoteEnable)
			return new RemoteWebDriver(remote_grid, option);
		return new ChromeDriver(option);
	}

	private ChromeOptions setChromeOptions() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", Integer.valueOf(0));
		chromePrefs.put("download.default_directory", DOWNLOADS_FOLDER);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		if (incognito)
			options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments(new String[] { "disable-infobars" });
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities capabilities = setChromeCapabilities();
		options.merge(capabilities);
		if (isRemoteEnable)
			capabilities.setCapability("goog:chromeOptions", options);
		return options;
	}

	private DesiredCapabilities setChromeCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("acceptSslCerts", true);
		return capabilities;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		FirefoxOptions options = setFireFoxOptions();
		if (isRemoteEnable)
			return new RemoteWebDriver(remote_grid, options);
		return new FirefoxDriver(options);
	}

	private FirefoxOptions setFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("gecko", true);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments(new String[] { "disable-infobars" });
		DesiredCapabilities capabilities = setFireFoxCapabilities();
		options.merge(capabilities);
		return options;
	}

	private DesiredCapabilities setFireFoxCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("acceptSslCerts", true);
		return capabilities;
	}

	private WebDriver initIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		InternetExplorerOptions options = new InternetExplorerOptions();
		capabilities.setPlatform(Platform.ANY);
		capabilities.setBrowserName("internet explorer");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capabilities.setJavascriptEnabled(true);
		if (isRemoteEnable)
			return new RemoteWebDriver(remote_grid, capabilities);
		options.merge(capabilities);
		driver = new InternetExplorerDriver(options);
		return driver;
	}

	private WebDriver initChromeProxyDriver() {
		configFileObj = new ReadXMLData(test_data_folder_path + CONFIG_FILE_NAME);
		proxyIP = configFileObj.get("Proxy", "ProxyIP");
		proxyPort = configFileObj.get("Proxy", "ProxyPort");
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyIP + ":" + proxyPort);
		proxy.setFtpProxy(proxyIP + ":" + proxyPort);
		proxy.setSslProxy(proxyIP + ":" + proxyPort);
		proxy.setSocksProxy(proxyIP + ":" + proxyPort);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setProxy(proxy);
		chromeOptions.addArguments("test-type");
		if (incognito)
			chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("disable-infobars");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		capabilities.setCapability("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("proxy", proxy);

		chromeOptions.merge(capabilities);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initFirefoxProxyDriver() {
		FirefoxProfile profile1 = new FirefoxProfile();
		configFileObj = new ReadXMLData(test_data_folder_path + CONFIG_FILE_NAME);
		proxyIP = configFileObj.get("Proxy", "ProxyIP");
		proxyPort = configFileObj.get("Proxy", "ProxyPort");
		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		profile1.setPreference("dom.max_chrome_script_run_time", "999");
		profile1.setPreference("dom.max_script_run_time", "999");
		profile1.setPreference("browser.download.folderList", 2);
		profile1.setPreference("browser.download.useDownloadDir", true);
		profile1.setPreference("browser.download.manager.showWhenStarting", false);
		profile1.setPreference("javascript.enabled", true);
		profile1.setPreference("network.http.use-cache", false);
		profile1.setPreference("network.proxy.type", 1);
		profile1.setPreference("network.proxy.http", proxyIP);
		profile1.setPreference("network.proxy.http_port", proxyPort);
		profile1.setPreference("network.proxy.ssl", proxyIP);
		profile1.setPreference("network.proxy.ssl_port", proxyPort);
		profile1.setPreference("network.proxy.ftp", proxyIP);
		profile1.setPreference("network.proxy.ftp_port", proxyPort);
		profile1.setPreference("network.proxy.socks", proxyIP);
		profile1.setPreference("network.proxy.socks_port", proxyPort);
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setProfile(profile1);
		options1.setAcceptInsecureCerts(true);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, options1);
			return driver;
		}
		driver = new FirefoxDriver(options1);
		return driver;
	}

	public boolean verifyVisible(By locator, int... timeOrAssert) {
		WebElement element = findVisibleElement(locator, timeOrAssert);
		return element != null ? element.isDisplayed() : false;
	}

	public boolean veifyElementIsNotVisible(By locator, int... time) {
		return !verifyVisible(locator, time);
	}

	public List<String> getTextFromElementList(By locator, int... timeOrAssert) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : getElementList(locator, timeOrAssert))
			textList.add(element.getText());
		return textList;
	}

	public List<WebElement> getElementList(By locator, int... timeOrAssert) {
		waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert));
		String message = "";
		ArrayList<WebElement> elementLst = new ArrayList<>();
		try {
			elementLst = (ArrayList<WebElement>) driver.findElements(locator);
			message = "getElementList passed, locator  by : " + locator;
		} catch (Exception e) {
			message = "getElementList failed: " + getPortableString(e.toString()) + ", locator by : " + locator;
		}
		return elementLst;
	}

	public void selectFromDropDown(By dropDownLoc, By valueLoc, int... time) {
		clickOnElement(dropDownLoc, time);
		clickOnElement(valueLoc, time);
	}

	public String getElementText(By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Get text for element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
		return element.getText();
	}

	public String getElementText(WebElement element, int... timeOrAssert) {
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Get text for element is failed: " + getPortableString(e.toString()) + ": "
					+ " by : " + element;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
		return element.getText();
	}

	public void clickOnElement(By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				String value = getElementText(element);
				if (value.equals("") || value.equals(null) || value.equals(" ")) {
					List<String> attributes = getElementAttributes(element);
					if (attributes.contains("name") && (!element.getAttribute("name").equals("")
							|| !element.getAttribute("name").equals(null))) {
						value = element.getAttribute("name");
					} else if (attributes.contains("id")
							&& (!element.getAttribute("id").equals("") || !element.getAttribute("id").equals(null))) {
						value = element.getAttribute("id");
					} else if (attributes.contains("class") && (!element.getAttribute("class").equals("")
							|| !element.getAttribute("class").equals(null))) {
						value = element.getAttribute("class");
					} else if (attributes.contains("value") && (!element.getAttribute("value").equals("")
							|| !element.getAttribute("value").equals(null))) {
						value = element.getAttribute("value");
					}
				}
				element.click();
				value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
				log("Clicked on " + value);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Click on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void removeReadOnlyProperty(WebElement webElement) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", webElement);
	}

	public void sendKeys(By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				waitForLoader();
				element.clear();
				element.sendKeys(data);
				String value = getElementText(element);
				if (value.equals("") || value.equals(null) || value.equals(" ")) {
					List<String> attributes = getElementAttributes(element);
					if (attributes.contains("name") && (!element.getAttribute("name").equals("")
							|| !element.getAttribute("name").equals(null))) {
						value = element.getAttribute("name");
					} else if (attributes.contains("id")
							&& (!element.getAttribute("id").equals("") || !element.getAttribute("id").equals(null))) {
						value = element.getAttribute("id");
					} else if (attributes.contains("class") && (!element.getAttribute("class").equals("")
							|| !element.getAttribute("class").equals(null))) {
						value = element.getAttribute("class");
					} else if (attributes.contains("value") && (!element.getAttribute("value").equals("")
							|| !element.getAttribute("value").equals(null))) {
						value = element.getAttribute("value");
					}
				}
				value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
				data = "<b><span style='color:#418eb5'>" + data + "</span></b>";
				log("Sent text in " + value + ": " + data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public void sendKeysWithRemoveReadOnlyProperty(By locator, String data, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
			else {
				removeReadOnlyProperty(element);
				element.clear();
				element.sendKeys(data);
				String value = getElementText(element);
				if (value.equals("") || value.equals(null) || value.equals(" ")) {
					List<String> attributes = getElementAttributes(element);
					if (attributes.contains("name") && (!element.getAttribute("name").equals("")
							|| !element.getAttribute("name").equals(null))) {
						value = element.getAttribute("name");
					} else if (attributes.contains("id")
							&& (!element.getAttribute("id").equals("") || !element.getAttribute("id").equals(null))) {
						value = element.getAttribute("id");
					} else if (attributes.contains("class") && (!element.getAttribute("class").equals("")
							|| !element.getAttribute("class").equals(null))) {
						value = element.getAttribute("class");
					} else if (attributes.contains("value") && (!element.getAttribute("value").equals("")
							|| !element.getAttribute("value").equals(null))) {
						value = element.getAttribute("value");
					}
				}
				value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
				data = "<b><span style='color:#418eb5'>" + data + "</span></b>";
				log("Sent text in " + value + ": " + data);
			}
		} catch (Exception e) {
			String ExceptionMessage = "Send skeys on Element is failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
	}

	public List<String> getElementAttributes(WebElement element) {
		List<String> elementAttributes = new ArrayList<String>();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Object attribute = executor.executeScript(
					"var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
					element);
			String[] attributes = attribute.toString().split(",");
			for (int i = 0; i < attributes.length; i++) {
				elementAttributes.add(attributes[i].split("=")[0].replace("{", "").replaceAll(" ", ""));
			}
		} catch (Exception e) {
			log("<b><span style='color:red'> Element " + element
					+ " contaning an attribute having null value </span></b>");
		}
		return elementAttributes;
	}

	public WebElement findVisibleElement(By locator, int... timeOrAssert) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isDisplayed, getTimeOut(timeOrAssert));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Element is not displayed failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, timeOrAssert);
		}
		return element;
	}

	public WebElement findPresentElement(By locator, int... time) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isPresent, getTimeOut(time));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Element is not present failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, time);
		}
		return element;
	}

	public WebElement findClickableElement(By locator, int... time) {
		String message = "";
		WebElement element = null;
		Map<WebElement, String> elementState = new HashMap<>();
		elementState = waitForElementState(locator, Condition.isClickable, getTimeOut(time));
		for (Map.Entry<WebElement, String> entry : elementState.entrySet()) {
			element = entry.getKey();
			message = entry.getValue();
		}
		try {
			if (element == null)
				throw new Exception();
		} catch (Exception e) {
			String ExceptionMessage = "Element is not clickable failed: " + getPortableString(message) + ": " + " by : "
					+ locator;
			exceptionOnFailure(false, ExceptionMessage, time);
		}
		return element;
	}

	private int getTimeOut(int[] time) {
		int timeOut = MAX_WAIT_TIME_IN_SEC;
		if (time.length != 0)
			if (time[0] > 0)
				timeOut = time[0];
		return timeOut;
	}

	private int getInvisibilityTimeOut(int[] time) {
		int timeOut = 10;
		if (time.length != 0)
			if (time[0] > 0)
				timeOut = time[0];
		return timeOut;
	}

	private Map<WebElement, String> waitForElementState(By locator, Condition condition, int time) {
		WebElement element;
		do {
		} while (!waitForLoader());
		do {
		} while (!isAjaxCallCompleted());
		Map<WebElement, String> map = new HashMap<>();
		element = getElement(condition, locator, time);
		String message = "";
		if (element == null) {
			try {
				throw new Exception();
			} catch (Exception e) {
				message = "State = " + condition.toString() + " failed: ";
			}
		} else {
			message = "State = " + condition.toString() + " Passed: ";
		}
		map.put(element, message);
		return map;

	}

	private boolean waitForInvisble(Condition condition, By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			switch (condition) {
			case isNotVisible:
				return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			default:
				break;
			}
		} catch (Exception e) {
		}
		return false;
	}

	private WebElement getElement(Condition condition, By by, int time) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			switch (condition) {
			case isClickable:
				element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				if (element == null) {
					return element;
				} else if (element.getAttribute("clickable") == null) {
					return element;
				} else if (element.getAttribute("clickable") != null) {
					element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));
					return element;
				}
				break;
			case isDisplayed:
				element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				break;
			case isPresent:
				element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
				break;
			default:
				break;
			}
			if (!isVisibleInViewport(element))
				scrollToElement(element);
		} catch (Exception e) {
		}
		return element;
	}

	public void pauseInSeconds(int i) {
		try {
			Thread.sleep(1000 * i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pauseInMilliSeconds(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void defaultPause() {
		try {
			Thread.sleep(1000 * DEFAULT_PAUSE_INSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		if (!isVisibleInViewport(element)) {
			((JavascriptExecutor) driver).executeScript(
					"window.scrollTo(" + element.getLocation().x + "," + (element.getLocation().y - 80) + ");");
		}
	}

	private boolean isAjaxCallCompleted() {
		WebDriverWait wait = new WebDriverWait(this.driver, (long) this.GENERAL_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		try {
			return ((Boolean) wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver inDriver) {
					boolean z = SetupInit.this.isJQueryLoaded() && SetupInit.this.isJSLoaded();
					return Boolean.valueOf(z);
				}

				public String toString() {
					return "Waiting for Ajax call to be completed";
				}
			})).booleanValue();
		} catch (TimeoutException e) {
			return false;
		}
	}

	private boolean isJSLoaded() {
		return ((JavascriptExecutor) this.driver).executeScript("return document.readyState", new Object[0]).toString()
				.equals("complete");
	}

	public boolean isJQueryLoaded() {
		try {
			return ((Long) ((JavascriptExecutor) this.driver).executeScript("return jQuery.active", new Object[0]))
					.longValue() == 0;
		} catch (Exception e) {
			return true;
		}
	}

	protected boolean isVisibleInViewport(WebElement element) {
		return ((Boolean) ((JavascriptExecutor) ((RemoteWebElement) element).getWrappedDriver()).executeScript(
				"var elem = arguments[0],                   box = elem.getBoundingClientRect(),      cx = box.left + box.width / 2,           cy = box.top + box.height / 2,           e = document.elementFromPoint(cx, cy); for (; e; e = e.parentElement) {           if (e === elem)                            return true;                         }                                        return false;                            ",
				new Object[] { element })).booleanValue();
	}

	public boolean isLoderDisplayed(By locator) {
		boolean state = false;
		try {
			state = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	// public boolean isDisplayed(By locator, int... wait) {
	// boolean state = false;
	// WebElement element = findVisibleElement(locator, getTimeOut(wait));
	// try {
	// state = element.isDisplayed();
	// } catch (Exception e) {
	// RuntimeException re = new RuntimeException();
	// }
	// return state;
	// }

	public boolean waitForLoader() {
		pauseInMilliSeconds(400);
		if (isLoderDisplayed(By.xpath("//*[contains(@class,'loader')]"))) {
			Instant currentTime = getCurrentTime();
			while (isLoderDisplayed(By.xpath("//*[contains(@class,'loader')]"))) {
				Instant loopingTime = getCurrentTime();
				Duration timeElapsed = Duration.between(currentTime, loopingTime);
				long sec = timeElapsed.toMillis() / 1000;
				int durDiff = (int) sec;
				if (durDiff >= 180) {
					reloadCurrentPage();
					reloadCounter++;
					if (reloadCounter == 6)
						driver.close();
				}
			}
		}
		if (isLoderDisplayed(By.xpath("//div[contains(text(),'Loading')]"))) {
			Instant currentTime = getCurrentTime();
			while (isLoderDisplayed(By.xpath("//div[contains(text(),'Loading')]"))) {
				Instant loopingTime = getCurrentTime();
				Duration timeElapsed = Duration.between(currentTime, loopingTime);
				long sec = timeElapsed.toMillis() / 1000;
				int durDiff = (int) sec;
				if (durDiff >= 180) {
					reloadCurrentPage();
					reloadCounter++;
					if (reloadCounter == 6)
						driver.close();
				}
			}
			pauseInMilliSeconds(400);
		}
		return true;
	}

	public void makeScreenshot(String screenShotName, File screenShotLoaction) {
		File screenshot;
		WebDriver augmentedDriver = null;
		augmentedDriver = new Augmenter().augment(driver);
		screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(screenShotLoaction + File.separator + screenShotName);
			FileUtils.copyFile(screenshot, f);
		} catch (IOException e) {
			e.printStackTrace();
			log("Failed to capture screenshot:" + e.getMessage());
		}
		log(createScreenshotLink(screenShotName, screenShotLoaction.toString()));
	}

	public synchronized void log(String message) {
		Reporter.log(message);
	}

	public String makeScreenshot(String testClassName, String testMethod) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String currentTime = timeFormat.format(date);
		String currentDir = System.getProperty("user.dir");
		String folderPath = currentDir + File.separator + "Failure_Screenshots" + File.separator + testClassName
				+ File.separator + currentDate.replaceAll("/", "_");
		folderPath = folderPath.trim();
		String screenshotName = currentTime.replace(":", "_") + ".png";
		String filePath = folderPath + File.separator + testMethod + "_" + screenshotName;
		filePath = filePath.trim();
		File screenshotLocation = new File(folderPath);
		if (!screenshotLocation.getAbsoluteFile().exists())
			screenshotLocation.mkdir();
		File screenshot;
		WebDriver augmentedDriver = null;
		augmentedDriver = new Augmenter().augment(driver);
		screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(filePath);
			FileUtils.copyFile(screenshot, f);
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed to capture a sccreenshot";
	}

	/**
	 * @author dishant.doshi
	 * @return the current URL
	 * @created on 25/02/2019
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	/**
	 * @author dishant.doshi to reload current url
	 * @creation date 23/11/2018
	 */
	public void reloadCurrentPage() {
		String url = getCurrentURL();
		driver.get(url);
	}

	@AfterClass
	public void closeBrowser() {
		this.driver.quit();
	}

	// ################ Supporting methods
	// #################################################################

	protected void logException(Throwable e, Map<Object, Object> map) {
		// map.put("Steps To Reproduce", logList);
		stacktrace = Utility.getStackStrace(e);
		Scanner sc = new Scanner(stacktrace);
		String firstLine = sc.nextLine();
		sc.close();
		Map<String, Object> dataMap = getDataMap(map);
		dataMap.put("Failure Reason", firstLine);
		dataMap.put("Datailed Failure Reason", stacktrace);
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if ((Long) dataMap.get("Test Start Time") < start) {
			startMS = (Long) dataMap.get("Test Start Time");
			start = startMS / 1000;
		}
		dataMap.put("Test Start Time", Utility.formatTime(startMS));
		dataMap.put("Test End Time", Utility.formatTime(endTime));
		dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
		String clsName = dataMap.get("Class Name").toString();
		String className = clsName.contains(".") ? clsName.substring(clsName.lastIndexOf('.') + 1) : clsName;
		dataMap.put("Failed Screenshot path", makeScreenshot(className, dataMap.get("Method Name").toString()));
		logMatrics.logToElasticsearch(dataMap);
		e.printStackTrace();
	}

	public void logData(Map<Object, Object> map) {
		Map<String, Object> dataMap = getDataMap(map);
		if (dataMap.get("Value") == null) {
			dataMap.put("Value", 50);
			endTime = System.currentTimeMillis();
			if (endTime > end)
				end = endTime / 1000;
			if ((Long) map.get("Test Start Time") < start) {
				startMS = (Long) dataMap.get("Test Start Time");
				start = startMS / 1000;
			}
			dataMap.put("Test Start Time", Utility.formatTime(startMS));
			dataMap.put("Test End Time", Utility.formatTime(endTime));
			dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
			logMatrics.logToElasticsearch(dataMap);
		} else if ((Integer) map.get("Value") == 100) {
			endTime = System.currentTimeMillis();
			if (endTime > end)
				end = endTime / 1000;
			if ((Long) map.get("Test Start Time") < start) {
				startMS = (Long) dataMap.get("Test Start Time");
				start = startMS / 1000;
			}
			dataMap.put("Test Start Time", Utility.formatTime(startMS));
			dataMap.put("Test End Time", Utility.formatTime(endTime));
			dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
			logMatrics.logToElasticsearch(dataMap);
		} else if ((Integer) dataMap.get("Value") == 0) {
			try {
				// logStatus(false);
				Assert.assertTrue(false);
			} catch (Exception e) {
				throw new RuntimeException(dataMap.get("Failure Reason").toString());
			}
		}
	}

	public Map<String, Object> getDataMap(Map<Object, Object> map) {
		Map<String, Object> dataToDump = new HashMap<>();
		for (Map.Entry<Object, Object> e : map.entrySet()) {
			dataToDump.put(e.getKey().toString(), e.getValue());
		}
		dataToDump.put("Executor IP", getIPOfNode());
		return dataToDump;
	}

	public String getIPOfNode() {
		if (isRemoteEnable) {
			pauseInSeconds(1);
			String hostFound = null;
			try {
				HttpCommandExecutor ce = (HttpCommandExecutor) ((RemoteWebDriver) this.driver).getCommandExecutor();
				String hostName = ce.getAddressOfRemoteServer().getHost();
				int port = ce.getAddressOfRemoteServer().getPort();
				HttpHost host = new HttpHost(hostName, port);
				HttpClient client = new DefaultHttpClient();
				URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session="
						+ ((RemoteWebDriver) this.driver).getSessionId());
				BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST",
						sessionURL.toExternalForm());
				HttpResponse response = client.execute(host, r);
				JSONObject object = extractObject(response);
				URL myURL = new URL(object.getString("proxyId"));
				if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
					hostFound = myURL.getHost();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			return hostFound;
		} else {
			String inetAddress = null;
			try {
				inetAddress = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
			}
			return inetAddress;
		}
	}

	public JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		InputStream contents = resp.getEntity().getContent();
		StringWriter writer = new StringWriter();
		IOUtils.copy(contents, writer, "UTF8");
		JSONObject objToReturn = new JSONObject(writer.toString());
		return objToReturn;
	}

	public String getCurrentMethodName() {
		return new Throwable().getStackTrace()[0].getMethodName();
	}

	public String createScreenshotLink(String screenShotName, String link_text) {
		return "<br><Strong><font color=#FF0000>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Failed screenshot name = </font></strong><a target='_blank' href='../"
				+ link_text + File.separator + screenShotName + "'>" + screenShotName + "</a>";
	}

	/**
	 * @author vivek.mishra
	 * @return current time in integer
	 * @created on 25/02/2019
	 */
	public Instant getCurrentTime() {
		return Instant.now();
	}

	public void fetchSuiteConfiguration(String configuration) {
		configFileObj = new ReadXMLData(test_data_folder_path + CONFIG_FILE_NAME);
		isRemoteEnable = Boolean.parseBoolean(configFileObj.get(configuration, "isRemoteEnable"));
		incognito = Boolean.parseBoolean(configFileObj.get(configuration, "incognito"));
		if (isRemoteEnable) {
			hubUrl = configFileObj.get(configuration, "Hub");
			hubPort = configFileObj.get(configuration, "Port");
		}
		logDefectAutomated = new Boolean(configFileObj.get(configuration, "AutoLogDefectInJira"));
		recordSessionVideo = new Boolean(configFileObj.get(configuration, "RecordVideoOfTestExecution"));
		regexTCID = configFileObj.get("Configuration", "TestIdRegex");
		regexAuthor = configFileObj.get("Configuration", "TestAuthorRegex");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		// logList.clear();
		if (!testResult.isSuccess()) {
			System.out.println(testResult);
			Reporter.setCurrentTestResult(testResult);
			String[] testClass = testResult.getTestClass().toString().split("\\.");
			String testClassName = testClass[testClass.length - 1].replace("]", "\\");
			String testMethod = testResult.getName().toString();

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			String currentTime = timeFormat.format(date);

			File screenshotLocation = new File(REPORT_FOLDER + SCREENSHOT_FOLDER + File.separator + testClassName
					+ testMethod + File.separator + currentDate.replaceAll("/", "-"));
			if (!screenshotLocation.getAbsoluteFile().exists())
				screenshotLocation.mkdir();

			String screenshotName = currentTime.replace(":", ";") + ".png";
			Reporter.log("<br> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please click for screenshot - </b>");
			makeScreenshot(screenshotName, screenshotLocation);
		}
	}

	public void exceptionOnFailure(boolean success, String message, int[] assertion) {
		if (!success) {
			if (assertionResult(assertion)) {
				try {
					assertStatus(success);
				} catch (Exception e) {
					RuntimeException ex = new RuntimeException(message + " : " + e.getMessage());
					System.out.println("Exception Logging For: " + message);
					ex.setStackTrace(e.getStackTrace());
					throw ex;
				}
			}
		}
	}

	public boolean assertionResult(int[] j) {
		if (j != null) {
			if (j.length > 0) {
				if (j[0] != 0) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isVarArgsPassed(int[] j) {
		if (j != null) {
			if (j.length > 0) {
				if (j[0] > 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public void assertStatus(boolean success) throws Exception {
		if (!success) {
			throw new Exception("");
		}
	}

	public String getPortableString(String str) {
		if (str.length() > 150) {
			return str.substring(0, 150) + "...";
		} else if (str.length() != 0) {
			return str.substring(0, str.length() - 1) + "...";
		} else {
			return str;
		}
	}

	public void setTestParameters(Map<Object, Object> map, String methodName) {
		map.put("Test Start Time", System.currentTimeMillis());
		map.put("Class Name", this.getClass().getName());
		map.put("Method Name", methodName);
	}

	public void setSuccessParameters(Map<Object, Object> map) {
		map.put("Value", 100);
	}

	public void setFailureParameters(Map<Object, Object> map) {
		map.put("Value", 0);
	}

}