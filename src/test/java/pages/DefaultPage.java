package pages;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import base.SetupInit;
import utils.ExcelUtility;
import utils.Utility;

public class DefaultPage extends SetupInit {
	CommonPage common;
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationParameterPage platformConfigurationParameterPage;
	PlatformConfigurationKYCPage platformConfigurationKYCPage;
	PlatformConfigurationUserCategoryPage platformConfigurationUserCategoryPage;
	PlatformConfigurationAccessChannelPage platformConfigurationAccessChannelPage;
	BusinessConfigurationBusinessZonePage businessConfigurationBusinessZonePage;
	OperatorConfigRolePage operatorConfigRolePage;
	OperatorConfigSystemOperatorEntityPage operatorConfigSystemOperatorEntityPage;
	OperatorConfigSystemOperatorOnboardingPage operatorConfigSystemOperatorOnboardingPage;
	Map<Object, Object> map;
	static final String FILE_NAME = TESTDATA_FOLDER + File.separator + "Default.xls";
	static final String PARAMETER_SHEET_NAME = "Parameter";
	static final String KYC_SHEET_NAME = "KYC";
	static final String USER_CATEGORY_SHEET_NAME = "User Category";
	static final String ACCESS_CHANNEL_SHEET_NAME = "Access Channel";
	static final String BUSINESS_ZONE_SHEET_NAME = "Business Zone";
	static final String ROLE_SHEET_NAME = "Role";
	static final String SYSTEM_OPERATOR_ENTITY_SHEET_NAME = "System Operator Entity";
	static final String SYSTEM_OPERATOR_ONBOARDING_SHEET_NAME = "System Operator Onboarding";

	public DefaultPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
		platformConfigurationParameterPage = new PlatformConfigurationParameterPage(getDriver());
		platformConfigurationKYCPage = new PlatformConfigurationKYCPage(getDriver());
		platformConfigurationUserCategoryPage = new PlatformConfigurationUserCategoryPage(getDriver());
		platformConfigurationAccessChannelPage = new PlatformConfigurationAccessChannelPage(getDriver());
		businessConfigurationBusinessZonePage = new BusinessConfigurationBusinessZonePage(getDriver());
		operatorConfigRolePage = new OperatorConfigRolePage(getDriver());
		operatorConfigSystemOperatorEntityPage = new OperatorConfigSystemOperatorEntityPage(getDriver());
		operatorConfigSystemOperatorOnboardingPage = new OperatorConfigSystemOperatorOnboardingPage(getDriver());
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
	}

	public Map<Object, Object> getDefaultData(String sheetName, int rowNumber) {
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		int cols = ExcelUtility.getColCount(FILE_NAME, sheetName);
		for (int i = 0; i < cols; i++) {
			map.put(ExcelUtility.getCellData(FILE_NAME, sheetName, 0, i),
					ExcelUtility.getCellData(FILE_NAME, sheetName, rowNumber, i));
		}
		return map;
	}

	public void addDefaultData() {
		int parameterSheetRows = ExcelUtility.getRowCount(FILE_NAME, PARAMETER_SHEET_NAME);
		int kycSheetRows = ExcelUtility.getRowCount(FILE_NAME, KYC_SHEET_NAME);
		int userCategorySheetRows = ExcelUtility.getRowCount(FILE_NAME, USER_CATEGORY_SHEET_NAME);
		int accessChannelSheetRows = ExcelUtility.getRowCount(FILE_NAME, ACCESS_CHANNEL_SHEET_NAME);
		int businessZoneSheetRows = ExcelUtility.getRowCount(FILE_NAME, BUSINESS_ZONE_SHEET_NAME);
		int roleSheetRows = ExcelUtility.getRowCount(FILE_NAME, ROLE_SHEET_NAME);
		int sysOperatorEntitySheetRows = ExcelUtility.getRowCount(FILE_NAME, SYSTEM_OPERATOR_ENTITY_SHEET_NAME);
		int sysOperatorOnboardingSheetRows = ExcelUtility.getRowCount(FILE_NAME, SYSTEM_OPERATOR_ONBOARDING_SHEET_NAME);
//		for (int i = 1; i <= parameterSheetRows; i++) {
//			map = getDefaultData(PARAMETER_SHEET_NAME, i);
//			homePage.goToHome();
//			navigationPage.clickOnPlateformConfigurationParameter();
//			platformConfigurationParameterPage.addParameter(map, Utility.getMapKeys(map));
//		}
//		for (int i = 1; i <= kycSheetRows; i++) {
//			map = getDefaultData(KYC_SHEET_NAME, i);
//			homePage.goToHome();
//			navigationPage.clickOnPlateformConfigurationKYC();
//			platformConfigurationKYCPage.addKYC(map, Utility.getMapKeys(map));
//		}
		for (int i = 1; i <= userCategorySheetRows; i++) {
			map = getDefaultData(USER_CATEGORY_SHEET_NAME, i);
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			platformConfigurationUserCategoryPage.addUserCategory(map, Utility.getMapKeys(map));
		}
		for (int i = 1; i <= accessChannelSheetRows; i++) {
			map = getDefaultData(ACCESS_CHANNEL_SHEET_NAME, i);
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigAccessChannel();
			platformConfigurationAccessChannelPage.addAccessChannel(map, Utility.getMapKeys(map));
		}
		for (int i = 1; i <= businessZoneSheetRows; i++) {
			map = getDefaultData(BUSINESS_ZONE_SHEET_NAME, i);
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			businessConfigurationBusinessZonePage.addBusinessZone(map, Utility.getMapKeys(map));
		}
		for (int i = 1; i <= roleSheetRows; i++) {
			map = getDefaultData(ROLE_SHEET_NAME, i);
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigRole();
			operatorConfigRolePage.addRole(map, Utility.getMapKeys(map));
		}
		for (int i = 1; i <= sysOperatorEntitySheetRows; i++) {
			map = getDefaultData(SYSTEM_OPERATOR_ENTITY_SHEET_NAME, i);
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorEntity();
			operatorConfigSystemOperatorEntityPage.addSystemOperatorEntity(map, Utility.getMapKeys(map));
		}
		for (int i = 1; i <= sysOperatorOnboardingSheetRows; i++) {
			map = getDefaultData(SYSTEM_OPERATOR_ONBOARDING_SHEET_NAME, i);
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorOnboarding();
			operatorConfigSystemOperatorOnboardingPage.addSystemOperatorOnboarding(map, Utility.getMapKeys(map));
		}
	}
}
