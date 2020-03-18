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
import pages.PlatformConfigurationUserCategoryPage;
import utils.Utility;

public class PlatformConfigurationUserCategory extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationUserCategoryPage platformConfigurationUserCategoryPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationUserCategoryPage = new PlatformConfigurationUserCategoryPage(getDriver());
	}

	@Test(dataProvider = "UserCategory_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUserCategory, Author: shivani.patel")
	public void addUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			platformConfigurationUserCategoryPage.addUserCategory(map, Utility.getMapKeys(map));
			platformConfigurationUserCategoryPage.verifyAddedUserCategory(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "UserCategory_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUserCategory, Author: shivani.patel")
	public void editUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			if (platformConfigurationUserCategoryPage.editUserCategory(map, Utility.getMapKeys(map)))
				platformConfigurationUserCategoryPage.verifyEditedUserCategory(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "UserCategory_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUserCategory, Author: shivani.patel")
	public void deleteUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			if (platformConfigurationUserCategoryPage.deleteUserCategory(map, Utility.getMapKeys(map)))
				if (platformConfigurationUserCategoryPage.verifyDeletedUserCategory(map, Utility.getMapKeys(map)))
					setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "UserCategory_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortUserCategory, Author: shivani.patel")
	public void sortUserCategory(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortUserCategory");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUserCategory();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationUserCategoryPage.sortUserCategory(map, Utility.getMapKeys(map)))
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