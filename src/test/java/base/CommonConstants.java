package base;

import java.io.File;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import elasticUtils.LogMatrics;
import pages.LoginPage;
import utils.ReadProperty;
import utils.ReadXMLData;
import utils.Utility;

public class CommonConstants {
	static String currentDir = System.getProperty("user.dir");
	final String elasticIndex = "automation_r&d_" + Utility.getCurrentDate();
	// final String elasticIndex = "";
	final String indexType = "doc";
	static final String CONFIG_FILE_NAME = ReadProperty.getPropertyValue("ConfigurationFileName");
	static final String REPORT_FOLDER = ReadProperty.getPropertyValue("REPORT_FOLDER");
	static final String SCREENSHOT_FOLDER = ReadProperty.getPropertyValue("SCREENSHOT_FOLDER");
	static final String VIDEOS_FOLDER = ReadProperty.getPropertyValue("VIDEOS_FOLDER");
	protected static final String TESTDATA_FOLDER = ReadProperty.getPropertyValue("TESTDATA_FOLDER");
	static final String RESOURCES_FOLDER = TESTDATA_FOLDER + "/" + ReadProperty.getPropertyValue("RESOURCES_FOLDER")
			+ "/";
	static final String DOWNLOADS_FOLDER = ReadProperty.getPropertyValue("DOWNLOADS_FOLDER");
	static final String DEPENDENCIES_FOLDER = (currentDir + File.separator
			+ ReadProperty.getPropertyValue("DEPENDENCIES_FOLDER")) + File.separator;
	static final String APPLICATIONS_FOLDER = (currentDir + File.separator
			+ ReadProperty.getPropertyValue("APPLICATIONS_FOLDER"));
	static final int DEFAULT_PAUSE_INSECONDS = 2;
	String paginationValue = "25";
	protected static boolean booleanValue = false;
	Boolean failure = false;
	String reason = "None";
	String detailedFailureReason = "None";
	String stacktrace = "None";
	float ScriptExecution = 50;
	long endTime;
	long end = Long.MIN_VALUE;
	long start = Long.MAX_VALUE;
	long startMS;
	protected static int setupCounter = 0;
	boolean maskingAllowed = Boolean.parseBoolean(ReadProperty.getPropertyValue("MaskingAllowed"));
	boolean viewReport = Boolean.parseBoolean(ReadProperty.getPropertyValue("ViewReport"));
	protected int GENERAL_TIMEOUT = 30;
	public boolean logDefectAutomated = false;
	String test_data_folder_path;
	String screenshot_folder_path;
	String resources_folder_path;
	String configFilePath;
	int MAX_WAIT_TIME_IN_SEC = Integer.parseInt(ReadProperty.getPropertyValue("MAX_WAIT_TIME_IN_SEC"));
	Date testStartTime;
	public WebDriver driver;
	Wait<WebDriver> wait;
	static URL remote_grid;
	int reloadCounter = 0;
	ReadXMLData configFileObj;
	ReadXMLData fwTestData = null;
	protected boolean isRemoteEnable;
	// Selenium hub IP
	protected String hubUrl;
	// Selenium hub port
	protected String hubPort;
	public String testUrl;
	protected String targetBrowser;
	boolean recordSessionVideo = false;
	static boolean incognito;
	static ReadXMLData readFilePath = null;
	protected static String proxyIP;
	protected static String proxyPort;
	String regexTCID;
	String regexAuthor;
	LoginPage loginPage;
	LogMatrics logMatrics = new LogMatrics(elasticIndex, indexType);
	public static final String ELEMENT_FILE = currentDir + File.separator + "constants.js";
	public static final String LABLE_FILE = currentDir + File.separator + "en-US.js";

	protected enum Condition {
		isDisplayed, isClickable, isPresent, isNotVisible
	}

	protected enum Speed {
		slow
	}

	// ******************************* Test Data File
	// *******************************//
	public static String PLATEFORMCONFIGURATION_FILE_PATH = TESTDATA_FOLDER + File.separator
			+ "Dishant_Mobifin_5.0_BusinessAndCRUDData.xls";
	public static String OPERATORCONFIG_FILE_PATH = TESTDATA_FOLDER + File.separator
			+ "Dishant_Mobifin_5.0_BusinessAndCRUDData.xls";
	public static String BUSINESSCONFIG_FILE_PATH = TESTDATA_FOLDER + File.separator
			+ "Dishant_Mobifin_5.0_BusinessAndCRUDData.xls";
	public static String OPERATION_FILE_PATH = TESTDATA_FOLDER + File.separator
			+ "Dishant_Mobifin_5.0_BusinessAndCRUDData.xls";

}
