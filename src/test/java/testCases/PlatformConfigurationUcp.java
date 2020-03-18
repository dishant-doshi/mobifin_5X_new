package testCases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.CommonPage;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationUcpPage;
import utils.Utility;

public class PlatformConfigurationUcp extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationUcpPage platformConfigurationUcpPage;
	SetupInit init;
	private int sortCounter;
	CommonPage common;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationUcpPage = new PlatformConfigurationUcpPage(getDriver());
		common = new CommonPage(getDriver());
	}

	@Test(dataProvider = "Ucp_Add", dataProviderClass = TestDataImport.class, description = "Add Ucp")
	public void addUcp(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addUcp");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigUcp();
			platformConfigurationUcpPage.addUcp(map, Utility.getMapKeys(map));
			platformConfigurationUcpPage.verifyAddedUcp(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "Ucp_Edit", dataProviderClass = TestDataImport.class, description = "Edit Ucp")
	public void editUcp(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUcp");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigUcp();
			if(platformConfigurationUcpPage.editUcp(map, Utility.getMapKeys(map)))
				platformConfigurationUcpPage.verifyEditedUcp(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "Ucp_Delete", dataProviderClass = TestDataImport.class, description = "Delete Ucp")
	public void deleteUcp(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteUcp");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigUcp();
			if(platformConfigurationUcpPage.deleteUcp(map, Utility.getMapKeys(map)))
				if(platformConfigurationUcpPage.verifyDeletedUcp(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "Ucp_Sort", dataProviderClass = TestDataImport.class, description = "Sort Ucp")
	public void sortUcp(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortUcp");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigUcp();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationUcpPage.sortUcp(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : sorting failed");
			} else
				throw new Exception("Method has return false : columns mis-matched");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	
}
