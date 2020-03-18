package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationAccessChannelPage;
import utils.Utility;

public class PlatformConfigurationAccessChannel extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationAccessChannelPage platformConfigurationAccessChannelPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationAccessChannelPage = new PlatformConfigurationAccessChannelPage(getDriver());
	}

	@Test(dataProvider = "AccessChannel_Add", dataProviderClass = TestDataImport.class, description = "Add Access Channel")
	public void addAccessChannel(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addAccessChannel");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigAccessChannel();
			platformConfigurationAccessChannelPage.addAccessChannel(map, Utility.getMapKeys(map));
			platformConfigurationAccessChannelPage.verifyAddedAccessChannel(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "AccessChannel_Edit", dataProviderClass = TestDataImport.class, description = "Edit Access Channel")
	public void editAccessChannel(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editAccessChannel");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigAccessChannel();
			if(platformConfigurationAccessChannelPage.editAccessChannel(map, Utility.getMapKeys(map)))
				platformConfigurationAccessChannelPage.verifyEditedAccessChannel(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "AccessChannel_Delete", dataProviderClass = TestDataImport.class, description = "Delete Access Channel")
	public void deleteAccessChannel(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteAccessChannel");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigAccessChannel();
			if(platformConfigurationAccessChannelPage.deleteAccessChannel(map, Utility.getMapKeys(map)))
			 if(platformConfigurationAccessChannelPage.verifyDeletedAccessChannel(map, Utility.getMapKeys(map)))
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
