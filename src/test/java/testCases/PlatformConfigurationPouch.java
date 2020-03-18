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
import pages.PlatformConfigurationPouchPage;
import utils.Utility;

public class PlatformConfigurationPouch extends SetupInit{
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationPouchPage platformConfigurationPouchPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationPouchPage = new PlatformConfigurationPouchPage(getDriver());
	}

	@Test(dataProvider = "Pouch_Add", dataProviderClass = TestDataImport.class, description = "Id: AddPouch, Author: shivani.patel")
	public void addPouch(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addPouch");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationPouch();
			platformConfigurationPouchPage.addPouch(map, Utility.getMapKeys(map));
			platformConfigurationPouchPage.verifyAddedPouch(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Pouch_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditPouch, Author: shivani.patel")
	public void editPouch(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editPouch");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationPouch();
			if (platformConfigurationPouchPage.editPouch(map, Utility.getMapKeys(map)))
				platformConfigurationPouchPage.verifyEditedPouch(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Pouch_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeletePouch, Author: shivani.patel")
	public void deletePouch(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editPouch");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationPouch();
			if (platformConfigurationPouchPage.deletePouch(map, Utility.getMapKeys(map)))
				if (platformConfigurationPouchPage.verifyDeletedPouch(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Pouch_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortPouch, Author: shivani.patel")
	public void sortPouch(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortPouch");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationParameter();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationPouchPage.sortPouch(map, Utility.getMapKeys(map)))
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
