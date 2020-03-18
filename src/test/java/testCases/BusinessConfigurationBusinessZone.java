package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationBusinessZonePage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationBusinessZone extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationBusinessZonePage businessConfigurationBusinessZonePage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationBusinessZonePage = new BusinessConfigurationBusinessZonePage(getDriver());
	}

	@Test(dataProvider = "BusinessZone_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntity, Author: shivani.patel")
	public void addBusinessZone(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addBusinessZone");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			businessConfigurationBusinessZonePage.addBusinessZone(map, Utility.getMapKeys(map));
			businessConfigurationBusinessZonePage.verifyAddedBusinessZone(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "BusinessZone_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditBusinessZone, Author: shivani.patel")
	public void editBusinessZone(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editBusinessZone");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			if (businessConfigurationBusinessZonePage.editBusinessZone(map, Utility.getMapKeys(map)))
				businessConfigurationBusinessZonePage.verifyEditedBusinessZone(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "BusinessZone_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteBusinessZone, Author: shivani.patel")
	public void deleteBusinessZone(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteBusinessZone");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			if (businessConfigurationBusinessZonePage.deleteBusinessZone(map, Utility.getMapKeys(map)))
				if (businessConfigurationBusinessZonePage.verifyDeletedBusinessZone(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
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
}
