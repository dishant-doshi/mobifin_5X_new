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
import pages.PlatformConfigurationServicePage;
import utils.Utility;

public class PlatformConfigurationService extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationServicePage platformConfigurationServicePage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationServicePage = new PlatformConfigurationServicePage(getDriver());
	}

	@Test(dataProvider = "Service_Add", dataProviderClass = TestDataImport.class, description = "Id: AddService, Author: shivani.patel")
	public void addService(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addService");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationService();
			platformConfigurationServicePage.addService(map, Utility.getMapKeys(map));
			platformConfigurationServicePage.verifyAddedService(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Service_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditService, Author: shivani.patel")
	public void editService(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editService");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationService();
			if (platformConfigurationServicePage.editService(map, Utility.getMapKeys(map)))
				platformConfigurationServicePage.verifyEditedService(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Service_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteService, Author: shivani.patel")
	public void deleteService(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editService");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationService();
			if (platformConfigurationServicePage.deleteService(map, Utility.getMapKeys(map)))
				if (platformConfigurationServicePage.verifyDeletedService(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Service_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortService, Author: shivani.patel")
	public void sortService(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortService");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationService();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationServicePage.sortService(map, Utility.getMapKeys(map)))
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
