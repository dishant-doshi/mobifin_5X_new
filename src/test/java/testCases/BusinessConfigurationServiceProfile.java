package testCases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationServiceProfilePage;
import pages.CommonPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationServiceProfile extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationServiceProfilePage businessConfigurationServiceProfilePage;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationServiceProfilePage = new BusinessConfigurationServiceProfilePage(getDriver());
		common = new CommonPage(getDriver());
	}

	@Test(dataProvider = "ServiceProfile_Add", dataProviderClass = TestDataImport.class, description = "Id: AddServiceProfile, Author: shivani.patel")
	public void addServiceProfile(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addServiceProfile");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceProfile();
			businessConfigurationServiceProfilePage.addServiceProfile(map, Utility.getMapKeys(map));
			businessConfigurationServiceProfilePage.verifyAddedServiceProfile(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "ServiceProfile_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditServiceProfile, Author: shivani.patel")
	public void editServiceProfile(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editServiceProfile");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceProfile();
			if (businessConfigurationServiceProfilePage.editServiceProfile(map, Utility.getMapKeys(map)))
				businessConfigurationServiceProfilePage.verifyEditedServiceProfile(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "ServiceProfile_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteServiceProfile, Author: shivani.patel")
	public void deleteServiceProfile(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteServiceProfile");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceProfile();
			if (businessConfigurationServiceProfilePage.deleteServiceProfile(map, Utility.getMapKeys(map)))
				if (businessConfigurationServiceProfilePage.verifyDeletedServiceProfile(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "ServiceProfile_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortServiceProfile, Author: Dishant Doshi")
	public void sortServiceProfile(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortServiceProfile");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigServiceProfile();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!businessConfigurationServiceProfilePage.sortServiceProfile(map, Utility.getMapKeys(map)))
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
