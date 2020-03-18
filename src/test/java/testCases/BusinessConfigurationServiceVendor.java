package testCases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationServiceVendorPage;
import pages.CommonPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationServiceVendor extends SetupInit{
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationServiceVendorPage businessConfigurationServiceVendorPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationServiceVendorPage = new BusinessConfigurationServiceVendorPage(getDriver());
	}

	@Test(dataProvider = "ServiceVendor_Add", dataProviderClass = TestDataImport.class, description = "Id: AddServiceVendor, Author: shivani.patel")
	public void addServiceVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addServiceVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceVendor();
			businessConfigurationServiceVendorPage.addServiceVendor(map, Utility.getMapKeys(map));
			businessConfigurationServiceVendorPage.verifyAddedServiceVendor(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "ServiceVendor_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditServiceVendor, Author: shivani.patel")
	public void editServiceVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editServiceVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceVendor();
			if (businessConfigurationServiceVendorPage.editServiceVendor(map, Utility.getMapKeys(map)))
				businessConfigurationServiceVendorPage.verifyEditedServiceVendor(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "ServiceVendor_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteServiceVendor, Author: shivani.patel")
	public void deleteServiceVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editServiceVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceVendor();
			if (businessConfigurationServiceVendorPage.deleteServiceVendor(map, Utility.getMapKeys(map)))
				if (businessConfigurationServiceVendorPage.verifyDeletedServiceVendor(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "ServiceVendor_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortServiceVendor, Author: shivani.patel")
	public void sortServiceVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortServiceVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceVendor();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!businessConfigurationServiceVendorPage.sortServiceVendor(map, Utility.getMapKeys(map)))
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
