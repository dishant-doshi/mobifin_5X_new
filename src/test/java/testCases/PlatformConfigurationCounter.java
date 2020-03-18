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
import pages.PlatformConfigurationCounterPage;
import utils.Utility;

public class PlatformConfigurationCounter extends SetupInit{
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationCounterPage platformConfigurationCounterPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationCounterPage = new PlatformConfigurationCounterPage(getDriver());
	}

	@Test(dataProvider = "Counter_Add", dataProviderClass = TestDataImport.class, description = "Id: AddCounter, Author: shivani.patel")
	public void addCounter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addCounter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationCounter();
			platformConfigurationCounterPage.addCounter(map, Utility.getMapKeys(map));
			platformConfigurationCounterPage.verifyAddedCounter(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Counter_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditCounter, Author: shivani.patel")
	public void editCounter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editCounter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationCounter();
			if (platformConfigurationCounterPage.editCounter(map, Utility.getMapKeys(map)))
				platformConfigurationCounterPage.verifyEditedCounter(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Counter_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteCounter, Author: shivani.patel")
	public void deleteCounter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editCounter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationCounter();
			if (platformConfigurationCounterPage.deleteCounter(map, Utility.getMapKeys(map)))
				if (platformConfigurationCounterPage.verifyDeletedCounter(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Counter_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortCounter, Author: shivani.patel")
	public void sortCounter(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortCounter");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationCounter();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationCounterPage.sortCounter(map, Utility.getMapKeys(map)))
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
