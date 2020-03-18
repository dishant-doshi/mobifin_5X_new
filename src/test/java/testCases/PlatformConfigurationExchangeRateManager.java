package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationExchangeRateManagerPage;
import utils.Utility;

public class PlatformConfigurationExchangeRateManager extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationExchangeRateManagerPage platformConfigurationExchangeRateManagerPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationExchangeRateManagerPage = new PlatformConfigurationExchangeRateManagerPage(getDriver());
	}

	@Test(dataProvider = "ExchangeRateManager_Add", dataProviderClass = TestDataImport.class, description = "Add Exchange Rate")
	public void addExchangeRate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addExchangeRate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigExchageRateManager();
			platformConfigurationExchangeRateManagerPage.addExchangeRateManager(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "ExchangeRateManager_Edit", dataProviderClass = TestDataImport.class, description = "Edit Exchange Rate")
	public void editExchangeRate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editExchangeRate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigExchageRateManager();
			if(platformConfigurationExchangeRateManagerPage.editExchangeRateManager(map, Utility.getMapKeys(map)))
				platformConfigurationExchangeRateManagerPage.verifyEditedExchangeRateManager(map, Utility.getMapKeys(map));
			else
				throw new Exception("Method has return false : Record not found");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "ExchangeRateManager_Delete", dataProviderClass = TestDataImport.class, description = "Delete Exchange Rate")
	public void deleteExchangeRate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteExchangeRate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigExchageRateManager();
			if(platformConfigurationExchangeRateManagerPage.deleteExchangeRateManager(map, Utility.getMapKeys(map)))
				if(platformConfigurationExchangeRateManagerPage.verifyDeletedExchangeRateManager(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
