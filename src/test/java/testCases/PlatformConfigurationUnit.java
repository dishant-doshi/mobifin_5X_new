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
import pages.PlatformConfigurationUnitPage;
import utils.Utility;

public class PlatformConfigurationUnit extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationUnitPage platformConfigurationUnitPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationUnitPage = new PlatformConfigurationUnitPage(getDriver());
	}

	@Test(dataProvider = "Unit_Add", dataProviderClass = TestDataImport.class, description = "Id: AddUnit, Author: shivani.patel")
	public void addUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			platformConfigurationUnitPage.addUnit(map, Utility.getMapKeys(map));
			platformConfigurationUnitPage.verifyAddedUnit(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Unit_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditUnit, Author: shivani.patel")
	public void editUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			if (platformConfigurationUnitPage.editUnit(map, Utility.getMapKeys(map)))
				platformConfigurationUnitPage.verifyEditedUnit(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Unit_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteUnit, Author: shivani.patel")
	public void deleteUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			if (platformConfigurationUnitPage.deleteUnit(map, Utility.getMapKeys(map)))
				if (platformConfigurationUnitPage.verifyDeletedUnit(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Unit_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortUnit, Author: shivani.patel")
	public void sortUnit(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortUnit");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationUnit();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationUnitPage.sortUnit(map, Utility.getMapKeys(map)))
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
