package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationOperatingEntityPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationOperatingEntity extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationOperatingEntityPage businessConfigurationOperatingEntityPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationOperatingEntityPage = new BusinessConfigurationOperatingEntityPage(getDriver());
	}

	@Test(dataProvider = "OperatingEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntity, Author: shivani.patel")
	public void addOperatingEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addOperatingEntity");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			businessConfigurationOperatingEntityPage.addOperatingEntity(map, Utility.getMapKeys(map));
			businessConfigurationOperatingEntityPage.verifyAddedOperatingEntity(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	// @Test(dataProvider = "OperatingEntity_Edit", dataProviderClass =
	// TestDataImport.class, description = "Id: EditOperatingEntity, Author:
	// shivani.patel")
	// public void editOperatingEntity(Map<Object, Object> map) {
	// try {
	// setTestParameters(map, "editOperatingEntity");
	// homePage.goToHome();
	// navigationPage.clickOnBusinessConfigBusinessHierarchy();
	// if (businessConfigurationOperatingEntityPage.editOperatingEntity(map,
	// Utility.getMapKeys(map)))
	// businessConfigurationOperatingEntityPage.verifyEditedOperatingEntity(map,
	// Utility.getMapKeys(map));
	// else
	// throw new Exception("Method has return false : Record not found");
	// setSuccessParameters(map);
	// } catch (Exception e) {
	// setFailureParameters(map);
	// logException(e, map);
	// } finally {
	// logData(map);
	// }
	// }
}
