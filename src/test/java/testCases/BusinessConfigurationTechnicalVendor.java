package testCases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationTechnicalVendorPage;
import pages.CommonPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationTechnicalVendor extends SetupInit{
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationTechnicalVendorPage businessConfigurationTechnicalVendorPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationTechnicalVendorPage = new BusinessConfigurationTechnicalVendorPage(getDriver());
	}

	@Test(dataProvider = "TechnicalVendor_Add", dataProviderClass = TestDataImport.class, description = "Id: AddTechnicalVendor, Author: shivani.patel")
	public void addTechnicalVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addTechnicalVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigTechnicalVendor();
			businessConfigurationTechnicalVendorPage.addTechnicalVendor(map, Utility.getMapKeys(map));
			businessConfigurationTechnicalVendorPage.verifyAddedTechnicalVendor(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "TechnicalVendor_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditTechnicalVendor, Author: shivani.patel")
	public void editTechnicalVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editTechnicalVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigTechnicalVendor();
			if (businessConfigurationTechnicalVendorPage.editTechnicalVendor(map, Utility.getMapKeys(map)))
				businessConfigurationTechnicalVendorPage.verifyEditedTechnicalVendor(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "TechnicalVendor_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteTechnicalVendor, Author: shivani.patel")
	public void deleteTechnicalVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editTechnicalVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigTechnicalVendor();
			if (businessConfigurationTechnicalVendorPage.deleteTechnicalVendor(map, Utility.getMapKeys(map)))
				if (businessConfigurationTechnicalVendorPage.verifyDeletedTechnicalVendor(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "TechnicalVendor_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortTechnicalVendor, Author: shivani.patel")
	public void sortTechnicalVendor(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortTechnicalVendor");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigTechnicalVendor();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!businessConfigurationTechnicalVendorPage.sortTechnicalVendor(map, Utility.getMapKeys(map)))
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
